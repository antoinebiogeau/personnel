package personnel;

public interface Passerelle 
{
	public GestionPersonnel getGestionPersonnel();
	public void sauvegarderGestionPersonnel(GestionPersonnel gestionPersonnel)  throws SauvegardeImpossible;
	public int insert(Ligue ligue) throws SauvegardeImpossible;
	public int insert(Employe employe) throws SauvegardeImpossible;
	public void updateEmploye(Employe employe, String column) throws SauvegardeImpossible;
	public void updateLigue(Ligue ligue) throws SauvegardeImpossible;
	public void deleteEmploye(Employe employe) throws SauvegardeImpossible;
	public void deleteLigue(Ligue ligue) throws SauvegardeImpossible;
	public void newAdmin(Employe employe) throws SauvegardeImpossible;
	public void removeAdmin(Ligue ligue) throws SauvegardeImpossible;
}
