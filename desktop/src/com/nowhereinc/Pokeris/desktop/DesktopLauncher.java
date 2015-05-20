package com.nowhereinc.Pokeris.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.badlogic.gdx.tools.texturepacker.TexturePacker.Settings;
import com.nowhereinc.Pokeris.PokerisMain;
import com.badlogic.gdx.backends.lwjgl.LwjglFrame;
import com.badlogic.gdx.Application.ApplicationType;

public class DesktopLauncher {	
	private static boolean rebuildAtlas = false;
	private static boolean drawDebugOutline = false;


	public static void main (String[] args) {
		if (rebuildAtlas) {
			Settings settings = new Settings();
			settings.maxWidth = 1024;
			settings.maxHeight = 1024;
			settings.duplicatePadding = false;
			settings.debug = drawDebugOutline;
			TexturePacker.process(settings, "assets-raw/images", "../android/assets/images", "Pokeris.pack");
		}
		
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Pokeris";
		cfg.width = 1600;
		cfg.height = 900;
		cfg.fullscreen = true;
		cfg.vSyncEnabled = true;
		
		new LwjglApplication(new PokerisMain(), cfg);
		
	}
	
}
