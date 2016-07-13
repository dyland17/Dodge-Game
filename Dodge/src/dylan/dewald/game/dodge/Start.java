package dylan.dewald.game.dodge;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;

import dylan.dewald.game.dodge.entities.Player;
import dylan.dewald.game.dodge.entities.Squares;
import dylan.dewald.game.dodge.graphics.GameScreen;
import dylan.dewald.game.dodge.utilities.Event;
import dylan.dewald.game.dodge.utilities.KeyMover;
import dylan.dewald.game.dodge.utilities.SquareHandler;
import dylan.dewald.game.dodge.utilities.Timer;
import dylan.dewald.game.dodge.utilities.WaveFactory;

public class Start implements Runnable{
	//Resolution
	public static int screenWidth = 460;
	public static int screenHeight = 460;
	//Components for graphics
	private JFrame window;
	private GameScreen screen;
	//Game utilities
	private SquareHandler squares;
	private Container c;
	private Timer eventTimer;
	public Start(){
		Dimension frameDim = new Dimension(screenWidth,screenHeight);
		//initiating variables
		window = new JFrame("Dodge");
		c = window.getContentPane();
		screen = new GameScreen(frameDim,this);
		squares = new SquareHandler(this);
		
		
		window.setPreferredSize(frameDim);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		c.add(BorderLayout.CENTER,screen);
		window.pack();
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		
		screen.requestFocusInWindow();
		
		//adding the player
		squares.getSquareList().add(new Player((screen.getWidth()/2),(screen.getHeight()/2)));
		screen.addKeyListener(new KeyMover((Player) squares.getSquareList().get(0)));
		window.setVisible(true);
	}
	
	public static void main(String[] args) {
		Start newGame = new Start();
		newGame.startGame();

	}
	/**
	 * @category-EndingPoint
	 * <br>		
	 * This is called to end the game.
	 */
	private void stopGame(){
		try {
			Thread.currentThread().join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	/**
	 * @category-StartingPoint
	 * <br>
	 * 	This is the starting point and
	 * 	is called to start the game loop.
	 */
	private void startGame() {
		//IMPORTANT=====@s.n. waveFactory will add new events to Timer. 
		Thread gameThread = new Thread(this,"Game");
		gameThread.start();
		eventTimer = new Timer();
		WaveFactory.Wave1(eventTimer);
	}
	/**
	 * @category-GameLoop
	 * <br>
	 * This is the game loop and starts the game logic
	 * and loops it.
	 */
	@Override
	public void run() {
		boolean running = true;
		int fps = 0, updates = 0;
		
		final double ns = 1000000000.0 / 60.0;
		long lastTime = System.nanoTime();
		double delta = 0.0;
		long timer = System.currentTimeMillis();
		
		while (running == true){
				
				long now = System.nanoTime();
				delta += (now - lastTime) / ns;
				lastTime = now;
				
				while( delta >= 1){
					fps++;
					screen.repaint();
					updates++;
					update();
					delta--;
				}
				//Checking fps stats.
				if(System.currentTimeMillis() - timer >= 1000){
					System.out.println("Fps: " + fps + " updates: " + updates);
					fps = 0;
					updates = 0;
					timer = System.currentTimeMillis();
				}
				
			}
		stopGame();
	}
	
	private void update() {
		squares.update();
		updateTimer();
	}
	public void updateTimer(){
			screen.getTimer().update();
	}
	public Timer getEventTimer(){
		if(eventTimer != null)
			return eventTimer;
		else
			return null;
	}
	public SquareHandler getSquareHandler(){
		return squares;
	}
}
