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
	
	public CameraHelper cameraHelper;
	
	Vector2 cameraPosition;

	public WorldController (DirectedGame game) {
		this.game = game;
		init();
	}

	private void init () {
		
		Gdx.input.setInputProcessor(this);
		Gdx.input.setCatchBackKey(true);
		
		cameraHelper = new CameraHelper();
		
		switch (Gdx.app.getType()) {
		
			case Desktop: 
				player1Controller = Controllers.getControllers().get(0);
				break;
				
			case Android:
				tsXAxis = 0;
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
		
		// cameraHelper.setTarget(level.player.body);
		
		cameraPosition = cameraHelper.getPosition();
	
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
		
		// handleDebugInput(deltaTime);
		
		gameOver = level.returnIsGameOver();
		
		if (!gameOver) {
		
			switch (Gdx.app.getType()) {
		
				case Desktop: 
					readController();
					break;
			
				case Android:
					readScreenInput(worldRenderer);
					break;
			
				default:
					break;
	
			}
			
			// set up camera vertical scroll of map
			
			cameraPosition = cameraHelper.getPosition();
			cameraPosition.y += Constants.SCROLL_SPEED * deltaTime;
			
			level.update(deltaTime, cameraPosition);
			level.deleteFlaggedItems(cameraPosition);
			
			// camera helper update
			
			// cameraHelper.update(deltaTime, cameraPosition, level.player.returnPlayerPosition());
			
			if (level.lives == 0) {
			
				gameOver = true;
			
			}
		
		}
		
		switch (Gdx.app.getType()) {
		
		case Desktop: 
			checkBackKeyJoystick();
			checkEscKey();
			break;
		
		case Android:
			break;
		
		default:
			break;
				
		}
	
	}
	
	private void readController() {
		
		// player move 
		float leftXAxis = player1Controller.getAxis(Xbox360Pad.AXIS_LEFT_X);
		float leftYAxis = player1Controller.getAxis(Xbox360Pad.AXIS_LEFT_Y);
		
		// player button checks
		boolean aButton = player1Controller.getButton(Xbox360Pad.BUTTON_A);
		boolean bButton = player1Controller.getButton(Xbox360Pad.BUTTON_B);
		boolean xButton = player1Controller.getButton(Xbox360Pad.BUTTON_X);
		boolean yButton = player1Controller.getButton(Xbox360Pad.BUTTON_Y);

		level.player.inputController(leftXAxis, leftYAxis, aButton, bButton,
				                     xButton, yButton);

		
		//pause check
		startPressed = player1Controller.getButton(Xbox360Pad.BUTTON_START);
		
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
			level.player.inputTouchScreen(wuXAxis, wuYAxis);
				
		}
		
		if (!Gdx.input.isTouched()) {
				
			level.player.inputTouchScreen(-99, -99);
			
		}
				
	}
	
	private void testCollisions() {

		// Test collisions

	}
	
	private void checkEscKey() {
		
		if (Gdx.input.isKeyJustPressed(Keys.ESCAPE))
				escPressed = true;

	}
	
	private void checkBackKeyJoystick() {
		
		//select check
		selectPressed =  player1Controller.getButton(Xbox360Pad.BUTTON_BACK);
		
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