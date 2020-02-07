package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;

import me.jjfoley.gfx.GFX;

/**
 * Aquarium is a graphical "application" that uses some code I built and have
 * shared with you that takes care of opening a window and communicating with
 * the user in a simple way.
 * 
 * The method draw is called 50 times per second, so we make an animation by
 * drawing our fish in one place, and moving that place slightly. The next time
 * draw gets called, our fish looks like it moved!
 * 
 * @author jfoley
 *
 */
public class Aquarium extends GFX { //GFX = animation/graphics, like 200-300 lines code
	/**
	 * This is a static variable that tells us how wide the aquarium is.
	 */
	public static int WIDTH = 500; //size of window = w width and height
	// like other languages; top left = (0,0) and top bottom (500, 500)
	//up: -y, down: +y, left: -x, right: +x
	/**
	 * This is a static variable that tells us how tall the aquarium is.
	 */
	public static int HEIGHT = 500;

	/**
	 * Put a snail on the top of the tank.
	 */
	Snail algorithm = new Snail(177, Snail.HEIGHT + 1, "top");

	/**
	 * This is a constructor, code that runs when we make a new Aquarium.
	 */
	public Aquarium() {
		// Here we ask GFX to make our window of size WIDTH and HEIGHT.
		// Don't change this here, edit the variables instead.
		super(WIDTH, HEIGHT);
	}

	int fish1X = getWidth() + 100;  //1x 2x as in 1x x coord movement (self)
	int fish2X = getWidth() + 300;
	int fish3X = -100;
	//red fish 3x :)

	Fish nemo = new Fish(-80, 40, Color.cyan, true, true); 
			//lowercase and uppercase are the same, did lowercase first and then added and now 2 of everything
	Fish boo = new Fish(-30, 80, Color.black, false, true);
	@Override
	public void draw(Graphics2D g) { //instead of graphicswin = graphics2d, g=what's usu called, arbitrary obj
		// Draw the "ocean" background.
		g.setColor(Color.blue); //bg color, obv set 1st so not over fish
		g.fillRect(0, 0, getWidth(), getHeight()); //

		nemo.draw(g); //becomes the this variable in the Fish class
		nemo.swim(); //like the draw(win) thing
		boo.draw(g);
		boo.swim();
		
		// Draw the fish! there are 1 versions of draw fish method, facingleft/right and smol fish vers of that 
		//DrawFish.smallFacingLeft(g, nemo.color, nemo.x, nemo.y); //can break spaces
		//and it doesn't cut tho code, tho it does for these comments smh
		DrawFish.facingLeft(g, Color.yellow, fish1X, 200);
		
		// Draw the confused fish!
		DrawFish.facingLeft(g, Color.green, fish2X, 300);

		// What if we wanted this little fish to swim, too?
		DrawFish.smallFacingRight(g, Color.red, fish3X, 100); //inst. of just 200, put fish3x

		// Draw our snail!
		algorithm.draw(g);

		// Move the fish!
		fish1X -= 1; //already in loop so makes move by x axis
		fish2X -= 2;
		fish3X +=3;
		if(fish3X > getWidth() + 45){
		   fish3X = -100;
		 //not perf bc can see it disppear so do getwidth + 50 so that can disappear a lil after it leaves the screen
	    }
	}

	public static void main(String[] args) {
		// Uncomment this to make it go slower!
		// GFX.FPS = 10;
		// This is potentially helpful for debugging movement if there are too many print statements!

		// Note that we can store an Aquarium in a variable of type GFX because Aquarium
		// is a very specific GFX, much like 7 can be stored in a variable of type int!
		GFX app = new Aquarium();
		app.start();
	}

}
