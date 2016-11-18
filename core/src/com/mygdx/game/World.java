package com.mygdx.game;

//import com.mygdx.game.GameScreen.STATE;

public class World {
	public static int RANDOM = 0;
	public static int HpCat = 3;
	public static boolean Check_E[] = {false,false,false,false,false,false,false,false,false,false};
	private Cat cat;
    private CatNin catNin;
    boolean gameover = false;
    private WorldRenderer worldRenderer;
    private Enamy enamy;
    private Item_Fish item_Fish;
    private Wood wood;
    private Wood wood2;
    private Maze maze;
    private GameScreen gamescreen;
    private FishFly_B fishFly_B;
    int score;
 
    World(CatNin catNin) {
        this.catNin = catNin;
        this.gamescreen = gamescreen;
        score = 0; 
    	maze = new Maze();      
    	fishFly_B = new FishFly_B(1000,500,this);
        cat = new Cat(562,135,this);
        enamy = new Enamy(this);
        wood = new Wood(450,400,this);
        wood2 = new Wood(700,600,this);
        item_Fish = new Item_Fish(500,600,this);     
    }
    
    Wood getWood() {
    	return wood;
    }
    
    
    Wood getWood2() {
    	return wood2;
    }
    
    FishFly_B getflyfish() {
        return fishFly_B;
    }
    
  
    
    Enamy getEnamy() {
    	return enamy;
    }
    
    Maze getMaze() {
        return maze;
    }
    
    Item_Fish getFish() {
    	return item_Fish;
    }

    
    Cat getCat() {
        return cat;
    }
    
    public void update(float delta) {
    	wood.update();  
    	wood2.update();
    	Add_E1();    
        enamy.update();
        fishFly_B.update1();
        cat.update();
    }
    
    
    public void increaseScore() {
        score += 1;
    }
    
    public void decreaseHp() {
    	HpCat -= 1;
    	if(HpCat == 0) {
    		gameover = true;
    		setOver();
    	}
    }
    
    public void increaseHp() {
    	HpCat += 1;
    }

    public int getScore() {
        return score;
    }
    
	public void Add_E1(){
		 int i = (int)(Math.random()*10)%10;
	     if(RANDOM > 200) {
	    	 Check_E[i] = true;
	    	 RANDOM =0;
	     }
		 ++RANDOM;
		 for(int j=0;j<10;j++) {
		    	if(Check_E[j] && (enamy.enamy_in_class[j] == 0)) {
		    		enamy.Reverse_E(j);
		    		worldRenderer.pos_E[j] = enamy.getPosition(j);
		    	}
		 }
	 }
	
	
	 public boolean setOver() {
	    	return gameover;
	 }
} 
