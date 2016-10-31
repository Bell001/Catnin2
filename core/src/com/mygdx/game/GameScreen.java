package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class GameScreen extends ScreenAdapter {
	private CatNin catNin;   
	private Texture NinjaCat;
	private Cat cat;
	World world;
	WorldRenderer worldRenderer;
 
	 
    public GameScreen(CatNin catNin) {
    	this.catNin = catNin;
        world = new World(catNin);
        worldRenderer = new WorldRenderer(catNin,world);
    }
    
    @Override
    public void render(float delta) {
    	
    	update(delta);
    	
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        worldRenderer.render(delta);
        
    }
    
    private void update(float delta) {
    	updateCatNinDirection();
    	world.update(delta);
    }
    
    private void updateCatNinDirection() {
    	Cat cat = world.getCat();
    	if(Gdx.input.isKeyPressed(Keys.UP)) {
    		cat.setNextDirection(Cat.DIRECTION_UP);
        }else if(Gdx.input.isKeyPressed(Keys.DOWN)) {
    		cat.setNextDirection(Cat.DIRECTION_DOWN);
        }else if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
    		cat.setNextDirection(Cat.DIRECTION_RIGHT);
        }else if(Gdx.input.isKeyPressed(Keys.LEFT)) {
    		cat.setNextDirection(Cat.DIRECTION_LEFT);
        }else {
        	cat.setNextDirection(cat.DIRECTION_STILL);
        }
    }   
  
}

