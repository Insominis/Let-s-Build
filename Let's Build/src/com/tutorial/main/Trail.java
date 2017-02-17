package com.tutorial.main;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Trail extends GameObject{
	
	private float life;
	private float alpha = 1;
	private Handler handler;
	private Color color;
	private int height, width;
	private String shape;
	
	//life = 0.001 = 0.1;
	
	public Trail (int x,int y, ID id, Color color, int width, int height, float life, Handler handler, String shape) {
		super(x, y, id);
		this.color=color;
		this.width=width;
		this.height=height;
		this.life=life;
		this.handler=handler;
		this.shape=shape;
	}
	
	public void tick() {
		if (alpha>life) {
			alpha -= life -0.0001;
		}
		else handler.removeObject(this);
	}

	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		//Alpha composite only works with Graphics 2D
		g2d.setComposite(makeTransparent(alpha));
		g.setColor(color);
		if (shape == "R") {
		g.fillRect(x, y, 16, 16);
		} 
		if (shape == "O") {
		g.fillOval(x, y, 32, 32);
		}
		
		g2d.setComposite(makeTransparent(1));
	}
	
	private AlphaComposite makeTransparent (float alpha) {
		int type = AlphaComposite.SRC_OVER;
		return(AlphaComposite.getInstance(type,alpha));
	}

	public Rectangle getBounds() {
		return null;
	}
}
