package Project_Animations;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import models.Bowl;
import models.Drogon;
import models.Feed;

public class Feed_Simulator_Controller {

	Feed feed;
	int turns=0;
	
	Bowl bowl;
	List<Feed> feeds;

	public Drogon drogon;

	@FXML
	static MediaView media;

	@FXML
	Label lab_drogon_lv;
	@FXML
	Label lab_drogon_score;
	@FXML
	ProgressBar pb;

	@FXML
	Label lab_feed_name;
	@FXML
	Label lab_feed_description;
	@FXML
	Label lab_feed_score;
	@FXML
	Label lab_feed_fury;
	@FXML
	Label lab_feed_acert;

	@FXML
	GridPane gp_select_Buttons;

	@FXML
	ImageView imv_feed;
	@FXML
	ImageView img_button_1;
	@FXML
	ImageView img_button_2;
	@FXML
	ImageView img_button_3;

	@FXML
	public void initialize() {

		pb.setProgress(1);
		pb.setStyle("-fx-accent: green;");
		lab_drogon_score.setText(0 + "");

		bowl = new Bowl(null, this);

		drogon = new Drogon(bowl, 1, 1.0, 0);

		feeds = new ArrayList<Feed>();

		feeds.add(new Feed("Humano (Vivo)",
				"Un humano asustado el cual está vivo y coleando. Su carne blandita y su huesos crujientes son un manjar para Drogon.",
				300, 95, 0.05, "src/main/resources/images/food_human.jpg"));
		feeds.add(new Feed("Carne Humana",
				"Carne de ser humano. Aún está fresca, pero no tiene el mismo gusto a cuando aún están con vida. A Drogon le encanta.",
				225, 85, 0.10, "src/main/resources/images/food_human_meat.jpg"));
		feeds.add(new Feed("Carne de Vaca",
				"Carne de Vaca. Aún está fresca. Drogon se cansa rápido de este tipo de carnes.", 100, 55, 0.20,
				"src/main/resources/images/food_cow_meat.jpg"));
		feeds.add(new Feed("Carne de Dragón",
				"Carne de un Dragón anciano. Está en un estado mediocre. A Drogon no le gusta comer carne de Dragón.",
				300, 50, 0.50, "src/main/resources/images/food_dragon_meat.jpg"));
		feeds.add(new Feed("Cráneos",
				"Cráneos de ser humano. Crujen al ser masticados en la boca de Drogon. No son muy nutritivos. Drogon prefiere carne.",
				150, 65, 0.25, "src/main/resources/images/food_skulls.jpg"));
		feeds.add(new Feed("Ensalada de Hortalizas y Verduras",
				"Ensalada que continene una gran variedad de hortalizas y verduras. A Drogon no le gusta este tipo de comidas, llegando incluso a vomitarlas.",
				25, 50, 0.40, "src/main/resources/images/food_salad.jpg"));

		this.bowl.setEmpty(true);

		drogon.start();
		
		media=new MediaView();
		
		File filestring = new File("src/main/resources/media/feed_ost.mp3");
		Media media2 = new Media(filestring.toURI().toString());
		MediaPlayer mp = new MediaPlayer(media2);
		
		media.setMediaPlayer(mp);
		mp.play();
		
		play();
	}

	public void play() {

		// sortear y setear los 3 primeros
		Collections.shuffle(feeds);
		File f = new File(feeds.get(0).getImage());
		Image img = new Image("file:" + f.getPath());
		img_button_1.setImage(img);
		f = new File(feeds.get(1).getImage());
		img = new Image("file:" + f.getPath());
		img_button_2.setImage(img);
		f = new File(feeds.get(2).getImage());
		img = new Image("file:" + f.getPath());
		img_button_3.setImage(img);
		select_1();
		// hacer visible los botones
		gp_select_Buttons.setVisible(true);
	}

	@FXML
	public void select_1() {
		feed = feeds.get(0);
		File f = new File(feed.getImage());
		Image aux = new Image("file:" + f.getPath());
		imv_feed.setImage(aux);

		lab_feed_name.setText(feed.getName());
		lab_feed_description.setText(feed.getDescription());
		lab_feed_score.setText("+" + feed.getScore() + "");
		lab_feed_fury.setText("-" + feed.getFury() * 100 + " %");
		lab_feed_acert.setText(feed.getAcert() + " %");
	}

	@FXML
	public void select_2() {
		feed = feeds.get(1);
		File f = new File(feed.getImage());
		Image aux = new Image("file:" + f.getPath());
		imv_feed.setImage(aux);

		lab_feed_name.setText(feed.getName());
		lab_feed_description.setText(feed.getDescription());
		lab_feed_score.setText("+" + feed.getScore() + "");
		lab_feed_fury.setText("-" + feed.getFury() * 100 + " %");
		lab_feed_acert.setText(feed.getAcert() + " %");
	}

