package com.nowhereinc.Pokeris.game.objects;

import java.util.*; 


public class Hand {
	
	private Card[] cards;
	private int counter = 0;
	
	public Hand() {
		cards = new Card[13];
		for (int i = 0; i < 13; i++) {
			cards[i] = new Card(1,1);
		}
		counter = 0;
	}
	
	public Card getCard(int cardNum) {
		
		Card returnCard = cards[cardNum];
        return returnCard;
        
    }
	
	public void putCard(int rank, int suit) {
		
		cards[counter] = new Card(rank, suit);
		counter++;
		
	}
	
	public int returnNumCards() {
		return counter;
	}
	
	public void displayCards() {
		
		for(int i = 0; i < counter; i++) {
			Card returnCard = cards[i];
			System.out.format("%s of %s%n",
	                returnCard.rankToString(returnCard.getRank()),
	                returnCard.suitToString(returnCard.getSuit()));
			
			
		}
	}
	
	//This will sort the cards in the hand based on rank
	
	public void sortCards() {
		
		for (int i = 0; i < counter; i++) {
			for (int j = 1; j < counter - i; j++) {
				
				Card compareCard1 = cards[j-1];
				Card compareCard2 = cards[j];
				
				int compareCard1Rank = 0;
				int compareCard2Rank = 0;	
				
				compareCard1Rank = compareCard1.getRank();
				
				if (compareCard1Rank == 1) {
					compareCard1Rank = 14; 
					}
				
				compareCard2Rank = compareCard2.getRank();
				
				if (compareCard2Rank == 1) {
					compareCard2Rank = 14; 
					}
				
				
				if (compareCard1Rank < compareCard2Rank) {
				
				  cards[j-1] = compareCard2;
				  cards[j] = compareCard1;
				}
			}
		}
	}
	
	/* The method below will return the poker hand as an integer: 1 = high card, 2 = pair, 3 = 2 pair, 4 = 3 of kind, 5 = str8, 6 = flush
	   7  = full house, 8 = quads, 9 = str8 flush 10 = royal flush */
	
