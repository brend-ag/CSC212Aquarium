package edu.smith.cs.csc212.aquarium;

import java.awt.Color;

public class HungryFish extends Fish {
	int hunger;
	int foodMeter;  
	boolean isHungry;
	
	public HungryFish(int hunger, int foodMeter, 
			boolean fishMeter, int x, int y, Color color, 
			boolean facingLeft, boolean isLittle) {
		super(x, y, color, facingLeft, isLittle); 
			/*logic for super line and constructor parameters borrowed from: 
			 * https://stackoverflow.com/questions/33335485/implicit-super-constructor-person-is-undefined-must-explicitly-invoke-another
			 */
		this.hunger = hunger;
		this.foodMeter = foodMeter;
		
		
	}
}
