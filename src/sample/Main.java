package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

import java.sql.SQLException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Student Management Project.");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 1600, 900));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void init() throws SQLException {
        Students.getInstance().loadData();
    }

    @Override
    public void stop() throws SQLException {
        Students.getInstance().saveData();
    }
}
