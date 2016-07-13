package dylan.dewald.game.dodge.utilities;

import dylan.dewald.game.dodge.entities.Squares;

public class Event {
		private long eventTime;
		private boolean timeReached,added = false;
		
		private Squares eventEnemy;
		
		//vvvvvv Gonna have to specify an enemy
					//vvvvvvvv to go along with this event.
		public Event(double time, Squares enemy){
					eventTime = (long)(System.currentTimeMillis() + (time * 1000));
					timeReached = false;
					eventEnemy = enemy;
		}
		
		public long  getTime(){
					return eventTime;
		}
		public Squares getEventEnemy()
		{
					return eventEnemy;
		}
		public void setTimeReached(boolean b){
				timeReached = b;
		}
		public boolean getTimeReached(){
			return timeReached;
		}

		public void setAdded(boolean b) {
			added = b;
			
		}
		public boolean getAdded(){
			return added;
		}
}
