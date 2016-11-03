package com.mygdx.game;

public class World {
	private Cat cat;
    private CatNin catNin;
    private Enamy enamy;
    private Enamy enamy1;
    private Maze maze;
    private int score;
 
    World(CatNin catNin) {
    	maze = new Maze();      
        this.catNin = catNin;
        score = 0;     
        cat = new Cat(562,135,this);
        enamy = new Enamy(350,200,this);
        
    }
    
    Enamy getEnamy() {
    	return enamy;
    }
    
    Cat getCat() {
        return cat;
    }
    
    public void update(float delta) {
        cat.update();
        enamy.update();
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
