package com.nowhereinc.Pokeris.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import com.nowhereinc.Pokeris.util.Constants;
import com.nowhereinc.Pokeris.util.GamePreferences;
import com.badlogic.gdx.math.Vector3;


public class WorldRenderer implements Disposable {

	private static final String TAG = WorldRenderer.class.getName();

	private OrthographicCamera camera;
	private OrthographicCamera cameraGUI;
	private SpriteBatch batch;;
	private WorldController worldController;

	public WorldRenderer (WorldController worldController) {
		this.worldController = worldController;
		init();
	}

	private void init () {
		batch = new SpriteBatch();
		camera = new OrthographicCamera(Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT);
		camera.position.set(0, 0, 0);
		camera.update();
		cameraGUI = new OrthographicCamera(Constants.VIEWPORT_GUI_WIDTH, Constants.VIEWPORT_GUI_HEIGHT);
		cameraGUI.position.set(0, 0, 0);
		cameraGUI.setToOrtho(true); // flip y-axis
		cameraGUI.update();
	
	}

	public void render (float deltaTime) {
	
		renderWorld(batch, deltaTime);
		renderGui(batch);
		
	}

	private void renderWorld (SpriteBatch batch, float deltaTime) {
		
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		worldController.level.render(batch, deltaTime);
		batch.end();
	}
	
	private void renderGui (SpriteBatch batch) {
		
		batch.setProjectionMatrix(cameraGUI.combined);
		batch.begin();

		// draw score in upper left
		renderGuiScore(batch);
		
		// draw cards remaining in upper right
		renderGuiCardsRemaining(batch);
		
		// draw Level in bottom left
		renderGuiLevel(batch);
		
		// draw game over text
		renderGuiGameOverMessage(batch);
		
		// draw hold card text
		renderGuiHoldCardText(batch);
		
		// draw hold card
		renderGuiHoldCard(batch);
		
		// draw hold card box
		renderGuiHoldCardBox(batch);
		
		// draw preview card text
		renderGuiPreviewCardText(batch);
		
		// draw preview card
		renderGuiPreviewCard(batch);
		
		// draw high score
		renderGuiHighScore(batch);
		
		// draw poker hand value
		
		if (worldController.level.returnLastPokerHandTime() > 0)
			renderGuiLastPokerHand(batch);
		
		// draw level time
		renderGuiLevelTime(batch);
		
		if (worldController.level.returnLevelClearPause()) 
			renderGuiScoreScreen(batch);


		batch.end();
		
	}
	
	private void renderGuiScore (SpriteBatch batch) {
		float x = 20;
		float y = 15;
		
		BitmapFont fpsFont = Assets.instance.fonts.defaultBig;
		
		fpsFont.setColor(0, 1, 0, 1); // green
		fpsFont.draw(batch, "Score " + worldController.level.returnScore() , x, y);
		fpsFont.setColor(1, 1, 1, 1); // white
	
	}
	
	private void renderGuiHoldCardText (SpriteBatch batch) {
		float x = cameraGUI.viewportWidth * .5f - 535;
		float y = cameraGUI.viewportHeight * .5f + 510;
		
		BitmapFont fpsFont = Assets.instance.fonts.defaultNormal;
		
		fpsFont.setColor(0, 1, 0, 1); // green
		fpsFont.draw(batch, "Hold Card" , x, y);
		fpsFont.setColor(1, 1, 1, 1); // white
	
	}
	
	private void renderGuiHoldCard (SpriteBatch batch) {
		float x = cameraGUI.viewportWidth * .5f - 515;
		float y = cameraGUI.viewportHeight * .5f + 610;
		
		if (worldController.level.holdCard.getRank() != 0 &&
			worldController.level.holdCard.getSuit() != 0) {
		
			batch.draw(worldController.level.holdCard.returnCardTextureRegion(),
					   x, y, 50, 50, 125, 150, 1f, -1f, 0);
		
		}

	}
	
	private void renderGuiHoldCardBox (SpriteBatch batch) {
		
		float x = cameraGUI.viewportWidth * .5f - 515;
		float y = cameraGUI.viewportHeight * .5f + 610;
		
		if (worldController.level.holdCard.getRank() == 0 &&
			worldController.level.holdCard.getSuit() == 0) {
		
			batch.draw(Assets.instance.border.border,
					   x, y, 50, 50, 125, 150, 1f, -1f, 0);
		
		}
		
	}
	
	private void renderGuiPreviewCardText (SpriteBatch batch) {
		float x = cameraGUI.viewportWidth * .5f + 350;
		float y = cameraGUI.viewportHeight * .5f + 510;
		
		BitmapFont fpsFont = Assets.instance.fonts.defaultNormal;
		
		fpsFont.setColor(0, 1, 0, 1); // green
		fpsFont.draw(batch, "Next Card" , x, y);
		fpsFont.setColor(1, 1, 1, 1); // white
	
	}
	
