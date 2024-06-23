package cse_360_group_project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static cse_360_group_project.Constants.*;

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
            testDB.testPut("ronak", "password");
            testDB.testGet("ronak");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}