package com.tutorial.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

//**LOOK UP what these libraries do**/


public class KeyInput extends KeyAdapter{

	private Handler handler;
//**instance of handler class**/
	
	private Random r = new Random(); 
	public KeyInput(Handler handler){
		this.handler=handler;
	}
	
	public synchronized void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
	
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if (tempObject.getId() == ID.Player) {
				//key events for player class
				
				if (key == KeyEvent.VK_W) tempObject.setvelY(-10);
				if (key == KeyEvent.VK_S) tempObject.setvelY(10);
				if (key == KeyEvent.VK_D) tempObject.setvelX(10);
				if (key == KeyEvent.VK_A) tempObject.setvelX(-10);
			}
		}
		
		if (key == KeyEvent.VK_ESCAPE) System.exit(1);
		if (key == KeyEvent.VK_SPACE) handler.addObject(new Enemy(r.nextInt(Game.width), r.nextInt(Game.height), ID.Enemy, handler));

		
		//hitting escape will end thhe game
	}
	
	public synchronized void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if (tempObject.getId() == ID.Player) {
				//key events for player class
				
				if (key == KeyEvent.VK_W) tempObject.setvelY(0);
				if (key == KeyEvent.VK_S) tempObject.setvelY(0);
				if (key == KeyEvent.VK_D) tempObject.setvelX(0);
				if (key == KeyEvent.VK_A) tempObject.setvelX(0);
			}
		}
	}
	
}
