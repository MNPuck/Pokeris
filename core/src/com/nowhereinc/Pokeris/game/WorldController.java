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
	private boolean keyPressed;
	
	private boolean androidMoveSet;
	private int androidColumn;
	
	private Rectangle arrowBox;
	private Rectangle holdBox;
	private Rectangle gameBox;
	
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
		gameBox = new Rectangle();
		
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
		keyPressed = false;
		
		androidMoveSet = false;
		
		if (!gameOver) {
		
			switch (Gdx.app.getType()) {
		
				case Desktop: 
					readKeyboardInput();
					break;
			
				case Android:
					readScreenInput2(worldRenderer);
					break;
			
				default:
					break;
	
			}
			
			level.update(deltaTime, holdPressed, keyPressed);
		
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
		
		level.activeCard.getInputDesktop(moveRight, moveLeft, moveUp, moveDown);
		
		if (Gdx.input.isKeyJustPressed(Keys.SHIFT_LEFT) ||
			Gdx.input.isKeyJustPressed(Keys.SHIFT_RIGHT)) {
					
			holdPressed = true;
					
		}
		
		if (Gdx.input.isKeyJustPressed(Keys.ANY_KEY)) {
			
			keyPressed = true;
			
		}
		
	}
	
	private void readScreenInput() {
		
		if (Gdx.input.justTouched()) {
			
			Vector2 tsAxis = new Vector2(0,0);
			
			tsAxis.x = Gdx.input.getX();
			tsAxis.y = Gdx.input.getY();
			
			// check to see if touch is in left rectangle
			float x = Constants.VIEWPORT_GUI_WIDTH * .5f - 167;
			float y = Constants.VIEWPORT_GUI_HEIGHT - 180;
			
			arrowBox.set(x, y, 150, 150);
			
			if (arrowBox.contains(tsAxis))
				moveLeft = true;
			
			// check to see if touch is in right rectangle
			x = Constants.VIEWPORT_GUI_WIDTH * .5f + 45;
			y = Constants.VIEWPORT_GUI_HEIGHT - 175;
			
			arrowBox.set(x, y, 150, 150);
			
			if (arrowBox.contains(tsAxis))
				moveRight = true;
			
			// check to see if touch is in up rectangle
			x = Constants.VIEWPORT_GUI_WIDTH * .5f - 52;
			y = Constants.VIEWPORT_GUI_HEIGHT - 255;
			
			arrowBox.set(x, y, 150, 150);
			
			if (arrowBox.contains(tsAxis))
				moveUp = true;
			
			x = Constants.VIEWPORT_GUI_WIDTH * .5f - 525;
			y = Constants.VIEWPORT_GUI_HEIGHT * .5f + 610;
			
			holdBox.set(x, y, 150, 150);
			
			if (holdBox.contains(tsAxis))
				holdPressed = true;
			
			keyPressed = true;
		
		}
		
		if (Gdx.input.isTouched()) {
			
			Vector2 tsAxis = new Vector2(0,0);
			
			tsAxis.x = Gdx.input.getX();
			tsAxis.y = Gdx.input.getY();
			
			// check to see if touch is in down rectangle
			float x = Constants.VIEWPORT_GUI_WIDTH * .5f - 63;
			float y = Constants.VIEWPORT_GUI_HEIGHT - 85;
			
			arrowBox.set(x, y, 150, 150);
			
			if (arrowBox.contains(tsAxis))
				moveDown = true;
			
		}
		
		level.activeCard.getInputAndroid(androidMoveSet, androidColumn);
				
	}
	
	private void readScreenInput2(WorldRenderer worldRenderer) {
		
		if (Gdx.input.justTouched()) {
			
			Vector2 tsAxis = new Vector2(0,0);
				
			tsAxis.x = Gdx.input.getX();
			tsAxis.y = Gdx.input.getY();
			
			//check if touch in hold box
			float x = Constants.VIEWPORT_GUI_WIDTH * .5f - 525;
			float y = Constants.VIEWPORT_GUI_HEIGHT * .5f + 610;
			
			holdBox.set(x, y, 150, 150);
			
			if (holdBox.contains(tsAxis))
				holdPressed = true;
			
			//get x and y ratio of pixels to world unit
			float xRatio = Constants.VIEWPORT_GUI_WIDTH / Constants.VIEWPORT_WIDTH;
			float yRatio = Constants.VIEWPORT_GUI_HEIGHT / Constants.VIEWPORT_HEIGHT;
			
			//use ratio to figure out gameboards left corner in pixels
			float xPos = Constants.GAMEBOARD_WIDTH * xRatio * .5f;
			float yPos = Constants.GAMEBOARD_HEIGHT * yRatio * .5f;
			
			//use ratio to figure out the length and height of rectangle in pixels
			float length = Constants.GAMEBOARD_WIDTH * xRatio;
			float height = Constants.GAMEBOARD_HEIGHT * yRatio;
			
			gameBox.set(xPos, yPos, length, height);
			
			if (gameBox.contains(tsAxis))
				androidMoveSet = true;
			
			if (androidMoveSet) {
				
				Gdx.app.error(TAG, "In true");
				
				//set up inputs to pass to convert
				Vector3 tsInputs;
				tsInputs = new Vector3(tsAxis.x, tsAxis.y, 0f);
				
				//set up output from convert
				Vector3 tsOutput;
			
				//call convert
				tsOutput = worldRenderer.cameraUnproject(tsInputs);
			
				//call player module
				float wuXAxis = tsOutput.x;
				float wuYAxis = tsOutput.y;
				
				Gdx.app.error(TAG, "X " + wuXAxis);
				Gdx.app.error(TAG, "Y " + wuYAxis);

				if (wuXAxis > - .5f &&
					wuXAxis < .5f)
					androidColumn = 3;
				
				if (wuXAxis <= - .5f &&
					wuXAxis > - 1.5f)
					androidColumn = 2;
				
				
				if (wuXAxis <= - 1.5f &&
					wuXAxis > - 2.5f)
					androidColumn = 1;
				
				if (wuXAxis >= .5f &&
					wuXAxis < 1.5f)
					androidColumn = 4;
				
				if (wuXAxis >= 1.5f &&
					wuXAxis < 2.5f)
					androidColumn = 5;
				
				Gdx.app.error(TAG, "Column " + androidColumn);
				
			}
		
			keyPressed = true;
					
		}
			
		else {
					
			androidMoveSet = false;
				
		}
		
		level.activeCard.getInputAndroid(androidMoveSet, androidColumn);
		
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
