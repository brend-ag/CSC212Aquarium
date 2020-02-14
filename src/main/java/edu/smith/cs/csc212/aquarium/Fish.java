package edu.smith.cs.csc212.aquarium;
import java.util.Random;
import java.awt.Color;
import java.awt.Graphics2D;


public class Fish {
   int x; //translates to: Every fish has an x position that is an int;
   int y;
   Color color; 
   boolean facingLeft;
   boolean isLittle;
   Random rand = new Random();
   //every fish has a destination (below) 
   int destX; 
   //can just pick random coord x y, in this case; 450, 450
   int destY;
   	
   
   public Fish(int x, int y, Color color, boolean facingLeft, boolean isLittle) {
	   this.x = x;
	   this.y = y;
	   this.color = color;
	   this.facingLeft = facingLeft;
	   this.isLittle = isLittle; 
	   
	   this.destX = rand.nextInt(480);
	   this.destY = rand.nextInt(480);
   } 
   public void swim(Graphics2D g) { 
	   if(this.x > this.destX) {
		   this.facingLeft = true;
		   this.x-=1;
		
	   }
	   
	   if(this.x < this.destX) {
		   this.facingLeft = false; 
		   this.x+=1;
	   }
	   
	   if(this.x==this.destX) {
		   this.destX = rand.nextInt(480);
	   }
	   
	   if (this.facingLeft==true) {
		   if (this.isLittle==true) {
			   DrawFish.smallFacingLeft(g, this.color, this.x, this.y);
		   }
		   else {
		   DrawFish.facingLeft(g, this.color, this.x, this.y);

		   }
	   }
	   if (this.facingLeft==false) {
		   if (this.isLittle==true) {
			   DrawFish.smallFacingRight(g, this.color, this.x, this.y);
		   }
		   else {
			   DrawFish.facingRight(g, this.color, this.x, this.y);
		   }
	   }
	   
	    if(this.y < this.destY) {
		   this.y+=1;  
	   }
	   if(this.y > this.destY) {
		   this.y-=1;
	   }
	   if(this.y==this.destY) {
		   this.destY = rand.nextInt(480);
	   }
   }
   
	public void draw(Graphics2D g) { 
		this.swim(g); 

	}

}

