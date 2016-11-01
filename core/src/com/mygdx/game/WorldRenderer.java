package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
	public static int NumCatImg = 0; //เปลี่ยนรูปแมว
	public static final int BLOCK_SIZE = 20;
	public  SpriteBatch batch;	
	private CatNin catNin;
	private Texture CatMove0;
	private Texture CatMove1;
	private Texture CatMove2;
	private Texture Enamy1;
	private World world;
	private MazeRenderer mazeRenderer;
	private BitmapFont font;
	
	public WorldRenderer(CatNin catNin, World world) {
		this.catNin = catNin;
	    batch = catNin.batch;
	    this.world = world;
	    CatMove0 = new Texture("Cat-Move1.png");
	    CatMove1 = new Texture("Cat-Move2.png");
	    CatMove2 = new Texture("Cat-Move3.png");
	    mazeRenderer = new MazeRenderer(catNin.batch, world.getMaze());
	    font = new BitmapFont();
	}
	
	public void render(float delta) {
		mazeRenderer.render();
		SpriteBatch batch = catNin.batch;
		Vector2 pos = world.getCat().getPosition();
        batch.begin(); 
        if(NumCatImg<=30){
            batch.draw(CatMove0, pos.x-BLOCK_SIZE/2, CatNin.HEIGHT - pos.y - BLOCK_SIZE/2);
            ++NumCatImg;
        } else if(NumCatImg <=60){
        	batch.draw(CatMove1, pos.x-BLOCK_SIZE/2, CatNin.HEIGHT - pos.y - BLOCK_SIZE/2);
        	++NumCatImg;
        } else if(NumCatImg<=90) {
        	batch.draw(CatMove2, pos.x-BLOCK_SIZE/2, CatNin.HEIGHT - pos.y - BLOCK_SIZE/2);   
        	++NumCatImg;
        } else {
        	batch.draw(CatMove0, pos.x-BLOCK_SIZE/2, CatNin.HEIGHT - pos.y - BLOCK_SIZE/2);
        	NumCatImg = 0;
        }
        System.out.println(NumCatImg);
        font.draw(batch, "SCORE  " + world.getScore(), 100, 150);
        batch.end();
	}

}
