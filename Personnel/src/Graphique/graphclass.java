package Graphique;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import personnel.GestionPersonnel;
import personnel.Ligue;
import personnel.SauvegardeImpossible;

public class graphclass extends Application implements EventHandler<ActionEvent>{
	
	public Stage window(Stage primaryStage){
		Stage LoginWindow = primaryStage;
		LoginWindow.setTitle("M2L");
		return LoginWindow;
	}
	public Button buttonLogin() {
		Button ButtonLogin = new Button("Login");
		ButtonLogin.setOnAction(this);
		ButtonLogin.setStyle("-fx-padding:20 40 20 40;-fx-border-radius: 20; -fx-border-color: #e2e2e2; -fx-border-width: 1; -fx-background-radius: 0; -fx-background-color: #2249A7; -fx-border-color: #2249A7; -fx-font-size: 20pt; -fx-text-fill: #d8d8d8; -fx-background-insets: 0 0 0 0, 0, 1, 2;");
		return ButtonLogin;
		
	}
	public Button button(String nom) {
		Button Button = new Button(nom);
		Button.setOnAction(this);
		return Button;
	}
	public Button Retour() {
		Button Back = new Button("←");
		Back.setOnAction(this);
		return Back;
	}
	public ListView ListLigue() throws SauvegardeImpossible {
		ObservableList<Ligue> observableLigues = FXCollections.observableArrayList(GestionPersonnel.getGestionPersonnel().getLigues());
		ListView <Ligue> listViewligue = new ListView<>();
		listViewligue.setItems(observableLigues);
		listViewligue.getItems();
		return listViewligue;
	}
	public TextField input() {
		TextField input = new TextField();
		return input;
	}
	public Label titre(String text) {
		Label title = new Label(text);
		title.setStyle("-fx-text-fill: white;-fx-font-size: 40pt; -fx-padding: 50 50 50 50");
		title.setTranslateY(-200);
		return title;
	}
	public PasswordField password() {
		PasswordField password = new PasswordField();
		password.setStyle("-fx-margin: 50 50 50 50");
		password.setTranslateY(-100);
		return password;
	}
	public Scene layout1() {
		VBox layout1 = new VBox();
		layout1.getChildren().addAll(titre("login"),password(),buttonLogin());
		Scene scene1 = new Scene(layout1,1000,800);
		layout1.setStyle("-fx-padding: 100 200 100 200; -fx-background-color: #222;");
		layout1.setAlignment(Pos.CENTER);
		return scene1;
	}
	public VBox layout2() throws SauvegardeImpossible {
		VBox layout2 = new VBox();
		layout2.getChildren().addAll(Retour(),titre("Menu Ligue"), ListLigue(),button("suivant"));
		layout2.setStyle("-fx-padding: 100 200 100 200; -fx-background-color: #222;");
		layout2.setAlignment(Pos.CENTER);
		return layout2;
	}
	public Scene scene(VBox layout) throws SauvegardeImpossible {
		Scene scene2 = new Scene(layout,1000,800);
		return scene2;
	}
	public static void main(String[] args) {
		
	    launch(args);
	    
	 }
	public void handle(ActionEvent event, Stage stage) throws SauvegardeImpossible {
		if(event.getSource()==this.button("suivant")) {
			System.out.println("prout");
			window(stage).setScene(layout1());
		}	
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		window(arg0).setScene(scene(layout2()));
		window(arg0).show();
	}
	public void handle(ActionEvent e) {
		
		// TODO Auto-generated method stub
	}
}
