package models;

import Project_Animations.TheftSimulator_Controller;
import javafx.application.Platform;

public class Treasure {

	private int money;
	private boolean empty;
	private TheftSimulator_Controller tsc;

	public Treasure() {
		this.money = 7500;
		this.empty = false;
		this.tsc = null;
	}

	public Treasure(int money, TheftSimulator_Controller tsc) {
		this.money = money;
		this.empty = false;
		this.tsc = tsc;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public boolean isEmpty() {
		return empty;
	}

	public void setEmpty(boolean empty) {
		this.empty = empty;
	}

	@Override
	public String toString() {
		return "Treasure [money=" + money + ", empty=" + empty + "]";
	}

	public synchronized int take_Money_Out(int amount) {

		if (this.money >= amount) {
			this.money -= amount;
			Platform.runLater(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					tsc.lab_treasure.setText(money + "");
				}
			});
			if(money==0) empty=true;
			return amount;
		} else {
			int result = this.money;
			this.money = 0;
			this.empty=true;
			Platform.runLater(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					tsc.lab_treasure.setText(money + "");
				}
			});
			empty = true;
			return result;
		}
	}

}
