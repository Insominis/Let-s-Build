package com.tutorial.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {
	
	/**Runnable interface...**/

	/** Game is made as a follow along lesson from 
	 * "Java Programming: Let's Build a Game" from RealTutsGML on February 13, 2017 to go over how
	 * to build a simple game in Java. I did modify it as I wanted to customize a few things**/
	
	private static final long serialVersionUID = 1550691097823471818L;
	
	private Handler handler;
	//initializes Handler
	
	private HUD hud;
	//initializes HUD
	
	private Spawn spawner;
	private Random r = new Random();

	public static final int width = 640, height = width / 12 * 9;
	private Thread thread;

	/** A thread is an independent path of execution within a program. 
	 * Many threads can run concurrently within a program. Every thread in Java is created and controlled by the java.lang.Thread class.
	 */
	
	private boolean running = false;
	
	/** Dimensions to create a 16:9 aspect ratio **/
	
	public Game() {
	/**Creates a new window with width and height variable listed above with the title "NEW GAME""**/
		handler = new Handler(); //Create the handler class first because code is compiled top to bottom
		this.addKeyListener(new KeyInput(handler)); //ASCI key listener
		
		hud = new HUD();
		//instantiates the HUD object
		spawner = new Spawn(handler, hud);
		
		new window(width, height, "New Game", this);
		
		handler.addObject (new Player(width/2-32, height/2-32, ID.Player, handler)); //adds player object at x,y
		handler.addObject(new Enemy(r.nextInt(Game.width), r.nextInt(Game.height), ID.Enemy, handler));
		//System.out.println("The player id is..." +ID.Player); //figuring out what the player ID is 
		
	/** this refers to this instance of our Game class **/
	}

	
	public synchronized void start() {
		thread = new Thread (this);
		thread.start();
		running = true;
		
		/** Not sure what Synchronization does...
		 * this method starts the thread and sets the boolean variable running to true**/
	}
	
	public synchronized void stop() {
		try {
			thread.join();
			
			/** thread.join is stopping the thread **/
			
			running = false;
		}catch (Exception e) {
			e.printStackTrace();
			
			/** run an error bug in the console**/
		}
	}
	
	public void run() {
		this.requestFocus();
		//this makes sure we don't need to click on the screen to have keyboard control
		
		/** This is for the game loop. Look into it later... LOOK UP! 
		 *  Code is copy pasta'd as a popular game loop**/
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >=1) {
				tick();
				delta--;
			}
			if (running)
				render();
			frames++;
			
			if(System.currentTimeMillis() - timer >1000){
				timer += 1000;
				//System.out.println("FPS: " + frames); //prints out FPS
				frames= 0;
				}
		}
		stop();
	}
	
	private void tick() {
	
		handler.tick();
		hud.tick();
		spawner.tick();
	}
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(2);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.setColor(gold);
		/**sets the color to gold for the graphics variable**/
		
		g.fillRect(0, 0, width, height);
		
		/**makes a big ass rectangle the size of the screen**/
		
		handler.render(g);
		
		//renders all the objects
		
		hud.render(g);
		
		//puts the hud ontop of the objects since its top down programming
		
		g.dispose();
		
		/**trashes it? LOOK UP**/
		
		bs.show();
		
		/** shows the graphic **/
	}
	
	Color gold=new Color(255,215,0);
	/**constructor for gold color**/
	
	public static int clamp (int var, int min, int max) {
		if (var >= max)
			return var = max;
		else if (var <=min)
			return var = min;
		else
			return var;
		/**clamp function that provides the boundary for the game, if the variable entered is greater than the max, then that becomes the max. Same logic
		 * with the minimum value. Else it just returns the variables if it doesn't fit within those parameters
		 */
	}

	public static void main (String args[]) {
		
		new Game();
	}
}
