package com.mygdx.game;

import java.awt.Frame;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Window;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
//import com.mygdx.game.World.STATE;

public class WorldRenderer {
	public static int NumCatImg = 0; //เปลี่ยนรูปแมว
	public static final int BLOCK_SIZE = 20;
	public static final int CAT_SIZE = 80;
	public static Vector2[] pos_E = new Vector2[10];
	public static Vector2 pos_C;
	public static Vector2 pos_W;
	public static Vector2 pos_W2;
	public static Vector2 pos_FB;

	private Enamy enamy;
	private FishFly_B fishFly_B;
	private CatNin catNin;
	private Texture CatMove0;
	private Texture CatMove1;
	private Texture CatMove2;
	private Texture HP1;
	private Texture HP2;
	private Texture HP3;
	private Texture Enamy1;
	private Texture WoodImage;	
	private Texture fishFly_Big;
	private Texture fishfly_bomb;
	private Cat cat;
	private Menu menu;
	private World world;
	private BufferedImage image = new BufferedImage(1200,800,BufferedImage.TYPE_INT_RGB);
	private MazeRenderer mazeRenderer;
	private BitmapFont font;
	public  SpriteBatch batch;
	
	public WorldRenderer(CatNin catNin, World world) {
		
		this.catNin = catNin;
	    batch = catNin.batch;
	    this.world = world;
	    CatMove0 = new Texture("Cat-Move1.png");
	    CatMove1 = new Texture("Cat-Move2.png");
	    CatMove2 = new Texture("Cat-Move3.png");
	    HP1 = new Texture("HP-MAX.png");
	    HP2 = new Texture("HP-MID.png"); 
	    HP3 = new Texture("HP-MIN.png");
	    fishFly_Big = new Texture("FishBig_Fly.png");
	    Enamy1 = new Texture("Melon1.png");
	    WoodImage = new Texture("Boxver3.jpg");
	    fishfly_bomb = new Texture("Bomb.png");
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
        draw_FishFly();
        font.draw(batch, "SCORE  " + world.getScore(), 100, 150);
        font.draw(batch, "HP " , 100, 100);
        batch.draw(HP1 , 140, 80);
        batch.end();

	}

	public void getPosition() {
	    pos_C = world.getCat().getPosition();
		pos_W = world.getWood().getPosition();
		pos_W2 = world.getWood2().getPosition();
        pos_FB = world.getflyfish().getPosition();
      
		for(int j=0;j<10;j++) {
		 if(world.Check_E[j]) {
			 pos_E[j] = world.getEnamy().getPosition(j);
		 }
		}
	}
	
	public void draw_Cat() {
	
		 if(NumCatImg<=30){
	            batch.draw(CatMove0, pos_C.x, CatNin.HEIGHT - pos_C.y );
	            ++NumCatImg;
	     } else if(NumCatImg <=60){
	        	batch.draw(CatMove1, pos_C.x, CatNin.HEIGHT - pos_C.y );
	        	++NumCatImg;
	     } else if(NumCatImg<=90) {
	        	batch.draw(CatMove2, pos_C.x, CatNin.HEIGHT - pos_C.y );   
	        	++NumCatImg;
	     } else {
	        	batch.draw(CatMove0, pos_C.x, CatNin.HEIGHT - pos_C.y );
	        	NumCatImg = 0;
	     }        
		
	}
	
	public void draw_Wood() {
		batch.draw(WoodImage , pos_W.x,CatNin.HEIGHT -  pos_W.y );
		batch.draw(WoodImage , pos_W2.x,CatNin.HEIGHT -  pos_W2.y );
	}
	
	public void draw_Enamy() {
		for(int j=0;j<10;j++) {
	          if(world.Check_E[j]) {
	             batch.draw(Enamy1 , pos_E[j].x, CatNin.HEIGHT - pos_E[j].y );
	          }
	        }  
	}
	
	public void draw_FishFly() {
		if(world.getflyfish().Point) {
			batch.draw(fishFly_Big , pos_FB.x, CatNin.HEIGHT - pos_FB.y);
		} else {
			batch.draw(fishfly_bomb, pos_FB.x,CatNin.HEIGHT - pos_FB.y);
			world.getflyfish().setpos1();
			
		}		
	
	}
	

	
}
