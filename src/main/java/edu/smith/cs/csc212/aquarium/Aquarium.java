package edu.smith.cs.csc212.aquarium;
import java.util.Random;
import java.awt.Color;
import java.awt.Graphics2D;
import me.jjfoley.gfx.GFX;
import java.util.concurrent.ThreadLocalRandom;

//Code borrowed from John Foley: 
public class Aquarium extends GFX { /*GFX = animation/graphics, like 
	200-300 lines code orig so not even gonna be talked abt */
	
	public static int W = 500; //width of window
	/*window: top left = (0,0) and bottom right (500, 500)
	up: -y, down: +y, left: -x, right: +x */
	public static int H = 500; //height of window

	Snail algorithm = new Snail(177, Snail.HEIGHT + 1, "top");
		//puts snail at top of tank //what's the 177???? 
	    //and top type nani and why .height wha
	Fish[] fishes = new Fish[20];
	Bubbles[] bubbles = new Bubbles[10];
	public Aquarium() { //constructor: runs when new Aq. made
		// ask GFX to set window w width & height we chose
		super(W, H);
		//Code borrowed from: Lists, Stacks, Queues slides by JJ Foley
		Random rand = new Random();
		for (int i =0; i <this.fishes.length; i++) {
			Color rcolor = Color.getHSBColor(rand.nextFloat(), 0.8f, 0.8f);
			boolean isSmall = rand.nextBoolean();
			boolean isRight = rand.nextBoolean();
			int x = 50 + (i*90)%(W -100);
			int y = 50 + (i*40)%(H -100);
			this.fishes[i] = new Fish(x, y, rcolor, isSmall, isRight);
					//is all my facing left etc code useless bc of this smfh, test out
		}
		for (int i =0; i <this.bubbles.length; i++) {
			//random function code borrowed from: https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java
			//int x = rand.nextInt((300-480)+1)+ 300;
			int x = ThreadLocalRandom.current().nextInt(300, 480 + 1);
			int y = ThreadLocalRandom.current().nextInt(350, 450 + 1);
			double size = 10*(0.5)*(ThreadLocalRandom.current().nextInt(1,6 +1));
			this.bubbles[i] = new Bubbles(x, y, size);
		}
		
	}
	

//	int fish1X = getWidth() + 100;  //1x 2x as in 1x x coord movement (self)
//	int fish2X = getWidth() + 300;
//	int fish3X = -100;
	//red fish 3x :)

//	Fish nemo = new Fish(100, 40, Color.cyan, false, true); 
			//100, 40 = x, y coord of fish
//	Fish boo = new Fish(140, 80, Color.pink, true, false);
	 /*problem: boo isn't showing up, and fishes 
	  * facing both ways, tho that's prob bc of the 2 times
	  * we are drawing the fish so don't do that? D:
	  */
	
	@Override
	public void draw(Graphics2D g) { //instead of graphicswin = graphics2d, g=what's usu called, arbitrary obj name
		//Ocean bg code
		g.setColor(Color.blue); //bg color, obv set 1st so not over fish
		g.fillRect(0, 0, getWidth(), getHeight());
		
		for(Bubbles b: this.bubbles) {
			b.draw(g);
		}
		for(Fish f: this.fishes) {
			f.draw(g);
		}
		
		
		
			//filling rect of the window blue ;)
//		nemo.draw(g); //becomes the this variable in the Fish class
//		 //like the draw(win) thing
//		boo.draw(g);
		
		
		/* Draw the fish! there are >1 versions of draw fish method, 
		 * facingleft/right and smol fish vers of that */
		//DrawFish.smallFacingLeft(g, nemo.color, nemo.x, nemo.y);  
		
//		DrawFish.facingLeft(g, Color.yellow, fish1X, 200);
//		 //instead of putting x coord, put fishX bc that's the x coord for that fish oo
//		
//		DrawFish.facingLeft(g, Color.green, fish2X, 300);
//
//		
//		DrawFish.smallFacingRight(g, Color.red, fish3X, 100); //inst. of just 200, put fish3x
//
//		//draw snail (fr Snail algorithm)
		algorithm.draw(g);

		//Moves fish
//		fish1X -= 1; //already in loop so makes move by x axis
//		fish2X -= 2;
//		fish3X +=3;
//		if(fish3X > getWidth() + 45){ //wrapping fish when goes too much to the left
//		   fish3X = -100;
//	    }
	}

	public static void main(String[] args) {
		// Makes movement slower:
		// GFX.FPS = 10;
		// This is potentially helpful for debugging movement if there are too many print statements!

		// Note that we can store an Aquarium in a variable of type GFX because Aquarium
		// is a very specific GFX, much like 7 can be stored in a variable of type int!
		GFX app = new Aquarium();
		app.start();
	}

}
