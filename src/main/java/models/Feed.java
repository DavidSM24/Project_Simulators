package models;

public class Feed {
	
	private String name;
	private String description;
	private int score;
	private int acert;
	private double fury;
	private String image;
	
	public Feed(String name, String description, int score, int acert, double fury, String image) {
		super();
		this.name = name;
		this.description = description;
		this.score = score;
		this.acert = acert;
		this.fury = fury;
		this.image = image;
	}
	
	public Feed() {
		this("","",0,0,100,"");
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getAcert() {
		return acert;
	}
	public void setAcert(int acert) {
		this.acert = acert;
	}
	public double getFury() {
		return fury;
	}
	public void setFury(double fury) {
		this.fury = fury;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
}
