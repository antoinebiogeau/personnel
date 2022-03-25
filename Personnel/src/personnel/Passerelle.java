package personnel;


public interface Passerelle 
{
	public GestionPersonnel getGestionPersonnel() throws SauvegardeImpossible;
	public void sauvegarderGestionPersonnel(GestionPersonnel gestionPersonnel)  throws SauvegardeImpossible;
	public int insert(Ligue ligue) throws SauvegardeImpossible;
	public void update(Ligue ligue) throws SauvegardeImpossible;
	public int insert(Employe employe) throws SauvegardeImpossible;
	public int insertRoot(Employe employe)throws SauvegardeImpossible;
	public void update(Employe employe) throws SauvegardeImpossible;
	public void deleteEmploye(Employe employe) throws SauvegardeImpossible;
	public void deleteLigue(Ligue ligue) throws SauvegardeImpossible;
	
}
