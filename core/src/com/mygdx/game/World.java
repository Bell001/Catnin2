package com.mygdx.game;

public class World {
	private Cat cat;
    private CatNin catNin;
    private WorldRenderer worldRenderer;
    private Enamy[] enamy = new Enamy[10];
    private Wood wood;
    private Maze maze;
    private int score;
 
    World(CatNin catNin) {
    	maze = new Maze();      
        this.catNin = catNin;
        score = 0;     
        cat = new Cat(562,135,this);
        for(int i=0;i<10;i++) {
        	if(i%2 == 0) {
        		enamy[i] = new Enamy(350,200,this);
        	} else {
        		enamy[i] = new Enamy(700,200,this);
        	}
        }
      
        wood = new Wood(450,400,this);
        
    }
    
    Wood getWood() {
    	return wood;
    }
    
    Enamy getEnamy(int i) {
    	return enamy[i];
    }
    
    public void Reset_E(int i) {
    	if(enamy[i] == null) {
    		  for(int j=0;j<10;j++) {
    	        	if(i%2 == 0) {
    	        		enamy[j] = new Enamy(350,200,this);
    	        	} else {
    	        		enamy[j] = new Enamy(700,200,this);
    	        	}
    	        }
    	      
    	}
    }
    
    public void Remove_E(int i) {
    	enamy[i] = null;
    }
    
    Cat getCat() {
        return cat;
    }
    
    public void update(float delta) {
    	wood.update();   
        for(int i=0;i<10;i++) {
            if(worldRenderer.Check_E[i] && (enamy[i] != null)) {	
               enamy[i].update();
            }
        }
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
