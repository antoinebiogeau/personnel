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
import javafx.scene.control.DatePicker;
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
	ObservableList<Employe> observableEmp;
	ListView <Employe> listViewEmp;
	TextField nomEmp;
	TextField PrenomEmp;
	TextField mailEmp;
	DatePicker DateArriv = new DatePicker();
	DatePicker DateDep = new DatePicker();
	TextField PasswordEmp;

	
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
		GestionRoot.setTranslateY(-10);
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
		Quitter.setTranslateY(10);
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
		button.setTranslateX(300);
		button.setTranslateY(-100);
		button.setStyle("-fx-padding:20 40 20 40;-fx-border-radius: 20; -fx-border-color: #e2e2e2; -fx-border-width: 1; -fx-background-radius: 0; -fx-background-color: #2249A7; -fx-border-color: #2249A7; -fx-font-size: 20pt; -fx-text-fill: #d8d8d8; -fx-background-insets: 0 0 0 0, 0, 1, 2;");
		return button;
	}
	public Button Retour() {
		Button Back = new Button("←");
		Back.setTranslateX(-400);
		Back.setTranslateY(-40);
		Back.setStyle("-fx-background-color: red;-fx-font-size: 20pt; -fx-text-fill: #d8d8d8;");
		Back.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	System.out.println("clique");
		    	try {
					window.setScene(scene(layout2()));
				} catch (SauvegardeImpossible e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
		    }
		});
		return Back;
	}
	public Button RetourSelect() {
		Button Back = new Button("←");
		Back.setTranslateX(-400);
		Back.setTranslateY(-40);
		Back.setStyle("-fx-background-color: red;-fx-font-size: 20pt; -fx-text-fill: #d8d8d8;");
		Back.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	System.out.println("clique");
		    	try {
					window.setScene(scene(layout4()));
				} catch (SauvegardeImpossible e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
		    }
		});
		return Back;
	}
	public Button RetourModif() {
		Button Back = new Button("←");
		Back.setTranslateX(-400);
		Back.setTranslateY(-40);
		Back.setStyle("-fx-background-color: red;-fx-font-size: 20pt; -fx-text-fill: #d8d8d8;");
		Back.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	System.out.println("clique");
		    	try {
					window.setScene(scene(layout4()));
				} catch (SauvegardeImpossible e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
		    }
		});
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
		AjouterLigue.setTranslateX(-300);
		AjouterLigue.setTranslateY(60);
		AjouterLigue.setStyle("-fx-padding:20 40 20 40;-fx-border-radius: 20; -fx-border-color: #e2e2e2; -fx-border-width: 1; -fx-background-radius: 0; -fx-background-color: #2249A7; -fx-border-color: #2249A7; -fx-font-size: 20pt; -fx-text-fill: #d8d8d8; -fx-background-insets: 0 0 0 0, 0, 1, 2;");
		return AjouterLigue;
	}
	Button SelectLigue() {
		Button SelectLigue = new Button("selectionner ligue");
		SelectLigue.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	ligue = listViewligue.getSelectionModel().getSelectedItem();
		    	try {
					window.setScene(scene(layout4()));
				} catch (SauvegardeImpossible e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		    
		});
		SelectLigue.setTranslateX(20);
		SelectLigue.setTranslateY(-20);
		SelectLigue.setStyle("-fx-padding:20 40 20 40;-fx-border-radius: 20; -fx-border-color: #e2e2e2; -fx-border-width: 1; -fx-background-radius: 0; -fx-background-color: #2249A7; -fx-border-color: #2249A7; -fx-font-size: 20pt; -fx-text-fill: #d8d8d8; -fx-background-insets: 0 0 0 0, 0, 1, 2;");
		return SelectLigue;
	}
	public Button RetourLigue() {
		Button Back = new Button("←");
		Back.setTranslateX(-400);
		Back.setTranslateY(-40);
		Back.setStyle("-fx-background-color: red;-fx-font-size: 20pt; -fx-text-fill: #d8d8d8;");
		Back.setOnAction(new EventHandler<ActionEvent>() {
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
		return Back;
	}
	Button SelectEmp() {
		Button SelectEmp = new Button("Modifier employé");
		SelectEmp.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	employe = listViewEmp.getSelectionModel().getSelectedItem();
		    	nomEmp.setText(employe.getNom());
		    	PrenomEmp.setText(employe.getPrenom());
		    	mailEmp.setText(employe.getMail());
		    	PasswordEmp.setText(employe.getPassword());
		    	try {
					window.setScene(scene(Layout6()));
				} catch (SauvegardeImpossible e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		});
		SelectEmp.setTranslateX(-300);
		SelectEmp.setTranslateY(-50);
		SelectEmp.setStyle("-fx-padding:20 40 20 40;-fx-border-radius: 20; -fx-border-color: #e2e2e2; -fx-border-width: 1; -fx-background-radius: 0; -fx-background-color: #2249A7; -fx-border-color: #2249A7; -fx-font-size: 20pt; -fx-text-fill: #d8d8d8; -fx-background-insets: 0 0 0 0, 0, 1, 2;");
		return SelectEmp;
	}
	Button AddEmp() {
		Button AddEmp = new Button("Ajouter employé");
		AddEmp.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	try {
					window.setScene(scene(Layout5()));
				} catch (SauvegardeImpossible e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }});
		AddEmp.setTranslateX(-6);
		AddEmp.setTranslateY(112);
		AddEmp.setStyle("-fx-padding:20 40 20 40;-fx-border-radius: 20; -fx-border-color: #e2e2e2; -fx-border-width: 1; -fx-background-radius: 0; -fx-background-color: #2249A7; -fx-border-color: #2249A7; -fx-font-size: 20pt; -fx-text-fill: #d8d8d8; -fx-background-insets: 0 0 0 0, 0, 1, 2;");
		return AddEmp;
	}
	Button SupprEmp() {
		Button SupprEmp = new Button("Supprimer employé");
		SupprEmp.setTranslateX(300);
		SupprEmp.setTranslateY(30);
		SupprEmp.setStyle("-fx-padding:20 40 20 40;-fx-border-radius: 20; -fx-border-color: #e2e2e2; -fx-border-width: 1; -fx-background-radius: 0; -fx-background-color: #2249A7; -fx-border-color: #2249A7; -fx-font-size: 20pt; -fx-text-fill: #d8d8d8; -fx-background-insets: 0 0 0 0, 0, 1, 2;");
		return SupprEmp;
	}
	public ListView<Ligue> ListLigue() throws SauvegardeImpossible {
		observableLigues = FXCollections.observableArrayList(GestionPersonnel.getGestionPersonnel().getLigues());
		listViewligue = new ListView<>();
		listViewligue.setItems(observableLigues);
		listViewligue.getItems();
		listViewligue.setStyle("fx-height : 25");
		return listViewligue;
	}
	public ListView<Employe> ListEmp() throws SauvegardeImpossible {
		observableEmp = FXCollections.observableArrayList(ligue.getEmployes());
		listViewEmp = new ListView<>();
		listViewEmp.setItems(observableEmp);
		listViewEmp.getItems();
		return listViewEmp;
	}
	public TextField input() {
		nomLigue = new TextField();
		return nomLigue;
	}
	public Label titre(String text) {
		Label title = new Label(text);
		title.setStyle("-fx-text-fill: white;-fx-font-size: 40pt;");
		title.setTranslateY(-170);
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
		titre.setTranslateY(-100);
		titre.setStyle("-fx-text-fill: white;-fx-font-size: 40pt; -fx-padding: 50 50 50 50");
		return titre;
	}
	public Label texte(String text){
		Label titre = new Label(text);
		titre.setStyle("-fx-text-fill: white;-fx-font-size: 10pt; -fx-padding: 5 5 5 5");
		return titre;
	}
	public TextField NomEmp() {
		nomEmp = new TextField();
		return nomEmp;
	}
	public TextField prenomEmp() {
		PrenomEmp = new TextField();
		return PrenomEmp;
	}
	public TextField mailEmp() {
		mailEmp = new TextField();
		return mailEmp;
	}
	public TextField passwordEmp() {
		PasswordEmp= new TextField();
		return PasswordEmp;
	}
	Button AjouterEmp() {
		Button AddEmp = new Button("Push employé");
		AddEmp.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	try {
		    		ligue.addEmploye(nomEmp.getText(),PrenomEmp.getText(),mailEmp.getText(),PasswordEmp.getText(),DateArriv.getValue(),DateDep.getValue());
					window.setScene(scene(layout4()));
				} catch (SauvegardeImpossible e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }});
		AddEmp.setStyle("-fx-padding:20 40 20 40;-fx-border-radius: 20; -fx-border-color: #e2e2e2; -fx-border-width: 1; -fx-background-radius: 0; -fx-background-color: #2249A7; -fx-border-color: #2249A7; -fx-font-size: 20pt; -fx-text-fill: #d8d8d8; -fx-background-insets: 0 0 0 0, 0, 1, 2;");
		return AddEmp;
	}
	Button UpdateEmp() {
		Button AddEmp = new Button("modifier employé");
		AddEmp.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	try {
		    		employe.setNom(nomEmp.getText());
		    		employe.setNom(PrenomEmp.getText());
		    		employe.setNom(mailEmp.getText());
		    		employe.setNom(PasswordEmp.getText());
		    		employe.update();
					window.setScene(scene(layout4()));
				} catch (SauvegardeImpossible | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }});
		AddEmp.setStyle("-fx-padding:20 40 20 40;-fx-border-radius: 20; -fx-border-color: #e2e2e2; -fx-border-width: 1; -fx-background-radius: 0; -fx-background-color: #2249A7; -fx-border-color: #2249A7; -fx-font-size: 20pt; -fx-text-fill: #d8d8d8; -fx-background-insets: 0 0 0 0, 0, 1, 2;");
		return AddEmp;
	}
	
	
	public VBox Layout5() throws SauvegardeImpossible{
		VBox layout5 = new VBox();
		layout5.getChildren().addAll(RetourModif(),titreL("Cree un employé"),texte("nom"),NomEmp(),texte("prenom"),prenomEmp(),texte("mail"),mailEmp(),texte("password"),passwordEmp(),DateArriv,DateDep, AjouterEmp());
		layout5.setStyle("-fx-padding: 100 200 100 200; -fx-background-color: #222;");
		return layout5;
	}
	public VBox Layout6() throws SauvegardeImpossible{
		VBox layout6 = new VBox();
		layout6.setStyle("-fx-padding: 100 200 100 200; -fx-background-color: #222;");
		layout6.getChildren().addAll( RetourSelect(),titreL("Modifier un employé"),texte("nom"),NomEmp(),texte("prenom"),prenomEmp(),texte("mail"),mailEmp(),texte("password"),passwordEmp(),UpdateEmp());
		return layout6;
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
		layout2.getChildren().addAll(titreL("Menu"),GestionRoot(), GestionLigue(), Quitter());
		layout2.setStyle("-fx-padding: 100 200 100 200; -fx-background-color: #222;");
		layout2.setAlignment(Pos.CENTER);
		return layout2;
	}
	public VBox layout3() throws SauvegardeImpossible {
		VBox layout3 = new VBox();
		layout3.getChildren().addAll(Retour(),titre("Menu Ligue"), titre("Ajouter Ligue"), ListLigue(),input(),AjouterLigue(),SelectLigue(),button());
		layout3.setStyle("-fx-padding: 100 200 100 200; -fx-background-color: #222;");
		layout3.setAlignment(Pos.CENTER);
		return layout3;
	}
	public VBox layout4() throws SauvegardeImpossible{
		VBox layout4 = new VBox();
		layout4.getChildren().addAll(RetourLigue(),titre(ligue.getNom()),ListEmp(),AddEmp(), SupprEmp(), SelectEmp());
		layout4.setStyle("-fx-padding: 100 200 100 200; -fx-background-color: #222;");
		layout4.setAlignment(Pos.CENTER);
		return layout4;
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
