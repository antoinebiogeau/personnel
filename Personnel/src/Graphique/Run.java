package Graphique;

import java.io.File;

import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Run extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
                                         
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Run.class.getResource("../Graphique/Test.fxml"));
            Parent page = loader.load();  
             
         
            Scene scene = new Scene(page);
            primaryStage.setTitle("Test Fenetres");
             
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
     
    public static void main(String[] args) {
        launch(args);
    }
}