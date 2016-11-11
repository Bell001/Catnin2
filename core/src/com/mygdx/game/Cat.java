package com.mygdx.game;

import java.util.LinkedList;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.List;

public class Cat {
	
	 private Vector2 position;
	 private WorldRenderer worldRenderer;
	 private CatNin catNin;
	 private World world;
	 private Maze maze;
	 private Wood wood;
	 private Enamy[] enamy;
	 private int currentDirection;
	 private int nextDirection;
	 private LinkedList<DotEattenListener> listeners;
	 public static Vector2 pos_w;
	 public static boolean CatinBase = true;
	 public static double ValueDown = 1.02;
	 public static double c = 10; //counter
	 public static int x = 0; // value for check jump
	 public static int check_one_jump = 0;
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
	        listeners = new LinkedList<DotEattenListener>();
	        this.world = world;
	        this.maze = maze;
	       
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
	        } else if(maze.hasBlockAt(newRow,newCol)){
	        	position.x += SPEED * DIR_OFFSETS[dir][0];
	        	CatinBase = true;
	        	ValueDown = 1.2;
	            return false;
	        } else if(checkcatinwood(pos_w)){
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
		    pos_w = world.getWood().getPosition();
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
	             
	             if(currentDirection == 1 && check_one_jump == 0) {
	            	 Jump = true;
	            	 Status = false;
	                 check_one_jump = 1;
	             } else if(currentDirection != 1) {
	            	 check_one_jump = 0;
	             }
	             
	             if(checkcatonmelon()) {
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
	        CheckBorder();
	        move(currentDirection); 
	        
	 }
	 
	 public boolean checkcatinbase() {
		    return CatinBase; 
	 }
	 
	 public boolean checkcatonmelon() {
		 this.world = world;
		 for(int i=0;i<10;i++) {
		  if(world.Check_E[i]) {		  
		     Vector2 pos = world.getEnamy(i).getPosition();
		     if((pos.y-position.y < 40 && pos.y-position.y >0 ) && (Math.abs(position.x - pos.x) < 40)) {
			    world.increaseScore();
			    world.Remove_E(i);
                world.Check_E[i] = false; 
			    return true;
	   	     }  else {
		       return false;
		     }
		   }
		 }
		 return false;
	 }	 
	 
	 public boolean checkcatinwood(Vector2 pos){
		 if((Math.abs(position.y-pos.y) < 20) && (Math.abs(position.x-pos.x) < 100)) {
			 return true;	 
	     } else {
	    	 return false;
	     }
	 }
	 
	 public void CheckBorder() {
		 if(position.x > 1100) {
	        	position.x -= 10;
	        } else if (position.x <= 20) {
	        	position.x += 10;
	        }
	 }
	 
}