	@FXML
	public void select_3() {
		feed = feeds.get(2);
		File f = new File(feed.getImage());
		Image aux = new Image("file:" + f.getPath());
		imv_feed.setImage(aux);

		lab_feed_name.setText(feed.getName());
		lab_feed_description.setText(feed.getDescription());
		lab_feed_score.setText("+" + feed.getScore() + "");
		lab_feed_fury.setText("-" + feed.getFury() * 100 + " %");
		lab_feed_acert.setText(feed.getAcert() + " %");
	}

	@FXML
	public void to_Feed() {
		
		turns++;
		
		gp_select_Buttons.setVisible(false);
		bowl.setFeed(feed);
		synchronized (bowl) {
			bowl.notify();
		}
	}

	public void update_UI() {

		lab_drogon_lv.setText("Lv " + drogon.getLv());
		lab_drogon_score.setText(drogon.getScore() + "");

		reduce_Progress();

	}

	private void reduce_Progress() {
		new Timer().schedule(new TimerTask() { // secuencia para hpbarrier
			@Override
			public void run() {
				if (pb.getProgress() >= 0.75) {
					pb.setStyle("-fx-accent: green;");
				}

				else if (pb.getProgress() >= 0.5) {
					pb.setStyle("-fx-accent: yellow;");
				}

				else if (pb.getProgress() >= 0.25) {
					pb.setStyle("-fx-accent: orange;");
				}

				else {
					pb.setStyle("-fx-accent: red;");
				}

				pb.setProgress(pb.getProgress() - 0.0005);

				if (pb.getProgress() <= 0.01) {

					cancel();
					Platform.runLater(new Runnable() {

						@Override
						public void run() {
							// TODO Auto-generated method stub
							finish_Game();
						}
					});
				}

				if (pb.getProgress() <= drogon.getFury()) {
					cancel();
					Platform.runLater(new Runnable() {

						@Override
						public void run() {
							// TODO Auto-generated method stub
							play();
						}
					});
				}
			}

		}, 0, 1);

	}

	private void finish_Game() {
		Stage stage = (Stage) this.gp_select_Buttons.getScene().getWindow();
		stage.close();
		
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("feed_result.fxml"));
			Parent root = loader.load();
			Result_Controller rc = loader.getController();
			rc.setController(drogon, turns);
			Scene scene = new Scene(root);
			Stage stage2 = new Stage();
			stage2.setScene(scene);
			Image image= new Image("file:src/main/resources/images/gotlogo.png");
			stage2.setTitle("Resultados");
			stage2.getIcons().add(image);
			stage2.setResizable(false);;
			stage2.initModality(Modality.APPLICATION_MODAL);
			stage2.setOnCloseRequest(new EventHandler<WindowEvent>() {
				@Override
				public void handle(WindowEvent e) {
					try {
						stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
						       @Override
						       public void handle(WindowEvent e) {  	   	
						    	   
									try {
										FXMLLoader loader = new FXMLLoader(getClass().getResource("feed_simulator.fxml"));
										Parent root;
										root = loader.load();
										Scene scene= new Scene(root);
										Stage stage= new Stage();
										Image icon= new Image("file:src/main/resources/images/gotlogo.png");
										stage.getIcons().add(icon);
										stage.setTitle("Minijuego: Alimenta a Drogon");
										stage.setScene(scene);
										stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
										       @Override
										       public void handle(WindowEvent e) {
										    	   System.exit(0);
										       }
										    });
										stage.show();
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									
						       }
						    });
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			});

			stage2.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void reproduce_eating() {
		
		File filestring = new File("src/main/resources/media/eating.mp3");
		Media media2 = new Media(filestring.toURI().toString());
		MediaPlayer mp = new MediaPlayer(media2);
		
		media.setMediaPlayer(mp);
		mp.play();
	}

	public static void reproduce_success() {
		File filestring = new File("src/main/resources/media/success.mp3");
		Media media2 = new Media(filestring.toURI().toString());
		MediaPlayer mp = new MediaPlayer(media2);
		
		media.setMediaPlayer(mp);
		mp.play();
	}

	public static void reproduce_fail() {
		File filestring = new File("src/main/resources/media/fail.mp3");
		Media media2 = new Media(filestring.toURI().toString());
		MediaPlayer mp = new MediaPlayer(media2);
		
		media.setMediaPlayer(mp);
		mp.play();
	}
}
