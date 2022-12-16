package commandLine;

import static commandLineMenus.rendering.examples.util.InOut.getString;

import java.sql.SQLException;

import commandLineMenus.ListOption;
import commandLineMenus.Menu;
import commandLineMenus.Option;
import personnel.Employe;
import personnel.Ligue;
import personnel.SauvegardeImpossible;
//Jamaais de debug ici ou d'appel de methode de la base de donnée tu doit toujours passer par employe ou gestion personnel a lalimite mais evite passe par employe
public class EmployeConsole 
{
	private Option afficher(final Employe employe)
	{
		return new Option("Afficher l'employé", "l", () -> {System.out.println(employe);});
	}


	ListOption<Employe> editerEmploye()
	{
		return (employe) -> editerEmploye(employe);		
	}
	//Option sert a ajouter une option dans un menu (ici editerEmploye) et menu bah c'est ton menu et .add c'est pour
	//ajouter une option dans le menu
	Option editerEmploye(Employe employe)
	{
			Menu menu = new Menu("Gérer le compte " + employe.getNom(), "c");
			menu.add(afficher(employe));
			menu.add(changerNom(employe));
			menu.add(changerPrenom(employe));
			menu.add(changerMail(employe));
			menu.add(changerPassword(employe));
			menu.add(supprimerEmploye(employe));
			menu.add(MetAdmin(employe));
			menu.addBack("q");
			return menu;
	}
// permet de changer le nom de l'employe dans la console
	private Option changerNom(final Employe employe)
	{
		return new Option("Changer le nom", "n", 
				() -> {
					employe.setNom(getString("Nouveau nom : "));
					try {
						employe.update();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					}
			);
	}
	// permet de changer le prenom de l'employe dans la console
	private Option changerPrenom(final Employe employe)
	{
		return new Option("Changer le prénom", "p", () -> {
			employe.setPrenom(getString("Nouveau prénom : "));
			try {
				employe.update();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			;});
	}
	// permet de changer le mail de l'employe dans la console
	private Option changerMail(final Employe employe)
	{
		return new Option("Changer le mail", "e", () -> {
			employe.setMail(getString("Nouveau mail : "));
			try {
				employe.update();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			});
	}
	// permet de changer le password de l'employe dans la console
	
	private Option changerPassword(final Employe employe)
	{
		return new Option("Changer le password", "x", () -> {
			employe.setPassword(getString("Nouveau password : "));
			try {
				employe.update();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			});
	}
	// permet de supprimer l'employe dans la console
	private Option supprimerEmploye(final Employe employe) {
		return new Option("supprimer", "r", () -> {try {
			employe.remove();
		} catch (SauvegardeImpossible e) {
			e.printStackTrace();
		}});
	}
	// permet de mettre l'employe en admin dans la console
	private Option MetAdmin(final Employe employe) {
		Ligue ligue = employe.getLigue();
		return new Option("Met admin de la ligue", "k", () -> {
			ligue.setAdministrateur(employe);
			});
	}

}
