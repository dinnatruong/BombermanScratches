package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class BombermanScratches extends ApplicationAdapter {
	SpriteBatch batch;
	TextureAtlas walking;
	Sprite[] spWalking;
	int i = 0, nSpeed = 0;

	@Override
	public void create () {
		batch = new SpriteBatch();
		walking = new TextureAtlas(Gdx.files.internal("bomber.txt"));
		spWalking = new Sprite[7];

		for(i = 0; i < 7; i++) {
			this.spWalking[i] = new Sprite(this.walking.findRegion("frame_" + i));
		}
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		nSpeed++;
		if(nSpeed%20 == 0) {
			if (i == 7) {
				i = 0;
			} else {
				spWalking[i].draw(batch);
				i++;
			}
		}
		batch.end();
	}
}
