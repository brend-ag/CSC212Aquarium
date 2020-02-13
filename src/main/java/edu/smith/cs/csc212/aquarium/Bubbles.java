package edu.smith.cs.csc212.aquarium;
import java.util.Random;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.concurrent.TimeUnit;

//import java.util.concurrent.ThreadLocalRandom;

public class Bubbles {
	int x; // do btwn 300 and 480
	int y;
	Random rand = new Random();
	double size; 
	int destBX;
	int destBY;

	public Bubbles(int x, int y, double size) {
		this.x = x;
		this.y = y;
		this.size = size; 
		///this.size = rand.nextInt(15);
		this.destBX = 400;
		this.destBY = 15;
	}
	
	public void floatUp(){
		if(this.x >=300 && this.x<=480) {
			//while(true) {
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
		  // }		
	   }	
	}
	public void wiggle() {
		if(this.y>this.destBY) {
			this.y-=1;
//			while(true) {
//				this.y-=1;
//				try {
//					//this.y-=5;
//					TimeUnit.SECONDS.sleep(1);
//					
//				}
//				catch(InterruptedException ex) {
//					Thread.currentThread().interrupt();
//				}
//			}
		}
		if(this.y < destBY) {
			this.y = 530;
		}
	
	}
	
	public void chest(Graphics2D g) {
		Graphics2D c = (Graphics2D)g; 
		
		c.setColor(Color.black);
		c.fillRect(360, 460, 100, 50);
		c.drawRect(360, 460, 100, 50); //x,y,width, height
		
		
	}
	//code borrowed from https://stackoverflow.com/questions/2509561/how-to-draw-a-filled-circle-in-java
	//and https://stackoverflow.com/questions/4166066/java-awt-draw-circle-border
	public void paintComponent(Graphics2D g) {
		//   super.paintComponent(g);
		   Graphics2D g2d = (Graphics2D)g;
		   // Assume x, y, and diameter are instance variables.
		   Shape circle = new Ellipse2D.Double(this.x, this.y, 40, 40);
		   g.setColor(Color.cyan);
		   g2d.fill(circle);
		   g.setColor(Color.black);
		   Ellipse2D.Double circleBorder = new Ellipse2D.Double(x, y, 40, 40);
		   g2d.draw(circleBorder);
	}
	public void draw(Graphics2D g) {
		this.paintComponent(g);
		this.chest(g);
		
	}
}
////////////////////////////////
/*
 * NEXT STEPSSSSSSSSSSSs
 * find out how to vary the bubble sizes (by a bit) bc
 *  obv my size thing isn't doing anything bc i didn
 * 't tell it to do anything
 * boo */
