package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MazeRenderer {
	 private Maze maze;
	 private SpriteBatch batch;
	 private Texture Border;
	 private Texture ItemImage;
	 private Texture BlockImage;
	 private Texture BackgroundImage;
	 
	 public MazeRenderer(SpriteBatch batch, Maze maze) {
	        this.maze = maze;
	        this.batch = batch;
	        Border = new Texture("Border-Corner.png");  //ให้แทนด้วยสัญลักษณะใน maze R
	        ItemImage = new Texture("ITEM1.png");
	        BlockImage = new Texture("BOX-40.png");
	        BackgroundImage = new Texture("BackGround2.png");
	        
	 }
	 
	 public void render() {
		 batch.begin();
		 batch.draw(BackgroundImage, 0, 0);
	     for(int r = 0; r < maze.getHeight(); r++) {
	            for(int c = 0; c < maze.getWidth(); c++) {
	            	int x = c * WorldRenderer.BLOCK_SIZE;
	                int y = CatNin.HEIGHT - 
	                        (r * WorldRenderer.BLOCK_SIZE) - WorldRenderer.BLOCK_SIZE;
	 
	                if(maze.Border(r, c)) {
//	                    batch.draw(ShadowImageRight, x, y);	       
	                } else if(maze.hasBlockAt(r,c)){
	                	batch.draw(BlockImage, x, y);
	                } else if(maze.hasItemAt(r, c)) {
	                    batch.draw(ItemImage, x, y);
	                }
	            }
	     }
	     batch.end();
	 }
}
