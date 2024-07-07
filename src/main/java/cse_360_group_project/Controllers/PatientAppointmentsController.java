package cse_360_group_project.Controllers;

import static cse_360_group_project.Lib.Constants.X_AXIS;
import static cse_360_group_project.Lib.Constants.Y_AXIS;

import java.io.IOException;

import cse_360_group_project.StartApplication;
import cse_360_group_project.Users.Patient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PatientAppointmentsController {
	private Patient patient;
	
	public PatientAppointmentsController() {}
	
	public void setPatient(Patient patient) throws IOException {
        this.patient = patient;
	}
	
	@FXML
    public void backToPortal(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(StartApplication.class.getResource("patient-portal.fxml"));
        Parent root = loader.load();

        PatientPortalController controller = loader.getController();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, Y_AXIS, X_AXIS);
        stage.setScene(scene);
        stage.show();
        controller.setPatient(this.patient);
    }
	
	//TODO properly change this to reflect the updated identically named method in PatientPortalController (when done)
	@FXML
    public void initStartScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(StartApplication.class.getResource("start-view.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, Y_AXIS, X_AXIS);
        stage.setScene(scene);
        stage.show();
    }
	
	@FXML
    public void initMessagingPortal(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(StartApplication.class.getResource("messaging-portal.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, Y_AXIS, X_AXIS);
        stage.setScene(scene);
        stage.show();
    }
}
