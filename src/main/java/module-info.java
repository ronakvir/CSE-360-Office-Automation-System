module cse_360_group_project {
    requires javafx.controls;
    requires javafx.fxml;


    opens cse_360_group_project to javafx.fxml;
    exports cse_360_group_project;
    exports cse_360_group_project.Controllers;
    opens cse_360_group_project.Controllers to javafx.fxml;
}