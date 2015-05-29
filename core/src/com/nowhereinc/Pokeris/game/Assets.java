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
	
	public AssetFonts fonts;
	
	public AssetBorder border;
	
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
	
	public AssetDownArrow downArrow;
	public AssetLeftArrow leftArrow;
	public AssetRightArrow rightArrow;
	public AssetUpArrow upArrow;
	
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
			defaultNormal.setScale(2.0f);
			defaultBig.setScale(3.0f);
			// enable linear texture filtering for smooth fonts
			defaultSmall.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
			defaultNormal.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
			defaultBig.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
			
		}
	}
	
	public class AssetBorder {
		public final AtlasRegion border;

		public AssetBorder (TextureAtlas atlas) {
			border = atlas.findRegion("border");
			
			if (border == null) {
				
				Gdx.app.debug(TAG,"Border is null");
			}

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
	
	public class AssetCard33 {
		public final AtlasRegion card33;

		public AssetCard33 (TextureAtlas atlas) {
			card33 = atlas.findRegion("33");
			
			if (card33 == null) {
				
				Gdx.app.debug(TAG, "Card33 is null");
			}

		}
		
	}
	
	public class AssetCard34 {
		public final AtlasRegion card34;

		public AssetCard34 (TextureAtlas atlas) {
			card34 = atlas.findRegion("34");
			
			if (card34 == null) {
				
				Gdx.app.debug(TAG, "Card34 is null");
			}

		}
		
	}
	
	public class AssetCard35 {
		public final AtlasRegion card35;

		public AssetCard35 (TextureAtlas atlas) {
			card35 = atlas.findRegion("35");
			
			if (card35 == null) {
				
				Gdx.app.debug(TAG, "Card35 is null");
			}

		}
		
	}
	
	public class AssetCard36 {
		public final AtlasRegion card36;

		public AssetCard36 (TextureAtlas atlas) {
			card36 = atlas.findRegion("36");
			
			if (card36 == null) {
				
				Gdx.app.debug(TAG, "Card36 is null");
			}

		}
		
	}
	
	public class AssetCard37 {
		public final AtlasRegion card37;

		public AssetCard37 (TextureAtlas atlas) {
			card37 = atlas.findRegion("37");
			
			if (card37 == null) {
				
				Gdx.app.debug(TAG, "Card37 is null");
			}

		}
		
	}
	
	public class AssetCard38 {
		public final AtlasRegion card38;

		public AssetCard38 (TextureAtlas atlas) {
			card38 = atlas.findRegion("38");
			
			if (card38 == null) {
				
				Gdx.app.debug(TAG, "Card38 is null");
			}

		}
		
	}
	
	public class AssetCard39 {
		public final AtlasRegion card39;

		public AssetCard39 (TextureAtlas atlas) {
			card39 = atlas.findRegion("39");
			
			if (card39 == null) {
				
				Gdx.app.debug(TAG, "Card39 is null");
			}

		}
		
	}
	
	public class AssetCard40 {
		public final AtlasRegion card40;

		public AssetCard40 (TextureAtlas atlas) {
			card40 = atlas.findRegion("40");
			
			if (card40 == null) {
				
				Gdx.app.debug(TAG, "Card40 is null");
			}

		}
		
	}
	
	public class AssetCard41 {
		public final AtlasRegion card41;

		public AssetCard41 (TextureAtlas atlas) {
			card41 = atlas.findRegion("41");
			
			if (card41 == null) {
				
				Gdx.app.debug(TAG, "Card41 is null");
			}

		}
		
	}
	
	public class AssetCard42 {
		public final AtlasRegion card42;

		public AssetCard42 (TextureAtlas atlas) {
			card42 = atlas.findRegion("42");
			
			if (card42 == null) {
				
				Gdx.app.debug(TAG, "Card42 is null");
			}

		}
		
	}
	
	public class AssetCard43 {
		public final AtlasRegion card43;

		public AssetCard43 (TextureAtlas atlas) {
			card43 = atlas.findRegion("43");
			
			if (card43 == null) {
				
				Gdx.app.debug(TAG, "Card43 is null");
			}

		}
		
	}
	
	public class AssetCard44 {
		public final AtlasRegion card44;

		public AssetCard44 (TextureAtlas atlas) {
			card44 = atlas.findRegion("44");
			
			if (card44 == null) {
				
				Gdx.app.debug(TAG, "Card44 is null");
			}

		}
		
	}
	
	public class AssetCard45 {
		public final AtlasRegion card45;

		public AssetCard45 (TextureAtlas atlas) {
			card45 = atlas.findRegion("45");
			
			if (card45 == null) {
				
				Gdx.app.debug(TAG, "Card45 is null");
			}

		}
		
	}
	
	public class AssetCard46 {
		public final AtlasRegion card46;

		public AssetCard46 (TextureAtlas atlas) {
			card46 = atlas.findRegion("46");
			
			if (card46 == null) {
				
				Gdx.app.debug(TAG, "Card46 is null");
			}

		}
		
	}
	
	public class AssetCard47 {
		public final AtlasRegion card47;

		public AssetCard47 (TextureAtlas atlas) {
			card47 = atlas.findRegion("47");
			
			if (card47 == null) {
				
				Gdx.app.debug(TAG, "Card47 is null");
			}

		}
		
	}
	
	public class AssetCard48 {
		public final AtlasRegion card48;

		public AssetCard48 (TextureAtlas atlas) {
			card48 = atlas.findRegion("48");
			
			if (card48 == null) {
				
				Gdx.app.debug(TAG, "Card48 is null");
			}

		}
		
	}
	
	public class AssetCard49 {
		public final AtlasRegion card49;

		public AssetCard49 (TextureAtlas atlas) {
			card49 = atlas.findRegion("49");
			
			if (card49 == null) {
				
				Gdx.app.debug(TAG, "Card49 is null");
			}

		}
		
	}
	
	public class AssetCard50 {
		public final AtlasRegion card50;

		public AssetCard50 (TextureAtlas atlas) {
			card50 = atlas.findRegion("50");
			
			if (card50 == null) {
				
				Gdx.app.debug(TAG, "Card50 is null");
			}

		}
		
	}
	
	public class AssetCard51 {
		public final AtlasRegion card51;

		public AssetCard51 (TextureAtlas atlas) {
			card51 = atlas.findRegion("51");
			
			if (card51 == null) {
				
				Gdx.app.debug(TAG, "Card51 is null");
			}

		}
		
	}
	
	public class AssetCard52 {
		public final AtlasRegion card52;

		public AssetCard52 (TextureAtlas atlas) {
			card52 = atlas.findRegion("52");
			
			if (card52 == null) {
				
				Gdx.app.debug(TAG, "Card52 is null");
			}

		}
		
	}
	
	public class AssetDownArrow {
		public final AtlasRegion downArrow;

		public AssetDownArrow (TextureAtlas atlas) {
			downArrow = atlas.findRegion("DownArrow");
			
			if (downArrow == null) {
				
				Gdx.app.debug(TAG,"Down arrow is null");
			}

		}
		
	}
	
	public class AssetLeftArrow {
		public final AtlasRegion leftArrow;

		public AssetLeftArrow (TextureAtlas atlas) {
			leftArrow = atlas.findRegion("LeftArrow");
			
			if (leftArrow == null) {
				
				Gdx.app.debug(TAG,"Left arrow is null");
			}

		}
		
	}
	
	public class AssetRightArrow {
		public final AtlasRegion rightArrow;

		public AssetRightArrow (TextureAtlas atlas) {
			rightArrow = atlas.findRegion("RightArrow");
			
			if (rightArrow == null) {
				
				Gdx.app.debug(TAG,"Right arrow is null");
			}

		}
		
	}
	
	public class AssetUpArrow {
		public final AtlasRegion upArrow;

		public AssetUpArrow (TextureAtlas atlas) {
			upArrow = atlas.findRegion("UpArrow");
			
			if (upArrow == null) {
				
				Gdx.app.debug(TAG,"Up arrow is null");
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
		
		TextureAtlas atlas = assetManager.get(Constants.TEXTURE_ATLAS_OBJECTS);

		// enable texture filtering for pixel smoothing
		for (Texture t : atlas.getTextures()) {
			t.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		}

		// create game resource objects
		fonts = new AssetFonts();
		
		border = new AssetBorder(atlas);
		
		card1 = new AssetCard1(atlas);
		card2 = new AssetCard2(atlas);
		card3 = new AssetCard3(atlas);
		card4 = new AssetCard4(atlas);
		card5 = new AssetCard5(atlas);
		card6 = new AssetCard6(atlas);
		card7 = new AssetCard7(atlas);
		card8 = new AssetCard8(atlas);
		card9 = new AssetCard9(atlas);
		card10 = new AssetCard10(atlas);
		card11 = new AssetCard11(atlas);
		card12 = new AssetCard12(atlas);
		card13 = new AssetCard13(atlas);
		card14 = new AssetCard14(atlas);
		card15 = new AssetCard15(atlas);
		card16 = new AssetCard16(atlas);
		card17 = new AssetCard17(atlas);
		card18 = new AssetCard18(atlas);
		card19 = new AssetCard19(atlas);
		card20 = new AssetCard20(atlas);
		card21 = new AssetCard21(atlas);
		card22 = new AssetCard22(atlas);
		card23 = new AssetCard23(atlas);
		card24 = new AssetCard24(atlas);
		card25 = new AssetCard25(atlas);
		card26 = new AssetCard26(atlas);
		card27 = new AssetCard27(atlas);
		card28 = new AssetCard28(atlas);
		card29 = new AssetCard29(atlas);
		card30 = new AssetCard30(atlas);
		card31 = new AssetCard31(atlas);
		card32 = new AssetCard32(atlas);
		card33 = new AssetCard33(atlas);
		card34 = new AssetCard34(atlas);
		card35 = new AssetCard35(atlas);
		card36 = new AssetCard36(atlas);
		card37 = new AssetCard37(atlas);
		card38 = new AssetCard38(atlas);
		card39 = new AssetCard39(atlas);
		card40 = new AssetCard40(atlas);
		card41 = new AssetCard41(atlas);
		card42 = new AssetCard42(atlas);
		card43 = new AssetCard43(atlas);
		card44 = new AssetCard44(atlas);
		card45 = new AssetCard45(atlas);
		card46 = new AssetCard46(atlas);
		card47 = new AssetCard47(atlas);
		card48 = new AssetCard48(atlas);
		card49 = new AssetCard49(atlas);
		card50 = new AssetCard50(atlas);
		card51 = new AssetCard51(atlas);
		card52 = new AssetCard52(atlas);
		
		downArrow = new AssetDownArrow(atlas);	
		leftArrow = new AssetLeftArrow(atlas);
		rightArrow = new AssetRightArrow(atlas);
		upArrow = new AssetUpArrow(atlas);
		
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