	public int return5CardPokerHand () {
		
		// check for str8 flush and royal flush		
		// needs to add code to figure the str8 flush wheel	
		
		if (cards[0].getSuit() == cards[1].getSuit() &
			cards[1].getSuit() == cards[2].getSuit() &
			cards[2].getSuit() == cards[3].getSuit() &
			cards[3].getSuit() == cards[4].getSuit() &
			cards[0].getRank() == cards[1].getRank() + 1 &
			cards[1].getRank() == cards[2].getRank() + 1 &	
			cards[2].getRank() == cards[3].getRank() + 1 &
			cards[3].getRank() == cards[4].getRank() + 1) {
				
				// if the first card is ace it's a royal flush
			
				if (cards[0].getRank() == 1) {
					return 10;
				}
				
				return 9;
		}
		
		if (cards[0].getSuit() == cards[1].getSuit() &
			cards[1].getSuit() == cards[2].getSuit() &
			cards[2].getSuit() == cards[3].getSuit() &
			cards[3].getSuit() == cards[4].getSuit() &
			cards[0].getRank() == cards[4].getRank() + 1 &
			cards[4].getRank() == cards[3].getRank() + 1 &	
			cards[3].getRank() == cards[2].getRank() + 1 &
			cards[2].getRank() == cards[1].getRank() + 1) {
					
				swapCards(1,4);
				swapCards(2,3);
				return 9;
			}
		
		// check for quads
		
		if (cards[0].getRank() == cards[1].getRank() &
			cards[1].getRank() == cards[2].getRank() &
			cards[2].getRank() == cards[3].getRank()) {
				return 8;
		}
		
		if (cards[1].getRank() == cards[2].getRank() &
			cards[2].getRank() == cards[3].getRank() &
			cards[3].getRank() == cards[4].getRank()) {
				
				swapCards(0,4);
				return 8;
			}
		
		// check for full house
		
		if (cards[0].getRank() == cards[1].getRank() &
			cards[2].getRank() == cards[3].getRank() &
			cards[3].getRank() == cards[4].getRank()) {
			    
				swapCards(0,3);
				swapCards(1,4);
				return 7;
		}
		
		if (cards[0].getRank() == cards[1].getRank() &
			cards[1].getRank() == cards[2].getRank() &
			cards[3].getRank() == cards[4].getRank())
				return 7;
		
		// check for flush
		
		if (cards[0].getSuit() == cards[1].getSuit() &
			cards[1].getSuit() == cards[2].getSuit() &
			cards[2].getSuit() == cards[3].getSuit() &
			cards[3].getSuit() == cards[4].getSuit())
				return 6;
		
		// check for str8
		
		if (cards[0].getRank() == cards[1].getRank() + 1 &
			cards[1].getRank() == cards[2].getRank() + 1 &	
			cards[2].getRank() == cards[3].getRank() + 1 &
			cards[3].getRank() == cards[4].getRank() + 1)
				return 5;
		
		if (cards[0].getRank() == cards[4].getRank() + 1 &
			cards[4].getRank() == cards[3].getRank() + 1 &	
			cards[3].getRank() == cards[2].getRank() + 1 &
			cards[2].getRank() == cards[1].getRank() + 1) {
		
				swapCards(1,4);
				swapCards(2,3);							
				return 5;
			}
		
		// check for 3 of kind
		
		if (cards[0].getRank() == cards[1].getRank() &
			cards[1].getRank() == cards[2].getRank())
				return 4;
		
		if (cards[1].getRank() == cards[2].getRank() &
			cards[2].getRank() == cards[3].getRank()) {
				
				swapCards(0,3);
				return 4;
		}
		
		if (cards[2].getRank() == cards[3].getRank() &
			cards[3].getRank() == cards[4].getRank()) {
				
				swapCards(0,3);
				swapCards(1,4);
				return 4;
		}
		
		// check for 2 pair
		
		if (cards[0].getRank() == cards[1].getRank() &
			cards[2].getRank() == cards[3].getRank())
				return 3;
		
		if (cards[0].getRank() == cards[1].getRank() &
			cards[3].getRank() == cards[4].getRank()) {
			
				swapCards(2,4);
				return 3;
		}
		
		if (cards[1].getRank() == cards[2].getRank() &
			cards[3].getRank() == cards[4].getRank()) {
				
				swapCards(0,1);
				swapCards(1,2);
				swapCards(2,3);
				swapCards(3,4);
				return 3;
		}
		
		// check for 1 pair
		
		if (cards[0].getRank() == cards[1].getRank())
				return 2;
		
		if (cards[1].getRank() == cards[2].getRank()) {
				
				swapCards(0,1);
				swapCards(1,2);
				return 2;
		}
		
		if (cards[2].getRank() == cards[3].getRank()) {
				
				swapCards(0,2);
				swapCards(1,3);
				return 2;		
		}
		
		if (cards[3].getRank() == cards[4].getRank()) {
			
				swapCards(0,3);
				swapCards(1,4);
				swapCards(2,3);
				swapCards(3,4);
				return 2;
		}
		
		// default return of high card
		
		return 1;
		
	}	
	/* The method below will return the poker hand as an integer: 1 = high card, 2 = pair, 3 = 3 of kind,
	*/
	
	public int return3CardPokerHand () {
		
		// check for 3 of kind
		
		if (cards[0].getRank() == cards[1].getRank() &
			cards[1].getRank() == cards[2].getRank())
				return 4;
		
		// check for 1 pair
		
		if (cards[0].getRank() == cards[1].getRank())
				return 2;
		
		if (cards[1].getRank() == cards[2].getRank()) {
			
				swapCards(0,1);
				swapCards(1,2);			
				return 2;
		}
			
		// default return of high card
		
		return 1;
		
	}	
	
	public int returnPokerRoyalties5(int pokerHandValue) {
		
		if (pokerHandValue == 5)
			return 2;
	
		if (pokerHandValue == 6)
			return 4;
		
		if (pokerHandValue == 7)
			return 6;
		
		if (pokerHandValue == 8)
			return 10;
		
		if (pokerHandValue == 9)
			return 15;
		
		if (pokerHandValue == 10)
			return 25;
		
		return 0;	
	}
	
