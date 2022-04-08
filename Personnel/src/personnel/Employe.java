package personnel;

import java.io.Serializable;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.TreeSet;

/**
 * Employ� d'une ligue h�berg�e par la M2L. Certains peuvent 
 * �tre administrateurs des employ�s de leur ligue.
 * Un seul employ�, rattach� � aucune ligue, est le root.
 * Il est impossible d'instancier directement un employ�, 
 * il faut passer la m�thode {@link Ligue#addEmploye addEmploye}.
 */

public class Employe implements Serializable, Comparable<Employe>
{
	private static final long serialVersionUID = 4795721718037994734L;
	private String nom, prenom, password, mail;
	private Ligue ligue;
	private GestionPersonnel gestionPersonnel;
	private LocalDate dateArrivee;
	private LocalDate dateDepart;
	private int id = -1;
	
	Employe(GestionPersonnel gestionPersonnel, Ligue ligue, String nom, String prenom, String mail, String password, LocalDate dateArrivee, LocalDate datedepart) 	{
		this.gestionPersonnel = gestionPersonnel;
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
		this.mail = mail;
		this.ligue = ligue;
		this.dateArrivee = dateArrivee;
		this.dateDepart = datedepart;
		try {
			this.id = gestionPersonnel.insert(this);
		} catch (SauvegardeImpossible e) {
			e.printStackTrace();
		} 
	}
	Employe(GestionPersonnel gestionPersonnel, Ligue ligue, String nom, String prenom, String mail, String password, LocalDate dateArrivee, LocalDate datedepart, int id)
	{
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
		this.mail = mail;
		this.ligue = ligue;
		this.dateArrivee = dateArrivee;
		this.dateDepart = datedepart;
		
			
		this.gestionPersonnel = gestionPersonnel;
		this.id = id;
	}
	/**
	 * Retourne vrai ssi l'employ� est administrateur de la ligue 
	 * pass�e en param�tre.
	 * @return vrai ssi l'employ� est administrateur de la ligue 
	 * pass�e en param�tre.
	 * @param ligue la ligue pour laquelle on souhaite v�rifier si this 
	 * est l'admininstrateur.
	 */
	
	public boolean estAdmin(Ligue ligue)
	{
		return ligue.getAdministrateur() == this;
	}
	public int getid() {
		return this.id;
	}
	
	/**
	 * Retourne vrai ssi l'employ� est le root.
	 * @return vrai ssi l'employ� est le root.
	 */
	
	public boolean estRoot()
	{
		return gestionPersonnel.getRoot() == this;
	}
	
	
	
	public LocalDate getDateArrivee() 
	{
		return dateArrivee;
	}
	
	public void setDateArrivee(LocalDate dateArrivee) throws DateImpossible
	{
		if(dateArrivee != null && dateDepart != null && dateArrivee.isBefore(dateDepart))
			throw new DateImpossible();
		else 
		{
			this.dateArrivee = dateArrivee;
		}
			
	}
	
	
	public LocalDate getDateDepart() 
	{
		return dateDepart;
	}
	
	public void setDateDepart(LocalDate dateDepart) throws DateImpossible
	{
		if(dateArrivee != null && dateDepart != null && dateDepart.isAfter(dateArrivee))
			throw new DateImpossible();
		else 
		{
			this.dateDepart = dateDepart;
		}
			
	}
	public int getIdLigue() {
		return this.ligue.getId();
	}
	
	/**
	 * Retourne le nom de l'employ�.
	 * @return le nom de l'employ�. 
	 */
	
	public String getNom()
	{
		return nom;
	}

	/**
	 * Change le nom de l'employ�.
	 * @param nom le nouveau nom.
	 */
	
	public void setNom(String nom)
	{
		this.nom = nom;
	}

	/**
	 * Retourne le pr�nom de l'employ�.
	 * @return le pr�nom de l'employ�.
	 */
	
	public String getPrenom()
	{
		return prenom;
	}
	
	/**
	 * Change le pr�nom de l'employ�.
	 * @param prenom le nouveau pr�nom de l'employ�. 
	 */

	public void setPrenom(String prenom)
	{
		this.prenom = prenom;
	}

	/**
	 * Retourne le mail de l'employ�.
	 * @return le mail de l'employ�.
	 */
	
	public String getMail()
	{
		return mail;
	}
	
	/**
	 * Change le mail de l'employ�.
	 * @param mail le nouveau mail de l'employ�.
	 */

	public void setMail(String mail)
	{
		this.mail = mail;
	}


	/**
	 * Retourne vrai ssi le password pass� en param�tre est bien celui
	 * de l'employ�.
	 * @return vrai ssi le password pass� en param�tre est bien celui
	 * de l'employ�.
	 * @param password le password auquel comparer celui de l'employ�.
	 */
	
	public boolean checkPassword(String password)
	{
		return this.password.equals(password);
	}

	/**
	 * Change le password de l'employ�.
	 * @param password le nouveau password de l'employ�. 
	 */
	
	public void setPassword(String password)
	{
		this.password= password;
	}
	public String getPassword() {
		return this.password;
	}

	/**
	 * Retourne la ligue � laquelle l'employ� est affect�.
	 * @return la ligue � laquelle l'employ� est affect�.
	 */
	
	public Ligue getLigue()
	{
		return ligue;
	}
	public int getType() {
		/* TODO if pour savoir le type */
		
		return 0;
	}
	
	public void remove() throws SauvegardeImpossible
	{
		Employe root = gestionPersonnel.getRoot();
		if (this != root)
		{
			if (estAdmin(getLigue()))
				getLigue().setAdministrateur(root);
			gestionPersonnel.delete(this);
			getLigue().remove(this);
			
		}
		else
			throw new ImpossibleDeSupprimerRoot();
	}

	/**
	 * Supprime l'employ�. Si celui-ci est un administrateur, le root
	 * r�cup�re les droits d'administration sur sa ligue.
	 * @throws SQLException 
	 */
	public void update() throws SQLException
	{
		try {
			gestionPersonnel.update(this);
		} catch (SauvegardeImpossible e) {
			
			e.printStackTrace();
		}
	}
	public GestionPersonnel getGestion() {
		return gestionPersonnel;
	}

	@Override
	public int compareTo(Employe autre)
	{
		int cmp = getNom().compareTo(autre.getNom());
		if (cmp != 0)
			return cmp;
		return getPrenom().compareTo(autre.getPrenom());
	}
	
	@Override
	public String toString()
	{
		String res ="\n"+ nom + " " + prenom + " " + mail +" Date Arrivee : "+ dateArrivee+" Date Depart : "+ dateDepart +" (";
		if (estRoot())
			res += "super-utilisateur";
		else
			res += ligue.toString();
		return res + ")";
	}

	
}
