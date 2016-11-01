package com.mygdx.game;

import java.util.LinkedList;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.List;

public class Cat {
	 private Vector2 position;
	 private CatNin catNin;
	 private World world;
	 private Maze maze;
	 private int currentDirection;
	 private int nextDirection;
	 private LinkedList<DotEattenListener> listeners;
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
	 
	 public interface DotEattenListener {
	        void notifyDotEatten();			
	    }
	 
	 public Cat(int x, int y, World world) {
	        position = new Vector2(x,y);
	        currentDirection = DIRECTION_STILL;
	        nextDirection = DIRECTION_STILL;
	        this.maze = maze;
	        listeners = new LinkedList<DotEattenListener>();
	        this.world = world;
	       
	 }  
	 
	 public void registerDotEattenListener(DotEattenListener l) {
	        listeners.add(l);
	 }
	 
	 private void notifyDotEattenListeners() {
	        for(DotEattenListener l : listeners) {
	            l.notifyDotEatten();
	        }
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
		    Maze maze = world.getMaze();
	    	int newRow = DIR_OFFSETS[dir][1]+getRow();  
	        int newCol = DIR_OFFSETS[dir][0]+getColumn(); 
	        
	        if(newRow <= 0 || newCol<= 0){
	        	return false;
	        } else if(maze.ShadowAtRight(newRow,newCol)){
	            return false;
	        } else if(maze.ShadowAtLeft(newRow,newCol)){
	            return false;
	        } else if(maze.ShadowAtDown(newRow,newCol)){
	            return false;
	        } else if(maze.ShadowAtUp(newRow,newCol)){
	            return false;
	        } else if(maze.ShadowAtCorner(newRow,newCol)){
	            return false;
	        } else {
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
	 
	 
	 public void update() {
		    Maze maze = world.getMaze();
	        if(true) {
	            	if(canMoveInDirection(nextDirection)) {
	                    currentDirection = nextDirection;
	                    if(maze.hasSpaceAt(getRow(), getColumn())){
	                    	maze.removeItem1At(getRow(),getColumn());
	                    	world.increaseScore();
	                    	notifyDotEattenListeners();
	                    }
	                    
	                } else {
	                    currentDirection = DIRECTION_STILL; 	                    
	                }
	        } 
	        move(currentDirection);     
	 }	 
}
