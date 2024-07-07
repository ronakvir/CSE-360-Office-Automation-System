package cse_360_group_project.Controllers;

import cse_360_group_project.Lib.UserMockDB;
import cse_360_group_project.StartApplication;
import cse_360_group_project.Users.Doctor;
import cse_360_group_project.Users.Nurse;
import cse_360_group_project.Users.Patient;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import static cse_360_group_project.Lib.Constants.*;

import java.io.IOException;

public class CreateAccountController {

    @FXML
    private ComboBox<String> userTypeDropdown;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private TextField email;
    @FXML
    private TextField phone;
    @FXML
    private TextField firstname;
    @FXML
    private TextField lastname;
    @FXML
    private TextField age;
    @FXML
    private TextField emergencyname;
    @FXML
    private TextField emergencycontactphone;
    @FXML
    private TextField emergencyrelation;
    @FXML
    private Text firstnameLabel;
    @FXML
    private Text lastnameLabel;
    @FXML
    private Text ageLabel;
    @FXML
    private Text phoneLabel;
    @FXML
    private Text emailLabel;
    @FXML
    private Text contactLabel;
    @FXML
    private Text contactPhoneLabel;
    @FXML
    private Text relationLabel;
    @FXML
    public void initialize() {
        userTypeDropdown.setItems(FXCollections.observableArrayList("Patient", "Nurse", "Doctor"));
    }

    @FXML
    private void updateFormVisibility() {
        String selectedType = userTypeDropdown.getValue();
        boolean isPatient = "Patient".equals(selectedType);

        // Set visibility based on user type
        firstname.setVisible(isPatient);
        lastname.setVisible(isPatient);
        phone.setVisible(isPatient);
        email.setVisible(isPatient);
        age.setVisible(isPatient);
        emergencyname.setVisible(isPatient);
        emergencycontactphone.setVisible(isPatient);
        emergencyrelation.setVisible(isPatient);

        firstnameLabel.setVisible(isPatient);
        lastnameLabel.setVisible(isPatient);
        phoneLabel.setVisible(isPatient);
        emailLabel.setVisible(isPatient);
        ageLabel.setVisible(isPatient);
        contactLabel.setVisible(isPatient);
        contactPhoneLabel.setVisible(isPatient);
        relationLabel.setVisible(isPatient);
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
    public void createAccountSubmit(ActionEvent event) throws IOException {
        String prefix = UserMockDB.isAlreadyUser(username.getText());
        if (prefix != null) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("User already has account");
            a.show();
            return;
        }

        if (userTypeDropdown.getValue() == null) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Please select a user type");
            a.show();
            return;
        }

        if ("Patient".equals(userTypeDropdown.getValue())) {
            Patient p1 = new Patient(username.getText(), password.getText(), firstname.getText(), lastname.getText(), phone.getText(), email.getText(), emergencyname.getText(), emergencyrelation.getText(), age.getText());
            UserMockDB.write(p1);

            FXMLLoader loader = new FXMLLoader(StartApplication.class.getResource("patient-portal.fxml"));
            Parent root = loader.load();

            PatientPortalController controller = loader.getController();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, Y_AXIS, X_AXIS);
            stage.setScene(scene);
            stage.show();
            controller.setPatient(p1);

        } else if ("Nurse".equals(userTypeDropdown.getValue())) {
            System.out.println("Nurse");
            Nurse nurse = new Nurse(username.getText(), password.getText());
            UserMockDB.write(nurse);
        } else if ("Doctor".equals(userTypeDropdown.getValue())) {
            Doctor doctor = new Doctor(username.getText(), password.getText());
            UserMockDB.write(doctor);
        }
    }
}