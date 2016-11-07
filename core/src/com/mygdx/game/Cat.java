package com.mygdx.game;

import java.util.LinkedList;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.List;

public class Cat {
	 private Vector2 position;
	 private CatNin catNin;
	 private World world;
	 private Maze maze;
	 private Enamy enamy;
	 private int currentDirection;
	 private int nextDirection;
	 private LinkedList<DotEattenListener> listeners;
	 public static boolean CatinBase = true;
	 public static boolean remove = false;
	 public static double ValueDown = 1.02;
	 public static double c = 10; //counter
	 public static int x = 0; // value for check jump
	 public static boolean Status = true;
	 public static boolean Jump = false;
	 public static final int SPEED = 5;
	 public static final int DIRECTION_SPACE = 1;
	 public static final int DIRECTION_RIGHT = 2;
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
	        } else if(maze.Border(newRow,newCol)){
	            return false;
	        } else if(maze.hasBlockAt(newRow,newCol)||checkcatinwood()){
	        	position.x += SPEED * DIR_OFFSETS[dir][0];
	        	CatinBase = true;
	        	ValueDown = 1.2;
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
	 }
	 
	 
	 public void update() {
		    Maze maze = world.getMaze();
	        if(canMoveInDirection(nextDirection)) {
	             currentDirection = nextDirection;
	             
	             if(position.y <= 760 && Status) { //Down
	            	position.y += 2*ValueDown;
	 	        	ValueDown += 0.2;
	 	        	CatinBase = false;
	             } else {
		        	ValueDown = 1.2;
		        	CatinBase = true;
		         }
	             
	             if(currentDirection == 1 || checkcatonmelon()) {
	            	 Jump = true;
	            	 Status = false;
	             }
	             
	             if(Jump) {
	            	position.y += (int)(Math.sin(c)+Math.cos(c))*SPEED;
	 	        	c += 0.03;
	 	        	if((int)(Math.sin(c)+Math.cos(c))*SPEED > -2) {
	 	        		c=10;
	 	        		Status = true;
	 	        		Jump = false;
	 	        	}
	             }
	             
	             if(maze.hasItemAt(getRow(), getColumn())){
	                   maze.removeItem1At(getRow(),getColumn());
	                   world.increaseScore();
	                   notifyDotEattenListeners();
	             }
	                    
	        } else {
	             currentDirection = DIRECTION_STILL; 	
	        }        
	        move(currentDirection);   
	        
	 }
	 
	 public boolean checkcatinbase() {
		    return CatinBase; 
	 }
	 
	 public boolean checkcatonmelon() {
		 Vector2 pos = world.getEnamy().getPosition();		 
		 if((Math.abs(position.y - pos.y) < 40) && (Math.abs(position.x - pos.x) < 40)) {
			 world.increaseScore();
			 remove = true;
			 return true;
		 } else {
		     return false;
		 }
	 }	 
	 
	 public boolean checkcatinwood(){
		 Vector2 pos = world.getWood().getPosition();
		 if((Math.abs(position.y-pos.y) < 10) && ((Math.abs(position.x-pos.x) < 30))) {
			 return true;	 
	     } else {
	    	 return false;
	     }
	 }
	 
	 public boolean Remove() {
		 return remove;
	 }
}
