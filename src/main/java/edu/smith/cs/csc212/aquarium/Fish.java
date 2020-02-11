package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;

public class Fish {
   int x; //translates to: Every fish has an x position that is an int;
   int y;
   Color color; /*imported Color class built-in Java, could also do import 
   java.awt.Color; or call java.awt.Color every time 
   (unless importing 2 diff Color classes)
   	//fish given space and location, but need constructor to take 
   	 * values and assign them to these var's
   	 */
   boolean facingLeft;
   boolean isLittle;
   
   //every fish has a destination (below) 
   int destX; //can just pick random coord x y, in this case; 450, 450
   int destY;
   
   public Fish(int x, int y, Color color, boolean facingLeft, boolean isLittle) {
	   //can do order above in whatever way you want, he usu does color 1st
	   //boolean facingLeft, boolean isLittle so T/F
	   /*can't put draw method in here, since can't move bc 
	    * keeps creating new fishes and want to move it! 
	    * so call it after create an indiv fish
	    */
	   this.x = x;
	   this.y = y;
	   this.color = color;
	   this.facingLeft = facingLeft;
	   this.isLittle = isLittle; 
	   
	   this.destX = 450; /*have to pass this too even tho not receiving 
	   it in instance of class(self)! */
	   this.destY = 450; //can guess if dest is too low/high w if statements in swim 
   } 
   public void swim() { //me: so these are what would be the 
	   //diff functions under each class in python
	   if(this.y < this.destY) {
		   this.y+=1;  /*slowly swim to bottom, if y is < destY 
		   (where we want them to go,
		   then keep adding y or decreasing the loc. 
		   of fish til it gets there*/
	   }
   }
   
	public void draw(Graphics2D g) { 
		this.swim(); 
		//if statements for isLittle, etc go here
		DrawFish.smallFacingLeft(g, this.color, this.x, this.y);
	}
   
}

