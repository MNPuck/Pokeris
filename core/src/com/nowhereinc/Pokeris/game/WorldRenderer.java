package com.nowhereinc.Pokeris.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool.PooledEffect;
import com.badlogic.gdx.utils.Disposable;
import com.nowhereinc.Pokeris.util.Constants;
import com.nowhereinc.Pokeris.util.GamePreferences;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool.PooledEffect;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;


public class WorldRenderer implements Disposable {

	private static final String TAG = WorldRenderer.class.getName();

	private OrthographicCamera camera;
	private OrthographicCamera cameraGUI;
	private SpriteBatch batch;
	private TiledMapRenderer renderer;
	private WorldController worldController;
	
	private Box2DDebugRenderer debugRenderer;
	// private Matrix4 debugMatrix;

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
		
		// draw high Score next to score
		//renderGuiHighScore(batch);
		
		// draw multiplier in upper middle
		//renderGuiMultiplier(batch);
		
		// draw cards remaining in upper right
		renderGuiCardsRemaining(batch);
		
		// draw bombs to the left of lives
		// renderGuiBombs(batch);
		
		// draw FPS text bottom right
		renderGuiFpsCounter(batch);
		
		// draw Level in bottom left
		renderGuiLevel(batch);
		
		// draw game over text
		renderGuiGameOverMessage(batch);
		
		// draw down arrow
		renderGuiDownArrow(batch);
		
		// draw left arrow
		renderGuiLeftArrow(batch);
		
		// draw right arrow
		renderGuiRightArrow(batch);
		
		// draw up arrow
		renderGuiUpArrow(batch);

		batch.end();
		
	}
	
	private void renderGuiDownArrow (SpriteBatch batch) {
		
		float x = cameraGUI.viewportWidth * .5f - 63;
		float y = cameraGUI.viewportHeight - 65;
		
		batch.draw(Assets.instance.downArrow.downArrow,
				x, y, 50, 50, 150, 150, 1f, -1f, 0);
		
	}
	
	private void renderGuiLeftArrow (SpriteBatch batch) {
		
		float x = cameraGUI.viewportWidth * .5f - 167;
		float y = cameraGUI.viewportHeight - 122;
		
		batch.draw(Assets.instance.leftArrow.leftArrow,
				x, y, 50, 50, 150, 150, 1f, -1f, 0);
		
	}
	
	private void renderGuiRightArrow (SpriteBatch batch) {
		
		float x = cameraGUI.viewportWidth * .5f + 45;
		float y = cameraGUI.viewportHeight - 112;
		
		batch.draw(Assets.instance.rightArrow.rightArrow,
				x, y, 50, 50, 150, 150, 1f, -1f, 0);
		
	}
	
	private void renderGuiUpArrow (SpriteBatch batch) {
		
		float x = cameraGUI.viewportWidth * .5f - 52;
		float y = cameraGUI.viewportHeight - 185;
		
		batch.draw(Assets.instance.upArrow.upArrow,
				x, y, 50, 50, 150, 150, 1f, -1f, 0);
		
	}
	
	private void renderGuiScore (SpriteBatch batch) {
		float x = 20;
		float y = 15;
		
		BitmapFont fpsFont = Assets.instance.fonts.defaultBig;
		
		fpsFont.setColor(0, 1, 0, 1); // green
		fpsFont.draw(batch, "Score " + worldController.level.returnScore() , x, y);
		fpsFont.setColor(1, 1, 1, 1); // white
	
	}
	
	private void renderGuiHighScore (SpriteBatch batch) {
		
	}
	
	private void renderGuiMultiplier (SpriteBatch batch) {

	}
	
	private void renderGuiCardsRemaining (SpriteBatch batch) {
		float x = cameraGUI.viewportWidth - 455;
		float y = 15;
		
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
		fpsFont.draw(batch, "Level: " + worldController.level.returnLevelNumber() , x, y);
		fpsFont.setColor(1, 1, 1, 1); // white

	}
	
	private void renderGuiGameOverMessage (SpriteBatch batch) {
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
