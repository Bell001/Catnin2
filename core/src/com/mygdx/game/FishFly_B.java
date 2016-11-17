package com.mygdx.game;

import java.util.LinkedList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Cat.DotEattenListener;

public class FishFly_B {

	 private Vector2 position;
	 boolean Point = true;
	 private World world;
	 private Object maze;	
	 private CatNin catNin;
	 public  SpriteBatch batch;
	 private Vector2 base_position = new Vector2(1000,500);
	 private Vector2 base_position2 = new Vector2(1000,600);
	
	 public FishFly_B(int x, int y, World world) {		 
	        position = new Vector2(x,y);
	        this.world = world;
	        this.maze = maze;   
	 }  
	 
	 public void update1() {
		 if(position.x > 50) {
		     position.x -= 5;
		 } else {
			 Point = false;	 
		 }
	 }
	 
	 public Vector2 getPosition() {
	        return position;    
	 }
	 
	 public void setpos1() {
		  position.x = base_position.x;
		  position.y = base_position.y;
		  Point = true;
	 }	 
	 
	 
}
