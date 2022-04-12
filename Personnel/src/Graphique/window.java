package Graphique;

import static commandLineMenus.rendering.examples.util.InOut.getString;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.management.DynamicMBean;

import commandLineMenus.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import personnel.Employe;
import personnel.GestionPersonnel;
import personnel.Ligue;
import personnel.SauvegardeImpossible;
public class window extends Application implements EventHandler<ActionEvent> {
	
	Button ButtonLogin;
	Button Button2;
	Stage LoginWindow;
	TextField password;
	TextField addligue;
	Scene scene1, scene2;
	Scene scene4, scene5;
	Button button3;
	Label label2;
	Label labellistligue;
	Label label3;
	ListView<Ligue> listViewligue;
	Ligue ligue;
	Button Button4;
	TextField nomligue;
	Button SupprLigue;
	Button SelectLigue;
	ListView<Employe> listViewEmploye;
	Button Back;
	Button SelectEmp;
	Employe employe;
	TextField nomEmp;
	TextField PrenomEmp;
	TextField mailEmp;
	TextField PasswordEmp;
	Button UpdateEmp;
	Label label4;
	private ObservableList<Employe> observableEmploye;
	private ObservableList<Ligue> observableLigues;
	
	@Override
	public void start (Stage primaryStage) throws SauvegardeImpossible{
		

		LoginWindow = primaryStage;
		LoginWindow.setTitle("Login");
		
		//fenetre 1
		Label label = new Label("Login");
		ButtonLogin = new Button("Login");
		ButtonLogin.setOnAction(this);
		password = new TextField("");
		
		VBox layout1 = new VBox();
		layout1.getChildren().addAll(label,password,ButtonLogin);
		scene1 = new Scene(layout1,1000,800);
		
		
		//fenetre 2
		label2 = new Label("Menu Ligue");
		Label labelcreate = new Label("Cree ligue");
		listViewligue = new ListView<>();
		observableLigues = FXCollections.observableArrayList(GestionPersonnel.getGestionPersonnel().getLigues());
		listViewligue.setItems(observableLigues);
		listViewligue.getItems();
		Button2 = new Button("←");
		Button2.setOnAction(this);
		addligue = new TextField();
		button3 = new Button("valider");
		button3.setOnAction(this);
		SupprLigue = new Button("Supprimer ligue");
		SupprLigue.setOnAction(this);
		SelectLigue = new Button("Selectionner");
		SelectLigue.setOnAction(this);
		VBox layout2 = new VBox();
		layout2.getChildren().addAll(Button2,label2, listViewligue,SupprLigue,SelectLigue,labelcreate,addligue,button3);
		scene2 = new Scene(layout2,1000,800);
		
		
		//fenetre 3
		label3 = new Label("nom ligue");
		Button4 = new Button("update Ligue");
		Button4.setOnAction(this);
		nomligue = new TextField("");
		listViewEmploye = new ListView<>();
		listViewEmploye.setItems(observableEmploye);
		listViewEmploye.getItems();
		Back = new Button("←");
		Back.setOnAction(this);
		SelectEmp = new Button("Select Employé");
		SelectEmp.setOnAction(this);
		VBox layout3 = new VBox();
		layout3.getChildren().addAll(Back,label3,nomligue,listViewEmploye,Button4,SelectEmp);
		scene4 = new Scene(layout3,1000,800);
		
		//fenetre 4
		label4 = new Label("nom emp");
		nomEmp = new TextField("");
		PrenomEmp = new TextField("");
		mailEmp = new TextField("");
		PasswordEmp = new TextField("");
		UpdateEmp = new Button("Update Emp");
		UpdateEmp.setOnAction(this);
		VBox layout4 = new VBox();
		layout4.getChildren().addAll(label4,nomEmp,PrenomEmp,mailEmp,PasswordEmp,UpdateEmp);
		scene5 = new Scene(layout4,1000,800);
		
		
		
		//La CSS scene 1
		ButtonLogin.setStyle("-fx-padding:20 40 20 40;-fx-border-radius: 20; -fx-border-color: #e2e2e2; -fx-border-width: 1; -fx-background-radius: 0; -fx-background-color: #2249A7; -fx-border-color: #2249A7; -fx-font-size: 20pt; -fx-text-fill: #d8d8d8; -fx-background-insets: 0 0 0 0, 0, 1, 2;");
		password.setStyle("-fx-margin: 50 50 50 50");
		layout1.setStyle("-fx-padding: 100 200 100 200; -fx-background-color: #222;");
		label.setStyle("-fx-text-fill: white;-fx-font-size: 40pt; -fx-padding: 50 50 50 50");
		label.setTranslateY(-200);
		password.setTranslateY(-100);
		layout1.setAlignment(Pos.CENTER);
		//CSS scene 2
		label2.setStyle("-fx-text-fill: white;-fx-font-size: 40pt; -fx-padding: 50 50 50 50");
		layout2.setStyle("-fx-padding: 50 100 50 100; -fx-background-color: #222;");
		label2.setTranslateX(200);
		label2.setTranslateY(-120);
		Button2.setStyle("-fx-background-color: red;-fx-font-size: 20pt; -fx-text-fill: #d8d8d8;");
		SupprLigue.setStyle("-fx-background-color: #2249A7;-fx-font-size: 15pt; -fx-text-fill: #d8d8d8;");
		SelectLigue.setStyle("-fx-background-color: #2249A7;-fx-font-size: 15pt; -fx-text-fill: #d8d8d8;");
		SupprLigue.setTranslateX(400);
		SupprLigue.setTranslateY(16);
		SelectLigue.setTranslateX(200);
		SelectLigue.setTranslateY(-28);
		button3.setStyle("-fx-background-color: #2249A7;-fx-font-size: 15pt; -fx-text-fill: #d8d8d8;");
		button3.setTranslateX(340);
		button3.setTranslateY(16);
		labelcreate.setStyle("-fx-text-fill: white;-fx-font-size: 20pt; -fx-padding: 10 10 10 10");
		labelcreate.setTranslateX(318);
		//CSS scene 3
		label3.setStyle("-fx-text-fill: white;-fx-font-size: 40pt; -fx-padding: 50 50 50 50");
		label3.setTranslateX(200);
		label3.setTranslateY(-120);
		layout3.setStyle("-fx-padding: 50 100 50 100; -fx-background-color: #222;");
		Button4.setStyle("-fx-background-color: #2249A7;-fx-font-size: 15pt; -fx-text-fill: #d8d8d8;");
		Button4.setTranslateX(430);
		Button4.setTranslateY(16);
		Back.setStyle("-fx-background-color: red;-fx-font-size: 20pt; -fx-text-fill: #d8d8d8;");
		SelectEmp.setStyle("-fx-background-color: #2249A7;-fx-font-size: 15pt; -fx-text-fill: #d8d8d8;");
		SelectEmp.setTranslateX(230);
		SelectEmp.setTranslateY(-28);
		//CSS scene 4
		label4.setStyle("-fx-text-fill: white;-fx-font-size: 40pt; -fx-padding: 50 50 50 50");
		layout4.setStyle("-fx-padding: 50 100 50 100; -fx-background-color: #222;");
		label4.setTranslateX(200);
		label4.setTranslateY(-50);
		UpdateEmp.setStyle("-fx-background-color: #2249A7;-fx-font-size: 15pt; -fx-text-fill: #d8d8d8;");
		UpdateEmp.setTranslateX(300);
		UpdateEmp.setTranslateY(100);
		
		
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
				observableLigues = FXCollections.observableArrayList(GestionPersonnel.getGestionPersonnel().getLigues());
				listViewligue.setItems(observableLigues);
				listViewligue.getItems();
			} catch (SauvegardeImpossible e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if(event.getSource()==SelectLigue) {
			try {
				ligue = SelectLigue(listViewligue.getSelectionModel().getSelectedItem());
				observableEmploye = FXCollections.observableArrayList(ligue.getEmployes());
				System.out.println(observableEmploye);
				System.out.println(ligue);
				System.out.println(ligue.getEmployes());
				listViewEmploye.setItems(observableEmploye);
				listViewEmploye.getItems();
				label3.setText(ligue.getNom());
				label3.getText();				
			} catch (SauvegardeImpossible e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			LoginWindow.setScene(scene4);
		}
		if(event.getSource()==SupprLigue) {
			try {
				ligue = SelectLigue(listViewligue.getSelectionModel().getSelectedItem());
				ligue.remove();
				observableLigues = FXCollections.observableArrayList(GestionPersonnel.getGestionPersonnel().getLigues());
				listViewligue.setItems(observableLigues);
				listViewligue.getItems();
			} catch (SauvegardeImpossible e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(event.getSource()==Button4) {
			ligue.setNom(nomligue.getText());
			try {
				ligue.update();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			}
		}
		if(event.getSource()==Back) {
			LoginWindow.setScene(scene2);
		}
		if(event.getSource()==SelectEmp) {
			try {
				employe = SelectEmploye(listViewEmploye.getSelectionModel().getSelectedItem());
			} catch (SauvegardeImpossible e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			observableEmploye = FXCollections.observableArrayList(ligue.getEmployes());
			System.out.println(observableEmploye);
			System.out.println(employe);
			System.out.println(employe.getLigue().getNom());
			listViewEmploye.setItems(observableEmploye);
			listViewEmploye.getItems();
			label4.setText(employe.getNom());
			label4.getText();
			nomEmp.setText(employe.getNom());
			nomEmp.getText();
			PrenomEmp.setText(employe.getPrenom());
			PrenomEmp.getText();
			mailEmp.setText(employe.getMail());
			mailEmp.getText();
			PasswordEmp.setText(employe.getPassword());
			PasswordEmp.getText();
			LoginWindow.setScene(scene5);
			
		}
		if(event.getSource()==UpdateEmp) {
			employe.setNom(nomEmp.getText());
			employe.setPrenom(PrenomEmp.getText());
			employe.setMail(mailEmp.getText());
			employe.setPassword(PasswordEmp.getText());
			try {
				employe.update();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			LoginWindow.setScene(scene4);
		}
		
	
	}
	public Ligue SelectLigue(Ligue ligue) throws SauvegardeImpossible{
		return ligue;
	}
	public Employe SelectEmploye(Employe Employe) throws SauvegardeImpossible{
		return Employe;
	}
}
	

