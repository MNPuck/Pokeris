package com.nowhereinc.Pokeris.game.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.nowhereinc.Pokeris.game.Assets;
import com.nowhereinc.Pokeris.util.Constants;

public class LineH extends AbstractGameObject {

	private TextureRegion LineH;

	public LineH () {
		init();
	}

	private void init () {
		dimension.set(Constants.GAMEBOARD_WIDTH, .025f);
		
		LineH = Assets.instance.lineH.lineH;

	}

	public void render (SpriteBatch batch) {
		
		TextureRegion reg = null;

		reg = LineH;
		batch.draw(reg.getTexture(), position.x, position.y, origin.x, origin.y, dimension.x, dimension.y, scale.x, scale.y,
			rotation, reg.getRegionX(), reg.getRegionY(), reg.getRegionWidth(), reg.getRegionHeight(), false, false);
		
	}

}
