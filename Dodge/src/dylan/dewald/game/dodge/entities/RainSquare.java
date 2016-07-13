package dylan.dewald.game.dodge.entities;

import java.awt.Color;
import java.awt.Graphics2D;

import dylan.dewald.game.dodge.enums.RainSpeed;

public class RainSquare extends Squares{
	private int widthOfTravel ;
	public RainSquare(double x, double y,RainSpeed rs){
			super(x,y);
			myColor = Color.CYAN;
			widthOfTravel  =(int) (x - 10);
			switch(rs){
				case SLOW:
					xSpeed = -0.75;
					ySpeed = 0.75;
				break;
				case FAST:
					xSpeed = -1.25;
					ySpeed = 2.25;
			}
	}

	@Override
	public void move() {
		//Trail Square code
		super.move();
		//RainSquare code
		y += ySpeed;
		x += xSpeed;
		x = Math.round(x);
		y = Math.round(y);
		System.out.println("Yspeed: "+ ySpeed );
		if(x <= widthOfTravel){
			xSpeed *= -1;
		}
		else if(x >= (widthOfTravel + width + 10)){
			xSpeed *= -1;
		}
	}

	@Override
	public void paint(Graphics2D g2d) {
		//To do trailSquares
		super.paint(g2d);
		//Painting the actual square
		g2d.fillRect((int)x,(int) y, width, height);
	}
	
}
