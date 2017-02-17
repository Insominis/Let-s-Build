package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject{
	
	Handler handler;
	private String shape;
	private Random r = new Random();
	
	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		/**Super class inheritance
		 * **/
		this.handler = handler;
	}

	public synchronized void tick() {
		x += velX;
		y += velY;
		handler.addObject(new Trail (x, y, ID.Trail,Color.black, 32, 32, 0.1f, handler, "O"));
		x = Game.clamp(x,  0,  Game.width -38);
		y= Game.clamp(y, 0, Game.height -61);
		collision();
		
	}
	
	private void collision() {
		for (int i = 0; i< handler.object.size(); i++) {
			
			GameObject tempObject = handler.object.get(i);
			//creating a tempObject that gets each instance of the for loop
			
			if (tempObject.getId() ==ID.Enemy) {
			//if its the basic enemy (temp object is now enemy	
				if(getBounds().intersects(tempObject.getBounds())) {
					HUD.hp +=1;	
					HUD.score +=1;
					handler.addObject(new Enemy(r.nextInt(Game.width-38), r.nextInt(Game.height-61), ID.Enemy, handler));
					//if the masks collide then the hp goes down by 2
				}
			}
		}
	}

	public void render(Graphics g) {
		g.setColor(Color.black);
		g.fillOval (x,y,32,32);
	}
	
	public Rectangle getBounds() {
		return new Rectangle (x,y,32,32);
		
	}
}
