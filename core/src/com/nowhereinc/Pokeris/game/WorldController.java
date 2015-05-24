package com.nowhereinc.Pokeris.game;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.Controllers;
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
	
	private float tsXAxis;
	private float tsYAxis;
	
	private boolean moveLeft;
	private boolean moveRight;
	private boolean moveUp;
	private boolean moveDown;
	
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
				tsXAxis = 0;
				tsYAxis = 0;
				break;
				
			case Android:
				tsXAxis = 0;
				tsYAxis = 0;
				break;
				
			default:
				break;
		
		}
		
		startPressed = false;
		selectPressed = false;
		gameOver = false;
		escPressed = false;
		
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
		
		if (!gameOver) {
		
			switch (Gdx.app.getType()) {
		
				case Desktop: 
					readKeyboardInput();
					break;
			
				case Android:
					readScreenInput(worldRenderer);
					break;
			
				default:
					break;
	
			}
			
			level.update(deltaTime);
		
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
		
	}
	
	private void readScreenInput(WorldRenderer worldRenderer) {
	
		// see if touch is in green sprite
		
		if (Gdx.input.isTouched()) {
			
			tsXAxis = Gdx.input.getX();
			tsYAxis = Gdx.input.getY();
			
			//set up inputs to pass to convert
			Vector3 tsInputs;
			tsInputs = new Vector3(tsXAxis, tsYAxis, 0f);
			
		    //set up output from convert
			Vector3 tsOutput;
		
			//call convert
			tsOutput = worldRenderer.cameraUnproject(tsInputs);
		
			//call player module
			float wuXAxis = tsOutput.x;
			float wuYAxis = tsOutput.y;
			
			// level.player.inputTouchScreen(wuXAxis, wuYAxis);
				
		}
		
		if (!Gdx.input.isTouched()) {
				
			// level.player.inputTouchScreen(-99, -99);
			
		}
				
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
