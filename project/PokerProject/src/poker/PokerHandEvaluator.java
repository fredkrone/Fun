package poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PokerHandEvaluator {

	List<Card> deck = new ArrayList<Card>();
	Map<Suit, ArrayList<Card>> suitMap = new HashMap<Suit, ArrayList<Card>>();
	Map<Integer, ArrayList<Card>> valueMap = new HashMap<Integer, ArrayList<Card>>();

	public PokerHandEvaluator() {
		deck = createDeck();
	}

	private List<Card> createDeck() {
		ArrayList<Card> cards = new ArrayList<Card>(52);

		for (int suit = 0; suit < 4; suit++) {
			for (int j = 0; j < 13; j++) {
				Card card = new Card(suit, j);
				cards.add(card);
			}
		}
		return cards;
	}

	public Hand<Card> generateHand() {

		Hand<Card> hand = new Hand<Card>();

		for (int i = 0; i < 5; i++) {
			int value = (int) (Math.random() * deck.size());
			Card card = getDeck().remove(value);
			hand.add(card);
			System.out.println("Adding card: " + card.suit + ", " + card.value);

		}

		return hand;
	}

	private void generateMaps(Hand<Card> hand) {

		for (Card card : hand.getCards()) {
			Suit s = Suit.getSuitFromValue(card.suit);
			if (suitMap.containsKey(s)) {
				suitMap.get(s).add(card);
			}
			else {
				ArrayList<Card> cardList = new ArrayList<Card>();
				cardList.add(card);
				suitMap.put(s, cardList);
			}
			Integer v = new Integer(card.value);
			if (valueMap.containsKey(v)) {
				valueMap.get(v).add(card);
			}
			else {
				ArrayList<Card> cardList = new ArrayList<Card>();
				cardList.add(card);
				valueMap.put(v, cardList);
			}
		}

	}

	public List<Card> getDeck() {
		return deck;
	}

	public void setDeck(List<Card> deck) {
		this.deck = deck;
	}

	public void evaluateHand(Hand<Card> hand) {

		generateMaps(hand);

		Collections.sort(hand.getCards(), new Comparator<Card>() {
			@Override
			public int compare(Card card1, Card card2) {

				Integer value1 = new Integer(card1.value);
				Integer value2 = new Integer(card2.value);
				return value1.compareTo(value2);
			}
		});

		int maxPair = checkPairs(hand);
		if (maxPair == 4) {
			System.out.println("Four of a kind!");
		}
		else if (maxPair == 3) {
			if (checkFullHouse(hand)) {
				System.out.println("Full house!");
			}
			else {
				System.out.println("Three of a kind!");
			}
		}

		else if (maxPair == 2) {
			System.out.println("Two of a kind!");

		}
		else {

			boolean flush = checkFlush(hand);
			boolean straight = checkStraight(hand);
			boolean royal = false;
			if (flush && straight) {
				royal = checkRoyal(hand);
			}

			if (royal) {
				System.out.println("Royal flush!  You win Vegas!");
			}
			else if (flush && straight) {
				System.out.println("Straight flush!  Lucky!");
			}
			else if (straight) {
				System.out.println("Straight!  Not bad!");
			}
			else if (flush) {
				System.out.println("Flush!");
			}
			else {
				System.out.println("High card");
			}
		}

		Collections.sort(hand.getCards(), new Comparator<Card>() {
			@Override
			public int compare(Card card1, Card card2) {

				Integer value1 = new Integer(card1.value);
				Integer value2 = new Integer(card2.value);
				return value1.compareTo(value2);
			}
		});

	}

	private int checkPairs(Hand<Card> hand) {

		int total = 0;
		for (Card c : hand.getCards()) {
			int size = valueMap.get(new Integer(c.value)).size();
			if (size > total) {
				total = size;
			}
		}
		return total;

	}

	private boolean checkFullHouse(Hand<Card> hand) {

		int full = 0;
		int house = 0;
		for (Card c : hand.getCards()) {
			int size = valueMap.get(new Integer(c.value)).size();
			if (size > full) {
				full = size;
			}
			else if (size == 2) {
				house = size;
			}
		}
		return (full == 3 && house == 2);

	}

	private boolean checkRoyal(Hand<Card> hand) {

		if (hand.getCards().get(4).value == 13) {
			return true;
		}
		else {
			return false;
		}
	}

	private boolean checkStraight(Hand<Card> hand) {
		Card first = hand.getCards().get(0);
		Card last = hand.getCards().get(4);
		if (last.value - first.value == 4) {
			return true;
		}
		else {
			return false;
		}

	}

	private boolean checkFlush(Hand<Card> hand) {

		Card card = hand.getCards().get(0);
		Suit suit = Suit.getSuitFromValue(card.suit);
		if (suitMap.get(suit).size() == 5) {
			return true;
		}
		return false;
	}

}
