package cse_360_group_project.Controllers;

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
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

import static cse_360_group_project.Lib.Constants.X_AXIS;
import static cse_360_group_project.Lib.Constants.Y_AXIS;

public class MessagingPortalController {
    private User user;
    @FXML
    private Label full_name;
    @FXML
    private Label age;
    @FXML
    private Label phone;

    public MessagingPortalController() {
    }

    public void setUser(User user) throws IOException {
        this.user = user;
    }


    @FXML
    public void initMessageDraft(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(StartApplication.class.getResource("message-draft-view.fxml"));
        Parent root = loader.load();

        MessagingDraftController controller = loader.getController();
        controller.setUser(user);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, Y_AXIS, X_AXIS);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void initBack(ActionEvent event) throws IOException {
        System.out.println("back");
        if (this.user instanceof Nurse || this.user instanceof Doctor) {
            FXMLLoader loader = new FXMLLoader(StartApplication.class.getResource("staff-portal.fxml"));
            Parent root = loader.load();

            StaffPortalController controller = loader.getController();
            controller.setUser(user);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, Y_AXIS, X_AXIS);
            stage.setScene(scene);
            stage.show();
        } else if (this.user instanceof Patient patient) {
            System.out.println("true");
            FXMLLoader loader = new FXMLLoader(StartApplication.class.getResource("patient-portal.fxml"));
            Parent root = loader.load();
            PatientPortalController controller = loader.getController();
            controller.setPatient(patient);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, Y_AXIS, X_AXIS);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    public void initStartScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(StartApplication.class.getResource("start-view.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, Y_AXIS, X_AXIS);
        stage.setScene(scene);
        stage.show();
    }

}
