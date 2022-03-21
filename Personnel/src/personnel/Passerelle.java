package personnel;

import java.sql.SQLException;
import java.util.SortedSet;

public interface Passerelle 
{
	public GestionPersonnel getGestionPersonnel();
	public void sauvegarderGestionPersonnel(GestionPersonnel gestionPersonnel)  throws SauvegardeImpossible;
	public int insert(Ligue ligue) throws SauvegardeImpossible;
	public int insert(Employe employ�) throws SauvegardeImpossible;
	public int update(Ligue ligue) throws SauvegardeImpossible, SQLException;
	public int update(Employe employ�) throws SauvegardeImpossible, SQLException;
	public int delete(Ligue ligue) throws SauvegardeImpossible;
	public int delete(Employe employ�) throws SauvegardeImpossible;
	public String selectEmploy�(Ligue ligue) throws SauvegardeImpossible, SQLException;
	public int select(Ligue ligue) throws SauvegardeImpossible;

}
