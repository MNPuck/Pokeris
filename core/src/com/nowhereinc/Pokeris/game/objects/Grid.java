package com.nowhereinc.Pokeris.game.objects;

import java.util.Random;

public class Grid {

    public static int numRows = 5;
    public static int numColumns = 5;
    public static int numCoordinates = numRows * numColumns;

    private Card[][] cards; 
    private boolean[][] isFull;
    
    public Grid() {
    	
        cards = new Card[numRows][numColumns];
        isFull = new boolean[numRows][numColumns];
        
        for (int row = 1; row < numRows - 1; row++) {
            for (int column = 1; column < numColumns; column++) {
                cards[row-1][column-1] = new Card(1, 1);
                isFull[row-1][column-1] = false;
            }
        }
        
    }
    
    public boolean getIsFull(int row, int column) {
    	
    	return isFull[row-1][column-1];
    	
    }

    public Card getCard(int row, int column) {
    	
    	return cards[row-1][column-1];
    	
    }
    
    public void putCard(int row, int column, int rank, int suit) {
    	
    	isFull[row-1][column-1] = true;
    	cards[row-1][column-1] = new Card(rank,suit);
    	
    }
    
    public void deleteCard(int row, int column) {
    	
    	isFull[row-1][column-1] = false;
    	
    }
    
    public void deleteRow (int row) {
    	
    	
    }
    
}
