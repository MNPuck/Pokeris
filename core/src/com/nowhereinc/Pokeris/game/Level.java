package com.nowhereinc.Pokeris.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.nowhereinc.Pokeris.game.objects.AbstractGameObject;
import com.nowhereinc.Pokeris.game.objects.Border;
import com.nowhereinc.Pokeris.game.objects.Card;
import com.nowhereinc.Pokeris.game.objects.Deck;
import com.nowhereinc.Pokeris.game.objects.Grid;
import com.nowhereinc.Pokeris.game.objects.Hand;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.nowhereinc.Pokeris.util.Constants;
import com.nowhereinc.Pokeris.game.Assets;

public class Level {

	public static final String TAG = Level.class.getName();
	
	// Border
	public Border border;
	
	// cards array
	public Array<Card> cards;
	
	// current active card
	public Card activeCard;
	
	// current hold card
	public Card holdCard;
	
	// current preview card
	public Card previewCard;
	
	// Deck
	public Deck deck;
	
	// Hand
	public Hand hand;
	
	// Grid
	public Grid grid;
	
	// variable to store level number
	public int levelNumber;
	
	// variable to store score
	public int score;
	
	// variable to see if this is new game
	private boolean newGame; 
	
	// game over boolean
	public boolean isGameOver;
	
	// cards remaining
	private int cardsRemaining;
	
	// can swap cards boolean
	private boolean canSwapCards;
	
	// lines cleared
	private int linesCleared;
	
	// level clear pause
	private boolean levelClearPause;
	
	// last poker hand
	private int lastPokerHand;
	
	// last poker hand time
	private float lastPokerHandTime;
	
	// level time
	private float levelTime;
	
	// level time multiplier
	private int levelTimeMultiplier;

	
	public Level () {

		init();
	}
		
	private void init() {
		
		// level number
		levelNumber = 0;
		
		// set score to 0
		score = 0;
		
		// level game over init
		isGameOver = false;
		
		// create border
		AbstractGameObject obj = null;
		obj = new Border();
		obj.position.set(0,0);
		border = (Border)obj;
		
		newLevel();
		
		canSwapCards = false;
		levelClearPause = false;
		
	}
	
	public void update (float deltaTime, boolean holdPressed, boolean keyPressed) {
		
		// check grid row 13 columns, if piece there set game over to true
	 	
		for (int columns = 1; columns < 6; columns++) {
			
			if (grid.getIsFull(10, columns)) {
				
				isGameOver = true;
				break;
				
			}
			
		}
		
		if (!isGameOver &&
			!levelClearPause) {
			
			levelTime += deltaTime;
			
			if (lastPokerHandTime > 0f) {
				
				lastPokerHandTime -= deltaTime;
				
			}
		
			if (holdPressed &&
				holdCard.getRank() != 0 &&
				holdCard.getSuit() != 0 &&
				canSwapCards) {
			
				canSwapCards = false;
			
				Card tempCard = new Card(activeCard.getRank(), activeCard.getSuit());	
				tempCard.setPosition(activeCard.getPositionX(), activeCard.getPositionY());
				
				activeCard = holdCard;
				holdCard = tempCard;
				
				Vector2 dropStartPos;
				dropStartPos = new Vector2 (0, Constants.GAMEBOARD_HEIGHT * .5f);
			
				activeCard.resetVelocity();
				activeCard.setPosition(dropStartPos.x, dropStartPos.y);
			
			}
		
			if (holdPressed &&
				holdCard.getRank() == 0 &&
				holdCard.getSuit() == 0) {
			
				holdCard = activeCard;
				holdCard.resetVelocity();
				addCard();
			
			}
		
			// if active card is stopped add a new card
		
			if (activeCard.returnCardStopped()) {
				
				if (cardsRemaining > 0) {
		
					cards.add(activeCard);
					addCard();
	
				}
			
				else {
				
					addLevelScore();
				
				}
			
			}
			
			switch (Gdx.app.getType()) {
			
			case Desktop: 
				
				activeCard.updateDesktop(deltaTime, grid, levelNumber);	
				break;
			
			case Android:
				activeCard.updateAndroid(deltaTime, grid, levelNumber);
				break;
			
			default:
				break;
					
			}

		
			// grid row update
			updateRows();
		
			// grid column update
			// updateColumns();

		}	
		
		if (levelClearPause) {
			
			if (keyPressed) {
				
				levelClearPause = false;
				newLevel();

			}
			
		}
		
	}
	
