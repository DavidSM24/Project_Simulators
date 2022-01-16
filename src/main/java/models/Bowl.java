package models;

import Project_Animations.Feed_Simulator_Controller;
import javafx.application.Platform;

public class Bowl {

	private boolean empty;
	private Feed feed;
	private Feed_Simulator_Controller fsc;

	public Bowl() {
		this.empty = true;
		this.feed = new Feed();
		this.fsc=null;
	}

	public Bowl(Feed feed, Feed_Simulator_Controller fsc) {
		super();
		this.empty=true;
		this.feed = feed;
		this.fsc=fsc;
	}

	public boolean isEmpty() {
		return empty;
	}

	public void setEmpty(boolean empty) {
		this.empty = empty;
	}

	public Feed getFeed() {
		return feed;
	}	
	
	public void setFeed(Feed feed) {
		this.feed=feed;
		
		if(this.feed!=null) {
			empty=false;
		}
		else {
			empty=true;
		}
		
	}
	
	public synchronized void eat() {
		// comprobar acierto y calcular
		while(isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			Feed_Simulator_Controller.reproduce_eating();
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				fsc.drogon.do_Changes();
				fsc.update_UI();
			}
		});
		
		empty=true;
		notifyAll();
		
		//poner interfaz para elegir
	}
}
