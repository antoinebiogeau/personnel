package commandLine;

import static commandLineMenus.rendering.examples.util.InOut.getString;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import commandLineMenus.List;
import commandLineMenus.Menu;
import commandLineMenus.Option;

import personnel.*;//bah c'est avec

public class LigueConsole 
{
	private GestionPersonnel gestionPersonnel;
	private EmployeConsole employeConsole;

	public LigueConsole(GestionPersonnel gestionPersonnel, EmployeConsole employeConsole)
	{
		this.gestionPersonnel = gestionPersonnel;
		this.employeConsole = employeConsole;
	}

	Menu menuLigues()
	{
		Menu menu = new Menu("Gérer les ligues", "l");
		menu.add(afficherLigues());
		menu.add(ajouterLigue());
		menu.add(selectionnerLigue());
		menu.addBack("q");
		return menu;
	}

	private Option afficherLigues()
	{
		return new Option("Afficher les ligues", "l", () -> {System.out.println(gestionPersonnel.getLigues());});
	}

	private Option afficher(final Ligue ligue)
	{
		return new Option("Afficher la ligue", "l", 
				() -> 
				{
					System.out.println(ligue);
					System.out.println("administrée par " + ligue.getAdministrateur());
				}
		);
	}
	private Option afficherEmployes(final Ligue ligue)
	{
		return new Option("Afficher les employes", "l", () -> {try {
			System.out.println(ligue.selectEmploy�(ligue));
		} catch (SauvegardeImpossible | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}});
	}

	private Option ajouterLigue()
	{
		return new Option("Ajouter une ligue", "a", () -> 
		{
			try
			{
				gestionPersonnel.addLigue(getString("nom : "));
			}
			catch(SauvegardeImpossible exception)
			{
				System.err.println("Impossible de sauvegarder cette ligue");
			}
		});
	}
	
	private Menu editerLigue(Ligue ligue)
	{
		Menu menu = new Menu("Editer " + ligue.getNom());
		menu.add(afficher(ligue));
		menu.add(gererEmployes(ligue));
		//menu.add(changerAdministrateur(ligue));
		menu.add(changerNom(ligue));
		menu.add(supprimer(ligue));
		menu.addBack("q");
		return menu;
	}

	private Option changerNom(final Ligue ligue)
	{
		return new Option("Renommer", "r", 
				() -> {
					ligue.setNom(getString("Nouveau nom : "));
					try {
						ligue.updateLigue(ligue);
					} catch (SauvegardeImpossible | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}
				);
	}

	private List<Ligue> selectionnerLigue()
	{
		return new List<Ligue>("Sélectionner une ligue", "e", 
				() -> new ArrayList<>(gestionPersonnel.getLigues()),
				(element) -> editerLigue(element)
				);
	}
	
	private Option ajouterEmploye(final Ligue ligue)
	{
		return new Option("ajouter un employé", "a",
				() -> 
				{
					String nom, prenom, mail, password;
					LocalDate Arrivee = null, Depart = null;

					nom = getString("nom : ");
					prenom = getString("prenom : ");
					mail = getString("mail : ");
					password = getString("password : ");
					Arrivee = LocalDate.parse(parseErr("Date Arrivee (YYYY-MM-DD) : "));
					Depart = LocalDate.parse(parseErr("Date Depart (YYYY-MM-DD) : "));
					ligue.addEmploye(nom, prenom, mail, password, Arrivee, Depart);
				}
		);
	}

	public String parseErr(String str)
	{
		String args = getString(str);
		tools tools = new tools();

		if (10 == args.length() && tools.verif_forma(args))
			return args;
		try {
			throw new BonsoirNon();
		}
		catch(BonsoirNon e) {
			return parseErr(str);
		}
	}

	private Menu gererEmployes(Ligue ligue)
	{
		Menu menu = new Menu("Gérer les employés de " + ligue.getNom(), "e");
		menu.add(afficherEmployes(ligue));
		menu.add(ajouterEmploye(ligue));
		menu.add( selectionnerEmploye(ligue));
		menu.addBack("q");
		return menu;
	}
	
	
	
	private List<Employe> selectionnerEmploye(final Ligue ligue)
	{
		return new List<>("Sélectionner un lemployer", "e", 
				() -> new ArrayList<>(ligue.getEmployes()),
				employeConsole.editerEmploye()
				
				);
	}

	
	private List<Employe> changerAdministrateur(final Ligue ligue)
	{
		return null;
	}		

	private List<Employe> modifierEmploye(final Ligue ligue)
	{
		return new List<>("Modifier un employé", "e", 
				() -> new ArrayList<>(ligue.getEmployes()),
				employeConsole.editerEmploye()
				);
	}
	
	private Option supprimer(Ligue ligue)
	{
		return new Option("Supprimer", "d", () -> {
			try {
				ligue.remove()
				;
			} catch (SauvegardeImpossible e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}});
	}
	
	
}
