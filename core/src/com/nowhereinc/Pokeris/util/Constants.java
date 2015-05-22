package com.nowhereinc.Pokeris.util;

public class Constants {

	// Visible game world is 9 meters wide
	public static final float VIEWPORT_WIDTH = 9.0f;

	// Visible game world is 16 meters tall
	public static final float VIEWPORT_HEIGHT = 16.0f;
	
	// GameWorld Border
	public static final float GAMEBOARD_WIDTH = 5.0f;
	public static final float GAMEBOARD_HEIGHT = 12.0f;
	
	// Level Size Input Size
	public static final float LEVEL_INPUT_WIDTH = 9.0f;
	public static final float LEVEL_INPUT_HEIGHT = 64.0f;

	// GUI Width
	public static final float VIEWPORT_GUI_WIDTH = 1920.0f;

	// GUI Height
	public static final float VIEWPORT_GUI_HEIGHT = 1080.0f;

	// Location of description file for texture atlas
	public static final String TEXTURE_ATLAS_OBJECTS = 
	"images/Pokeris.pack.atlas";
	
	// Number of Levels
	public static final int NUMBEROFLEVELS = 1;

	// Delay after game over
	public static final float TIME_DELAY_GAME_OVER = 3;
	
	// Size of card
	public static final float CARDXSIZE = 1f;
	public static final float CARDYSIZE = 1f;
	
	// Game preferences file
	public static final String PREFERENCES = "pokeris.prefs";
		
}
