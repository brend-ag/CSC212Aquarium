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

	public Snail(int sx, int sy, String s, boolean isSleep) {
		this.setSide(s); //can be: "top," "bottom," "left," "right"
		this.x = sx;
		this.y = sy;
		this.isSleep = isSleep;

	}

	public void setSide(String s) {
		this.direction = s.toLowerCase();
	} 
	
	public void move() {
		String s = this.direction; //use direction bc inherent part of Snail
			if (isSleep==false) {
			    if (s=="top") {
					x+=5;
					//System.out.println("i am top");
					if (x>=480) {
						//System.out.println("moving fr top to right");
						x=450;
						this.setSide("right");
						
					}
				}
				if (s=="right") {
					y+=5;
				//	System.out.println("i am right");
					if(y>=450) {
					//	System.out.println("i am moving fr right to bottom");
						//this.s = "bottom";
						y=450;
						this.setSide("bottom");
						
					}
				}
				if (s=="bottom") {
					x-=5;
					if(x==50) {
						//s = "left";
						x=50;
						this.setSide("left");
						
						
					}
				}
				if (s=="left") {
					y-=5;
					if(y==50) {
						//s = "top";
						y=50;
						this.setSide("top");
						
					}
			}
		} 
		
	}


	public void draw(Graphics2D g) {
		this.move();

		Graphics2D position = (Graphics2D) g.create();
		position.translate(x, y);

		
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
