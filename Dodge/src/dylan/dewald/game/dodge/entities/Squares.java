package dylan.dewald.game.dodge.entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Squares {
	//variables
	protected double x, y;
	protected int xSpeed, ySpeed;
	private Object key;
	//Final variables
	protected final int width = 26, height = 26;
	protected final int screenXOffset = 6;
	protected final int screenYOffset = 26;
	//Other variables
	protected Color myColor;
	protected ArrayList<FadeSquare> trailSquares;
	private ArrayList<FadeSquare> removeSquares;
	//constructor
	public Squares(double x, double y){
		this.x = x;
		this.y = y;
		trailSquares = new ArrayList<FadeSquare>();
		removeSquares = new ArrayList<FadeSquare>();
		key = new Object();
	}
	
	//methods
	public  void move(){
			//FadeSquare code
			//adding new FadeSquares
		ArrayList<FadeSquare> trail = this.getTrailSquares();
		if(trail.size() <= 5){
			trail.add(new FadeSquare(x, y, myColor));
		}
		int size = trail.size();
		ArrayList<FadeSquare> removeSquares = new ArrayList<FadeSquare>();
		for(int i = 0; i < size; i++){
			trail.get(i).decay();
			if(trail.get(i).getDead() == true)
				removeSquares.add(trail.get(i));
		}
		//removing dead squares
		this.removeSquares.addAll(removeSquares);
	}
		
	public void paint(Graphics2D g2d){
		g2d.setColor(myColor);
		try{
			ArrayList<FadeSquare> trail = this.getTrailSquares();
			for(int i = 0; i < trail.size(); i++){
				trail.get(i).paint(g2d);
			}
		}
		catch(NullPointerException ex){
			ex.printStackTrace();
		}
	}
	public int getySpeed() {
		return ySpeed;
	}

	public void setySpeed(int ySpeed) {
		this.ySpeed = ySpeed;
	}

	private ArrayList<FadeSquare> getTrailSquares(){
		synchronized(key){
			if(!removeSquares.isEmpty()){
				trailSquares.removeAll(removeSquares);
				removeSquares.removeAll(removeSquares);
			}
		}
			return trailSquares;
	}
}
