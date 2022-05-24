package Graphique;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

public class Run extends Application {

    public void start(Stage primaryStage) throws IOException {

        Parent root;
        root = FXMLLoader.load(getClass().getResource("../Test.fxml"));
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.setResizable(false);
        primaryStage.setTitle("PPE - Gestion du personnel des ligues");
        primaryStage.show();
    }

    public static void main(String[] args) throws Exception {

        launch(args);
    }

}