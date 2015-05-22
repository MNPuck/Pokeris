package com.nowhereinc.Pokeris.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.nowhereinc.Pokeris.game.objects.AbstractGameObject;
import com.nowhereinc.Pokeris.game.objects.Border;
import com.nowhereinc.Pokeris.game.objects.Card;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.nowhereinc.Pokeris.util.Constants;
import com.nowhereinc.Pokeris.util.Deck;
import com.nowhereinc.Pokeris.util.Hand;
import com.nowhereinc.Pokeris.game.Assets;

public class Level {

	public static final String TAG = Level.class.getName();
	
	// Border
	public Border border;
	
	// cards array
	public Array<Card> cards;
	
	// current active card
	public Card activeCard;
	
	// Deck
	public Deck deck;
	
	// Hand
	public Hand hand;
	
	// variable to store level number
	public int levelNumber;
	
	// variable to store score
	public int score;
	
	// variable to see if this is new game
	private boolean newGame; 
	
	// game over boolean
	public boolean isGameOver;
	
	public Level () {

		init();
	}
		
	private void init() {
		
		// level number
		levelNumber = 0;
		
		// Deck
		deck = new Deck();
		
		// Shuffle Deck
		deck.shuffleDeck();
		
		// set to new game
		newGame = true;
		
		// set score to 0
		score = 0;
		
		// level game over init
		isGameOver = false;
		
		// create border
		AbstractGameObject obj = null;
		obj = new Border();
		obj.position.set(0,0);
		border = (Border)obj;
		
		// cards
		cards = new Array<Card>();
		
		newLevel();
		
	}
	
	public void update (float deltaTime) {
		
		// if active card is stopped add a new card
		
		if (activeCard.returnCardStopped()) {
			
			cards.add(activeCard);
			addCard();
			
		}
		
		// update active cards
		activeCard.update(deltaTime);
	
	}	
	
	private void addCard() {
		
		Card card = deck.getNextCard();
		
		Vector2 dropStartPos;
		dropStartPos = new Vector2 ( - Constants.GAMEBOARD_WIDTH * .5f + Constants.CARDXSIZE * .5f,
									   Constants.GAMEBOARD_HEIGHT * .5f - Constants.CARDYSIZE * .5f);
		
		card.setPosition(dropStartPos);
		activeCard = card;
		
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
		
		if (newGame) {
			
			newGame = false;
			addCard();
			
		}
		
		else {
			
			
		}
			
	}
	
	public int returnLevelNumber() {
		
		return levelNumber;
		
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
		
		// draw active card
		activeCard.render(batch);
		
		// draw inactive cards
		for (Card card : cards)
			card.render(batch);
		
	}

}
