package com.mygdx.game;

import java.util.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
	public static int NumCatImg = 0; //เปลี่ยนรูปแมว
	public static final int BLOCK_SIZE = 20;
	public static final int CAT_SIZE = 80;
	public static Vector2[] pos_E = new Vector2[10];
	public static Vector2 pos_C;
	public static Vector2 pos_W;
	public  SpriteBatch batch;	
	private Enamy[] enamy;
	private CatNin catNin;
	private Texture CatMove0;
	private Texture CatMove1;
	private Texture CatMove2;
	private Texture Enamy1;
	private Texture WoodImage;
	private Cat cat;
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
	    Enamy1 = new Texture("Melon1.png");
	    WoodImage = new Texture("Boxver3.jpg");
	    mazeRenderer = new MazeRenderer(catNin.batch, world.getMaze());
	    font = new BitmapFont();
	}
	
	public void render(float delta) {
		mazeRenderer.render();
		SpriteBatch batch = catNin.batch;
		getPosition();
        batch.begin(); 
        draw_Cat();
        draw_Wood();
        draw_Enamy();
        font.draw(batch, "SCORE  " + world.getScore(), 100, 150);
        font.draw(batch, "HP " , 100, 100);
        batch.end();
	}
	
	public void getPosition() {
	    pos_C = world.getCat().getPosition();
		pos_W = world.getWood().getPosition();
		for(int j=0;j<10;j++) {
		 if(world.Check_E[j]) {
			 pos_E[j] = world.getEnamy(j).getPosition();
		 }
		}
	}
	
	public void draw_Cat() {
		 if(NumCatImg<=30){
	            batch.draw(CatMove0, pos_C.x-BLOCK_SIZE/2, CatNin.HEIGHT - pos_C.y - BLOCK_SIZE/2);
	            ++NumCatImg;
	     } else if(NumCatImg <=60){
	        	batch.draw(CatMove1, pos_C.x-BLOCK_SIZE/2, CatNin.HEIGHT - pos_C.y - BLOCK_SIZE/2);
	        	++NumCatImg;
	     } else if(NumCatImg<=90) {
	        	batch.draw(CatMove2, pos_C.x-BLOCK_SIZE/2, CatNin.HEIGHT - pos_C.y - BLOCK_SIZE/2);   
	        	++NumCatImg;
	     } else {
	        	batch.draw(CatMove0, pos_C.x-BLOCK_SIZE/2, CatNin.HEIGHT - pos_C.y - BLOCK_SIZE/2);
	        	NumCatImg = 0;
	     }        
	}
	
	public void draw_Wood() {
		batch.draw(WoodImage , pos_W.x-BLOCK_SIZE/2-50, CatNin.HEIGHT - pos_W.y - BLOCK_SIZE/2);
	}
	
	public void draw_Enamy() {
		for(int j=0;j<10;j++) {
	          if(world.Check_E[j]) {
	             batch.draw(Enamy1 , pos_E[j].x-BLOCK_SIZE/2, CatNin.HEIGHT - pos_E[j].y - BLOCK_SIZE/2);
	          }
	        }  
	}

}
