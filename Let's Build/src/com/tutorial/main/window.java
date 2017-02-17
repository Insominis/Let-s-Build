package com.tutorial.main;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class window extends Canvas{
	
	private static final long serialVersionID = -240840600533728354L;

	public window (int width, int height, String title, Game game) {
		JFrame frame = new JFrame(title); 
		/** creates new windows **/
		
		frame.setPreferredSize (new Dimension (width, height));
		frame.setMaximumSize (new Dimension(width, height));
		frame.setMinimumSize (new Dimension(width,height));
		
		/**sets the frame size (preferred, maximum and minimum size with our new dimension variable width and height**/
		
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		
		/** X button in the java frame **/
		
		frame.setResizable(false);
	
		/** Can we resize our window? **/
		
		frame.setLocationRelativeTo(null);
		
		/** Starts the window in the middle of the screen =**/
		
		frame.add(game);
		
		/** adds the game class to the frame **/
		frame.setVisible(true);
		
		/** makes frame visible **/
		game.start();
		
		/**starts the game**/
	}
	
	
 }
