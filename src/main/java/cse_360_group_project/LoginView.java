package cse_360_group_project;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class LoginView {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}