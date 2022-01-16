package models;

import Project_Animations.TheftSimulator_Controller;

public class Thief extends Thread{

	private String alias;
	private Treasure treasure;
	private int money;
	private int score;
	private Bag bag;
	String photo;
	TheftSimulator_Controller tsc;
	
	public Thief(String alias, Treasure treasure, int money,int score, Bag bag, String photo,TheftSimulator_Controller tsc) {
		super();
		this.alias = alias;
		this.treasure = treasure;
		this.money = money;
		this.score=score;
		this.bag=bag;
		this.photo=photo;
		this.tsc=tsc;
	}
	
	public Thief() {
		this("",new Treasure(),0,0, new Bag(),"",null);
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String name) {
		this.alias = name;
	}

	public Treasure getTreasure() {
		return treasure;
	}

	public void setTreasure(Treasure treasure) {
		this.treasure = treasure;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "Thief [name=" + alias + ", treasure=" + treasure + ", money=" + money + "]";
	}
	
	public synchronized void steal_Gold() {
		int n=(int) (Math.random()*(30 + 10));
		if(n==0) n=1;
		money+=treasure.take_Money_Out(n);	
		score+=money;
		to_Bag();
	}
	
	public synchronized void to_Bag() {
		
		int n2=(int) (Math.random()*(3000 + 1000));
		try {
			Thread.sleep(n2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			interrupt();
		}
		bag.deposit_Money(money);
		money=0;
	}
	
	@Override
	public void run() {
		try {
			while(!treasure.isEmpty()&&!interrupted()) steal_Gold();
			tsc.stop_Simulation();
		} catch (Exception e) {
			// TODO: handle exception
		}	
		
		
	}
}
