package personnel;


public interface Passerelle 
{
	//ici tu fais le lien etre la db et le code revise le mvc pour carry mais ducoups c'est pour utiliser les methodes de jdbc dans gestion personnel puis dans ligue ou employe
	public GestionPersonnel getGestionPersonnel() throws SauvegardeImpossible;
	public void sauvegarderGestionPersonnel(GestionPersonnel gestionPersonnel)  throws SauvegardeImpossible;
	public int insert(Ligue ligue) throws SauvegardeImpossible;
	public void update(Ligue ligue) throws SauvegardeImpossible;
	public int insert(Employe employe) throws SauvegardeImpossible;
	public void update(Employe employe) throws SauvegardeImpossible;
	public void deleteEmploye(Employe employe) throws SauvegardeImpossible;
	public void deleteLigue(Ligue ligue) throws SauvegardeImpossible;
	
}
