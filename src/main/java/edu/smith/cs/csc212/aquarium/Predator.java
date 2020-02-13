package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.util.Random;

public class Predator {
	int x;
	int y;
	Color color;
	boolean facingLeft;
	boolean isLittle;
	Random rand = new Random();
	int destX;    
	int destY;
	
	public Predator(int x, int y, Color color, boolean facingLeft, boolean isLittle) {
		this.x = x;
		this.y = y;
		this.color = color;
		this.facingLeft = facingLeft;
		this.isLittle = isLittle;
	}
}
