package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends ScreenAdapter {
	private CatNin catNin;
	private Texture NinjaCat;
	private int x;
    private int y;
 
	 
    public GameScreen(CatNin catNin) {
        this.catNin = catNin;
        NinjaCat = new Texture("Ninja-Cat1.png");
        x = 700;
        y = 400;
    }
    
    @Override
    public void render(float delta) {
    	update(delta);
    	SpriteBatch batch = catNin.batch;
        batch.begin();
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.draw(NinjaCat, x, y);
        batch.end();
        
    }
    
    private void update(float delta) {
    	if(Gdx.input.isKeyPressed(Keys.LEFT)) {
            x -= 5;
        }
        if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
            x += 5;
        }
    }
    
  
}

