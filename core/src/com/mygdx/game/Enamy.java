package com.mygdx.game;

import java.util.LinkedList;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Cat.DotEattenListener;

public class Enamy {
	 
	 double[] enamy_in_class = {0,0,0,0,0,0,0,0,0,0};
	 public static Vector2[] pos_E = new Vector2[10];
	 private World world;
	 private Maze maze;
	 public static boolean Haveenamy = false;
	 public static boolean[] A = {true,true,true,true,true,true,true,true,true,true};
	 
	 public Enamy(World world) {
		    Vector2[] pos_E = new Vector2[10];
		    for(int i=0;i<10;i++) {
	        	if(i%2 == 0) {
	        	    pos_E[i] = new Vector2(350,400);
	        	} else {
	        		pos_E[i] = new Vector2(700,200);
	        	}
	        }  
	        this.maze = maze;
	        this.world = world;	 
	 }  
	 
	 public void update() {
		 double X,Y;
		 checkenamy_world();
		 for(int j=0;j<10;j++) {
			 if(enamy_in_class[j] != 0) {
				 if(pos_E[j].y <= 760) {
					 pos_E[j].y += 5;
				 } else if(pos_E[j].x >= 40 && A[j]){
					 pos_E[j].x -= 5; 
				 } else {
					 pos_E[j].x += 5;  
					 A[j] = false;
				 }
				 if(pos_E[j].x >= 1150){
					 A[j] = true;
				 }
				 Haveenamy = true;
			 }		 
		 }
	 }
	 
	 public Vector2 getPosition(int j) {
		    Vector2 posN = new Vector2(0,0);

		    if(world.Check_E[j] == true){
		    	return pos_E[j];    
		    } else {
		    	return posN;
		    }
	 }
	 
	 public boolean checkhaveenamy() {
		 return Haveenamy;
	 }
	 
	 public void Reverse_E(int j) {
		 if(enamy_in_class[j] == 0) {
		        	if(j%2 == 0) {
		        		pos_E[j] = new Vector2(350,500);
		        	} else {
		        		pos_E[j] = new Vector2(700,500);
		        	}
		 }
	 }
	 
	 public void Remove_E(int i) {
		 enamy_in_class[i] = 0;
	 }
	 
	 public void checkenamy_world() {
		for(int h=0;h<10;h++) {
			if(world.Check_E[h]){
				 enamy_in_class[h] = 1;
			}
		}	
	 }
	 

}