	public int returnPokerRoyalties3(int pokerHandValue) {
		
		int cardRank;
		
		cardRank = cards[0].getRank();
		
		if (pokerHandValue == 4)
			return 20;
		
		if (pokerHandValue == 2)
			
			switch (cardRank) {
				
				case 6: 
					return 1;
					
				case 7: 
					return 2;
					
				case 8:
					return 3;
					
				case 9:
					return 4;
					
				case 10:
					return 5;
					
				case 11:
					return 6;
					
				case 12:
					return 7;
					
				case 13:
					return 8;
					
				case 1:
					return 9;
					
				default:
					return 0;
			}
		
		return 0;	
	}
	
	public int checkFor4Flush(){
		
		// compare first 4 cards for 4 flush
		if (cards[0].getSuit() == cards[1].getSuit() &
			cards[1].getSuit() == cards[2].getSuit() &
			cards[2].getSuit() == cards[3].getSuit()) {
				return 1;
		}
		
		// compare cards 1, 3, 4, 5 for 4 flush
		if (cards[0].getSuit() == cards[2].getSuit() &
			cards[2].getSuit() == cards[3].getSuit() &
			cards[3].getSuit() == cards[4].getSuit()) {
				swapCards(1,4);
				return 1;
		}
		
		//compare cards 1, 2, 4, 5 for 4 flush
		if (cards[0].getSuit() == cards[1].getSuit() &
			cards[1].getSuit() == cards[3].getSuit() &
			cards[3].getSuit() == cards[4].getSuit()) {
				swapCards(2,3);
				swapCards(3,4);
				return 1;
		}
		
		//compare cards 1, 2, 3, 5 for 4 flush
		if (cards[1].getSuit() == cards[2].getSuit() &
			cards[2].getSuit() == cards[3].getSuit() &
			cards[3].getSuit() == cards[4].getSuit()) {
				swapCards(0,4);
				return 1;
		}
		
		return 0;
		
	}
	
	public int checkFor4Str8(){
		
		if (cards[0].getRank() == cards[1].getRank() + 1 &
		    cards[1].getRank() == cards[2].getRank() + 1 &
		    cards[2].getRank() == cards[3].getRank() + 1) {
				return 1;
		}
		
		if (cards[1].getRank() == cards[2].getRank() + 1 &
		    cards[2].getRank() == cards[3].getRank() + 1 &
		    cards[3].getRank() == cards[4].getRank() + 1) {
				swapCards(0,4);
				return 1;
		}
		
		if (cards[0].getRank() == cards[4].getRank() + 1 &
			cards[4].getRank() == cards[3].getRank() + 1 &
			cards[3].getRank() == cards[2].getRank() + 1) {
				swapCards(1,4);
				return 1;
		}
		
		return 0;
	}
	
	public int checkFor3Flush(){
	
		// compare first 3 cards for 3 flush
		if (cards[0].getSuit() == cards[1].getSuit() &
			cards[1].getSuit() == cards[2].getSuit()) {
				return 1;
		}
		
		// compare cards 1, 3, 4 for 3 flush
		if (cards[0].getSuit() == cards[2].getSuit() &
			cards[2].getSuit() == cards[3].getSuit()) {
				swapCards(1,3);
				return 1;
		}
		
		//compare cards 1, 3, 5 for 3 flush
		if (cards[0].getSuit() == cards[2].getSuit() &
			cards[2].getSuit() == cards[4].getSuit()) {
				swapCards(1,2);
				swapCards(2,4);
				return 1;
		}
		
		//compare cards 1, 2, 4 for 3 flush
		
		if (cards[0].getSuit() == cards[1].getSuit() &
			cards[1].getSuit() == cards[3].getSuit()) {
				swapCards(2,3);
				return 1;
		}
		
		//compare cards 1, 2, 5 for 3 flush
		if (cards[0].getSuit() == cards[1].getSuit() &
			cards[1].getSuit() == cards[4].getSuit()) {
				swapCards(2,4);
				return 1;
		}
		
		//compare cards 2, 3, 4 for 3 flush
		if (cards[1].getSuit() == cards[2].getSuit() &
			cards[2].getSuit() == cards[3].getSuit()) {
				swapCards(0,3);
				return 1;
		}
		
		//compare cards 2, 3, 5 for 3 flush
		if (cards[1].getSuit() == cards[2].getSuit() &
			cards[2].getSuit() == cards[4].getSuit()) {
				swapCards(0,4);
				return 1;
		}
		
		//compare cards 3, 4 ,5 for 3 flush
		if (cards[2].getSuit() == cards[3].getSuit() &
			cards[3].getSuit() == cards[4].getSuit()) {
				swapCards(0,3);
				swapCards(1,4);
				return 1;
		}
		
		return 0;
		
	}
	
