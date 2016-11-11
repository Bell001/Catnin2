package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class Item_Fish {
	
	 private World world;
	 private Vector2 position;
	
	 public Item_Fish(int x, int y, World world) {
		 position = new Vector2(x,y);
	     this.world = world;	
	 }
	 
	 public void update() {
		 
	 }
	 
     public Vector2 getPosition() {
       return position;    
     }

}
