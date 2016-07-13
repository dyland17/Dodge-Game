package dylan.dewald.game.dodge.entities;

import java.awt.Color;
import java.awt.Graphics2D;

public class CircleSquare extends Squares{
	private int radius;
	private double angle = 0;
	private int xCenter,yCenter;
	private long lastTime;
	public CircleSquare(double x, double y, int rad) {
		super(x, y);
		myColor = Color.pink;
		xCenter = (int)(x + (width / 2));
		yCenter = (int)(y + (height / 2));
		radius = rad;
		
		lastTime = System.currentTimeMillis();
	}

	@Override
	public void move() {
		//Called to update square trail.
		super.move();
		if(System.currentTimeMillis() -  lastTime > 20){
			xCenter += (int)(Math.cos(angle)*radius);
			yCenter += (int)(Math.sin(angle)*radius);
			angle += Math.PI/ 8;
			lastTime = System.currentTimeMillis();
		}
		
		x = xCenter - (width / 2);
		y = yCenter -(height / 2);
		
	}

	@Override
	public void paint(Graphics2D g2d) {
		super.paint(g2d);
		g2d.fillRect((int)x,(int) y, width, height);
	}
}