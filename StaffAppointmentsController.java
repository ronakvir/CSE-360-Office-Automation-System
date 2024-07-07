package cse_360_group_project.Controllers;

import cse_360_group_project.Lib.Appointment;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

import static cse_360_group_project.Lib.Constants.*;

public class StaffAppointmentsController {
    private User staff;
    private Patient patient;
    @FXML
    private VBox ApptVBox;
    @FXML
    private HBox ApptHBox, ApptHBox1, ApptHBox2, ApptHBox3, ApptHBox4;
    @FXML
    private Label ApptHboxDate, ApptHboxDate1, ApptHboxDate2, ApptHboxDate3, ApptHboxDate4;
    @FXML
    private Label AptHboxReason, AptHboxReason1, AptHboxReason2, AptHboxReason3, AptHboxReason4;

    public StaffAppointmentsController() {
    }

    public void setPatient(Patient patient) throws IOException {
        this.patient = patient;

        File dir = new File(APPOINTMENTS_DB_PATH);
        File[] foundFiles = dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.startsWith(patient.getUsername());
            }
        });

        HBox[] boxes = { ApptHBox, ApptHBox1, ApptHBox2, ApptHBox3, ApptHBox4 };
        Label[] dates = { ApptHboxDate, ApptHboxDate1, ApptHboxDate2, ApptHboxDate3, ApptHboxDate4 };
        Label[] reasons = { AptHboxReason, AptHboxReason1, AptHboxReason2, AptHboxReason3, AptHboxReason4 };
        int i = 0;
        for (File file : foundFiles) {
            if (i < 5) {
                Appointment apt = new Appointment(file);
                System.out.println(file.getName());
                boxes[i].setVisible(true);
                dates[i].setText(apt.convertDate(apt.getDate()));
                reasons[i].setText(apt.getReasonForVisit());
                System.out.println(apt.getReasonForVisit());
                i++;
            }


        }

    }

    public void setUser(User staff) throws IOException {
        this.staff = staff;
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
    public void initStaffPortal(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(StartApplication.class.getResource("staff-portal.fxml"));
        Parent root = loader.load();

        StaffPortalController controller = loader.getController();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, Y_AXIS, X_AXIS);
        stage.setScene(scene);
        stage.show();
        controller.setUser(staff);
    }

    @FXML
    public void initMedicalPortal(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(StartApplication.class.getResource("patient-medical-portal.fxml"));
        Parent root = loader.load();

        MedicalPortalController controller = loader.getController();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, Y_AXIS, X_AXIS);
        stage.setScene(scene);
        stage.show();
        controller.setUser(staff);
        controller.setPatient(patient);
    }

    @FXML
    public void initNewAppt(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(StartApplication.class.getResource("edit-appointment.fxml"));
        Parent root = loader.load();

        EditApptController controller = loader.getController();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, Y_AXIS, X_AXIS);
        stage.setScene(scene);
        stage.show();
        controller.setUser(staff);
        controller.setPatient(patient);
    }

    @FXML
    public void initEditAppt(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(StartApplication.class.getResource("edit-appointment.fxml"));
        Parent root = loader.load();

        EditApptController controller = loader.getController();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, Y_AXIS, X_AXIS);
        stage.setScene(scene);
        stage.show();
        controller.setUser(staff);
        controller.setPatient(patient);
    }



}
