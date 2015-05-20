package com.nowhereinc.Pokeris.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.nowhereinc.Pokeris.game.objects.AbstractGameObject;
import com.nowhereinc.Pokeris.game.objects.Border;
import com.nowhereinc.Pokeris.game.objects.Card;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.nowhereinc.Pokeris.util.Constants;
import com.nowhereinc.Pokeris.util.Deck;
import com.nowhereinc.Pokeris.util.Hand;
import com.nowhereinc.Pokeris.game.Assets;

public class Level {

	public static final String TAG = Level.class.getName();
	
	// Border
	public Border border;
	
	// Card
	public Card card;
	
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
		
		newLevel();
		
	}
	
	public void update (float deltaTime) {
	
		
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
		
	}

}
