package dylan.dewald.game.dodge.utilities;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import dylan.dewald.game.dodge.entities.Player;
//To control the players movement
public class KeyMover implements KeyListener {
	//reference to the player in the Squares list
	private Player p1;
	//constructor
	public KeyMover(Player p){
		p1 = p;
	}
	//when appropriate keys are pressed
	//	the p1 reference chances the boolean
	//	variables of the Player class so it can move.
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if(keyCode == KeyEvent.VK_UP){
			p1.setUP(true);
		}
		else if(keyCode == KeyEvent.VK_DOWN){
			p1.setDOWN(true);
		}
		else if(keyCode == KeyEvent.VK_LEFT){
			p1.setLEFT(true);
		}
		else if(keyCode == KeyEvent.VK_RIGHT){
			p1.setRIGHT(true);
		}

	}
	//when appropriate keys are released
		//	the p1 reference chances the boolean
		//	variables of the Player class so it can stop moving.
	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if(keyCode == KeyEvent.VK_UP){
			p1.setUP(false);
		}
		else if(keyCode == KeyEvent.VK_DOWN){
			p1.setDOWN(false);
		}
		else if(keyCode == KeyEvent.VK_LEFT){
			p1.setLEFT(false);
		}
		else if(keyCode == KeyEvent.VK_RIGHT){
			p1.setRIGHT(false);
		}

	}
	//Not used.
	@Override
	public void keyTyped(KeyEvent e) {
	

	}

}
