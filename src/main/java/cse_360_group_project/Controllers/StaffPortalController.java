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
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

import static cse_360_group_project.Lib.Constants.X_AXIS;
import static cse_360_group_project.Lib.Constants.Y_AXIS;

public class StaffPortalController {
    private User staff;
    @FXML
    private TextField username;
    @FXML
    private Text welcomeuser;

    public StaffPortalController() {
    }

    public void setUser(User staff) throws IOException {
        this.staff = staff;

        System.out.println(staff.getUsername());

        welcomeuser.setText("Welcome " + staff.getUsername());

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
        FXMLLoader loader = new FXMLLoader(StartApplication.class.getResource("messaging-portal.fxml"));
        Parent root = loader.load();
        MessagingPortalController controller = loader.getController();
        controller.setUser(staff);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, Y_AXIS, X_AXIS);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void initMedicalPortal(ActionEvent event) throws IOException {
        String patientSearch = username.getText();
        String prefix = UserMockDB.isAlreadyUser(patientSearch);
            if (prefix == null) {

                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("User Not Found");
                a.show();

                return;
            }
            User user = UserMockDB.read(prefix, patientSearch);
            if (user instanceof Patient patient) {
                FXMLLoader loader = new FXMLLoader(StartApplication.class.getResource("staff-view-patient-medical-portal.fxml"));
                Parent root = loader.load();

                MedicalPortalController controller = loader.getController();

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root, Y_AXIS, X_AXIS);
                stage.setScene(scene);
                stage.show();
                controller.setPatient(patient);
                controller.setUser(staff);


            } else  {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("Username is not a patient");
                a.show();

                return;

            }
        }
    }
