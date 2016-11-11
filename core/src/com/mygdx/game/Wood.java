package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class Wood {
	 
	 public static boolean Turn = true;
	 public static final int Move = 4;
	 public static int distance = 0; 
	 private Vector2 position;
	 private World world;
	 
	 public Wood(int x, int y, World world) {
		 position = new Vector2(x,y);
	     this.world = world;	
	 }
	 
	 public void update() {
		 if(Turn) {
			 position.x -= Move;
			 distance -= Move;
		 }else {
			 position.x += Move;
			 distance +=Move ;		
		 }
		 if(position.x >= 1000) {
			 Turn = true;
		 } else if(position.x <= 200) {
			 Turn = false;
		 }
		 
	 }
	 
	 public Vector2 getPosition() {
	        return position;    
	 }

}