	private void updateRows() {
		
		// loop thru grid rows, if there are 5 cards check for valid poker hand delete row and move
		// rows down
		
		for (int row = 1; row < 10; row++) {
			
			int columnCounter = 0;
			
			Hand rowHand;
			
			rowHand = new Hand();
			
			for (int column = 1; column < 6; column++) {
				
				if (grid.getIsFull(row, column)) {
					
					Card rowCard;
					rowCard = grid.getCard(row, column);
					
					int rowRank = rowCard.getRank();
					int rowSuit = rowCard.getSuit();
			
					rowHand.putCard(rowRank, rowSuit);
					
					columnCounter++;
					
				}
				
				else {
					
					break;
					
				}	
				
			}
			
			if (columnCounter == 5) {
				
				rowHand.sortCards();
				int rowPokerHand = rowHand.return5CardPokerHand();
				
				if (rowPokerHand > 1) {
					
					score += rowHand.returnScore(rowPokerHand);
					linesCleared++;
					lastPokerHand = rowPokerHand;
					lastPokerHandTime = Constants.POKERSCORESHOWTIME;
					
					grid.deleteRow(row);
					
					// change card position in card for rows which fell down after deletion
					
					for (int i = row; i < 10; i++) {
						
						for (int j = 1; j < 6; j++) {
							
							if (grid.getIsFull(i, j)) {
								
								Card changePosCard = grid.getCard(i, j);
							
								for (Card card : cards) {
								
									if (changePosCard.getRank() == card.getRank() &&
										changePosCard.getSuit() == card.getSuit()) {
									
										card.dropRow();
									
									}
								
								}
								
							}
							
						}
						
					}
					
				}
					
			}	
			
		}
			
	}
	
	private void updateColumns() {
		
		// loop thru columns and delete column if valid poker hand is made
		
		for (int column = 1; column < 6; column++) {
			
			int rowCounter = 0;
			
			Hand columnHand;
			
			columnHand = new Hand();
			
			for (int row = 1; row < 6; row++) {
				
				if (grid.getIsFull(row, column)) {
					
					Card columnCard;
					columnCard = grid.getCard(row, column);
			
					columnHand.putCard(columnCard.getRank(), columnCard.getSuit());
					
					rowCounter++;
					
				}
				
				else {
					
					break;
					
				}
				
			}
				
			if (rowCounter == 5) {
					
				columnHand.sortCards();
				int columnPokerHand = columnHand.return5CardPokerHand();
					
				if (columnPokerHand > 1) {
					
					score += columnHand.returnScore(columnPokerHand);
						
					grid.deleteColumn(column);
						
				}
				
			}
			
		}
		
	}
	
	private void addCard() {
		
		Card card = deck.getNextCard();
		
		Vector2 dropStartPos;
		dropStartPos = new Vector2 (0, Constants.GAMEBOARD_HEIGHT * .5f);
		
		card.setPosition(dropStartPos.x, dropStartPos.y);
		activeCard = card;
		
		cardsRemaining--;
		
		if (cardsRemaining > 0) {
		
			previewCard = deck.getPreviewCard();
			
		}
		
		else {
			
			previewCard = new Card(0,0);
			
		}
		
		canSwapCards = true;
		
	}
	
	private void addLevelScore() {
		
		if (levelTime < Constants.LEVELTIMEGOAL) {
			
			levelTimeMultiplier = (int) (Constants.LEVELTIMEGOAL - levelTime);
			
		}
		
		else {
			
			levelTimeMultiplier = 1;
			
		}
		
		levelClearPause = true;
		
		score += (linesCleared * levelNumber * 100) + (levelTimeMultiplier * 100); 
		
	}
	
	private void newLevel() {
		
		// inc level number 
		levelNumber++;
		
		// if level greater then max level set game over
		
		if (levelNumber > Constants.NUMBEROFLEVELS) {
			
			isGameOver = true;
			
		}
		
		else {
	
			loadLevel();
		
		}
		
	}
	
	private void loadLevel() {
		
		// Deck
		deck = null;
		deck = new Deck();
		
		// Shuffle Deck
		deck.shuffleDeck();
		
	    // Grid
		grid = null;
		grid = new Grid();
		
		// cards
		cards = null;
		cards = new Array<Card>();
		
		// init hold card to 0,0
		holdCard = new Card(0,0);
	
		cardsRemaining = 52;
		linesCleared = 0;
		
		lastPokerHand = 0;
		
		levelTime = 0;
		
		addCard();
			
	}
	
	public int returnCardsRemaining() {
		
		return cardsRemaining;
		
	}
	
	public int returnLastPokerHand() {
		
		return lastPokerHand;
		
	}
	
	public float returnLastPokerHandTime() {
		
		return lastPokerHandTime;
		
	}
	
	public boolean returnLevelClearPause() {
		
		return levelClearPause;
		
	}
	
	public int returnLevelNumber() {
		
		return levelNumber;
		
	}
	
	public float returnLevelTime() {
		
		return levelTime;
		
	}
	
	public int returnLevelTimeMultiplier() {
		
		return levelTimeMultiplier;
		
	}
	
	public int returnLinesCleared() {
		
		return linesCleared;
		
	}
	
	public int returnScore() {
		
		return score;
		
	}
	
	public boolean returnIsGameOver() {
		
		return isGameOver;
	}

	public void render (SpriteBatch batch, float deltaTime) {
		
		// draw border
		border.render(batch);
		
		if (!levelClearPause) {
		
			// draw active card
			activeCard.render(batch);
		
			//draw cards from grid
			renderGrid(batch);
		
		}
		
	}
	
	private void renderGrid(SpriteBatch batch) {
		
		for (int row = 1; row < 11; row++) {
			
			for (int column = 1; column < 6; column++) {
				
				if (grid.getIsFull(row, column)) {
					
					Card currentCard = grid.getCard(row, column);
					
					for (Card card : cards) {
						
						if (currentCard.getRank() == card.getRank() &&
							currentCard.getSuit() == card.getSuit()) {
							
							card.render(batch);
							
							
						}
						
					}
					
				}
				
			}
			
		}
		
	}

}
