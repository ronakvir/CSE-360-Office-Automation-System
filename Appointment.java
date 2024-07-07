package cse_360_group_project.Lib;

import cse_360_group_project.Users.User;
import java.util.Scanner;
import java.io.*;

import static cse_360_group_project.Lib.Constants.APPOINTMENTS_DB_PATH;
import static cse_360_group_project.Lib.Constants.USER_DB_PATH;

public class Appointment {
    String patient = "empty";
    String date = "empty";
    double temp = 0.0;
    int bpHigh = 0;
    int bpLow = 0;
    String reasonForVisit = "None given";
    double weight = 0.0;
    int height = 0;
    String symptoms = "empty";
    String diagnoses = "empty";
    String prescriptions = "empty";

    public Appointment() {
    }

    public Appointment(File file) {
        boolean read = readFile(file);
    }

    public String getPatient() { return patient; }
    public String getDate() { return date; }
    public double getTemp() { return temp; }
    public int getBpHigh() { return bpHigh; }
    public int getBpLow() { return bpLow; }
    public String getReasonForVisit() { return reasonForVisit; }
    public double getWeight() { return weight; }
    public int getHeight() { return height; }
    public String getSymptoms() { return symptoms; }
    public String getDiagnoses() { return diagnoses; }
    public String getPrescriptions() { return prescriptions; }

    public void setPatient(String patient) { this.patient = patient; }
    public void setDate(String date) { this.date = date; }
    public void setTemp(double temp) { this.temp = temp; }
    public void setBpHigh(int bpHigh) { this.bpHigh = bpHigh; }
    public void setBpLow(int bpLow) { this.bpLow = bpLow; }
    public void setReasonForVisit(String reasonForVisit) { this.reasonForVisit = reasonForVisit; }
    public void setWeight(double weight) { this.weight = weight; }
    public void setHeight(int height) { this.height = height; }
    public void setSymptoms(String symptoms) { this.symptoms = symptoms; }
    public void setDiagnoses(String diagnoses) { this.diagnoses = diagnoses; }
    public void setPrescriptions(String prescriptions) { this.prescriptions = prescriptions; }

    public boolean saveToFile()  {
        if (patient == "empty") { return false; }
        if (date == "empty") { return false; }
        String filename = (APPOINTMENTS_DB_PATH + "/" + patient + "_" + date + ".txt");
        try {
            File output = new File(filename);
            boolean created = output.createNewFile(); }
        catch (Exception e) {
            return false;
        }

        PrintWriter out;
        try {
            out = new PrintWriter(filename);
            out.println(patient);
            out.println(date);
            out.println(temp);
            out.println(bpHigh);
            out.println(bpLow);
            out.println(reasonForVisit);
            out.println(weight);
            out.println(height);
            out.println(symptoms);
            out.println(diagnoses);
            out.println(prescriptions);
            out.close();
        } catch (FileNotFoundException e) {
            return false;
        }
        return true;
    }

    boolean readFile(File file) {
        /*if (patient == "empty") { return false; }
        if (date == "empty") { return false; }
        String filename = (patient + "_" + date + ".txt");
        File input = new File(filename);*/
        Scanner in;
        try {
            in = new Scanner(file);
        } catch (FileNotFoundException e) {
            return false;
        }
        setPatient(in.nextLine());
        setDate(in.nextLine());
        setTemp(in.nextDouble());
        setBpHigh(in.nextInt());
        setBpLow(in.nextInt());
        in.nextLine();
        setReasonForVisit(in.nextLine());
        setWeight(in.nextDouble());
        setHeight(in.nextInt());
        in.nextLine();
        setSymptoms(in.nextLine());
        setDiagnoses(in.nextLine());
        setPrescriptions(in.nextLine());
        in.close();

        return true;

    }

    public String convertDate(String date) {
        if(date.length() != 8) { return date; }
        String newDate = date.substring(0, 2) + "/" + date.substring(2, 4) + "/" + date.substring(4, 8);
        return newDate;
    }


}

