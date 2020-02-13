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

	Snail algorithm = new Snail(177, Snail.HEIGHT + 1, "top", true);
		/*puts snail at top of tank; 177 is the x; height  
		 * makes sense bc 50 and since coming down, 
		 * y increases as hgo down so y=50
		 */
	
	    
	Fish[] fishes = new Fish[20];
	Bubbles[] bubbles = new Bubbles[10];
	//would be funny if i did an array of snails and there were a bunch of snails going around ;)
	
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
					//is all my facing left etc code useless bc of this: yes smfh, that was to start
		}
		for (int i =0; i <this.bubbles.length; i++) {
			//random function code borrowed from: https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java
			//int x = rand.nextInt((300-480)+1)+ 300;
			int x = ThreadLocalRandom.current().nextInt(300, 470 + 1);
			int y = ThreadLocalRandom.current().nextInt(350, 450 + 1);
			//double size = 10*(0.5)*(ThreadLocalRandom.current().nextInt(1,6 +1));
			this.bubbles[i] = new Bubbles(x, y); //took off size here
		}
		
	}
	
	@Override
	public void draw(Graphics2D g) { //instead of graphicswin = graphics2d, g=what's usu called, arbitrary obj name
		//Ocean bg code
		int re = 0;
		int gr = 102;
		int bl = 204;
		
		Color bgColor = new Color(re, gr, bl); 
		//this color logic is borrowed from: https://stackoverflow.com/questions/42855224/how-to-add-rgb-values-into-setcolor-in-java
		g.setColor(bgColor); //bg color, obv set 1st so not over fish; 
		g.fillRect(0, 0, getWidth(), getHeight()); //filling rect of the window blue ;)
	//	for(int i = 0; i<100; i++) {
			while (gr!=250) {
			gr+=10;
			bgColor = new Color(re, gr, bl);
			g.setColor(bgColor); 
			g.fillRect(0, 0, getWidth(), getHeight());
//			if(Snail.isSleep==false) {
//				 insert code for the change back to blue thing :(
//			}
		}
		for(Bubbles b: this.bubbles) {
			b.draw(g);
		}
		for(Fish f: this.fishes) {
			f.draw(g);
		}
		algorithm.draw(g);
		
	}

	public static void main(String[] args) {
		 //GFX.FPS = 10; //slow movement; good for debugging if there are a lot of print statements

		// Note that we can store an Aquarium in a variable of type GFX because Aquarium
		// is a very specific GFX, much like 7 can be stored in a variable of type int!
		GFX app = new Aquarium();
		app.start();
	}

}
