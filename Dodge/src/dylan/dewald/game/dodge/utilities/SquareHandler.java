package dylan.dewald.game.dodge.utilities;

import java.util.ArrayList;

import dylan.dewald.game.dodge.Start;
import dylan.dewald.game.dodge.entities.Squares;
/**
 * 
 * @author-Dylan_Dewald
 *<br>
 *This class handles the list of squares.
 */
public class SquareHandler {
	private ArrayList<Squares> squares;
	private Start game;
	public SquareHandler(Start game){
		this.game = game;
		squares = new ArrayList<Squares>();
	}
	
	public void update() {
		int size = squares.size();
		for(int i = 0;i < size; i++)
			squares.get(i).move();
		addNewEnemies();
		
	}

	private void addNewEnemies() {
		ArrayList<Event> addEnemy = game.getEventTimer().getEventList();
		if(!addEnemy.isEmpty()){
			for(int i = 0; i < addEnemy.size(); i++){
				if(addEnemy.get(i).getTimeReached() == true){
					Squares tempSquare = addEnemy.get(i).getEventEnemy();
					squares.add(tempSquare);
					addEnemy.get(i).setAdded(true);
				}
			}
		}
	}
	public ArrayList<Squares> getSquareList() {
		return squares;
	}
	public void setSquares(ArrayList<Squares> squares) {
		this.squares = squares;
	}

	
	
	
}
