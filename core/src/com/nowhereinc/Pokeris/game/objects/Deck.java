 package com.nowhereinc.Pokeris.game.objects;

import java.util.*;

public class Deck {

    public static int numSuits = 4;
    public static int numRanks = 13;
    public static int numCards = numSuits * numRanks;

    private Card[][] cards; 
    
    private int nextCard;

    public Deck() {
        cards = new Card[numSuits][numRanks];
        for (int suit = Card.DIAMONDS; suit <= Card.SPADES; suit++) {
            for (int rank = Card.ACE; rank <= Card.KING; rank++) {
                cards[suit-1][rank-1] = new Card(rank, suit);
            }
        }
        
        nextCard = 0;
        
    }

    public Card getCard(int suit, int rank) {
        return cards[suit-1][rank-1];
    }
    
    public void shuffleDeck() {
    	
    	Random generator = new Random();
    	int rndRank, rndSuit;
    	
    	 for (int suit = 0; suit <= numSuits - 1; suit++) {
    		 
           	for (int rank = 0; rank <= numRanks - 1; rank++) {
           		
            Card tempCard1 = cards[suit][rank];
            rndRank = generator.nextInt(13);
            rndSuit = generator.nextInt(4);
            Card tempCard2 = cards[rndSuit][rndRank];
            cards[suit][rank] = tempCard2;
            cards[rndSuit][rndRank] = tempCard1;
            
           	}
         }
    	 
    	 nextCard = 0;
        	 
    }

    public Card getNextCard() {
    	
    	int suitMod, rankMod;
    	
    	suitMod = nextCard / 13;
    	rankMod = nextCard % 13;
    	nextCard = nextCard + 1;
    	
    	return cards[suitMod][rankMod];
    	 
    }
    
    public Card getPreviewCard() {
    	
    	int suitMod, rankMod;
    	
    	suitMod = nextCard / 13;
    	rankMod = nextCard % 13;
    	
    	return cards[suitMod][rankMod];
    	 
    }
   
}
