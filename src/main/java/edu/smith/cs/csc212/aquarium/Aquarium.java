//Code done by me, though worked with Aneliz Vargas for some parts of the code
package edu.smith.cs.csc212.aquarium;
import java.util.Random;
import java.awt.Color;
import java.awt.Graphics2D;
import me.jjfoley.gfx.GFX;
import java.util.concurrent.ThreadLocalRandom;

//Code borrowed from John Foley: 
public class Aquarium extends GFX { 
	
	public static int W = 500; //width of window
	/*window: top left = (0,0) and bottom right (500, 500)
	up: -y, down: +y, left: -x, right: +x */
	public static int H = 500; //height of window
	int re = 0;
	int gr = 102;
	int bl = 204;
	int timer = 15;
	Snail algorithm = new Snail(177, Snail.HEIGHT + 1, "top", true);
	
	
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
					//isSmall and isRight = random booleans for Fish; so random in orientation and size
		}
		
		for (int i = 0; i <this.bubbles.length; i++) {
			//random function code borrowed from: https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java
			int x = ThreadLocalRandom.current().nextInt(300, 470 + 1);
			int y = ThreadLocalRandom.current().nextInt(350, 450 + 1);
			this.bubbles[i] = new Bubbles(x, y); //took off size here
		}
		
	}
	public void changeBG(Graphics2D g) {
		//this color logic is borrowed from: https://stackoverflow.com/questions/42855224/how-to-add-rgb-values-into-setcolor-in-java
		//notice how don't have to use this.!
		Random rand = new Random();
		boolean isSleep = rand.nextBoolean();
		if(isSleep==false) {
			gr+=1;
			bl-=1;
		//	algorithm.isSleep = true;
			if(gr==245) {
//				gr=102;
//				bl=204;
				algorithm.isSleep = false;
				if (algorithm.isSleep==false) {
					gr-=1;
					bl+=1;
					if(bl==204 && gr==102) {
						algorithm.isSleep=false;
					}
				}
			}	
			
			
		}
	}
	
	@Override
	public void draw(Graphics2D g) { //instead of graphicswin = graphics2d, g=what's usu called, arbitrary obj name

		this.changeBG(g);
		Color bgColor = new Color(re, gr, bl); 
		g.setColor(bgColor); //bg color, obv set 1st so not over fish; 
		g.fillRect(0, 0, getWidth(), getHeight()); //filling rect of the window blue ;)
		
		for(Bubbles b: this.bubbles) {
			b.draw(g);
		}
		for(Fish f: this.fishes) {
			f.draw(g);
		}
		algorithm.draw(g);
		
	}

	public static void main(String[] args) {
		GFX app = new Aquarium();
		app.start();
	}

}

