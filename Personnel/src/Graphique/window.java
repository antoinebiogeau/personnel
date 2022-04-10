package Graphique;

import static commandLineMenus.rendering.examples.util.InOut.getString;

import java.util.ArrayList;

import commandLineMenus.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import personnel.GestionPersonnel;
import personnel.Ligue;
import personnel.SauvegardeImpossible;
public class window extends Application implements EventHandler<ActionEvent> {
	public void gg() throws SauvegardeImpossible {
		GestionPersonnel gestionPersonnel = GestionPersonnel.getGestionPersonnel();
	}
	
	Button ButtonLogin;
	Button Button2;
	Stage LoginWindow;
	TextField password;
	TextField addligue;
	Scene scene1, scene2, scene3;
	Button button3;
	Label label2;
	Label labellistligue;
	Label label3;
	ListView<String> listViewligue;
	Ligue ligue;
	
	@Override
	public void start (Stage primaryStage) throws SauvegardeImpossible{
		

		LoginWindow = primaryStage;
		LoginWindow.setTitle("Login");
		Label label = new Label("Login");
		//fenetre 1
		
		ButtonLogin = new Button("Login");
		ButtonLogin.setOnAction(this);
		password = new TextField("");
		
		VBox layout1 = new VBox(20);
		layout1.getChildren().addAll(label,password,ButtonLogin);
		scene1 = new Scene(layout1,300,250);
		
		
		//fenetre 2
		label2 = new Label("Menu Ligue");
		listViewligue = new ListView<>();
		
		listViewligue.getItems().addAll(GestionPersonnel.getGestionPersonnel().getLigues().toString().split(" "));
		
		Button2 = new Button("Back");
		Button2.setOnAction(this);
		addligue = new TextField();
		button3 = new Button("valider");
		button3.setOnAction(this);
		
		VBox layout2 = new VBox(20);
		layout2.getChildren().addAll(Button2,label2, listViewligue,addligue,button3);
		scene2 = new Scene(layout2,400,300);
		
		
		//fenetre 3
		label3 = new Label("");
		ButtonLogin = new Button("Login");
		ButtonLogin.setOnAction(this);
		password = new TextField("");
		
		VBox layout3 = new VBox(20);
		layout3.getChildren().addAll(label,password,ButtonLogin);
		scene3 = new Scene(layout3,300,250);
		
		LoginWindow.setScene(scene1);
		LoginWindow.show();
	}
	
	

	public static void main(String[] args) {
	    launch(args);
	 }

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		if(event.getSource()==ButtonLogin) {
			System.out.println(password.getText());
			try {
				if(GestionPersonnel.getGestionPersonnel().getRoot().checkPassword(password.getText())) {
				LoginWindow.setScene(scene2);
				}
				else {
					System.out.println("wrong password");
				}
			} catch (SauvegardeImpossible e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(event.getSource()==Button2) {
			System.out.println("prout2");
			LoginWindow.setScene(scene1);
		}
		if(event.getSource()==button3) {
			System.out.println("pouf");
			try {
				GestionPersonnel.getGestionPersonnel().addLigue(addligue.getText());
				listViewligue.getItems().removeAll(GestionPersonnel.getGestionPersonnel().getLigues().toString().split(" "));
				listViewligue.getItems().addAll(GestionPersonnel.getGestionPersonnel().getLigues().toString().split(" "));
			} catch (SauvegardeImpossible e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if(event.getSource()==listViewligue) {
			int x = listViewligue.getSelectionModel().getSelectedIndex();
			
			LoginWindow.setScene(scene3);
			
		}
		
	
}
}
	

