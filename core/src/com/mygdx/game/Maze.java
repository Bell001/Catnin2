package com.mygdx.game; 

public class Maze {
	 
	String[] MAP_Base = new String [] {
	
            "BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB",
            "B..........................................................B",
            "B..........................................................B",
            "B..........................................................B",
            "B..........................................................B",
            "B..........................................................B",
            "B..........................................................B",
            "B..........................................................B",
            "B..........................................................B",
            "B..........................................................B",
            "B..........................................................B",
            "B..........................................................B",
            "B..........................................................B",
            "B..........................................................B",
            "B..........................................................B",
            "B..........................................................B",
            "B....................----------------......................B",
            "B..........................................................B",
            "B..........................................................B",       
            "B..........................................................B",
            "B..........................................................B",
            "B..........................................................B",
            "B..........................................................B",
            "B..........................................................B",
            "B..........................................................B",
            "B..........................................................B",
            "B..........................................................B",
            "B..........................................................B",
            "B..........................................................B",
            "B..........................................................B",
            "B..........................................................B",
            "B..........................................................B",
            "B..........................................................B",
            "B..........................................................B",
            "B..........................................................B",
            "B..........................................................B",
            "B..........................................................B",
            "B..........................................................B",
            "B..........................................................B",       
            "BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB"          
    
    };
	
	String[] MAP_Item = new String [] {
			
            "BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB",
            "B..........................................................B",
            "B..........................................................B",
            "B..........................................................B",
            "B..........................................................B",
            "B..........................................................B",
            "B..........................................................B",
            "B..........................................................B",
            "B..........................................................B",
            "B..........................................................B",
            "B..........................................................B",
            "B..........................................................B",
            "B..........................................................B",
            "B............................>>............................B",
            "B..........................................................B",
            "B........>........................................>........B",
            "B..........................................................B",
            "B..........................................................B",
            "B........--......................................--........B",       
            "B.......-..-....................................-..-.......B",
            "B......-....-..................................-....-......B",
            "B..........................................................B",
            "B..........................................................B",
            "B..........................................................B",
            "B...........-------.....................------.............B",
            "B..........................................................B",
            "B..........................................................B",
            "B..........................................................B",
            "B..........................----............................B",
            "B........---....................................---........B",
            "B..........................................................B",
            "B.>......................................................>.B",
            "B-----......................--........................-----B",
            "B...........................--.............................B",
            "B.......................----------.........................B",
            "B..........................................................B",
            "B..........................................................B",
            "B..........................................................B",
            "B..........................................................B",       
            "BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB"          
    
    };
	
	String[] MAP = MAP_Base;
	
	private int height;
    private int width;
    private World world;
    private Cat cat;
    private boolean [][] hasItem;
	boolean OUTBOX = false;
 
    public Maze() {
        height = MAP.length;
        width = MAP[0].length();
        collectItemData();
    }
    
    private void collectItemData() {
        hasItem = new boolean[height][width];
        for(int r = 0; r < height; r++) {
            for(int c = 0; c < width; c++) {
                hasItem[r][c] = MAP[r].charAt(c) == '>';
            }
        }
    }
 
    public int getHeight() {
        return height;
    }
 
    public int getWidth() {
        return width;
    }
    
    public boolean Border(int r, int c) {
        return MAP[r].charAt(c) == 'B';
    }
 
    public boolean hasItemAt(int r, int c) {
    	return hasItem[r][c];
    }
    
    public void removeItem1At(int r, int c) {
        hasItem[r][c] = false;
    }
    
    public boolean hasBlockAt(int r, int c) {
           return MAP[r].charAt(c) == '-';
    }
    
    public boolean hasFishAt(int r, int c) {
    	return MAP[r].charAt(c) == 'F';
    }
    
    public void change_mazeB() {
    	MAP = MAP_Item;
    }
    
    public void change_mazeA() {
    	MAP = MAP_Base;
    }
    
    
}
