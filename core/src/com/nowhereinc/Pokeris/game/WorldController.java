package com.nowhereinc.Pokeris.game;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.Controllers;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.nowhereinc.Pokeris.screens.DirectedGame;
import com.nowhereinc.Pokeris.util.CameraHelper;
import com.nowhereinc.Pokeris.util.Constants;
import com.nowhereinc.Pokeris.util.Xbox360Pad;


public class WorldController extends InputAdapter {

	private static final String TAG = WorldController.class.getName();
	
	private DirectedGame game;
	public Level level;
	
	private Controller player1Controller;
	
	private boolean startPressed;
	private boolean selectPressed;
	public boolean escPressed;
	public boolean gameOver;
	
	private boolean moveLeft;
	private boolean moveRight;
	private boolean moveUp;
	private boolean moveDown;
	private boolean holdPressed;
	
	private Rectangle arrowBox;
	private Rectangle holdBox;
	
	Vector2 cameraPosition;

	public WorldController (DirectedGame game) {
		this.game = game;
		init();
	}

	private void init () {
		
		Gdx.input.setInputProcessor(this);
		Gdx.input.setCatchBackKey(true);
		
		switch (Gdx.app.getType()) {
		
			case Desktop: 
				break;
				
			case Android:
				break;
				
			default:
				break;
		
		}
		
		startPressed = false;
		selectPressed = false;
		gameOver = false;
		escPressed = false;
		
		arrowBox = new Rectangle();
		holdBox = new Rectangle();
		
		initLevel();
		
	}
	
	private void initLevel() {
		
		level = new Level();

	}
	
	public boolean isGameOver () {
		return gameOver;
	}
	
	public boolean isEscPressed () {
		return escPressed;
	}
	
	public boolean isStartPressed() {
		return startPressed;
	}
	
	public boolean isSelectPressed() {
		return selectPressed;
	}
	
	public void update (float deltaTime, WorldRenderer worldRenderer) {
		
		gameOver = level.returnIsGameOver();
		
		moveRight = false;
		moveLeft = false;
		moveUp = false;
		moveDown = false;
		
		holdPressed = false;
		
		if (!gameOver) {
		
			switch (Gdx.app.getType()) {
		
				case Desktop: 
					readKeyboardInput();
					break;
			
				case Android:
					readScreenInput();
					break;
			
				default:
					break;
	
			}
			
			level.update(deltaTime, holdPressed);
		
		}
		
		switch (Gdx.app.getType()) {
		
		case Desktop: 
			checkEscKey();
			break;
		
		case Android:
			break;
		
		default:
			break;
				
		}
	
	}
	
	private void readKeyboardInput() {
		
		// if down is pressed speed up piece drop
		
		if (Gdx.input.isKeyPressed(Keys.DOWN) ||
			Gdx.input.isKeyPressed(Keys.S)) {
			
			moveDown = true;
	
		}
		
		// if up is pressed hard drop piece
		
		if (Gdx.input.isKeyJustPressed(Keys.UP) ||
			Gdx.input.isKeyJustPressed(Keys.W)) {
			
			moveUp = true;
			
		}
		
		// if right is pressed move card right
		
		if (Gdx.input.isKeyJustPressed(Keys.RIGHT) ||
			Gdx.input.isKeyJustPressed(Keys.D)) {
			
			moveRight = true;
			
		}
		
		// if left is pressed move card left
		
		
		if (Gdx.input.isKeyJustPressed(Keys.LEFT) ||
			Gdx.input.isKeyJustPressed(Keys.A)) {
			
			moveLeft = true;
			
		}
		
		level.activeCard.getInput(moveRight, moveLeft, moveUp, moveDown);
		
		if (Gdx.input.isKeyJustPressed(Keys.SHIFT_LEFT) ||
			Gdx.input.isKeyJustPressed(Keys.SHIFT_RIGHT)) {
					
			holdPressed = true;
					
		}
		
	}
	
	private void readScreenInput() {
		
		if (Gdx.input.justTouched()) {
			
			// see if touch is in up arrow box
			
			Vector2 tsAxis = new Vector2(0,0);
			
			tsAxis.x = Gdx.input.getX();
			tsAxis.y = Gdx.input.getY();
			
			// check to see if touch is in down rectangle
			float x = Constants.VIEWPORT_GUI_WIDTH * .5f - 63;
			float y = Constants.VIEWPORT_GUI_HEIGHT - 65;
			
			arrowBox.set(x, y, 150, 150);
			
			if (arrowBox.contains(tsAxis))
				moveDown = true;
			
			// check to see if touch is in left rectangle
			x = Constants.VIEWPORT_GUI_WIDTH * .5f - 167;
			y = Constants.VIEWPORT_GUI_HEIGHT - 122;
			
			arrowBox.set(x, y, 150, 150);
			
			if (arrowBox.contains(tsAxis))
				moveLeft = true;
			
			// check to see if touch is in right rectangle
			x = Constants.VIEWPORT_GUI_WIDTH * .5f + 45;
			y = Constants.VIEWPORT_GUI_HEIGHT - 112;
			
			arrowBox.set(x, y, 150, 150);
			
			if (arrowBox.contains(tsAxis))
				moveRight = true;
			
			// check to see if touch is in up rectangle
			x = Constants.VIEWPORT_GUI_WIDTH * .5f - 52;
			y = Constants.VIEWPORT_GUI_HEIGHT - 185;
			
			arrowBox.set(x, y, 150, 150);
			
			if (arrowBox.contains(tsAxis))
				moveUp = true;
			
			x = Constants.VIEWPORT_GUI_WIDTH * .5f - 525;
			y = Constants.VIEWPORT_GUI_HEIGHT * .5f + 610;
			
			holdBox.set(x, y, 150, 150);
			
			if (holdBox.contains(tsAxis))
				holdPressed = true;

							
		}
		
		level.activeCard.getInput(moveRight, moveLeft, moveUp, moveDown);
				
	}
	
	private void checkEscKey() {
		
		if (Gdx.input.isKeyJustPressed(Keys.ESCAPE))
				escPressed = true;

	}
	
	@Override
	public boolean keyDown (int keycode) {
		
		// Reset game world
		if (keycode == Keys.BACK) {
			
			selectPressed = true;
			return true;
			
		}
		
		return false;
		
	}

	@Override
	public boolean keyUp (int keycode) {
		// Reset game world
		if (keycode == Keys.R) {
			init();
			Gdx.app.debug(TAG, "Game world resetted");
		}
		// Toggle camera follow
		else if (keycode == Keys.ENTER) {
		
		}
		return false;
	}
	
}
