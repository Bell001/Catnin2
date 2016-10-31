package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class Cat {
	 private Vector2 position;
	 private CatNin catNin;
	 private World world;
	 private Maze maze;
	 private int currentDirection;
	 private int nextDirection;
	 public static final int SPEED = 5;
	 public static final int DIRECTION_UP = 1;
	 public static final int DIRECTION_RIGHT = 2;
	 public static final int DIRECTION_DOWN = 3;
	 public static final int DIRECTION_LEFT = 4;
	 public static final int DIRECTION_STILL = 0;
	 private static final int [][] DIR_OFFSETS = new int [][] {
	        {0,0},
	        {0,-1},
	        {1,0},
	        {0,1},
	        {-1,0}
	    };
	 
	 public Cat(int x, int y, Maze maze) {
	        position = new Vector2(x,y);
	        currentDirection = DIRECTION_STILL;
	        nextDirection = DIRECTION_STILL;
	        this.maze = maze;
	       
	 }  
	 
	 public Vector2 getPosition() {
	        return position;    
	 }
	 
	 private int getRow() {
	        return ((int)position.y) / WorldRenderer.BLOCK_SIZE; 
	    }
	 
	 private int getColumn() {
	        return ((int)position.x) / WorldRenderer.BLOCK_SIZE; 
	    }
	 
	 
	
	 private boolean canMoveInDirection(int dir) {
	
	    	int newRow = DIR_OFFSETS[dir][1]+getRow();  
	        int newCol = DIR_OFFSETS[dir][0]+getColumn(); 
	        
	        if(newRow <= 0 || newCol<= 0)
	        {
	        	return false;
	        }
	        else if(maze.hasWallAt(newRow,newCol))
	        {
	            return false;
	        }
	        else 
	        {
	            return true;
	        }
	    }
	    
	
	 
	 public void setNextDirection(int dir) {
	        nextDirection = dir;
	    }
	 
	 public void move(int dir) { 
		 position.x += SPEED * DIR_OFFSETS[dir][0];
	     position.y += SPEED * DIR_OFFSETS[dir][1];
	  
	 }
	 
	 public boolean isAtCenter() {
	        int blockSize = WorldRenderer.BLOCK_SIZE;
	 
	        return ((((int)position.x - blockSize/2) % blockSize) == 0) &&
	                ((((int)position.y - blockSize/2) % blockSize) == 0);
	    }
	 
	 
	 public void update() {
	        if(isAtCenter()) {
	            	if(canMoveInDirection(nextDirection)) {
	                    currentDirection = nextDirection;
	                    
	                } else {
	                    currentDirection = DIRECTION_STILL;    
	                }
	        }
	        position.x += SPEED * DIR_OFFSETS[currentDirection][0];
	        position.y += SPEED * DIR_OFFSETS[currentDirection][1];       
	 }	 
}
