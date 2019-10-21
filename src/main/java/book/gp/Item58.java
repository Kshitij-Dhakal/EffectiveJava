package book.gp;

import java.util.*;


/**
 * <h1>Prefer for each loop to traditional for loops</h1>
 * <p>
 * If you are writing a type that represents a group of elements , you should strongly consider having it implement Iterable. This will allow your user to iterate over your type using the for-each loop.
 * </p>
 */

public class Item58 {

    private static Collection<Card.Suit> suits = Arrays.asList(Card.Suit.values());
    private static Collection<Card.Rank> ranks = Arrays.asList(Card.Rank.values());
    private Item58() {

    }

    public static void main(String[] args) {
        List<Card> deck = new ArrayList<>();
        notPreferred(deck);
        preferred(deck);

    }

    private static void preferred(List<Card> deck) {
        for (Card.Suit suit : suits) {
            for (Card.Rank rank : ranks) {
                deck.add(new Card(suit, rank));
            }
        }
        //to remove from collection do not use Iterator. Instead use removeIf
        suits.removeIf(suit -> suit == Card.Suit.CLUB);
    }

    private static void notPreferred(List<Card> deck) {
//        bugs(deck);
        for (Iterator<Card.Suit> i = suits.iterator(); i.hasNext(); ) {
            Card.Suit suit = i.next();//cluttered
            for (Iterator<Card.Rank> j = ranks.iterator(); j.hasNext(); ) {
                deck.add(new Card(suit, j.next()));
            }
        }
    }

    private static void bugs(List<Card> deck) {
        for (Iterator<Card.Suit> i = suits.iterator(); i.hasNext(); ) {
            for (Iterator<Card.Rank> j = ranks.iterator(); j.hasNext(); ) {
                deck.add(new Card(i.next(), j.next())); //parallel iteration
                //bug i.next() is called to many times
            }
        }
    }

    protected static class Card {
        Suit suit;
        Rank rank;

        public Card(Suit suit, Rank rank) {
            this.suit = suit;
            this.rank = rank;
        }

        enum Suit {
            CLUB, DIAMOND, HEART, SPADE
        }

        enum Rank {
            ACE, DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
        }
    }


}
