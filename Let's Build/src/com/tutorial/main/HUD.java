package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	
	public static int hp = 99;
	public static int score = 0;
	public static int level = 1;
	
	public void tick() {
		hp = Game.clamp (hp,0,100);
		
		//sets limits on the hp bar between 0-100
		
	}
	
	public void render (Graphics g) {
		g.setColor(Color.gray);
		g.fillRect (15, 15, 200, 32);
		//fill the gray behind the hp bar
		g.setColor(Color.green);
		g.fillRect (15, 15, hp * 2, 32);
		//fill the green rectangle in the hp bar
		g.setColor(Color.black);
		g.drawRect (15, 15, 200, 32);
		//draws the black border
		
		g.drawString("Score: "  + score, 15, 64);
		g.drawString("Level:  " + level, 15, 80);
	}
	
//getters and setters
	public void score (int score) {
		this.score = score;
	}

	public int getScore() {
		return score;
	}
	
	public void level (int level) {
		this.level = level;
	}
	
	public int getLevel() {
		return level;	
	}
}

