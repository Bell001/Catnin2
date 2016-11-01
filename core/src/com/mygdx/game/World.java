package com.mygdx.game;

public class World {
	private Cat cat;
    private CatNin catNin;
    private Maze maze;
    private int score;
 
    World(CatNin catNin) {
    	maze = new Maze();      
        this.catNin = catNin;
        score = 0;     
        cat = new Cat(100,100,this);
        
    }
    
    
    Cat getCat() {
        return cat;
    }
    
    public void update(float delta) {
        cat.update();
    }
    
    Maze getMaze() {
        return maze;
    }
    
    public void increaseScore() {
        score += 1;
    }

    public int getScore() {
        return score;
    }
}
