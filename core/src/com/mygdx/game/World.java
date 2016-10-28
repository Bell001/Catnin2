package com.mygdx.game;

public class World {
	private Cat cat;
    private CatNin catNin;
    private Maze maze;
 
    World(CatNin catNin) {
        this.catNin = catNin;
        cat = new Cat(60,60,maze);
        maze = new Maze();
    }
        
    Maze getMaze() {
        return maze;
    }
    
    Cat getCat() {
        return cat;
    }
    
    public void update(float delta) {
        cat.update();
    }
}
