package cse_360_group_project;

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

    }

    public static void main(String[] args) {
        launch();
    }
}