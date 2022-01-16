module Project_Animations {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.media;

    opens Project_Animations to javafx.fxml;
    exports Project_Animations;
}
