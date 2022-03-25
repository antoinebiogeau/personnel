package personnel;

import java.io.Serializable;
import java.sql.SQLException;
import java.time.LocalDate;

import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Repr�sente une ligue. Chaque ligue est reli�e � une liste
 * d'employ�s dont un administrateur. Comme il n'est pas possible
 * de cr�er un employ� sans l'affecter � une ligue, le root est 
 * l'administrateur de la ligue jusqu'� ce qu'un administrateur 
 * lui ait �t� affect� avec la fonction {@link #setAdministrateur}.
 */

public class Ligue implements Serializable, Comparable<Ligue>
{
	private static final long serialVersionUID = 1L;
	private int id = -1;
	private String nom;
	private SortedSet<Employe> employes;
	private Employe administrateur;
	private GestionPersonnel gestionPersonnel;
	private LocalDate dateDepart;
	
	/**
	 * Cr�e une ligue.
	 * @param nom le nom de la ligue.
	 */
	
	Ligue(GestionPersonnel gestionPersonnel, String nom) throws SauvegardeImpossible
	{
		this(gestionPersonnel, -1, nom);
		this.id = gestionPersonnel.insert(this);
	}

	Ligue(GestionPersonnel gestionPersonnel, int id, String nom)
	{
		this.nom = nom;
		employes = new TreeSet<>();
		this.gestionPersonnel = gestionPersonnel;
		administrateur = gestionPersonnel.getRoot();
		this.id = id;
	}

	/**
	 * Retourne le nom de la ligue.
	 * @return le nom de la ligue.
	 */

	public String getNom()
	{
		return nom;
	}

	/**
	 * Change le nom.
	 * @param nom le nouveau nom de la ligue.
	 */

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	/**
	 * Retourne l'administrateur de la ligue.
	 * @return l'administrateur de la ligue.
	 */
	
	public Employe getAdministrateur()
	{
		return administrateur;
	}
	
	public int getId() {
		return this.id;
	}
	/**
	 * Fait de administrateur l'administrateur de la ligue.
	 * L�ve DroitsInsuffisants si l'administrateur n'est pas 
	 * un employ� de la ligue ou le root. R�voque les droits de l'ancien 
	 * administrateur.
	 * @param administrateur le nouvel administrateur de la ligue.
	 */
	
	public void setAdministrateur(Employe administrateur)
	{
		Employe root = gestionPersonnel.getRoot();
		if (administrateur != root && administrateur.getLigue() != this)
			throw new DroitsInsuffisants();
		this.administrateur = administrateur;
		
	}

	/**
	 * Retourne les employ�s de la ligue.
	 * @return les employ�s de la ligue dans l'ordre alphab�tique.
	 */
	
	public SortedSet<Employe> getEmployes()
	{
		return Collections.unmodifiableSortedSet(employes);
		
	}

	/**
	 * Ajoute un employ� dans la ligue. Cette m�thode 
	 * est le seul moyen de cr�er un employ�.
	 * @param nom le nom de l'employ�.
	 * @param prenom le pr�nom de l'employ�.
	 * @param mail l'adresse mail de l'employ�.
	 * @param password le password de l'employ�.
	 * @param string2 
	 * @param string 
	 * @return l'employ� cr��. 
	 * @throws SauvegardeImpossible 
	 */
	public Employe addEmploye(String nom, String prenom, String mail, String password, LocalDate dateArrive, LocalDate dateDepart, int id) {
        Employe employe = new Employe(this.gestionPersonnel, this, nom, prenom, mail, password, dateArrive, dateDepart, id);
        employes.add(employe);
        return employe;
    }
	public Employe addEmploye(String nom, String prenom, String mail, String password, LocalDate date_arrivee,LocalDate date_depart) {
		Employe employe = new Employe(this.gestionPersonnel, this, nom, prenom, mail, password, date_arrivee, date_depart);
        employes.add(employe);
        return employe;
	}
	
	void remove(Employe employe)
	{
		employes.remove(employe);
	}
	/**
	 * Supprime la ligue, entra�ne la suppression de tous les employ�s
	 * de la ligue.
	 * @throws SauvegardeImpossible 
	 */
	

	@Override
	public int compareTo(Ligue autre)
	{
		return getNom().compareTo(autre.getNom());
	}
	public void remove()
	{
		gestionPersonnel.remove(this);
	}
	public void removeAdmin()
	{
		administrateur = gestionPersonnel.getRoot();
	}
	public void update() throws SQLException
	{
		try { /* TODO pas d'entre sortie enl�ve try catch*/
			gestionPersonnel.update(this);
		} catch (SauvegardeImpossible e) {
			
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString()
	{
		return nom;
	}

}
