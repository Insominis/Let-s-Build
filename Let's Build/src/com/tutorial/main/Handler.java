package com.tutorial.main;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	/** Handler class is going to maintain, update and render all the objects in
	 * the room since we are going to have more than one object in the game.
	 * 
	 * We need to create a linked list of the GameObjects we have in this game.
	 * 
	 * LinkedList is a disjointed data structure meaning that if we have a list of numbers for instance, the memory manager allocates blocks of information
	 * the data (value) and the address of the next block in a memory sequence. Arrays stores memory in sequence and must allocate memory ahead of time, as 
	 * arrays gets bigger, you would run out of memory and have to copy everything over to a bigger array which is inefficient.
	 * 
	 * Unlike an array in which you can access any element in constant time, a LinkedlList would have to sequentially go through the head node to the find the
	 * address of the next node in the LinkedList.
	 * 
	 * The LinkedList in the handler creates an ever expanding list of objects in the game.
	 * **/

	LinkedList <GameObject> object = new LinkedList <GameObject>();
	
	/**creates new LinkedList **/
	
	public void tick() {
		for (int i=0; i< object.size(); i++) {
			
		/** loop that checks how many objects are on the screen and compares**/	
		
		GameObject tempObject = object.get(i);
		
		
		/** gets the ID of what object is currently in the loop **/
		
		tempObject.tick();
		
		/**calls the method for tick**/
			
		}
	}
	
	public void render(Graphics g){
		for (int i=0; i< object.size(); i++) {
			
			/** loop that checks how many objects are on the screen comparing it to the number of objects**/
			
			GameObject tempObject = object.get(i);
			
			/**gets the id of what object is currently in the loop**/
		
			tempObject.render(g);
			
			/**calls the method to render the objects as it goes through the loop **/
		}
	}
		
	public void addObject (GameObject object){
		this.object.add(object);
		
		/** this adds the object based off the ID **/
	}
	
	public void removeObject (GameObject object) {
		this.object.remove(object);
		
		/** this removes the object based off the ID **/
		
	}
	
}
