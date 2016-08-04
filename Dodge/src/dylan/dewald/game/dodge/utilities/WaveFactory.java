package dylan.dewald.game.dodge.utilities;

import java.util.ArrayList;

import dylan.dewald.game.dodge.Start;
import dylan.dewald.game.dodge.entities.*;
import dylan.dewald.game.dodge.enums.DiagnolDirection;
import dylan.dewald.game.dodge.enums.RainSpeed;

public class WaveFactory {
	private static double secInterval;
	public static void Wave1(){
		double endpoint = 9.5 * 40;
		double lastSecond = 0.0;
		secInterval = .50;
		for(double i = .5; i < 10; i += .50){
			lastSecond += secInterval;
			Start.eventTimer.setNewEvent(new Event(lastSecond, new RainSquare( i*45,50, RainSpeed.FAST)));
		}
		for(double x = .5; x < 10; x += .50){
			lastSecond += secInterval;
			Start.eventTimer.setNewEvent(new Event(lastSecond, new RainSquare((endpoint - (x*42)),50, RainSpeed.FAST)));
		}
		secInterval = 0.0;
		int spaceOffset = 40;
		for(int n = 1; n <= 5; n++){
			lastSecond += secInterval;
			Start.eventTimer.setNewEvent(new Event(lastSecond, new DiagnolSquare(n,spaceOffset*n, DiagnolDirection.DOWNRIGHT)));
			Start.eventTimer.setNewEvent(new Event(lastSecond, new DiagnolSquare(n,(spaceOffset*n)+40,DiagnolDirection.UPRIGHT)));
		}
			
		
	}
	public static void Wave1(ArrayList<Squares> list){
		DiagnolSquare enemy = new DiagnolSquare(50,200,DiagnolDirection.DOWNLEFT);
		list.add(enemy);
		
		DiagnolSquare enemy2 = new DiagnolSquare((Start.screenWidth / 2 - 20),50, DiagnolDirection.UPLEFT);
		list.add(enemy2);
		
		DiagnolSquare enemy3 = new DiagnolSquare((Start.screenWidth / 2 - 20), (Start.screenHeight - 80), DiagnolDirection.DOWNRIGHT);
		list.add(enemy3);
		
		DiagnolSquare enemy4 = new DiagnolSquare((Start.screenWidth - 60),200, DiagnolDirection.UPRIGHT);
		list.add(enemy4);
		
	}
}
