package com.mygdx.game;
import java.awt.Font;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class GameScreen extends ScreenAdapter {
	private CatNin catNin;  
	private Maze maze;
	private Texture NinjaCat;
	boolean Gameover = false;
	boolean Gamestart = false;
	private Cat cat;
	private Texture Background_PAUSE;
	private Texture Background_START;
	private Texture Background_Over;
	public static boolean Pause = true;
	public static boolean Restart = false;
	private BitmapFont font;
	World world;
	WorldRenderer worldRenderer;
	 
    public GameScreen(CatNin catNin) {
    	
    	Background_START = new Texture("START.png");
    	Background_PAUSE = new Texture("Background_PAUSE.png");
    	Background_Over = new Texture("Background_GAMEOVER.png");
    	this.catNin = catNin;
        world = new World(catNin);
        worldRenderer = new WorldRenderer(catNin,world);
        font = new BitmapFont();
    }
    
    @Override
    public void render(float delta) {
    	
    	SpriteBatch batch = catNin.batch;
        Pause();
        Gameover = world.setOver();
        
        if(Gameover) {
        
        	batch.begin(); 
   		    batch.draw(Background_Over, 0, 0);
   		    font.draw(batch, "YOURSCORE  :  "+world.score, 560, 440);
   		    font.draw(batch, "HIGHSCORE  :  "+world.High_Point, 560, 400);
   		    batch.end();        
   		    Restart();
   		    if(Restart) {
   		    	Resetgame();
   		    	Restart = false;
   		    }
        
        } else if(Pause) {
    		if(Gamestart) {
    			update(delta);
    	
    			Gdx.gl.glClearColor(0, 0, 0, 1);
    			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
    			worldRenderer.render(delta);
    		} else {
    			 batch.begin(); 
        		 batch.draw(Background_START, 0, 0);
        		 batch.end();
    		}
    		
    	} else {
    		 		 
    		 batch.begin(); 
    		 batch.draw(Background_PAUSE, 0, 0);
    		 batch.end();
    		
    	}
        
        EnterGamestart();
        
    }
    
    GameScreen getgamescreen() {
    	return this;
    }

    public void EnterGamestart(){
    	if(Gdx.input.isKeyPressed(Keys.ENTER)) {
    		Gamestart = true;
    		Pause = true;
    	}
    }
    
    private void update(float delta) {
    	updateCatNinDirection();
    	world.update(delta);
    }
    
    private void updateCatNinDirection() {

    	Cat cat = world.getCat();
    	if(Gdx.input.isKeyPressed(Keys.SPACE)) {
     		if(cat.checkcatinbase()){
    		   cat.setNextDirection(Cat.DIRECTION_SPACE);
    		}
        }else if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
    		cat.setNextDirection(Cat.DIRECTION_RIGHT);
        }else if(Gdx.input.isKeyPressed(Keys.LEFT)) {
    		cat.setNextDirection(Cat.DIRECTION_LEFT);
        }else {
        	cat.setNextDirection(cat.DIRECTION_STILL);
        }
    	   	

    }
    
    private void Pause() {
    	if(Gdx.input.isKeyPressed(Keys.ENTER)) {
    	    try {
    	            Thread.sleep(100);                 //1000 milliseconds is one second.
    	    } catch(InterruptedException ex) {
    	            Thread.currentThread().interrupt();
    	    }
    		if(Pause == true) {
    			Pause = false;
    		} else if(Pause == false){
    			Pause = true;
    		}
    	}
    }
    
    private void Restart() {
    	if(Gdx.input.isKeyPressed(Keys.BACKSPACE)) {
    		try {
	            Thread.sleep(100);                 //1000 milliseconds is one second.
	        } catch(InterruptedException ex) {
	            Thread.currentThread().interrupt();
	        }
    		Restart = true;
   		
    	}
    }
    
    void setOver() {
    	Gameover = true;
    }
    
    private void Resetgame() {
    	Gameover = false;
    	world.gameover = false;
    	world.HpCat = 3;
    	world.score =0;
    	world.Base_score = 0;
    	maze.MAP = maze.MAP_Base;
    }
}
  

