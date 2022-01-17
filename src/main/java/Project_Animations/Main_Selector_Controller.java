package Project_Animations;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main_Selector_Controller {

	@FXML
	Button btn_feed;
	
	@FXML
	public void open_Theft_Simulator() {
		
		Stage stage = (Stage) this.btn_feed.getScene().getWindow();
		stage.close();
		
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("theft_Simulation.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			Stage stage2 = new Stage();
			stage2.setScene(scene);
			Image image= new Image("file:src/main/resources/images/lcplogo.png");
			stage2.setTitle("Simulación: Robo al Tesoro Nacional");
			stage2.getIcons().add(image);
			stage2.setOnCloseRequest(new EventHandler<WindowEvent>() {
				@Override
				public void handle(WindowEvent e) {
					try {
						System.exit(0);
					} catch (Exception e2) {
						// TODO: handle exception
					}
					
				}
			});

			stage2.show();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@FXML
	public void open_Feed_Simulator() {
		
		Stage stage = (Stage) this.btn_feed.getScene().getWindow();
		stage.close();
		
		try {		
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("feed_simulator.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			Stage stage2 = new Stage();
			stage2.setScene(scene);
			Image image= new Image("file:src/main/resources/images/gotlogo.png");
			stage2.setTitle("Minijuego: Alimenta a Drogon");
			stage2.getIcons().add(image);
			stage2.setOnCloseRequest(new EventHandler<WindowEvent>() {
				@Override
				public void handle(WindowEvent e) {
					try {
						System.exit(0);
					} catch (Exception e2) {
						// TODO: handle exception
					}
					
				}
			});

			stage2.show();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
