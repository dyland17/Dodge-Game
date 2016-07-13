package dylan.dewald.game.dodge.entities;

import java.awt.Color;
import java.awt.Graphics2D;

public class FadeSquare extends Squares{
	private int health;
	private boolean dead = false;
	public FadeSquare(double x, double y, Color c){
		super(x,y);
		health = 40;
		this.x = x;
		this.y = y;
		myColor = c;
	}
	
	public void decay(){
		health -= 7;
		if(health <= 0){
			dead = true;
		}
	}
	
	public void paint(Graphics2D g2d){
		g2d.fillRect((int)x,(int) y, width, height);
	}
	
	public boolean getDead(){return dead;}
}
