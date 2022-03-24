package personnel;

import java.sql.SQLException;
import java.util.SortedSet;

public interface Passerelle 
{
	public GestionPersonnel getGestionPersonnel();
	public void sauvegarderGestionPersonnel(GestionPersonnel gestionPersonnel)  throws SauvegardeImpossible;
	public int insert(Ligue ligue) throws SauvegardeImpossible;
	public void update(Ligue ligue) throws SauvegardeImpossible, SQLException;
	public int insert(Employe employe) throws SauvegardeImpossible;
	public void update(Employe employe) throws SauvegardeImpossible, SQLException;
	public void deleteEmploye(Employe employe) throws SauvegardeImpossible;
	public void deleteLigue(Ligue ligue) throws SauvegardeImpossible;
	public void newAdmin(Employe employe) throws SauvegardeImpossible;
	public void removeAdmin(Ligue ligue) throws SauvegardeImpossible;

}
