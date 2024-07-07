package cse_360_group_project.Controllers;

import cse_360_group_project.StartApplication;
import cse_360_group_project.Users.Patient;
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

public class PatientPortalController {
    private Patient patient;
    @FXML
    private Label full_name;

    public PatientPortalController() {
    }

    public void setPatient(Patient patient) throws IOException {
        this.patient = patient;

        System.out.println(patient.getUsername());
        System.out.println(patient.getLastname());
        System.out.println(patient.getFirstname());

        full_name.setText(patient.getLastname() + ", " + patient.getFirstname());

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
