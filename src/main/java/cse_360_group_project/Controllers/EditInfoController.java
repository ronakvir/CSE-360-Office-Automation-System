package cse_360_group_project.Controllers;

import cse_360_group_project.Lib.UserMockDB;
import cse_360_group_project.StartApplication;
import cse_360_group_project.Users.Patient;
import cse_360_group_project.Users.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static cse_360_group_project.Lib.Constants.X_AXIS;
import static cse_360_group_project.Lib.Constants.Y_AXIS;

public class EditInfoController {
    private User staff;
    private Patient patient;
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField email;
    @FXML
    private TextField phoneNumber;


    public EditInfoController() {
    }

    public void setPatient(Patient patient) throws IOException {
        this.patient = patient;
    }

    public void setStaff(User staff) {
        this.staff = staff;
    }

    @FXML
    public void backToPortal(ActionEvent event) throws IOException {
        if (this.staff != null) {
            FXMLLoader loader = new FXMLLoader(StartApplication.class.getResource("staff-view-patient-medical-portal.fxml"));
            Parent root = loader.load();

            MedicalPortalController controller = loader.getController();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, Y_AXIS, X_AXIS);
            stage.setScene(scene);
            stage.show();
            controller.setPatient(patient);
            controller.setUser(staff);
        } else {
            FXMLLoader loader = new FXMLLoader(StartApplication.class.getResource("patient-portal.fxml"));
            Parent root = loader.load();

            PatientPortalController controller = loader.getController();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, Y_AXIS, X_AXIS);
            stage.setScene(scene);
            stage.show();
            controller.setPatient(this.patient);
        }
    }
    @FXML
    public void saveInfo(ActionEvent event) throws IOException {
        this.patient.setFirstname(firstName.getText());
        this.patient.setLastname(lastName.getText());
        this.patient.setEmail(email.getText());
        this.patient.setTelephone(phoneNumber.getText());
        UserMockDB.write(this.patient);
        this.backToPortal(event);
    }
}
