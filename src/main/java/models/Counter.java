package models;

import javafx.application.Platform;
import javafx.scene.control.Label;

public class Counter extends Thread {

	private int min;
	private int seconds;
	private Label label;

	public Counter(Label label) {
		min = (int) (Math.random() * 0);
		seconds = 5;
		this.label = label;
	}

	public int getMin() {
		return min;
	}

	public int getSeconds() {
		return seconds;
	}

	public void setMin(int min) {
		this.min=min;
	}
	
	public void setSeconds(int seconds) {
		this.seconds=seconds;
	}
	
	@Override
	public void run() {
		while (min != 0 || seconds != 0 && !interrupted()) {

			Platform.runLater(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					label.setText(converter());
				}
			});

			seconds--;
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
			}

			// algoritmo tiempo

			if (seconds == 0) {
				if(min>0) {
					seconds=60;
					min--;
				}
			}

		}
	}

	public String converter() {
		String result = "";

		if (min < 10) {
			result += "0" + min;
		} else {
			result += min;
		}

		result += " : ";

		if (seconds < 10) {
			result += "0" + seconds;
		} else {
			result += seconds;
		}

		return result;
	}
}
