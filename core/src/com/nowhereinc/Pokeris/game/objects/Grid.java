package com.nowhereinc.Pokeris.game.objects;

public class Grid {

    public static int numRows = 10;
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
    	
    	for (int column = 1; column < 6; column++) {
    		
    		deleteCard(row, column);
    		
    	}
    	
    	// move rows down 
    	
    	for (int moveRow = row + 1; moveRow < 11; moveRow++) {
    		
    		for (int moveColumn = 1; moveColumn < 6; moveColumn++) {
    			
    			if (getIsFull(moveRow, moveColumn)) {
    			
    				Card moveCard = getCard(moveRow, moveColumn);
    			
    				putCard(moveRow - 1, moveColumn, moveCard.getRank(), moveCard.getSuit());
    				
    			
    			}
    			
    			isFull[moveRow - 1][moveColumn - 1] = false;
    			
    		}
    		
    	}
    	
    }
    
    public void deleteColumn (int column) {
    	
    	for (int row = 1; row < 6; row++) {
    		
    		deleteCard(row, column);
    		
    	}
    	
    }
    
}
