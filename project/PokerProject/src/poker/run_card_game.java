package poker;


import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;

public class run_card_game {

	PokerHandEvaluator eval;

	@Test
	public void test_hand() {
		eval = new PokerHandEvaluator();

		eval.getDeck();
		Assert.assertEquals(52, eval.deck.size());
		
		Hand<Card> hand = eval.generateHand();
		Assert.assertEquals(5, hand.getCards().size());
		
		
	}

	@Test
	public void test_royal_flush() {
		eval = new PokerHandEvaluator();

		Hand<Card> hand = new Hand<Card>();
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card(0, 13)); // ace
		cards.add(new Card(0, 12)); // king
		cards.add(new Card(0, 11)); // queen
		cards.add(new Card(0, 10)); // jack
		cards.add(new Card(0, 9)); // 10

		hand.setCards(cards);

		String result = eval.evaluateHand(hand);
		System.out.println(result);
	}

	@Test
	public void test_straight_flush() {
		eval = new PokerHandEvaluator();

		Hand<Card> hand = new Hand<Card>();
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card(0, 1)); // ace
		cards.add(new Card(0, 2)); // king
		cards.add(new Card(0, 3)); // queen
		cards.add(new Card(0, 4)); // jack
		cards.add(new Card(0, 5)); // 10

		hand.setCards(cards);

		String result = eval.evaluateHand(hand);
		System.out.println(result);
	}
	
	@Test
	public void test_two_pair() {
		eval = new PokerHandEvaluator();

		Hand<Card> hand = new Hand<Card>();
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card(0, 1)); // ace
		cards.add(new Card(1, 1)); // king
		cards.add(new Card(0, 6)); // queen
		cards.add(new Card(0, 6)); // jack
		cards.add(new Card(0, 5)); // 10

		hand.setCards(cards);

		String result = eval.evaluateHand(hand);
		System.out.println(result);
	}

	@Test
	public void test_flush() {
		eval = new PokerHandEvaluator();

		Hand<Card> hand = new Hand<Card>();
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card(0, 1)); // two
		cards.add(new Card(0, 12)); // king
		cards.add(new Card(0, 11)); // queen
		cards.add(new Card(0, 10)); // jack
		cards.add(new Card(0, 9)); // 10

		hand.setCards(cards);

		String result = eval.evaluateHand(hand);
		System.out.println(result);
	}

	@Test
	public void test_straight() {
		eval = new PokerHandEvaluator();

		Hand<Card> hand = new Hand<Card>();
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card(1, 13)); // ace
		cards.add(new Card(0, 12)); // king
		cards.add(new Card(0, 11)); // queen
		cards.add(new Card(0, 10)); // jack
		cards.add(new Card(0, 9)); // 10

		hand.setCards(cards);

		String result = eval.evaluateHand(hand);
		System.out.println(result);	}

	@Test
	public void test_four_of_a_kind() {
		eval = new PokerHandEvaluator();

		Hand<Card> hand = new Hand<Card>();
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card(0, 13)); // ace
		cards.add(new Card(2, 13)); // ace
		cards.add(new Card(3, 13)); // ace
		cards.add(new Card(1, 13)); // ace
		cards.add(new Card(0, 9)); // 10

		hand.setCards(cards);

		String result = eval.evaluateHand(hand);
		System.out.println(result);
	}

	@Test
	public void test_three_of_a_kind() {
		eval = new PokerHandEvaluator();

		Hand<Card> hand = new Hand<Card>();
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card(0, 12)); // king
		cards.add(new Card(2, 13)); // ace
		cards.add(new Card(3, 13)); // ace
		cards.add(new Card(1, 13)); // ace
		cards.add(new Card(0, 9)); // 10

		hand.setCards(cards);

		String result = eval.evaluateHand(hand);
		System.out.println(result);
	}

	@Test
	public void test_two_of_a_kind() {
		eval = new PokerHandEvaluator();

		Hand<Card> hand = new Hand<Card>();
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card(0, 12)); // king
		cards.add(new Card(2, 11)); // queen
		cards.add(new Card(3, 13)); // ace
		cards.add(new Card(1, 13)); // ace
		cards.add(new Card(0, 9)); // 10

		hand.setCards(cards);

		String result = eval.evaluateHand(hand);
		System.out.println(result);
	}

	@Test
	public void test_full_house() {
		eval = new PokerHandEvaluator();

		Hand<Card> hand = new Hand<Card>();
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card(0, 12)); // king
		cards.add(new Card(2, 12)); // king
		cards.add(new Card(3, 13)); // ace
		cards.add(new Card(1, 13)); // ace
		cards.add(new Card(0, 13)); // ace

		hand.setCards(cards);

		String result = eval.evaluateHand(hand);
		System.out.println(result);
	}

	@Test
	public void test_random_hand() {
		eval = new PokerHandEvaluator();

		Hand<Card> hand = eval.generateHand();

		String result = eval.evaluateHand(hand);
		System.out.println(result);
	}

}

