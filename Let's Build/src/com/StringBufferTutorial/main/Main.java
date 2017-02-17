package com.StringBufferTutorial.main;

public class Main {

	public static void main (String args[]) {
		StringBuffer buffer = new StringBuffer(" A string is an array.");
		System.out.println("Protip" +buffer);
		buffer.setCharAt(0, ':');
		System.out.println("Protip" +buffer);
		
		/** StringBuffer class is an abstract class pre built into java with defined functions and methods to change the string at will **/
	}
}
