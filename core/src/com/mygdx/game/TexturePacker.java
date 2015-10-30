package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

// OPTION 1 (less smooth than option 2)
public class TexturePacker extends ApplicationAdapter {
	SpriteBatch batch;
	TextureAtlas taBomberman;
	Sprite[] spBomberman;
	int i = 0, nSpeed = 0;

	@Override
	public void create () {
		batch = new SpriteBatch();
		taBomberman = new TextureAtlas(Gdx.files.internal("bomber.txt"));
		spBomberman = new Sprite[7];

		for(i = 0; i < 7; i++) {
			this.spBomberman[i] = new Sprite(this.taBomberman.findRegion("frame_" + i));
		}
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		nSpeed++;
		if(nSpeed%30 == 0) {
			if (i == 7) {
				i = 0;
			} else {
				spBomberman[i++].draw(batch);
			}
		}
		batch.end();
	}
}

/* OPTION 2: http://www.gamefromscratch.com/post/2015/02/27/LibGDX-Video-Tutorial-Sprite-Animation.aspx

	SpriteBatch batch;
	private TextureAtlas textureAtlas;
	private Animation animation;
	private float elapsedTime = 0f;

	@Override
	public void create () {
		batch = new SpriteBatch();
		textureAtlas = new TextureAtlas(Gdx.files.internal("bomber.pack"));
		animation = new Animation(1f/15f, textureAtlas.getRegions());
	}

	@Override
	public void dispose() {
		batch.dispose();
		textureAtlas.dispose();
	}

	@Override
	public void render () {
		elapsedTime += Gdx.graphics.getDeltaTime();
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(animation.getKeyFrame(elapsedTime,true),0,0);
		batch.end();
	}
}*/