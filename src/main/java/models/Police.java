package models;

import java.util.List;

import Project_Animations.TheftSimulator_Controller;
import javafx.application.Platform;

public class Police extends Thread {

	TheftSimulator_Controller tsc;
	public Counter counter;

	public Police(TheftSimulator_Controller tsc) {
		this.tsc = tsc;
		counter = new Counter(tsc.lab_counter);
	}

	public void run() {
		//Counter counter Counter counter = new Counter(tsc.lab_counter);
		counter.start();
		try {
			counter.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
		System.out.println("voy a arrestar");
		arrest_or_stop();
	}

	public void arrest_or_stop() {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				if (tsc.treasure.getMoney() > 1) {
					tsc.imv_cross_dalies.setVisible(true);
					tsc.imv_cross_thief.setVisible(true);
				}

				tsc.stop_Simulation();
			}

		});

	}
}
