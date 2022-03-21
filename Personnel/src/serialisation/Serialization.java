package serialisation;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;

import personnel.Employe;
import personnel.GestionPersonnel;
import personnel.Ligue;
import personnel.SauvegardeImpossible;

public class Serialization implements personnel.Passerelle
{
	private static final String FILE_NAME = "GestionPersonnel.srz";

	@Override
	public GestionPersonnel getGestionPersonnel()
	{
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME)))
		{
			return (GestionPersonnel) ois.readObject();
		}
		catch (IOException | ClassNotFoundException e)
		{
			return null;
		}
	}
	
	/**
	 * Sauvegarde le gestionnaire pour qu'il soit ouvert automatiquement 
	 * lors d'une exÃ©cution ultÃ©rieure du programme.
	 * @throws SauvegardeImpossible Si le support de sauvegarde est inaccessible.
	 */
	@Override
	public void sauvegarderGestionPersonnel(GestionPersonnel gestionPersonnel) throws SauvegardeImpossible
	{
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME)))
		{
			oos.writeObject(gestionPersonnel);
		}
		catch (IOException e)
		{
			throw new SauvegardeImpossible(e);
		}
	}
	
	@Override
	public int insert(Ligue ligue) throws SauvegardeImpossible
	{
		return -1;
	}

	@Override
	public int insert(Employe employé) throws SauvegardeImpossible {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Ligue ligue) throws SauvegardeImpossible, SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Employe employé) throws SauvegardeImpossible {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Ligue ligue) throws SauvegardeImpossible {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Employe employé) throws SauvegardeImpossible {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String selectEmployé(Ligue ligue) throws SauvegardeImpossible, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int select(Ligue ligue) throws SauvegardeImpossible {
		// TODO Auto-generated method stub
		return 0;
	}
}
