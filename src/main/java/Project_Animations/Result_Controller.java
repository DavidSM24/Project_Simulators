package Project_Animations;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import models.Drogon;

public class Result_Controller {

	@FXML
	Label lab_result_lv;
	@FXML
	Label lab_result_score;
	@FXML
	Label lab_result_turns;
	
	public void setController(Drogon drogon, int turns) {
		lab_result_lv.setText(drogon.getLv()+"");
		lab_result_score.setText(drogon.getScore()+"");
		lab_result_turns.setText(turns+"");
	}
}
