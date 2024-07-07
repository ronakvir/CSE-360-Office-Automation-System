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
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

import static cse_360_group_project.Lib.Constants.X_AXIS;
import static cse_360_group_project.Lib.Constants.Y_AXIS;

public class EditApptController {
    private Patient patient;
    @FXML
    private User staff;
    @FXML
    private TextField apptDate;
    @FXML
    private TextField bodyTemp;
    @FXML
    private TextField bpHigh;
    @FXML
    private TextField bpLow;
    @FXML
    private TextField reasonForVisit;
    @FXML
    private TextField weight;
    @FXML
    private TextField height;
    @FXML
    private TextField symptoms;
    @FXML
    private TextField diagnoses;
    @FXML
    private TextField prescriptions;
    @FXML
    private Text apptTitle;


    public EditApptController() {
    }

    public void setPatient(Patient patient) throws IOException {
        this.patient = patient;
        apptTitle.setText("Appointment Info for " + patient.getFirstname() + " " + patient.getLastname());
    }

    public void setUser(User staff) throws IOException {
        this.staff = staff;
    }

    public static boolean isDouble(String str)
    {
        if (str == "") { return false; }
        if (str.length() != 8) { return false; }
        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) != '.') && (str.charAt(i) < '0'
                    || str.charAt(i) > '9')) {
                return false;
            }
        }
        return true;
    }

    public static boolean isInt(String str)
    {
        if (str == "") { return false; }
        if (str.length() != 8) { return false; }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < '0'
                    || str.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

    public void saveAppointment() {
        String date = apptDate.getText();
        String regex = "[0-9]+";
        if (!isInt(date) || date.length() != 8) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Please enter date as MMDDYYYY format");
            a.show();
            return;
        }
        Appointment apt = new Appointment();
        apt.setPatient(patient.getUsername());
        apt.setDate(date);
        if (isDouble(bodyTemp.getText())) { apt.setTemp(Double.parseDouble(bodyTemp.getText())); }

        if (isInt(bpHigh.getText())) { apt.setBpHigh(Integer.parseInt(bpHigh.getText())); }

        if (isInt(bpLow.getText())) { apt.setBpHigh(Integer.parseInt(bpLow.getText())); }

        if (!reasonForVisit.getText().equals("")) { apt.setReasonForVisit(reasonForVisit.getText()); }

        if (isDouble(weight.getText())) { apt.setWeight(Double.parseDouble(weight.getText())); }

        if (isInt(height.getText())) { apt.setHeight(Integer.parseInt(height.getText())); }

        if (!symptoms.getText().equals("")) { apt.setSymptoms(symptoms.getText()); }

        if (!diagnoses.getText().equals("")) { apt.setDiagnoses(diagnoses.getText()); }

        if (!prescriptions.getText().equals(""))  { apt.setPrescriptions(prescriptions.getText()); }

        if (!apt.saveToFile()) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Error saving appointment");
            a.show();
            return;
        } else {
            return;
        }
    }

    @FXML
    public void initAppointmentsPage(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(StartApplication.class.getResource("staff-appointments-page.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, Y_AXIS, X_AXIS);
        stage.setScene(scene);
        stage.show();

        StaffAppointmentsController controller = loader.getController();
        controller.setUser(staff);
        controller.setPatient(patient);
    }
}
