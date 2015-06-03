package com.nowhereinc.Pokeris.game.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.nowhereinc.Pokeris.game.Assets;
import com.nowhereinc.Pokeris.util.Constants;

public class LineV extends AbstractGameObject {

	private TextureRegion LineV;

	public LineV () {
		init();
	}

	private void init () {
		dimension.set(.025f, Constants.GAMEBOARD_HEIGHT);
		
		LineV = Assets.instance.lineV.lineV;

	}

	public void render (SpriteBatch batch) {
		
		TextureRegion reg = null;

		reg = LineV;
		batch.draw(reg.getTexture(), position.x, position.y, origin.x, origin.y, dimension.x, dimension.y, scale.x, scale.y,
			rotation, reg.getRegionX(), reg.getRegionY(), reg.getRegionWidth(), reg.getRegionHeight(), false, false);
		
	}

}

