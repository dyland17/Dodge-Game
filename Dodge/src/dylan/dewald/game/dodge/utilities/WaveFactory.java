package dylan.dewald.game.dodge.utilities;

import java.util.ArrayList;

import dylan.dewald.game.dodge.Start;
import dylan.dewald.game.dodge.entities.*;
import dylan.dewald.game.dodge.enums.DiagnolDirection;
import dylan.dewald.game.dodge.enums.RainSpeed;

public class WaveFactory {
	public static void Wave1(Timer timer){
		double endpoint = 9.5 * 40;
		double lastSecond = 9.5+(9.5 *.25);
		for(double i = .5; i < 10; i += .50)
			timer.setNewEvent(new Event(i+.25, new RainSquare(i*40,50, RainSpeed.FAST)));
		
		for(double x = .5; x < 10; x += .50){
			lastSecond += .25;
			timer.setNewEvent(new Event(lastSecond, new RainSquare((endpoint - (x*40)),50, RainSpeed.FAST)));
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