	private void renderGuiPreviewCard (SpriteBatch batch) {
		float x = cameraGUI.viewportWidth * .5f + 375;
		float y = cameraGUI.viewportHeight * .5f + 610;
		
		if (worldController.level.previewCard.getRank() != 0 &&
			worldController.level.previewCard.getSuit() != 0) {
		
			batch.draw(worldController.level.previewCard.returnCardTextureRegion(),
					   x, y, 50, 50, 125, 150, 1f, -1f, 0);
		
		}

	}
	
	private void renderGuiHighScore(SpriteBatch batch) {
		float x = cameraGUI.viewportWidth - 445;
		float y = 15;
		
		BitmapFont fpsFont = Assets.instance.fonts.defaultBig;
		
		int highScore = 0;
		
		if (worldController.level.returnScore() > GamePreferences.instance.highScore) {
			
			highScore = worldController.level.returnScore();
			
		}
		
		else {
			
			highScore = GamePreferences.instance.highScore;
			
		}
			 
		fpsFont.setColor(0, 1, 0, 1);
		fpsFont.draw(batch, "High Score: " + highScore , x , y);		
		fpsFont.setColor(1, 1, 1, 1); // white
		
	}
	
	private void renderGuiCardsRemaining (SpriteBatch batch) {
		float x = cameraGUI.viewportWidth * .5f - 200;
		float y = cameraGUI.viewportHeight * .5f - 800;
		
		BitmapFont fpsFont = Assets.instance.fonts.defaultBig;
		
		fpsFont.setColor(0, 1, 0, 1);
		fpsFont.draw(batch, "Cards Remaining: " + worldController.level.returnCardsRemaining() , x , y);		
		fpsFont.setColor(1, 1, 1, 1); // white
		
	}
	
	private void renderGuiFpsCounter (SpriteBatch batch) {
		float x = cameraGUI.viewportWidth - 205;
		float y = cameraGUI.viewportHeight - 55;
		
		int fps = Gdx.graphics.getFramesPerSecond();
		
		BitmapFont fpsFont = Assets.instance.fonts.defaultBig;
		
		if (fps >= 45) {
			
			fpsFont.setColor(0, 1, 0, 1);
			
		} else if (fps >= 30) {
			
			fpsFont.setColor(1, 1, 0, 1);
			
		} else {
			
			fpsFont.setColor(1, 0, 0, 1);
			
		}
		
		fpsFont.draw(batch, "FPS: " + fps , x, y);
		fpsFont.setColor(1, 1, 1, 1); // white

	}
	
	private void renderGuiLevel (SpriteBatch batch) {
		
		float x = 55;
		float y = cameraGUI.viewportHeight - 55;
		
		BitmapFont fpsFont = Assets.instance.fonts.defaultBig;
		
		fpsFont.setColor(1, 1, 1, 1); // white
		fpsFont.draw(batch, "Level: " + worldController.level.returnLevelNumber(), x, y);
		fpsFont.setColor(1, 1, 1, 1); // white

	}
	
	private void renderGuiScoreScreen(SpriteBatch batch) {
		
		float x = cameraGUI.viewportWidth * .5f - 275;
		float y = cameraGUI.viewportHeight * .5f - 500;
		
		BitmapFont fpsFont = Assets.instance.fonts.defaultNormal;
		
		fpsFont.setColor(1, 1, 1, 1); // white		
		
		fpsFont.draw(batch, "Lines Cleared: " + worldController.level.returnLinesCleared(), x, y);
		
		y += 100;
	
		fpsFont.draw(batch, "Level: " + worldController.level.returnLevelNumber(), x, y);
		
		y += 100;
		
		fpsFont.draw(batch, "Multiplier: " + 100, x, y);
		
		y += 100;
		
		fpsFont.setColor(1, 1, 0, 1); // yellow
		
		fpsFont.draw(batch, "Subtotal: " + worldController.level.returnLinesCleared()
				            + " x " + worldController.level.returnLevelNumber() + " x 100 = "
				            + worldController.level.returnLinesCleared() *
						    worldController.level.returnLevelNumber() * 100, x, y);
		
		y += 200;
		
		fpsFont.setColor(1, 1, 1, 1); // white	
		
		fpsFont.draw(batch, "Level Time: " + Constants.LEVELTIMEGOAL + " - " +
							+ worldController.level.returnLevelTimeInt() + " = " +
							+ worldController.level.returnLevelTimeMultiplier(), x, y);
		
		y += 100;
		
		fpsFont.draw(batch, "Multiplier: " + 100, x, y);
		
		y += 100;
		
		fpsFont.setColor(1, 1, 0, 1); // yellow
		
		fpsFont.draw(batch, "Subtotal: " + worldController.level.returnLevelTimeMultiplier() 
							+ " x 100 = " + (worldController.level.returnLevelTimeMultiplier() * 100), x, y);
		
		int bonusTotal = (worldController.level.returnLinesCleared() *
						 worldController.level.returnLevelNumber() *
						 100) + (worldController.level.returnLevelTimeMultiplier() * 100);
		
		y += 200;
		
		fpsFont = Assets.instance.fonts.defaultBig;
		
		fpsFont.setColor(0, 1, 0, 1); // green
		
		fpsFont.draw(batch, "Bonus Total: " + bonusTotal, x, y);
		
		fpsFont.setColor(1, 1, 1, 1); // white		
		
	}
	
