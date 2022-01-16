package models;

import Project_Animations.TheftSimulator_Controller;
import javafx.application.Platform;
import javafx.scene.control.Label;

public class Bag {

	private Label label;
	private int money;

	public Bag(int money, Label label) {
		this.money=money;
		this.label=label;
	}
	
	public Bag() {
		money=0;
	}
	
	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "Bag [money=" + money + "]";
	}
	
	public synchronized void deposit_Money(int n){
		this.money+=n;
		Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				label.setText(money+"");
			}
		});
	}
	
}
