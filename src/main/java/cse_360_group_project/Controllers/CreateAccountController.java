package cse_360_group_project.Controllers;

import cse_360_group_project.Lib.UserMockDB;
import cse_360_group_project.StartApplication;
import cse_360_group_project.Users.Nurse;
import cse_360_group_project.Users.Patient;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static cse_360_group_project.Lib.Constants.*;

import java.io.IOException;

public class CreateAccountController {

    @FXML
    private Label welcomeText;
    @FXML
    private ComboBox<String> user_type;
    @FXML
    private TextField username;
    @FXML
    private TextField password;

    @FXML
    public void initialize() {
        user_type.setItems(FXCollections.observableArrayList("Patient", "Nurse", "Doctor"));
    }


    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to Create Account Application!");
    }

    public void initStartScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(StartApplication.class.getResource("start-view.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, Y_AXIS, X_AXIS);
        stage.setScene(scene);
        stage.show();
    }

    public void createAccountSubmit(ActionEvent event) throws IOException {
        String prefix = UserMockDB.isAlreadyUser(username.getText());
        if (prefix != null) {
            return; // user was found in db
        }

        if ("Patient".equals(user_type.getValue())) {
            Patient p1 = new Patient(username.getText(), password.getText());
            UserMockDB.write(p1);
            PatientPortalController portal = new PatientPortalController();
            portal.setPatient(p1, event);
        } else if ("Nurse".equals(user_type.getValue())) {
            System.out.println("Nurse");
        }
    }
}