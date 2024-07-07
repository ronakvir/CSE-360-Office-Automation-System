package cse_360_group_project.Controllers;

import cse_360_group_project.Lib.UserMockDB;
import cse_360_group_project.StartApplication;
import cse_360_group_project.Users.Doctor;
import cse_360_group_project.Users.Nurse;
import cse_360_group_project.Users.Patient;
import cse_360_group_project.Users.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static cse_360_group_project.Lib.Constants.*;

import java.io.IOException;

public class LoginController {

    @FXML
    private Label welcomeText;
    @FXML
    private TextField username;
    @FXML
    private TextField password;


    public void initStartScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(StartApplication.class.getResource("start-view.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, Y_AXIS, X_AXIS);
        stage.setScene(scene);
        stage.show();
    }

    public void initCreateAccountScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(StartApplication.class.getResource("create-account-view.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, Y_AXIS, X_AXIS);
        stage.setScene(scene);
        stage.show();
    }

    public void loginSubmit(ActionEvent event) throws IOException {
        String prefix = UserMockDB.isAlreadyUser(username.getText());
        if (prefix == null) {

            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("User Not Found");
            a.show();

            return;
        }
        User user = UserMockDB.read(prefix, username.getText());
        if (!user.getPassword().equals(password.getText())) {

            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Incorrect Password");
            a.show();

            return;
        }

        if (user instanceof Patient patient) {
            FXMLLoader loader = new FXMLLoader(StartApplication.class.getResource("patient-portal.fxml"));
            Parent root = loader.load();

            PatientPortalController controller = loader.getController();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, Y_AXIS, X_AXIS);
            stage.setScene(scene);
            stage.show();
            controller.setPatient(patient);

        } else if (user instanceof Nurse || user instanceof Doctor) {
            FXMLLoader loader = new FXMLLoader(StartApplication.class.getResource("staff-portal.fxml"));
            Parent root = loader.load();

            StaffPortalController controller = loader.getController();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, Y_AXIS, X_AXIS);
            stage.setScene(scene);
            stage.show();
            controller.setUser(user);

        }
    }
}