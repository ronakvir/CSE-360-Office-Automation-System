module com.example.cse_360_group_project {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cse_360_group_project to javafx.fxml;
    exports com.example.cse_360_group_project;
}