package com.mygdx.game; 

public class Maze {
	private String[] MAP = new String [] {
            "CUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUC",
            "L..........................................................R",
            "L..........................................................R",
            "L..........................................................R",
            "L..........................................................R",
            "L..........................................................R",
            "L..........................................................R",
            "L..........................................................R",
            "L..........................................................R",
            "L..........................................................R",
            "L..........................................................R",
            "L..........................................................R",
            "L..........................................................R",
            "L..........................................................R",
            "L..........................................................R",
            "L..........................................................R",
            "L..........................................................R",
            "L..........................................................R",
            "L..........................................................R",
            "L..........................................................R",
            "L..........................................................R",
            "L..........................................................R",
            "L..........................................................R",
            "L..........................................................R",
            "L..........................................................R",
            "L..........................................................R",
            "L..........................................................R",
            "L..........................................................R",
            "L..........................................................R",
            "L..........................................................R",
            "L..........................................................R",
            "L..........................................................R",
            "L..........................................................R",
            "L..........................................................R",
            "L..........................................................R",
            "L..........................................................R",
            "L..........................................................R",
            "L..........................................................R",
            "L..........................................................R",
            "CDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDC"
    };
	private int height;
    private int width;
    private boolean [][] hasSpace;
 
    public Maze() {
        height = MAP.length;
        width = MAP[0].length();
        initDotData();
    }
    
    private void initDotData() {
        hasSpace = new boolean[height][width];
        for(int r = 0; r < height; r++) {
            for(int c = 0; c < width; c++) {
                hasSpace[r][c] = MAP[r].charAt(c) == '.';
            }
        }
    }
 
    public int getHeight() {
        return height;
    }
 
    public int getWidth() {
        return width;
    }
    
    public boolean ShadowAtRight(int r, int c) {
        return MAP[r].charAt(c) == 'R';
    }
    public boolean ShadowAtLeft(int r, int c) {
        return MAP[r].charAt(c) == 'L';
    }  
    public boolean ShadowAtCorner(int r, int c) {
        return MAP[r].charAt(c) == 'C';
    }
    public boolean ShadowAtUp(int r, int c) {
        return MAP[r].charAt(c) == 'U';
    }
    public boolean ShadowAtDown(int r, int c) {
        return MAP[r].charAt(c) == 'D';
    }
 
    public boolean hasSpaceAt(int r, int c) {
    	return hasSpace[r][c];
    }
    
    public void removeItem1At(int r, int c) {
        hasSpace[r][c] = false;
    }
    
    public boolean Item1(int r, int c) {
        return MAP[r].charAt(c) == '-';
    }
 

}
