package Project_Animations;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import models.Bag;
import models.Counter;
import models.Police;
import models.Thief;
import models.Treasure;

public class TheftSimulator_Controller {

	@FXML
	GridPane gp;
	@FXML
	TextField txt_min;
	@FXML
	TextField txt_seconds;
	@FXML
	TextField txt_treasure;
	
	@FXML
	Button btn_start;
	
	@FXML
	public Label lab_treasure;
	@FXML
	public Label lab_dalis;
	@FXML
	public Label lab_thiefs;
	@FXML
	public Label lab_counter;
	
	public Police police=new Police(this);
	
	public Treasure treasure;

	Bag dalis;
	Bag villains;

	Thief professor;
	Thief tokyo;
	Thief berlin;
	Thief dember;
	Thief moscou;

	Thief fox;
	Thief dragon;
	Thief eagle;
	Thief wolf;
	Thief delphin;

	@FXML
	public ImageView imv_cross_dalies;
	@FXML
	public ImageView imv_cross_thief;
	@FXML
	ImageView imv_dalies;
	@FXML
	ImageView imv_thiefs;
	@FXML
	ImageView imv_treasure;
	@FXML
	ImageView imv_money1;
	@FXML
	ImageView imv_money2;

	@FXML
	public void initialize() {
		treasure = new Treasure(7500, this);
		this.lab_treasure.setText(treasure.getMoney() + "");
		this.lab_dalis.setText(0 + "");
		this.lab_thiefs.setText(0 + "");
		
		
	}

	@FXML
	public void start_Simulation() {
		try {
			imv_cross_dalies.setVisible(false);
			imv_cross_thief.setVisible(false);
			
			if(!txt_treasure.getText().matches("")) {
				int n=Integer.parseInt(txt_treasure.getText());
				if(n<1000) {
					treasure=new Treasure(7500,this);
				}
				else{
					treasure = new Treasure(Integer.parseInt(txt_treasure.getText()), this);
				}
			}
			else {
				treasure=new Treasure(7500,this);
			}
			
			lab_treasure.setText(treasure.getMoney()+"");
			
			dalis=new Bag(0,lab_dalis);
			villains=new Bag(0,lab_thiefs);
			
			this.lab_treasure.setText(treasure.getMoney() + "");
			this.lab_dalis.setText(0 + "");
			this.lab_thiefs.setText(0 + "");

			professor = new Thief("professor", treasure, 0,0, dalis,"src/main/resources/images/professor.jpg",this);
			tokyo = new Thief("tokyo", treasure, 0,0, dalis,"src/main/resources/images/tokyo.jpg",this);
			berlin = new Thief("berlin", treasure,0, 0, dalis,"src/main/resources/images/berlin.jpg",this);
			dember = new Thief("dember", treasure, 0,0, dalis,"src/main/resources/images/dember.jpg",this);
			moscou = new Thief("moscou", treasure, 0,0, dalis,"src/main/resources/images/moscou.jpg",this);

			fox = new Thief("fox", treasure, 0,0, villains,"src/main/resources/images/ladrones.jpg",this);
			dragon = new Thief("dragon", treasure, 0,0, villains,"src/main/resources/images/ladrones.jpg",this);
			eagle = new Thief("eagle", treasure, 0,0, villains,"src/main/resources/images/ladrones.jpg",this);
			wolf = new Thief("wolf", treasure, 0,0, villains,"src/main/resources/images/ladrones.jpg",this);
			delphin = new Thief("delphin", treasure, 0,0, villains,"src/main/resources/images/ladrones.jpg",this);
			
			police=new Police(this);
			
			if(!txt_min.getText().matches("")) {
				police.counter.setMin(Integer.parseInt(txt_min.getText()));
			}
			
			if(!txt_seconds.getText().matches("")) {
				police.counter.setSeconds(Integer.parseInt(txt_seconds.getText()));
			}
			
			professor.start();
			tokyo.start();
			berlin.start();
			dember.start();
			moscou.start();
			
			fox.start();
			dragon.start();
			eagle.start();
			wolf.start();
			delphin.start();
			
			btn_start.setDisable(true);
			
			police.start();	
			
			gp.setVisible(false);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@FXML
	public void stop_Simulation() {
		
		professor.interrupt();
		tokyo.interrupt();
		berlin.interrupt();
		dember.interrupt();
		moscou.interrupt();
		
		fox.interrupt();
		dragon.interrupt();
		eagle.interrupt();
		wolf.interrupt();
		delphin.interrupt();
		
		btn_start.setDisable(false);
		
		police.interrupt();
		open_Windows();
		gp.setVisible(true);
	}
	
	public void open_Windows(){	
		if(treasure.getMoney()==0) {
			try {

				Stage close = (Stage) this.btn_start.getScene().getWindow();
				close.close();
				
				FXMLLoader loader = new FXMLLoader(getClass().getResource("win.fxml"));
				Parent root = loader.load();
				Win_Controller wc=loader.getController();
				List<Thief> list = new ArrayList<Thief>(List.of(professor,tokyo,berlin,dember,moscou,fox,dragon,eagle,wolf,delphin));
				wc.setController(list);
				Scene scene= new Scene(root);
				Stage stage= new Stage();
				//Image icon= new Image("file:src/main/resources/images/icons/icon_chara_creator.jpg");
				//stage.getIcons().add(icon);
				stage.setTitle("Resultados");
				stage.setScene(scene);
				stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
				       @Override
				       public void handle(WindowEvent e) {  	   	
							
							try {
								FXMLLoader loader = new FXMLLoader(getClass().getResource("theft_Simulation.fxml"));
								Parent root;
								root = loader.load();
								Scene scene= new Scene(root);
								Stage stage= new Stage();
								//Image icon= new Image("file:src/main/resources/images/icons/icon_chara_creator.jpg");
								//stage.getIcons().add(icon);
								stage.setTitle("Resultados");
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
				stage.show();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				
			}
		}
		else {
			
		}
	}
}