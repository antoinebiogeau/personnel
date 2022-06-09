package Graphique;
import java.sql.SQLException;

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
import personnel.Employe;
import personnel.GestionPersonnel;
import personnel.Ligue;
import personnel.SauvegardeImpossible;

public class graphclass extends Application implements EventHandler<ActionEvent>{
	Button button;
	PasswordField password;
	Stage window;
	TextField nomLigue;
	Ligue ligue;
	Employe employe;
	ObservableList<Ligue> observableLigues;
	ListView <Ligue> listViewligue;
	
	public Stage window(Stage primaryStage){
		Stage LoginWindow = primaryStage;
		LoginWindow.setTitle("M2L");
		window = LoginWindow;
		return LoginWindow;
	}
	public Button buttonLogin(){
		Button ButtonLogin = new Button("Login");
		ButtonLogin.setOnAction(new EventHandler<ActionEvent>() {

		    @Override
		    public void handle(ActionEvent event) {
		    	System.out.println("clique");
		    	System.out.println(password.getText());
		    	try {
					if(GestionPersonnel.getGestionPersonnel().getRoot().checkPassword(password.getText())) {
						window.setScene(scene(layout2()));
					}
				} catch (SauvegardeImpossible e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    }
		});
		ButtonLogin.setStyle("-fx-padding:20 40 20 40;-fx-border-radius: 20; -fx-border-color: #e2e2e2; -fx-border-width: 1; -fx-background-radius: 0; -fx-background-color: #2249A7; -fx-border-color: #2249A7; -fx-font-size: 20pt; -fx-text-fill: #d8d8d8; -fx-background-insets: 0 0 0 0, 0, 1, 2;");
		return ButtonLogin;
	}
	public Button GestionRoot() {
		Button GestionRoot = new Button("Gerer le Root");
		GestionRoot.setOnAction(new EventHandler<ActionEvent>() {

		    @Override
		    public void handle(ActionEvent event) {
		    	System.out.println("clique");
					try {
							window.setScene(scene(layout3()));
					} catch (SauvegardeImpossible e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    }
		});
		GestionRoot.setStyle("-fx-padding:20 40 20 40;-fx-border-radius: 20; -fx-border-color: #e2e2e2; -fx-border-width: 1; -fx-background-radius: 0; -fx-background-color: #2249A7; -fx-border-color: #2249A7; -fx-font-size: 20pt; -fx-text-fill: #d8d8d8; -fx-background-insets: 0 0 0 0, 0, 1, 2;");
		return GestionRoot;
	}
	public Button GestionLigue() {
		Button GestionLigue = new Button("Gerer les Ligues");
		GestionLigue.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	System.out.println("clique");
					try {
						window.setScene(scene(layout3()));
					} catch (SauvegardeImpossible e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    }
		});
		GestionLigue.setStyle("-fx-padding:20 40 20 40;-fx-border-radius: 20; -fx-border-color: #e2e2e2; -fx-border-width: 1; -fx-background-radius: 0; -fx-background-color: #2249A7; -fx-border-color: #2249A7; -fx-font-size: 20pt; -fx-text-fill: #d8d8d8; -fx-background-insets: 0 0 0 0, 0, 1, 2;");
		return GestionLigue;
	}
	public Button Quitter() {
		Button Quitter = new Button("Quitter");
		Quitter.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	System.out.println("clique");
					window.close();
		}});
		Quitter.setStyle("-fx-padding:20 40 20 40;-fx-border-radius: 20; -fx-border-color: #e2e2e2; -fx-border-width: 1; -fx-background-radius: 0; -fx-background-color: #2249A7; -fx-border-color: #2249A7; -fx-font-size: 20pt; -fx-text-fill: #d8d8d8; -fx-background-insets: 0 0 0 0, 0, 1, 2;");
		return Quitter;
	}
	
	public Button button() {
		button = new Button("update");
		button.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	System.out.println("pouf");
		    	ligue = listViewligue.getSelectionModel().getSelectedItem();
		    	System.out.println(ligue);
				ligue.setNom(nomLigue.getText());
				System.out.println(ligue);
				try {
					ligue.update();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		});
		button.setStyle("-fx-padding:20 40 20 40;-fx-border-radius: 20; -fx-border-color: #e2e2e2; -fx-border-width: 1; -fx-background-radius: 0; -fx-background-color: #2249A7; -fx-border-color: #2249A7; -fx-font-size: 20pt; -fx-text-fill: #d8d8d8; -fx-background-insets: 0 0 0 0, 0, 1, 2;");
		return button;
	}
	public Button Retour() {
		Button Back = new Button("←");
		Back.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	System.out.println("clique");
					System.out.println(ligue.getNom());
		    }
		});
		Back.setStyle("-fx-padding:20 40 20 40;-fx-border-radius: 20; -fx-border-color: #e2e2e2; -fx-border-width: 1; -fx-background-radius: 0; -fx-background-color: #2249A7; -fx-border-color: #2249A7; -fx-font-size: 20pt; -fx-text-fill: #d8d8d8; -fx-background-insets: 0 0 0 0, 0, 1, 2;");
		return Back;
	}
	Button AjouterLigue() {
		Button AjouterLigue = new Button("ajouter Ligue");
		AjouterLigue.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	System.out.println(nomLigue.getText());
					try {
						GestionPersonnel.getGestionPersonnel().addLigue(nomLigue.getText());
					} catch (SauvegardeImpossible e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    }
		});
		AjouterLigue.setStyle("-fx-padding:20 40 20 40;-fx-border-radius: 20; -fx-border-color: #e2e2e2; -fx-border-width: 1; -fx-background-radius: 0; -fx-background-color: #2249A7; -fx-border-color: #2249A7; -fx-font-size: 20pt; -fx-text-fill: #d8d8d8; -fx-background-insets: 0 0 0 0, 0, 1, 2;");
		return AjouterLigue;
	}
	Button SelectLigue() {
		Button SelectLigue = new Button("selectionner ligue");
		SelectLigue.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	System.out.println(ligue = listViewligue.getSelectionModel().getSelectedItem());
		    }
		});
		SelectLigue.setStyle("-fx-padding:20 40 20 40;-fx-border-radius: 20; -fx-border-color: #e2e2e2; -fx-border-width: 1; -fx-background-radius: 0; -fx-background-color: #2249A7; -fx-border-color: #2249A7; -fx-font-size: 20pt; -fx-text-fill: #d8d8d8; -fx-background-insets: 0 0 0 0, 0, 1, 2;");
		return SelectLigue;
	}
	public ListView<Ligue> ListLigue() throws SauvegardeImpossible {
		observableLigues = FXCollections.observableArrayList(GestionPersonnel.getGestionPersonnel().getLigues());
		listViewligue = new ListView<>();
		listViewligue.setItems(observableLigues);
		listViewligue.getItems();
		return listViewligue;
	}
	public TextField input() {
		nomLigue = new TextField();
		return nomLigue;
	}
	public Label titre(String text) {
		Label title = new Label(text);
		title.setStyle("-fx-text-fill: white;-fx-font-size: 40pt; -fx-padding: 50 50 50 50");
		title.setTranslateY(-200);
		return title;
	}
	public PasswordField password() {
		password = new PasswordField();
		password.setStyle("-fx-margin: 50 50 50 50");
		password.setTranslateY(-100);
		return password;
	}
	public Label titreL(String text){
		Label titre = new Label(text);
		titre.setStyle("-fx-text-fill: white;-fx-font-size: 40pt; -fx-padding: 50 50 50 50");
		return titre;
	}
	
	public VBox layout1() {
		Button Login  = buttonLogin();
		Login.setOnAction(this);
		buttonLogin().setOnAction(this);
		VBox layout1 = new VBox();
		layout1.getChildren().addAll(titreL("Login"),password(),buttonLogin());
		layout1.setStyle("-fx-padding: 100 200 100 200; -fx-background-color: #222;");
		layout1.setAlignment(Pos.CENTER);
		return layout1;
	}
	public VBox layout2() {
		VBox layout2 = new VBox();
		layout2.getChildren().addAll(GestionRoot(), GestionLigue(), Quitter());
		layout2.setStyle("-fx-padding: 100 200 100 200; -fx-background-color: #222;");
		layout2.setAlignment(Pos.CENTER);
		return layout2;
	}
	public VBox layout3() throws SauvegardeImpossible {
		VBox layout3 = new VBox();
		layout3.getChildren().addAll(Retour(),titre("Menu Ligue"), ListLigue(), titre("Ajouter Ligue"),input(),AjouterLigue(),SelectLigue(),button());
		layout3.setStyle("-fx-padding: 100 200 100 200; -fx-background-color: #222;");
		layout3.setAlignment(Pos.CENTER);
		return layout3;
	}

	public Scene scene(VBox layout) throws SauvegardeImpossible {
		Scene scene2 = new Scene(layout,1000,800);
		return scene2;
	}
	public static void main(String[] args) {
		
	    launch(args);
	    
	 }
	

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		window(arg0).setScene(scene(layout1()));
		window(arg0).show();
	}
	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}
}
