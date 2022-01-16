package Project_Animations;

import java.io.File;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import models.Thief;

public class Win_Controller {
	
	@FXML
	ImageView imv;
	
	@FXML
	Label lab_professor;
	@FXML
	Label lab_tokyo;
	@FXML
	Label lab_berlin;
	@FXML
	Label lab_dember;
	@FXML
	Label lab_moscou;
	
	@FXML
	Label lab_fox;
	@FXML
	Label lab_dragon;
	@FXML
	Label lab_eagle;
	@FXML
	Label lab_wolf;
	@FXML
	Label lab_delphin;
	
	public void setController(List<Thief> thiefs) {
		lab_professor.setText(thiefs.get(0).getScore()+"");
		lab_tokyo.setText(thiefs.get(1).getScore()+"");
		lab_berlin.setText(thiefs.get(2).getScore()+"");
		lab_dember.setText(thiefs.get(3).getScore()+"");
		lab_moscou.setText(thiefs.get(4).getScore()+"");
		
		lab_fox.setText(thiefs.get(5).getScore()+"");
		lab_dragon.setText(thiefs.get(6).getScore()+"");
		lab_eagle.setText(thiefs.get(7).getScore()+"");
		lab_wolf.setText(thiefs.get(8).getScore()+"");
		lab_delphin.setText(thiefs.get(9).getScore()+"");	
		
		Thief winner=thiefs.get(0);
		for (int i = 0; i < thiefs.size(); i++) {
			if(thiefs.get(i).getScore()>winner.getScore()) {
				winner=thiefs.get(i);
			}
		}
		File f=new File(winner.getPhoto());
		Image img=new Image("file:"+f.getPath());
		imv.setImage(img);
	}
}
