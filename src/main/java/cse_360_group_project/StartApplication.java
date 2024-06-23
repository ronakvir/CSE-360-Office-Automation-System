package cse_360_group_project;

import cse_360_group_project.Lib.UserMockDB;
import cse_360_group_project.Users.Patient;
import cse_360_group_project.Users.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static cse_360_group_project.Lib.Constants.*;

import java.io.IOException;

public class StartApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource("start-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), Y_AXIS, X_AXIS);
        stage.setTitle("ASU Health Portal!");
        stage.setScene(scene);
        stage.show();


        UserMockDB testDB = new UserMockDB();
        try {
            Patient p1 = new Patient("ronakkkk", "pass");
            testDB.write(p1);
            User p2 = testDB.read(p1.getDBPrefix(), p1.getUsername());
            if (p2 != null && p2 instanceof Patient) {
                Patient p3 = (Patient) p2;
                System.out.println(p3.getDBPrefix());
                System.out.println(p3.getUsername());
                System.out.println(p3.getPassword());
            }


            } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}