	private void renderGuiLastPokerHand(SpriteBatch batch) {
		
		float x = cameraGUI.viewportWidth * .5f - 150;
		float y = cameraGUI.viewportHeight * .5f + 750;
		
		BitmapFont fpsFont = Assets.instance.fonts.defaultBig;
		
		fpsFont.setColor(0, 1, 0, 1);
		
		if (worldController.level.returnLastPokerHand() == 2)
			fpsFont.draw(batch, "Pair + 100", x, y);
		
		if (worldController.level.returnLastPokerHand() == 3)
			fpsFont.draw(batch, "2 Pair + 200", x, y);
		
		if (worldController.level.returnLastPokerHand() == 4)
			fpsFont.draw(batch, "3 of a Kind + 300", x, y);
		
		if (worldController.level.returnLastPokerHand() == 5)
			fpsFont.draw(batch, "Straight + 400", x, y);
		
		if (worldController.level.returnLastPokerHand() == 6)
			fpsFont.draw(batch, "Flush + 600", x, y);
		
		if (worldController.level.returnLastPokerHand() == 7)
			fpsFont.draw(batch, "Full House + 900", x, y);
		
		if (worldController.level.returnLastPokerHand() == 8)
			fpsFont.draw(batch, "4 of a Kind +2500", x, y);
		
		if (worldController.level.returnLastPokerHand() == 9)
			fpsFont.draw(batch, "Straight Flush + 5000", x, y);
		
		if (worldController.level.returnLastPokerHand() == 10)
			fpsFont.draw(batch, "Royal Flush + 25000", x, y);
			
		
		fpsFont.setColor(1, 1, 1, 1); // white		
		
	}
	
	private void renderGuiLevelTime(SpriteBatch batch) {
		
		float x = cameraGUI.viewportWidth - 355;
		float y = cameraGUI.viewportHeight - 55;
		
		int levelTime = (int) worldController.level.returnLevelTime();
		
		BitmapFont fpsFont = Assets.instance.fonts.defaultBig;
		
		if (levelTime < Constants.LEVELTIMEGOAL) {
		
			fpsFont.setColor(0, 1, 0, 1); // green
			
		
		}
		
		else {
			
			fpsFont.setColor(1, 0, 0, 1); // red
			
		}
		
		fpsFont.draw(batch, "Level Time: " + levelTime, x, y);
		
		fpsFont.setColor(1, 1, 1, 1); // white
		
		
	}
	
	private void renderGuiGameOverMessage(SpriteBatch batch) {
		
		float x = cameraGUI.viewportWidth * .5f;
		float y = cameraGUI.viewportHeight * .5f;
		
		if (worldController.gameOver) {
			BitmapFont fontGameOver = Assets.instance.fonts.defaultBig;
			fontGameOver.setColor(0, 1, 0, 1);
			fontGameOver.drawMultiLine(batch, "GAME OVER", x, y, 1, BitmapFont.HAlignment.CENTER);
			fontGameOver.setColor(1, 1, 1, 1);
		}

	}
	
	public void resize (int width, int height) {
		camera.viewportWidth = (Constants.VIEWPORT_HEIGHT / height) * width;
		camera.update();
		cameraGUI.viewportHeight = Constants.VIEWPORT_GUI_HEIGHT;
		cameraGUI.viewportWidth = (Constants.VIEWPORT_GUI_HEIGHT / (float)height) * (float)width;
		cameraGUI.position.set(cameraGUI.viewportWidth * .5f,
							   cameraGUI.viewportHeight * .5f,
							   0);
		cameraGUI.update();
	}
	
	public Vector3 cameraUnproject(Vector3 tsInputs) {
		
		return camera.unproject(tsInputs);
		
	}

	@Override
	public void dispose () {
		batch.dispose();
		
	}

}
