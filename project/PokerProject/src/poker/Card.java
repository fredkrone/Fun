package poker;

public class Card {
	
	protected int value;
	protected int suit;

	public Card(int s, int v) {
		value = v;
		suit = s;
	}

	public Suit getSuit() {
		return Suit.getSuitFromValue(value);
	}


}