	public int checkFor3Str8(){
			
		// compare first 3 cards for 3 str8
		
		if (cards[0].getRank() == cards[1].getRank() + 1 &
			cards[1].getRank() == cards[2].getRank() + 1) {
				return 1;
		}
		
		// compare cards 2, 3, 4 for 3 str8
		
		if (cards[1].getRank() == cards[2].getRank() + 1 &
			cards[2].getRank() == cards[3].getRank() + 1) {
				swapCards(0,3);
				return 1;
		}
		
		//compare cards 3, 4, 5 for 3 str8
		
		if (cards[2].getRank() == cards[3].getRank() + 1 &
			cards[3].getRank() == cards[4].getRank() + 1) {
				swapCards(0,4);
				swapCards(1,3);
				return 1;
		}
		
		//compare cards 1, 4, 5 for wrap around str8
		if (cards[0].getRank() == cards[4].getRank() + 1 &
			cards[4].getRank() == cards[3].getRank() + 1) {
				swapCards(1,4);
				swapCards(2,3);
				return 1;
		}
		
		//compare cards 1, 4, 5 for wrap around str8
		
		return 0;
		
	}
	
	public int twoXtoflush(){
		
		// compare cards 1 & 2 for 2 flush and cards 3 & 4 for another 2 flush
		
		if (cards[0].getSuit() == cards[1].getSuit() &
			cards[2].getSuit() == cards[3].getSuit()) {
				return 1;
		}
		
		// compare cards 1 & 2 for 2 flush and cards 3 & 5 for another 2 flush
		
		if (cards[0].getSuit() == cards[1].getSuit() &
			cards[2].getSuit() == cards[4].getSuit()) {
				swapCards(4,5);
				return 1;
		}
		
		// compare cards 1 & 2 for 2 flush and cards 4 & 5 for another 2 flush
		
		if (cards[0].getSuit() == cards[1].getSuit() &
			cards[3].getSuit() == cards[4].getSuit()) {
				swapCards(2,3);
				swapCards(3,4);
				return 1;
		}
		
		// compare cards 1 & 3 for 2 flush and cards 2 & 4 for another 2 flush
		
		if (cards[0].getSuit() == cards[2].getSuit() &
			cards[1].getSuit() == cards[3].getSuit()) {
				swapCards(1,2);
				return 1;
		}
		
		// compare cards 1 & 3 for 2 flush and cards 2 & 5 for another 2 flush
		
		if (cards[0].getSuit() == cards[2].getSuit() &
			cards[1].getSuit() == cards[4].getSuit()) {
				swapCards(1,2);
				swapCards(3,4);
				return 1;
		}
		
		// compare cards 1 & 3 for 2 flush and cards 4 & 5 for another 2 flush

		if (cards[0].getSuit() == cards[2].getSuit() &
			cards[3].getSuit() == cards[4].getSuit()) {
				swapCards(1,2);
				swapCards(2,3);
				swapCards(3,4);
				return 1;
		}
		
		// compare cards 2 & 3 for 2 flush and cards 1 & 4 for another 2 flush
		
		if (cards[0].getSuit() == cards[3].getSuit() &
			cards[1].getSuit() == cards[2].getSuit()) {
				swapCards(1,3);
				swapCards(2,3);
				return 1;
		}
		
		// compare cards 2 & 3 for 2 flush and cards 1 & 5 for another 2 flush
		
		if (cards[0].getSuit() == cards[4].getSuit() &
			cards[1].getSuit() == cards[2].getSuit()) {
				swapCards(1,4);
				swapCards(2,4);
				return 1;	
		}
		
		// compare cards 2 & 3 for 2 flush and cards 4 & 5 for another 2 flush
		
		if (cards[3].getSuit() == cards[4].getSuit() &
			cards[1].getSuit() == cards[2].getSuit()) {
				swapCards(0,1);
				swapCards(1,2);
				swapCards(2,3);
				swapCards(3,4);
				return 1;	
		}
		
		// compare cards 3 & 4 for 2 flush and cards 1 & 5 for another 2 flush
		
		if (cards[2].getSuit() == cards[3].getSuit() &
			cards[0].getSuit() == cards[4].getSuit()) {
				swapCards(1,4);
				return 1;			
		}
		
		// compare cards 3 & 4 for 2 flush and cards 2 & 5 for another 2 flush
		
		if (cards[2].getSuit() == cards[3].getSuit() &
			cards[1].getSuit() == cards[4].getSuit()) {
				swapCards(0,1);
				swapCards(1,4);
				return 1;			
		}
		
		return 0;
	}
	
