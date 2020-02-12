package edu.smith.cs.csc212.aquarium;
import java.util.Random;
import java.awt.Color;
//import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.concurrent.TimeUnit;

//import java.util.concurrent.ThreadLocalRandom;

public class Bubbles {
	int x; // do btwn 300 and 480
	int y;
	Random rand = new Random();
	int size; 
	int destBX;
	int destBY;

	public Bubbles(int x, int y, int size) {
		this.x = x;
		//this.x = rand.nextInt((300-480)+1)+ 300; //x/y has to be in a certain range! :)
			//add 1 to make it inclusive bc exclusive of the top value
		this.y = y;
		//this.y = 480; 
		//will it be mad if i hard code it like that?
		//int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
		this.size = size; 
		///this.size = rand.nextInt(15);
		this.destBX = 400;
		this.destBY = 15;
	}
	
	public void floatUp(){
		if(this.x >=300 && this.x<=480) {
			while(true) {
				try {
					this.x+=2;
					TimeUnit.SECONDS.sleep(1);
					this.x-=2;
				}
				catch(InterruptedException ex) {
					Thread.currentThread().interrupt();
				}
//				try {
//					this.x+=2;
//					Thread.sleep(500);
//					this.x-=2;
//				}
//				catch(InterruptedException ex) {
//					Thread.currentThread().interrupt();
//				}
			}		
		 }	
	}
	public void wiggle() {
		if(this.y>this.destBY) {
			this.y-=1;
		}
	
	}
//	public void circDraw(Graphics2D g) {
//		Shape circle = new Ellipse2D.Double(this.x - 20, this.y - 20, 40, 40);
//		g.setColor(Color.white);
//		g.fill((Shape) Color.cyan);
//			//lol java fixed this like that and we gonna trust it
//		g.draw(circle);
//		
//	}
	//code borrowed from https://stackoverflow.com/questions/2509561/how-to-draw-a-filled-circle-in-java
	public void paintComponent(Graphics2D g) {
		//   super.paintComponent(g);
		   Graphics2D g2d = (Graphics2D)g;
		   // Assume x, y, and diameter are instance variables.
		   Shape circle = new Ellipse2D.Double(this.x - 20, this.y - 20, 40, 40);
		   g.setColor(Color.cyan);
		   g2d.fill(circle);
	}
	public void draw(Graphics2D g) {
		this.paintComponent(g);
	}
}
////////////////////////////////
/*
 * NEXT STEPSSSSSSSSSSSs
 * find out how to put the outline for the bubbles
 * find out how to vary the bubble sizes (by a bit) bc
 *  obv my size thing isn't doing anything bc i didn
 * 't tell it to do anything
 * boo */
