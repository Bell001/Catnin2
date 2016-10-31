package com.mygdx.game;

public class World {
	private Cat cat;
    private CatNin catNin;
    private Maze maze;
 
    World(CatNin catNin) {
    	maze = new Maze();
        cat = new Cat(100,100,maze);
        this.catNin = catNin;
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
}
