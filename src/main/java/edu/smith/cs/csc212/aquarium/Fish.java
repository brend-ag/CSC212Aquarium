package edu.smith.cs.csc212.aquarium;
import java.util.Random;
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
   Random rand = new Random();
   //every fish has a destination (below) 
   int destX; 
   //can just pick random coord x y, in this case; 450, 450
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
	   
	   this.destX = rand.nextInt(480); /*have to pass this too even tho not receiving 
	   it in instance of class(self)! */
	   this.destY = rand.nextInt(480); /*can guess if dest is too low/high w 
	   if statements in swim */
	   /*imma leave it as 480 bc doing a min/max thing is a bit confusing bc 
	   	 * a whole diff class thing but will wrap after so doesn't really 
	   	 */
   } 
   public void swim(Graphics2D g) { //me: so these are what would be the 
	   //diff functions under each class in python
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
	   
	   if ((this.isLittle=true) && (this.facingLeft=true)){
		   DrawFish.smallFacingLeft(g, this.color, this.x, this.y);
	   }
	   //how to incorporate the isLittle :((((
	   if ((this.isLittle = false) && (this.facingLeft= false)) {
			DrawFish.smallFacingRight(g, this.color, this.x, this.y);
		}
	   else if (this.facingLeft == true) { //remember true = LOWERCASE
		   DrawFish.facingLeft(g, this.color, this.x, this.y);
		}
	   
	   else if (this.facingLeft == false) {
			DrawFish.facingRight(g, this.color, this.x, this.y);
		}
	   
	    if(this.y < this.destY) {
		   this.y+=1;  /*slowly swim to bottom, if y is < destY 
		   (where we want them to go,
		   then keep adding y or decreasing the loc. 
		   of fish til it gets there*/
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
		//if statements for isLittle, etc go here
		
//		if ((this.isLittle = true) && (this.facingLeft=true)) {
//			DrawFish.smallFacingLeft(g, this.color, this.x, this.y);
//			
//		}
//		if ((this.isLittle = false) && (this.facingLeft= false)) {
//			DrawFish.smallFacingRight(g, this.color, this.x, this.y);
//		}
		//DrawFish.smallFacingLeft(g, this.color, this.x, this.y);
	}
//    public void wrap() {
//    	if(this.x == )
//    }
}

