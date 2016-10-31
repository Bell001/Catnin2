package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MazeRenderer {
	 private Maze maze;
	 private SpriteBatch batch;
	 private Texture ShadowImageRight;
	 private Texture ShadowImageLeft;
	 private Texture ShadowImageCorner;
	 private Texture ShadowImageDown;
	 private Texture ShadowImageUp;
	 private Texture EnamyImage;
	 private Texture ItemImage;
	 private Texture BackgroundImage;
	 
	 public MazeRenderer(SpriteBatch batch, Maze maze) {
	        this.maze = maze;
	        this.batch = batch;
	        ShadowImageRight = new Texture("Border-Right.png");  //ให้แทนด้วยสัญลักษณะใน maze R
	        ShadowImageLeft = new Texture("Border-Left.png");   //ให้แทนด้วยสัญลักษณะใน maze L
	        ShadowImageCorner = new Texture("Border-Corner.png"); //ให้แทนด้วยสัญลักษณะใน maze C
	        ShadowImageDown = new Texture("Border-Down.png");   //ให้แทนด้วยสัญลักษณะใน maze D
	        ShadowImageUp = new Texture("Border-Up.png");     //ให้แทนด้วยสัญลักษณะใน maze U
	        EnamyImage = new Texture("T1.png");
	        ItemImage = new Texture("ITEM1.png");
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
	 
	                if(maze.ShadowAtRight(r, c)) {
	                    batch.draw(ShadowImageRight, x, y);
	                } else if(maze.ShadowAtLeft(r, c)) {
	                	batch.draw(ShadowImageLeft, x, y);
	                } else if(maze.ShadowAtCorner(r, c)) {
	                	batch.draw(ShadowImageCorner, x, y);
	                } else if(maze.ShadowAtDown(r, c)) {
	                	batch.draw(ShadowImageDown, x, y);
	                } else if(maze.ShadowAtUp(r, c)) {
	                	batch.draw(ShadowImageUp, x, y);
	                } else if(maze.hasSpaceAt(r, c)) {
//	                    batch.draw(EnamyImage, x, y);
	                } else if(maze.Item1(r,c)){
	                	batch.draw(ItemImage, x, y);
	                }
	            }
	     }
	     batch.end();
	 }
}
