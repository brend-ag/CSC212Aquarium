package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Snail {
	public static int HEIGHT = 50; //how tall snail is
	private String direction; //The positioning of the snail. Use setSide(s) to change this.
	public int x; //The position of the Snail; x-coordinate.
	public int y; //position of snail, y-coord
	boolean isSleep;
	/**
	 * Create a snail at (sx, sy) with position s.
	 * 
	 * @param sx - x coordinate
	 * @param sy - y coordinate
	 * @param s  - the "positioning" of the Snail - ig he means orientation
	 */
	public Snail(int sx, int sy, String s, boolean isSleep) {
		this.setSide(s); //can be: "top," "bottom," "left," "right"
		this.x = sx;
		this.y = sy;
		this.isSleep = isSleep;
	}

	/**
	 * Change which side of the the snail thinks its on.
	 * @param s - one of "top", "bottom", "left" or "right".
	 */
	public void setSide(String s) {
		this.direction = s.toLowerCase();
	} 
	
	public void move() {
		String s = this.direction; //use direction bc inherent part of Snail
			if (s=="top") {
				x+=5;
				//System.out.println("i am top");
				if (x>=480) {
					//System.out.println("moving fr top to right");
					x=480;
					this.setSide("right");
					
				}
			}
			if (s=="right") {
				y+=5;
			//	System.out.println("i am right");
				if(y>=460) {
				//	System.out.println("i am moving fr right to bottom");
					//this.s = "bottom";
					y=460;
					this.setSide("bottom");
					
				}
			}
			if (s=="bottom") {
				x-=5;
				if(x==60) {
					//s = "left";
					x=60;
					this.setSide("left");
					
					
				}
			}
			if (s=="left") {
				y-=5;
				if(y==60) {
					//s = "top";
					y=60;
					this.setSide("top");
					
				}
			}
		 //  isSleep = false; 
		
	}

	/**
	 * Draw the snail at the current setup.
	 * 
	 * @param g - the window to draw to.
	 */
	public void draw(Graphics2D g) {
		// By calling move here, if we want to move our snail, we can do so.
		// Move gets called by draw, so whenever draw gets called.
		this.move();

		// By making a new Graphics2D object, we can move everything that gets drawn to
		// it.
		// This is kind of tricky to wrap your head around, so I gave it to you.
		Graphics2D position = (Graphics2D) g.create();
		position.translate(x, y);

		// Note that I need to compare strings with ".equals" this is a Java weirdness.
			if ("bottom".equals(this.direction)) {
				drawSnail(position, Color.red, Color.white, Color.black, this.isSleep);
			} else if ("top".equals(this.direction)) {
				position.scale(-1, -1);
				drawSnail(position, Color.red, Color.white, Color.black, this.isSleep);
			} else if ("left".equals(this.direction)) {
				// Oh no, radians.
				position.rotate(Math.PI / 2);
				drawSnail(position, Color.red, Color.white, Color.black, this.isSleep);
			} else { // we don't have to say "right" here.
				// Oh no, radians.
				position.rotate(-Math.PI / 2);
				drawSnail(position, Color.red, Color.white, Color.black, this.isSleep);
			}
		
		
//			if ("bottom".equals(this.direction)) {
//				drawSnail(position, Color.red, Color.white, Color.black, false);
//			} else if ("top".equals(this.direction)) {
//				position.scale(-1, -1);
//				drawSnail(position, Color.red, Color.white, Color.black, false);
//			} else if ("left".equals(this.direction)) {
//				// Oh no, radians.
//				position.rotate(Math.PI / 2);
//				drawSnail(position, Color.red, Color.white, Color.black, false);
//			} else { // we don't have to say "right" here.
//				// Oh no, radians.
//				position.rotate(-Math.PI / 2);
//				drawSnail(position, Color.red, Color.white, Color.black, false);
//			}	
			

		// It's OK if you forget this, Java will eventually notice, but better to have
		// it!
		position.dispose();
	}

	/**
	 * Kudos to Group 7, (Fall 2018).
	 * 
	 * @param g          The graphics object to draw with.
	 * @param bodyColor  The color of the snail body.
	 * @param shellColor The color of the snail shell.
	 * @param eyeColor   The color of the snail eye.
	 */
	public static void drawSnail(Graphics2D g, Color bodyColor, Color shellColor, Color eyeColor, boolean isSleep) {
		Shape body = new Rectangle2D.Double(0, 0, 40, 50);
		Shape tentacleL = new Rectangle2D.Double(0, -20, 5, 20);
		Shape eyeWhiteL = new Ellipse2D.Double(-4, -28, 12, 12);
		Shape eyePupilL = new Ellipse2D.Double(-2, -26, 4, 4);
		
		g.setColor(bodyColor);
		g.fill(body);
		g.fill(tentacleL);
		if (isSleep) {
			g.setColor(Color.red);
			g.fill(eyeWhiteL); 
			g.setColor(Color.red); //eyecolor is for the pupil!
			g.fill(eyePupilL);
		}
		else {
			g.setColor(Color.white);
			g.fill(eyeWhiteL); 
			g.setColor(Color.black); 
			g.fill(eyePupilL);
		}
//		g.setColor(Color.white);
//		g.fill(eyeWhiteL); 
//		g.setColor(eyeColor); 
//		g.fill(eyePupilL);

		Shape tentacleR = new Rectangle2D.Double(35, -20, 5, 20);
		Shape eyeWhiteR = new Ellipse2D.Double(35 - 4, -28, 12, 12);
		Shape eyePupilR = new Ellipse2D.Double(35 + 2, -26 + 4, 4, 4);

		g.setColor(bodyColor);
		g.fill(tentacleR);
		if (isSleep) {
			g.setColor(Color.red);
			g.fill(eyeWhiteL); 
			g.setColor(Color.red); 
			g.fill(eyePupilL);
		}
		else {
			g.setColor(Color.white);
			g.fill(eyeWhiteR);
			g.setColor(Color.black);
			g.fill(eyePupilR);
		}
//		g.setColor(Color.white);
//		g.fill(eyeWhiteR);
//		g.setColor(eyeColor);
//		g.fill(eyePupilR);

		Shape shell3 = new Ellipse2D.Double(45, 20, 10, 10);
		Shape shell2 = new Ellipse2D.Double(35, 10, 30, 30);
		Shape shell1 = new Ellipse2D.Double(25, 0, 50, 50);

		g.setColor(shellColor);
		g.fill(shell1);
		g.setColor(Color.black);
		g.draw(shell1);
		g.setColor(shellColor);
		g.fill(shell2);
		g.setColor(Color.black);
		g.draw(shell2);
		g.setColor(shellColor);
		g.fill(shell3);
		g.setColor(Color.black);
		g.draw(shell3);
	}
}
