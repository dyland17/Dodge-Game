package dylan.dewald.game.dodge.entities;

import java.awt.Color;
import java.awt.Graphics2D;

import dylan.dewald.game.dodge.Start;
import dylan.dewald.game.dodge.graphics.GameScreen;

public class Player extends Squares{
	private boolean right = false,left = false,up = false,down = false;
	public Player(double x, double y) {
		super(x, y);
	}

	@Override
	public void move() {
		//movement code
		if(up == true){
			y -= 2;
		}
		if(down == true){
			y += 2;
		}
		if(left == true){
			x -= 2;
		}
		if(right == true){
			x += 2;
		}
		//collision code
			//X collision
		if(x < 0){
			x = 0;
		}
		if((x + width + screenXOffset) > Start.screenWidth){
			x = Start.screenWidth - (width + screenXOffset);
		}
			//Y collision
		if(y < 0){
			y = 0;
		}
		if((y + height + screenYOffset) > Start.screenHeight){
			y = Start.screenHeight - (height + screenYOffset);
		}
	}

	@Override
	public void paint(Graphics2D g2d) {
		g2d.setColor(Color.white);
		g2d.fillRect((int)x,(int) y, width, height);
		
		
	}
	//setters
	public void setUP(boolean b){up = b;}
	public void setDOWN(boolean b){down = b;}
	public void setLEFT(boolean b){left = b;}
	public void setRIGHT(boolean b){right = b;}
}
