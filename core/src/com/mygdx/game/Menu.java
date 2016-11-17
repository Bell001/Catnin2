package com.mygdx.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Menu {
	
	public Rectangle playButton = new Rectangle(CatNin.WIDTH/2 + 120, 150, 100, 50);
	public Rectangle helpButton = new Rectangle(CatNin.WIDTH/2 + 120, 250, 100, 50);
	public Rectangle quitButton = new Rectangle(CatNin.WIDTH/2 + 120, 350, 100, 50);
	
	public void render(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		
		Font font0 = new Font("arial",Font.BOLD,50);
		g.setFont(font0);
		g.setColor(Color.white);
		g.drawString("SPACE GAME", CatNin.HEIGHT/2, 10);
		
		Font fon0 = new Font("arial", Font.BOLD, 30);
		g.setFont(font0);
		g.drawString("Play", playButton.x + 19, playButton.y + 30);
		g2d.draw(playButton);
		g.drawString("Help", playButton.x + 19, playButton.y + 30);
		g2d.draw(helpButton);
		g.drawString("Quit", playButton.x + 19, playButton.y + 30);
		g2d.draw(quitButton);
		
	}

}
