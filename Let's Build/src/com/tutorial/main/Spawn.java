package com.tutorial.main;

import java.util.Random;

public class Spawn {
	
	private Handler handler;
	private HUD hud;
	private Random r = new Random();
	
	private int scorekeep = 0;

	public Spawn (Handler handler, HUD hud) {
	this.handler = handler; 	
	this.hud= hud;
	}
	
	public void tick() {
		
		if (HUD.hp==100) {
			HUD.hp=0;
			HUD.level +=1;
		}
	}
}
	
