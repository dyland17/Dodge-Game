package dylan.dewald.game.dodge.utilities;

public class GameTimer {
		private int minutes;
		private int seconds;
		private final long timerStart;
		public GameTimer(){
			minutes = 0;
			seconds = 0;
			timerStart = System.currentTimeMillis();
		}
		public void update(){
			long delta = System.currentTimeMillis() - timerStart;
			if(delta >= 1000){
				seconds = (int)(delta / 1000);
				if(seconds >= 60){
					minutes = seconds / 60;
					seconds = (seconds - minutes*60);
				}
			}
			
		}
		public int getMinutes() {
			return minutes;
		}
		public int getSeconds() {
			return seconds;
		}
}
