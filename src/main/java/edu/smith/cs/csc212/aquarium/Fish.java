package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;

public class Fish {
   int x; //translates to: Every fish has an x position that is an int;
   int y;
   Color color; //imported Color class built-in Java, could also do import java.awt.Color; or call java.awt.Color every time (unless importing 2 diff Color classes)
   	//given this space and location, but need constructor to take values and assign them to these var's
   boolean facingLeft;
   boolean isLittle;
   
   //every fish has a destination (below) 
   int destX; //can just pick random coord x y, in this case; 450, 450
   int destY;
   
   public Fish(int x, int y, Color color, boolean facingLeft, boolean isLittle) {
	   //can do this order whatever you want, he usu does color 1st
	   //boolean facingLeft, boolean isLittle
	   //can't put draw method in here, since can't move bc keeps creating new fishes and want to move it! so call it after create an indiv fish
	   this.x = x;
	   this.y = y;
	   this.color = color;
	   this.facingLeft = facingLeft;
	   this.isLittle = isLittle; 
	   this.destX = 450;
	   this.destY = 450; //can guess if dest is too low/high w if statements in swim 
   } 
   public void swim() {
	   this.y-=1; //slowly swim to bottom
	   if(this.y < this.destY) {
		   this.y+=1;
	   }
   }
   
	public void draw(Graphics2D g) { 
		this.swim(); 
		//if statements for isLittle, 
		DrawFish.smallFacingLeft(g, this.color, this.x, this.y);
	}
   
}

//
//	public OneCard(String person, double money) { //constructor that takes two parameters, w personal and initial deposit basically
//		this.owner = person;
//		this.balance = money; //could do the same name for instance var and param but did it diff for clarity
//		/** = does a javadoc comment, meaning if hover over var = see description written @ certain pace, associate it w certain variable (reminds me of the big commments under functions in python <<< or smth **/
//		public void deposit(double amount) {
//			this.balance += amount; //changes the data
//		}
//		public boolean canAfford(double amount) { // notice how its boolean, so can return this.balance = the same as doing if then = true else false 
//			return this.balance > amount;//says if amt fits inside the balance should be >=
//		
//		}
//		public void spend(double amount) {
//			if(!this.canAfford(amount)) {
//				throw new RuntimeException("Can't afford " + amount);
//			}
//			this.balance -= amount;
//		}
//	}
//}