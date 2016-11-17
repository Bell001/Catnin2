package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class GameScreen extends ScreenAdapter {
	private CatNin catNin;   
	private Texture NinjaCat;
	private Cat cat;
	private Texture Background_PAUSE;
	public static boolean Pause= true;
	World world;
	WorldRenderer worldRenderer;
	 
    public GameScreen(CatNin catNin) {
    	Background_PAUSE = new Texture("Background_PAUSE.png");
    	this.catNin = catNin;
        world = new World(catNin);
        worldRenderer = new WorldRenderer(catNin,world);
//        Sound backsound = Gdx.audio.newSound(Gdx.files.internal("data/Background-S.mp3"));
//        backsound.play();
    }
    
    @Override
    public void render(float delta) {
    	
    	SpriteBatch batch = catNin.batch;
        Pause();
       
    	if(Pause) {
    		
    		update(delta);
    	
    		Gdx.gl.glClearColor(0, 0, 0, 1);
    		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
    		worldRenderer.render(delta);
    	} else {
    		 		 
    		 batch.begin(); 
    		 batch.draw(Background_PAUSE, 0, 0);
    		 batch.end();
    		
    		
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
}
  

