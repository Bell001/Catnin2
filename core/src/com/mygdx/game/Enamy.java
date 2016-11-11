package com.mygdx.game;

import java.util.LinkedList;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Cat.DotEattenListener;

public class Enamy {
	
	 private Vector2 position;
	 private World world;
	 private Maze maze;
	 public static boolean Haveenamy = false;
	 public static boolean A = true;
	 
	 public Enamy(int x, int y, World world) {
	        position = new Vector2(x,y);
	        this.maze = maze;
	        this.world = world;	       
	 }  
	 
	 public void update() {
		 if(position.y<=760) {
	       position.y += 5;
		 } else if(position.x >= 40 && A){
		   position.x -= 10; 
		 } else {
		   position.x += 10;  
		   A = false;
		 }
		 if(position.x >= 1150){
			 A = true;
		 }
		 Haveenamy = true;
	 }
	 
	 public Vector2 getPosition() {
	        return position;    
	 }
	 
	 public boolean checkhaveenamy() {
		 return Haveenamy;
	 }

}
