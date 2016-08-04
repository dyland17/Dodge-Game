package dylan.dewald.game.dodge.entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import dylan.dewald.game.dodge.Start;
import dylan.dewald.game.dodge.enums.DiagnolDirection;
import dylan.dewald.game.dodge.utilities.MiscMath;

public class DiagnolSquare extends Squares{
	private DiagnolDirection startDirection;
	public DiagnolSquare(double x, double y, DiagnolDirection dd) {
		super(x, y);
		//Color established
		myColor = Color.blue;
		//Starting Direction of DiagnolSquare
		xSpeed = 1;
		ySpeed = 1;
		startDirection = dd;
		
		switch(startDirection){
			case UPLEFT:
				ySpeed *= -1;
				xSpeed *= -1;
				break;
			case UPRIGHT:
				ySpeed *= -1;
				xSpeed *= 1;
				break;
			case DOWNLEFT:
				ySpeed *= 1;
				xSpeed *= -1;
				break;
			case DOWNRIGHT:
				ySpeed *= 1;
				xSpeed *= 1;
		};
	}

	@Override
	public void move() {
		super.move();
		//movement code
		x += xSpeed;
		y += ySpeed;
		x =  Math.round(x);
		y =  Math.round(y);
		//collision code
		//X collision
		if(x < 0){
			x = 0;
			xSpeed *= -1;
		}
		if((x + width + screenXOffset) > Start.screenWidth){
			x = Start.screenWidth - (width + screenXOffset);
			xSpeed *= -1;
		}
			//Y collision
		if(y < 0){
			y = 0;
			ySpeed *= -1;
		}
		if((y + height + screenYOffset) > Start.screenHeight){
			y = Start.screenHeight - (height + screenYOffset);
			ySpeed *= -1;
		}
	}

	@Override
	public void paint(Graphics2D g2d) {
		super.paint(g2d);
		g2d.fillRect((int)x,(int) y, width, height);
	}
}
