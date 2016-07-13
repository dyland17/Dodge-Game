package dylan.dewald.game.dodge.graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import dylan.dewald.game.dodge.Start;
import dylan.dewald.game.dodge.entities.Squares;
import dylan.dewald.game.dodge.utilities.GameTimer;

public class GameScreen extends JPanel{
	private Start game;
	private GameTimer timer;
	public GameScreen(Dimension dim,Start s){
		this.setPreferredSize(dim);
		game = s;
		timer = new GameTimer();
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		//background
		g2d.setColor(Color.black);
		g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
		//g2d.drawRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
		//foreground
		ArrayList<Squares> slist = game.getSquareHandler().getSquareList();
		int size = slist.size();
		for(int i = 0; i < size; i++)
			slist.get(i).paint(g2d);
		//drawing timer in game
		g2d.setColor(Color.WHITE);
		g2d.setFont(new Font(Font.SANS_SERIF,Font.BOLD,22));
		g2d.drawString(timer.getMinutes() + ":" + timer.getSeconds(),getWidth() - 100, 50);
	}
	public GameTimer getTimer(){
		return timer;
	}
}
