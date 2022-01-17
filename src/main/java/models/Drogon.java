package models;

import Project_Animations.Feed_Simulator_Controller;

public class Drogon extends Thread {

	private Bowl bowl;
	private int lv;
	private static double fury;
	private int score;

	public Drogon(Bowl bowl, int lv, double fury, int score) {
		super();
		this.bowl = bowl;
		this.lv = lv;
		this.fury = fury;
		this.score = score;
	}

	public Drogon() {
		this(new Bowl(), 0, 0, 0);
	}

	public Bowl getBowl() {
		return bowl;
	}

	public int getLv() {
		return lv;
	}

	public void setLv(int lv) {
		this.lv = lv;
	}

	public static double getFury() {
		return fury;
	}

	public void setFury(double fury) {
		this.fury = fury;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void setBowl(Bowl bowl) {
		this.bowl = bowl;
	}

	public void do_Changes() {
		// comprobar acierto y calcular
		int n = (int) (Math.random() * 100);

		switch (lv) {
		case 2:
			n -= 5;
			break;
		case 3:
			n -= 8;
			break;
		case 4:
			n -= 10;
			break;
		case 5:
			n -= 12;
			break;
		}

		if (n <= bowl.getFeed().getAcert()) { // acierto
			score += bowl.getFeed().getScore();
			Feed_Simulator_Controller.reproduce_success();
			
		} else { // error
			score -= bowl.getFeed().getScore();
			if (score < 0)
				score = 0;
			fury -= bowl.getFeed().getFury();
			if (fury > 1)
				fury = 1;
			if (fury < 0)
				fury = 0.0;
			
			Feed_Simulator_Controller.reproduce_fail();
		}
		// calcular lv
		if (score > 999)
			lv = 2;
		if (score > 2999)
			lv = 3;
		if (score > 4999)
			lv = 4;
		if (score > 6999)
			lv = 5;
		if(score<1000)
			lv = 1;
	}

	@Override
	public void run() {

		while (true) {
			bowl.eat();
		}

		// presentar pantalla final

	}
}
