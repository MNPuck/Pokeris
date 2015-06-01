package com.nowhereinc.Pokeris;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.nowhereinc.Pokeris.screens.DirectedGame;
import com.nowhereinc.Pokeris.screens.GameScreen;
import com.nowhereinc.Pokeris.game.Assets;

public class PokerisMain extends DirectedGame {

	@Override
	public void create () {
		
		// Set Libgdx log level to DEBUG
		Gdx.app.setLogLevel(Application.LOG_ERROR);
		// Load assets
		Assets.instance.init(new AssetManager());
		
		// Initialize controller and renderer
		
		setScreen(new GameScreen(this));
		
	   // Assets.instance.dispose();
		
	}

}
