package dylan.dewald.game.dodge.utilities;

import java.util.ArrayList;

public class Timer implements Runnable{
		private long runningTimer;
		private Object lock = new Object();
		
		ArrayList<Event> eventList;
		private boolean run = true;
		//Constructor 1
		public Timer(){
				eventList = new ArrayList<Event>();
				runningTimer = System.currentTimeMillis();
				new Thread(this, "Watch").start();
				
		}
		/**
		 * @param-event This spawns new enemies squares.
		 */
		public void setNewEvent(Event event){
				getEventList().add(event);
		}
		
		public ArrayList<Event> getEventList() {
			synchronized(lock){
					return eventList;
			}
		}
		public void stopTimer(){
				run = false;
				try {
					Thread.currentThread().join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}
		@Override
		public void run() {
			while(run){
				ArrayList<Event> list = getEventList();
				ArrayList<Event> removeList = new ArrayList<Event>();
				if(list.size() > 0){
					for(int i = 0; i < list.size(); i++){
						if(list.get(i).getTime() < System.currentTimeMillis()){
							list.get(i).setTimeReached(true);
						}
						if(list.get(i).getAdded() == true){
							removeList.add(list.get(i));
						}

					}
					list.removeAll(removeList);
				}

				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		public long getTimeInSeconds(){
				return System.currentTimeMillis() - runningTimer;
		}
	}
