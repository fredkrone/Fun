package poker;
import java.util.ArrayList;


public class Hand<Card> {
	
	protected ArrayList<Card> cards = new ArrayList<Card>();

	public int score() {
		int score = 0;
		for (Card card : cards) {
			// score += card.value();
		}
		return score;
	}

	public void add(Card card) {
		cards.add(card);
	}

	public ArrayList<Card> getCards() {
		return cards;
	}

	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}

}