	public int processInitPairHands(){
		
		// if cards 3,4,5 are same suit keep in same place
		
		if (cards[2].getSuit() == cards[3].getSuit() &
			cards[3].getSuit() == cards[4].getSuit()) {
				return 1;
		}
		
		// if cards 3,4,5 are a str8 keep in same place
		if (cards[2].getRank() == cards[3].getRank() + 1 &
			cards[3].getRank() == cards[4].getRank() + 1) {
				return 1;
		}
		
		// if pair is aces then return them up front
		if (cards[0].getRank() == 1 &
			cards[1].getRank() == 1) {
				return 3;
		}
		
		// if the pair is less than card 3 then place the pair in back with high card, one middle, one front
		if (cards[0].getRank() < cards[2].getRank()|
			cards[2].getRank() == 1) {

				return 2;
		}
		
		// returning a 3 will result in the calling program placing 2 cards in middle and 1 up front
		
		return 3;
		
	}
	
	public int subCheckFor4Flush(){
		
		if (cards[0].getSuit() == cards[1].getSuit() &
			cards[1].getSuit() == cards[2].getSuit() &
			cards[2].getSuit() == cards[3].getSuit()) {
				return cards[0].getSuit();
		}
		
		return 0;
		
	}
	
	public int subCheckFor4Str8Low(){
		
		if (cards[0].getRank() == cards[1].getRank() + 1 &
			cards[1].getRank() == cards[2].getRank() + 1 &
			cards[2].getRank() == cards[3].getRank() + 1) {
				return cards[3].getRank() - 1;
		}
		
		return 0;
		
	}
	
	public int subCheckFor4Str8High(){
		
		if (cards[0].getRank() == cards[1].getRank() + 1 &
			cards[1].getRank() == cards[2].getRank() + 1 &
			cards[2].getRank() == cards[3].getRank() + 1) {
				return cards[0].getRank() + 1;
		}
		
		return 0;
		
	}
	
	public int subCheckFor2PairFirst(){
		
		if (cards[0].getRank() == cards[1].getRank() &
			cards[2].getRank() == cards[3].getRank()) {
				return cards[0].getRank();
		}
			
		return 0;
	
	}
	
	public int subCheckFor2PairSecond(){
		
		if (cards[0].getRank() == cards[1].getRank() &
			cards[2].getRank() == cards[3].getRank()) {
				return cards[2].getRank();
		}
		
		return 0;
	
	}
	
	public int subCheckFor4FullHouse1(){
	
		
		if (cards[0].getRank() == cards[1].getRank() &
			cards[1].getRank() == cards[2].getRank()) {
				return cards[0].getRank();
		}
		
		if (cards[1].getRank() == cards[2].getRank() &
			cards[2].getRank() == cards[3].getRank()) {
				return cards[1].getRank();
		}
		
		if (cards[0].getRank() == cards[2].getRank() &
			cards[2].getRank() == cards[3].getRank()) {
				return cards[0].getRank();
		}
		
		if (cards[0].getRank() == cards[1].getRank() &
			cards[1].getRank() == cards[3].getRank())
				return cards[0].getRank();
		
		return 0;
		
	}
	
