package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Enemy extends GameObject{

	private Handler handler; 
	//private String shape;
	
	public Enemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler=handler;
		//if you want enemy to have initial movement
		//velX = 5;
		//velY = 5;
	}


	public void tick() {
		x += velX;
		y += velY;
		//if you want enemy to have movement
		//if (y <= 0 || y >= Game.height - 32) velY *= -1;
		//if (x <= 0 || x >= Game.width - 32) velX *= -1;
		//enemy trail
		//handler.addObject(new Trail (x, y, ID.Trail,Color.red, 16, 16, 0.02f, handler, "R"));
		collision();
	}
	
	private void collision() {
		for (int i = 0; i< handler.object.size(); i++) {
			
			GameObject tempObject = handler.object.get(i);
			//creating a tempObject that gets each instance of the for loop
			
			if (tempObject.getId() ==ID.Player) {
			//if its the basic enemy (temp object is now enemy	
				if(getBounds().intersects(tempObject.getBounds())) {
					handler.removeObject(this);	
				}
			}
		}
	}

	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x,y,16,16);
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x,y,16,16);
		//collision masks
		
	}
	

}
