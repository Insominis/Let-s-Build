package com.tutorial.main;

import java.awt.Graphics;
import java.awt.Rectangle;


/** This is an abstract class. Abstract classes encapsulate the elements and properties of a type of object. 
 * 
 * Class describes the name/type of object, attributes/properties and its behavior/operations. A method is a function
 * that belongs to a class
 * 
 * APIE (Abstraction, Polymorphism, Inheritance, Encapsulation)
 * 
 * By definition,
 * 
 * Abstraction is a process of hiding the implementation details and showing only functionality to the user. Example:
 * You understand what a table is. The properties that are associated with the tables without talking about the specifics
 * about what the table is.
 * 
 * Polymorphism describes the many different forms. Example: the plus form that is able to add numerically 1+2=3 but also
 * the plus form that concatenates a+b=ab as a string in certain languages. Polymorphism along with inheritance enables
 * object oriented programming. For example, a bank account would be the abstract class that can become investment accounts,
 * investment accounts and saving accounts. 
 * We can override properties but we will have a base inheritance of properties
 * 
 * Inheritance describes the properties passed on from the existing class. For example, a person class. If we want to make
 * a customer. We can inherit from the person class with the exception of one more property (customerNumber) for example.
 * A sub class (child class) will inherit from a super class (parent class)
 * 
 * Encapsulation describes surrounding something. Taking the attributes and properties of an object and bundling it 
 * into a unit. An object should not reveal everything about itself without except what is absolutely necessary.
 * 
 * "Black boxing" - interaction with telephone (I want to know how to use a telephone but not all thhe interworkings
 * of a telephone). This helps reduce dependency throughout the class
 * 
 *  * Everything (from players, enemies, coins, etc.) will be considered GameObject and will inherit all the functions 
 * and properties etc. from this GameObject class 
 * **/

public abstract class GameObject {

	protected int x,y;
	/** "protected" means it can only be accessed by which object inherits the GameObject. 
	 * For example, if you created a player class and extended the GameObject class, you can use the x variable or y
	 * variable from here without it error-ing. Everything is inherited from this GameObject class.
	 *  **/
	
	
	/** We need a way to ID what a player, what an enemy is, etc.?
	 * We created ID enum for this 
	 * **/
	
	protected ID id;
	protected int velX, velY;
	
	public GameObject(int x, int y, ID id) {
		this.x= x;
		this.y=y;
		this.id=id;
		
	/**assigns whatever instance of x,y,id to the instance of the object itself
	 * **/
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	
	//in the rectangle class JRE, if two rectangles intercept each other, it will return true. This is the basics of masking.
	
	/** basic getters and setter methods are by providing an easy way to change x and y methods. This will refer
	 * this instance and the inheritance that comes with it. **/
	public void setX(int x ){
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setId (ID id) {
		this.id = id;
	}
	public ID getId() {
		return id;
	}
	public void setvelX (int velX) {
		this.velX=velX;
	}
	public int getvelX () {
		return velX;
	}
	public void setvelY (int velY) {
		this.velY=velY;
	}
	public int getvelY () {
		return velY;
	}
	
}
