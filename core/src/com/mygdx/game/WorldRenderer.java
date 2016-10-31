package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
	public static final int BLOCK_SIZE = 40;
	public  SpriteBatch batch;	
	private CatNin catNin;
	private Texture NinjaCat;
	private World world;
	private MazeRenderer mazeRenderer;
	
	public WorldRenderer(CatNin catNin, World world) {
		this.catNin = catNin;
	    batch = catNin.batch;
	    this.world = world;
	    NinjaCat = new Texture("Catbox.png");
	    mazeRenderer = new MazeRenderer(catNin.batch, world.getMaze());
	}
	
	public void render(float delta) {
		mazeRenderer.render();
		SpriteBatch batch = catNin.batch;
		Vector2 pos = world.getCat().getPosition();
        batch.begin(); 
        batch.draw(NinjaCat, pos.x-BLOCK_SIZE/2, CatNin.HEIGHT - pos.y - BLOCK_SIZE/2);
        batch.end();
	}

}
