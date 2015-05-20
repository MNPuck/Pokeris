package com.nowhereinc.Pokeris.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.nowhereinc.Pokeris.util.Constants;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class Assets implements Disposable, AssetErrorListener {

	public static final String TAG = Assets.class.getName();

	public static final Assets instance = new Assets();

	private AssetManager assetManager;
	
	public TiledMap map;
	public MapObjects mapObjects;
	public MapLayer mapObjectLayer;
	
	public AssetFonts fonts;
	
	public AssetCard1 card1;	
	public AssetCard2 card2;
	public AssetCard3 card3;
	public AssetCard4 card4;
	public AssetCard5 card5;
	public AssetCard6 card6;
	public AssetCard7 card7;
	public AssetCard8 card8;
	public AssetCard9 card9;
	public AssetCard10 card10;
	public AssetCard11 card11;
	public AssetCard12 card12;
	public AssetCard13 card13;
	public AssetCard14 card14;
	public AssetCard15 card15;
	public AssetCard16 card16;
	public AssetCard17 card17;
	public AssetCard18 card18;
	public AssetCard19 card19;
	public AssetCard20 card20;	
	public AssetCard21 card21;
	public AssetCard22 card22;
	public AssetCard23 card23;
	public AssetCard24 card24;
	public AssetCard25 card25;
	public AssetCard26 card26;
	public AssetCard27 card27;
	public AssetCard28 card28;
	public AssetCard29 card29;
	public AssetCard30 card30;
	public AssetCard31 card31;
	public AssetCard32 card32;
	public AssetCard33 card33;
	public AssetCard34 card34;
	public AssetCard35 card35;
	public AssetCard36 card36;
	public AssetCard37 card37;
	public AssetCard38 card38;
	public AssetCard39 card39;
	public AssetCard40 card40;	
	public AssetCard41 card41;
	public AssetCard42 card42;
	public AssetCard43 card43;
	public AssetCard44 card44;
	public AssetCard45 card45;
	public AssetCard46 card46;
	public AssetCard47 card47;
	public AssetCard48 card48;
	public AssetCard49 card49;	
	public AssetCard50 card50;
	public AssetCard51 card51;
	public AssetCard52 card52;	

	
	public AssetSounds sounds;
	

	// singleton: prevent instantiation from other classes
	private Assets () {
	}
	
	public class AssetFonts {
		public final BitmapFont defaultSmall;
		public final BitmapFont defaultNormal;
		public final BitmapFont defaultBig;

	public AssetFonts () {

			// create three fonts using Libgdx's 15px bitmap font
			defaultSmall = new BitmapFont(Gdx.files.internal("images/arial-15.fnt"), true);
			defaultNormal = new BitmapFont(Gdx.files.internal("images/arial-15.fnt"), true);
			defaultBig = new BitmapFont(Gdx.files.internal("images/arial-15.fnt"), true);
			// set font sizes
			defaultSmall.setScale(0.75f);
			defaultNormal.setScale(1.0f);
			defaultBig.setScale(2.0f);
			// enable linear texture filtering for smooth fonts
			defaultSmall.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
			defaultNormal.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
			defaultBig.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
		}
	}
	
	public class AssetCard1 {
		public final AtlasRegion card1;

		public AssetCard1 (TextureAtlas atlas) {
			card1 = atlas.findRegion("1");
			
			if (card1 == null) {
				
				Gdx.app.debug(TAG, "Card1 is null");
			}

		}
		
	}
	
	public class AssetCard2 {
		public final AtlasRegion card2;

		public AssetCard2 (TextureAtlas atlas) {
			card2 = atlas.findRegion("2");
			
			if (card2 == null) {
				
				Gdx.app.debug(TAG, "Card2 is null");
			}

		}
		
	}
	
	public class AssetCard3 {
		public final AtlasRegion card3;

		public AssetCard3 (TextureAtlas atlas) {
			card3 = atlas.findRegion("3");
			
			if (card3 == null) {
				
				Gdx.app.debug(TAG, "Card3 is null");
			}

		}
		
	}
	
	public class AssetCard4 {
		public final AtlasRegion card4;

		public AssetCard4 (TextureAtlas atlas) {
			card4 = atlas.findRegion("4");
			
			if (card4 == null) {
				
				Gdx.app.debug(TAG, "Card4 is null");
			}

		}
		
	}
	
	public class AssetCard5 {
		public final AtlasRegion card5;

		public AssetCard5 (TextureAtlas atlas) {
			card5 = atlas.findRegion("5");
			
			if (card5 == null) {
				
				Gdx.app.debug(TAG, "Card5 is null");
			}

		}
		
	}
	
	public class AssetCard6 {
		public final AtlasRegion card6;

		public AssetCard6 (TextureAtlas atlas) {
			card6 = atlas.findRegion("6");
			
			if (card6 == null) {
				
				Gdx.app.debug(TAG, "Card6 is null");
			}

		}
		
	}
	
	public class AssetCard7 {
		public final AtlasRegion card7;

		public AssetCard7 (TextureAtlas atlas) {
			card7 = atlas.findRegion("7");
			
			if (card7 == null) {
				
				Gdx.app.debug(TAG, "Card7 is null");
			}

		}
		
	}
	
	public class AssetCard8 {
		public final AtlasRegion card8;

		public AssetCard8 (TextureAtlas atlas) {
			card8 = atlas.findRegion("8");
			
			if (card8 == null) {
				
				Gdx.app.debug(TAG, "Card8 is null");
			}

		}
		
	}
	
	public class AssetCard9 {
		public final AtlasRegion card9;

		public AssetCard9 (TextureAtlas atlas) {
			card9 = atlas.findRegion("9");
			
			if (card9 == null) {
				
				Gdx.app.debug(TAG, "Card9 is null");
			}

		}
		
	}
	
	public class AssetCard10 {
		public final AtlasRegion card10;

		public AssetCard10 (TextureAtlas atlas) {
			card10 = atlas.findRegion("10");
			
			if (card10 == null) {
				
				Gdx.app.debug(TAG, "Card10 is null");
			}

		}
		
	}
	
	public class AssetCard11 {
		public final AtlasRegion card11;

		public AssetCard11 (TextureAtlas atlas) {
			card11 = atlas.findRegion("11");
			
			if (card11 == null) {
				
				Gdx.app.debug(TAG, "Card11 is null");
			}

		}
		
	}
	
	public class AssetCard12 {
		public final AtlasRegion card12;

		public AssetCard12 (TextureAtlas atlas) {
			card12 = atlas.findRegion("12");
			
			if (card12 == null) {
				
				Gdx.app.debug(TAG, "Card12 is null");
			}

		}
		
	}
	
	public class AssetCard13 {
		public final AtlasRegion card13;

		public AssetCard13 (TextureAtlas atlas) {
			card13 = atlas.findRegion("13");
			
			if (card13 == null) {
				
				Gdx.app.debug(TAG, "Card13 is null");
			}

		}
		
	}
	
	public class AssetCard14 {
		public final AtlasRegion card14;

		public AssetCard14 (TextureAtlas atlas) {
			card14 = atlas.findRegion("14");
			
			if (card14 == null) {
				
				Gdx.app.debug(TAG, "Card14 is null");
			}

		}
		
	}
	
	public class AssetCard15 {
		public final AtlasRegion card15;

		public AssetCard15 (TextureAtlas atlas) {
			card15 = atlas.findRegion("15");
			
			if (card15 == null) {
				
				Gdx.app.debug(TAG, "Card15 is null");
			}

		}
		
	}
	
	public class AssetCard16 {
		public final AtlasRegion card16;

		public AssetCard16 (TextureAtlas atlas) {
			card16 = atlas.findRegion("16");
			
			if (card16 == null) {
				
				Gdx.app.debug(TAG, "Card16 is null");
			}

		}
		
	}
	
	public class AssetCard17 {
		public final AtlasRegion card17;

		public AssetCard17 (TextureAtlas atlas) {
			card17 = atlas.findRegion("17");
			
			if (card17 == null) {
				
				Gdx.app.debug(TAG, "Card17 is null");
			}

		}
		
	}
	
	public class AssetCard18 {
		public final AtlasRegion card18;

		public AssetCard18 (TextureAtlas atlas) {
			card18 = atlas.findRegion("18");
			
			if (card18 == null) {
				
				Gdx.app.debug(TAG, "Card18 is null");
			}

		}
		
	}
	
	public class AssetCard19 {
		public final AtlasRegion card19;

		public AssetCard19 (TextureAtlas atlas) {
			card19 = atlas.findRegion("19");
			
			if (card19 == null) {
				
				Gdx.app.debug(TAG, "Card19 is null");
			}

		}
		
	}
	
	public class AssetCard20 {
		public final AtlasRegion card20;

		public AssetCard20 (TextureAtlas atlas) {
			card20 = atlas.findRegion("20");
			
			if (card20 == null) {
				
				Gdx.app.debug(TAG, "Card20 is null");
			}

		}
		
	}
	
	public class AssetCard21 {
		public final AtlasRegion card21;

		public AssetCard21 (TextureAtlas atlas) {
			card21 = atlas.findRegion("21");
			
			if (card21 == null) {
				
				Gdx.app.debug(TAG, "Card21 is null");
			}

		}
		
	}
	
	public class AssetCard22 {
		public final AtlasRegion card22;

		public AssetCard22 (TextureAtlas atlas) {
			card22 = atlas.findRegion("22");
			
			if (card22 == null) {
				
				Gdx.app.debug(TAG, "Card22 is null");
			}

		}
		
	}
	
	public class AssetCard23 {
		public final AtlasRegion card23;

		public AssetCard23 (TextureAtlas atlas) {
			card23 = atlas.findRegion("23");
			
			if (card23 == null) {
				
				Gdx.app.debug(TAG, "Card23 is null");
			}

		}
		
	}
	
	public class AssetCard24 {
		public final AtlasRegion card24;

		public AssetCard24 (TextureAtlas atlas) {
			card24 = atlas.findRegion("24");
			
			if (card24 == null) {
				
				Gdx.app.debug(TAG, "Card24 is null");
			}

		}
		
	}
	
	public class AssetCard25 {
		public final AtlasRegion card25;

		public AssetCard25 (TextureAtlas atlas) {
			card25 = atlas.findRegion("25");
			
			if (card25 == null) {
				
				Gdx.app.debug(TAG, "Card25 is null");
			}

		}
		
	}
	
	public class AssetCard26 {
		public final AtlasRegion card26;

		public AssetCard26 (TextureAtlas atlas) {
			card26 = atlas.findRegion("26");
			
			if (card26 == null) {
				
				Gdx.app.debug(TAG, "Card26 is null");
			}

		}
		
	}
	
	public class AssetCard27 {
		public final AtlasRegion card27;

		public AssetCard27 (TextureAtlas atlas) {
			card27 = atlas.findRegion("27");
			
			if (card27 == null) {
				
				Gdx.app.debug(TAG, "Card27 is null");
			}

		}
		
	}
	
	public class AssetCard28 {
		public final AtlasRegion card28;

		public AssetCard28 (TextureAtlas atlas) {
			card28 = atlas.findRegion("28");
			
			if (card28 == null) {
				
				Gdx.app.debug(TAG, "Card28 is null");
			}

		}
		
	}
	
	public class AssetCard29 {
		public final AtlasRegion card29;

		public AssetCard29 (TextureAtlas atlas) {
			card29 = atlas.findRegion("29");
			
			if (card29 == null) {
				
				Gdx.app.debug(TAG, "Card29 is null");
			}

		}
		
	}
	
	public class AssetCard30 {
		public final AtlasRegion card30;

		public AssetCard30 (TextureAtlas atlas) {
			card30 = atlas.findRegion("30");
			
			if (card30 == null) {
				
				Gdx.app.debug(TAG, "Card30 is null");
			}

		}
		
	}
	
	public class AssetCard31 {
		public final AtlasRegion card31;

		public AssetCard31 (TextureAtlas atlas) {
			card31 = atlas.findRegion("31");
			
			if (card31 == null) {
				
				Gdx.app.debug(TAG, "Card31 is null");
			}

		}
		
	}
	
	public class AssetCard32 {
		public final AtlasRegion card32;

		public AssetCard32 (TextureAtlas atlas) {
			card32 = atlas.findRegion("32");
			
			if (card32 == null) {
				
				Gdx.app.debug(TAG, "Card32 is null");
			}

		}
		
	}
	
	public class AssetSounds {
		
		public final Sound shipShot;
		public final Sound shipExplosion;
		public final Sound gemPickup;
		public final Sound enemyExplosion;
		public final Sound enemySpawn;
		public final Sound bombExplosion;
		
		public AssetSounds (AssetManager am) {
			
			shipShot = am.get("sounds/ship_shot.wav", Sound.class);
			shipExplosion = am.get("sounds/ship_explosion.wav", Sound.class);
			gemPickup = am.get("sounds/gem_pickup.wav", Sound.class);
			enemyExplosion = am.get("sounds/enemy_explosion.wav", Sound.class);
			enemySpawn = am.get("sounds/enemy_spawn.wav", Sound.class);
			bombExplosion = am.get("sounds/bomb_explosion.wav", Sound.class);
			
		}
		
	}

	public void init (AssetManager assetManager) {
		this.assetManager = assetManager;
		// set asset manager error handler
		assetManager.setErrorListener(this);
		
		// load tiled map
		assetManager.setLoader(TiledMap.class, new TmxMapLoader(new InternalFileHandleResolver()));
		assetManager.load("maps/AirCommander1.tmx", TiledMap.class);
		
		// load texture atlas
		assetManager.load(Constants.TEXTURE_ATLAS_OBJECTS, TextureAtlas.class);
		
		// load sounds
		assetManager.load("sounds/ship_shot.wav", Sound.class);
		assetManager.load("sounds/ship_explosion.wav", Sound.class);
		assetManager.load("sounds/gem_pickup.wav", Sound.class);
		assetManager.load("sounds/enemy_explosion.wav", Sound.class);
		assetManager.load("sounds/enemy_spawn.wav", Sound.class);
		assetManager.load("sounds/bomb_explosion.wav", Sound.class);
		
		// start loading assets and wait until finished
		assetManager.finishLoading();

		Gdx.app.debug(TAG, "# of assets loaded: " + assetManager.getAssetNames().size);
		for (String a : assetManager.getAssetNames()) {
			Gdx.app.debug(TAG, "asset: " + a);
		}
		
		map = assetManager.get("maps/AirCommander1.tmx");
		mapObjectLayer = map.getLayers().get("Object Layer 1");
		
		mapObjects = mapObjectLayer.getObjects();
		
		TextureAtlas atlas = assetManager.get(Constants.TEXTURE_ATLAS_OBJECTS);

		// enable texture filtering for pixel smoothing
		for (Texture t : atlas.getTextures()) {
			t.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		}

		// create game resource objects
		fonts = new AssetFonts();
		
		plane1 = new AssetPlane1(atlas);
		plane2 = new AssetPlane2(atlas);
		plane3 = new AssetPlane3(atlas);
		plane4 = new AssetPlane4(atlas);
		plane5 = new AssetPlane5(atlas);
		plane6 = new AssetPlane6(atlas);
		plane7 = new AssetPlane7(atlas);
		plane8 = new AssetPlane8(atlas);
		plane9 = new AssetPlane9(atlas);
		plane10 = new AssetPlane10(atlas);
		
		sounds = new AssetSounds(assetManager);
		
	}

	@Override
	public void dispose () {
		assetManager.dispose();
		fonts.defaultSmall.dispose();
		fonts.defaultNormal.dispose();
		fonts.defaultBig.dispose();
	}
	
	@Override
	public void error(@SuppressWarnings("rawtypes") AssetDescriptor asset, Throwable throwable) {
	   Gdx.app.error(getClass().getSimpleName(), "Couldn't load asset '" + asset + "'", throwable);
   }

}
