package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class Item {
	
	private Vector2 position;
    private World world;
    public boolean haveitem = false;
    
    public Item(World world){
    	 int i = (int)(Math.random()*1000)%1000;
    	 if(i >= 110 && i <=760) {
    	    position = new Vector2(1160, i);
    	    haveitem = true;
    	 }  	
    }
    
    public Vector2 getPosition() {
    	return position;
    }
    
    public void update() {
        this.position = position;
        if(haveitem) {
         	position.x -= 3;
         	if(position.x < 10) {
    	    	position.x = 1160;
    	    }
        }
    }
    
    public void removeitem() {
    	haveitem = false;
    }
    
    public boolean checkitem() {
    	return haveitem;
    }
}
