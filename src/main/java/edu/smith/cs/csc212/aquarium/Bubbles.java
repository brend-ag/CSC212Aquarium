package edu.smith.cs.csc212.aquarium;
import java.util.Random;
import java.awt.Color;
//package edu.smith.cs.csc212.aquarium;
//import java.util.Random;
//import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

//import java.util.concurrent.ThreadLocalRandom;

public class Bubbles {
	int x; // do btwn 300 and 480
	int y;
	Random rand = new Random();
	double size; 
	int destBX;
	int destBY;
	int delay;
	int wiggle;

	public Bubbles(int x, int y) {
		this.x = x;
		this.y = y;
		//this.size = size; 
		///this.size = rand.nextInt(15);
		this.destBX = 400;
		this.destBY = -40;
		this.delay = 0;
		this.wiggle = 0;
	}
	
	public void floatUp(){
		//this.delay+=1;
		if(this.y>this.destBY) {
			this.y-=3;
			
		};
		if(this.y <= destBY) {
			this.y = 435;
		}
//		if(this.delay<100) {
//			this.delay=0;
//		}
		this.wiggle=(int)(30.0 * Math.sin(this.y/100.0));
			//while(true) {
				
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
	
	public void wiggle() {
			if(this.x >=300 && this.x<=480) {
//			while(true) {
//				this.y-=1;
				//this.x+=10;
			//	this.delay+=1;
				//Thread.sleep(500);
				//this.x-=10;
				
//				if(this.delay<100) {
//					this.delay=0;
//				}
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
		   Graphics2D g2d = g;
		 //  double circX = 10*(0.5)*(ThreadLocalRandom.current().nextInt(1,6 +1));
		 //  double circY = 10*(0.5)*(ThreadLocalRandom.current().nextInt(1,6 +1));
//		   int circW = ThreadLocalRandom.current().nextInt(10,30 +1);
//		   int circH = ThreadLocalRandom.current().nextInt(10,30 +1);
		   // Assume x, y, and diameter are instance variables.
		   Shape circle = new Ellipse2D.Double(this.x, this.y, 40, 40);
		   g.setColor(Color.cyan);
		   g2d.fill(circle);
		   g.setColor(Color.black);
		   Ellipse2D.Double circleBorder = new Ellipse2D.Double(x, y, 40, 40);
		   //think abt the W/H and how we can change that randomly w/o it freaking out bc draw is calledf 50 times a sec etc
		   g2d.draw(circleBorder);
	}
	public void draw(Graphics2D g) {
		this.paintComponent(g);
		this.chest(g);
		this.floatUp();
		this.wiggle();
		
	}
}
////////////////////////////////
/*
 * NEXT STEPSSSSSSSSSSSs
 * find out how to vary the bubble sizes (by a bit) bc my size thing
 *     isn't doing anything
 * move the bubbles up! not sure why not working :/ 
 * didn't implement the wiggle yet bc nothing is moving
 * figure out the random change in size thingggg
 * make sure the screen turns green etc
 * 
 *  */