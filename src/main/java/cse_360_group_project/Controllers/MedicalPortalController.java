package cse_360_group_project.Controllers;

import cse_360_group_project.StartApplication;
import cse_360_group_project.Users.Patient;
import cse_360_group_project.Users.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

import static cse_360_group_project.Lib.Constants.X_AXIS;
import static cse_360_group_project.Lib.Constants.Y_AXIS;

public class MedicalPortalController {
    private User staff;
    private Patient patient;
    @FXML
    private Label full_name;
    @FXML
    private Label age;
    @FXML
    private Label phone;
    @FXML
    private Text StaffName;

    public MedicalPortalController() {
    }

    public void setPatient(Patient patient) throws IOException {
        this.patient = patient;

        full_name.setText(patient.getLastname() + ", " + patient.getFirstname());
        age.setText(String.valueOf(patient.getAge()));
        phone.setText(patient.getTelephone());

    }

    public void setUser(User staff) throws IOException {
        this.staff = staff;
        StaffName.setText("Staff Member: " + staff.getUsername());
    }

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
    @FXML
    public void initAppointmentsPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(StartApplication.class.getResource("patient-appointments-page.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, Y_AXIS, X_AXIS);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void initEditInfo(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(StartApplication.class.getResource("staffEditInfo.fxml"));
        Parent root = loader.load();

        // Correctly get the EditInfoController instead of PatientPortalController
        EditInfoController controller = loader.getController();
        controller.setPatient(patient);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, Y_AXIS, X_AXIS);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void initStaffPage(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(StartApplication.class.getResource("staff-portal.fxml"));
        Parent root = loader.load();

        StaffPortalController controller = loader.getController();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, Y_AXIS, X_AXIS);
        stage.setScene(scene);
        stage.show();
        controller.setUser(staff);
    }
}