	public int subCheckFor4FullHouse2(){
		
		if (cards[0].getRank() == cards[1].getRank() &
			cards[1].getRank() == cards[2].getRank()) {
				return cards[3].getRank();
		}
		
		if (cards[1].getRank() == cards[2].getRank() &
			cards[2].getRank() == cards[3].getRank()) {
				return cards[0].getRank();
		}
		
		if (cards[0].getRank() == cards[2].getRank() &
			cards[2].getRank() == cards[3].getRank()) {
				return cards[1].getRank();
		}
		
		if (cards[0].getRank() == cards[1].getRank() &
			cards[1].getRank() == cards[3].getRank())
				return cards[2].getRank();
		
		
		return 0;
		
	}
	
	public int subCheckFor3Flush(){
		
		if (cards[0].getSuit() == cards[1].getSuit() &
			cards[1].getSuit() == cards[2].getSuit()) {
				return cards[0].getSuit();
		}
			
		return 0;
	
	}
	
	public boolean subCheckForTrips(){
		
		if (cards[0].getRank() == cards[1].getRank() &
			cards[1].getRank() == cards[2].getRank()) {
				return true;
		}
		
		return false;
		
	}
	
	public int subCheckForPairPlusOne1(){
		
		if (cards[0].getRank() == cards[1].getRank()){
				return cards[0].getRank();
		}
		
		if (cards[0].getRank() == cards[2].getRank()){
			return cards[0].getRank();
		}
		
		if (cards[1].getRank() == cards[2].getRank()){
			return cards[1].getRank();
		}
		
		return 0;
			
	}
	
	public int subCheckForPairPlusOne2(){
		
		if (cards[0].getRank() == cards[1].getRank()){
				return cards[2].getRank();
		}
		
		if (cards[0].getRank() == cards[2].getRank()){
			return cards[1].getRank();
		}
		
		if (cards[1].getRank() == cards[2].getRank()){
			return cards[0].getRank();
		}
		
		return 0;
			
	}
	
	public int subCheckforPairPlusTwo1(){
		
		if (cards[0].getRank() == cards[1].getRank()){
			return cards[0].getRank();
		}
		
		if (cards[0].getRank() == cards[2].getRank()){
			return cards[0].getRank();
		}
		
		if (cards[0].getRank() == cards[3].getRank()){
			return cards[0].getRank();
		}
		
		if (cards[1].getRank() == cards[2].getRank()){
			return cards[1].getRank();
		}
		
		if (cards[1].getRank() == cards[3].getRank()){
			return cards[1].getRank();
		}
		
		if (cards[2].getRank() == cards[3].getRank()){
			return cards[0].getRank();
		}
		
		return 0;
	}
	
	public int subCheckforPairPlusTwo2(){
		
		if (cards[0].getRank() == cards[1].getRank()){
			return cards[2].getRank();
		}
		
		if (cards[0].getRank() == cards[2].getRank()){
			return cards[1].getRank();
		}
		
		if (cards[0].getRank() == cards[3].getRank()){
			return cards[1].getRank();
		}
		
		if (cards[1].getRank() == cards[2].getRank()){
			return cards[0].getRank();
		}
		
		if (cards[1].getRank() == cards[3].getRank()){
			return cards[0].getRank();
		}
		
		if (cards[2].getRank() == cards[3].getRank()){
			return cards[0].getRank();
		}
		
		return 0;
	}
	
	public int subCheckforPairPlusTwo3(){
		
		if (cards[0].getRank() == cards[1].getRank()){
			return cards[3].getRank();
		}
		
		if (cards[0].getRank() == cards[2].getRank()){
			return cards[3].getRank();
		}
		
		if (cards[0].getRank() == cards[3].getRank()){
			return cards[2].getRank();
		}
		
		if (cards[1].getRank() == cards[2].getRank()){
			return cards[3].getRank();
		}
		
		if (cards[1].getRank() == cards[3].getRank()){
			return cards[2].getRank();
		}
		
		if (cards[2].getRank() == cards[3].getRank()){
			return cards[1].getRank();
		}
		
		return 0;
	}
		
	public void swapCards(int card1, int card2) {
		
		Card tempCard = cards[0];
		
		tempCard = cards[card1];
		cards[card1] = cards[card2];
		cards[card2] = tempCard;
	}
}
