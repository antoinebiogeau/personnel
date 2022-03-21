package jdbc;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import personnel.*;

public class JDBC implements Passerelle 
{
	Connection connection;

	public JDBC()
	{
		try
		{
			Class.forName(Credentials.getDriverClassName());
			connection = DriverManager.getConnection(Credentials.getUrl(), Credentials.getUser(), Credentials.getPassword());
		}
		catch (ClassNotFoundException e)
		{
			System.out.println("Pilote JDBC non installÃ©.");
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
	}
	
	@Override
	public GestionPersonnel getGestionPersonnel() 
	{
		GestionPersonnel gestionPersonnel = new GestionPersonnel();
		try 
		{
			String requete = "select * from LIGUE";
			Statement instruction = connection.createStatement();
			ResultSet ligues = instruction.executeQuery(requete);
			while (ligues.next())
				gestionPersonnel.addLigue(ligues.getInt(1), ligues.getString(2));
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
		return gestionPersonnel;
	}

	@Override
	public void sauvegarderGestionPersonnel(GestionPersonnel gestionPersonnel) throws SauvegardeImpossible 
	{
		close();
	}
	
	public void close() throws SauvegardeImpossible
	{
		try
		{
			if (connection != null)
				connection.close();
		}
		catch (SQLException e)
		{
			throw new SauvegardeImpossible(e);
		}
	}
	
	@Override
	public int insert(Ligue ligue) throws SauvegardeImpossible 
	{
		try 
		{
			PreparedStatement instruction;
			instruction = connection.prepareStatement("insert into LIGUE (nom) values (?)", Statement.RETURN_GENERATED_KEYS);
			instruction.setString(1, ligue.getNom());		
			instruction.executeUpdate();
			ResultSet id = instruction.getGeneratedKeys();
			id.next();
			return id.getInt(1);
		} 
		catch (SQLException exception) 
		{
			exception.printStackTrace();
			throw new SauvegardeImpossible(exception);
		}		
	}
	@Override
	public int insert(Employe employé) throws SauvegardeImpossible 
	{
		try 
		{
			if(employé.getNom().equals("root")) {
			/*PreparedStatement instruction;
			instruction = connection.prepareStatement("INSERT INTO `employé` (`date_d'entré`,`date_de_sortie`,`nom`,`prénom`,`mail`,`type`,`idligue`) values(?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			instruction.setDate(1, employé.getDateArrivee() == null ? null : Date.valueOf(employé.getDateArrivee()));
			instruction.setDate(2, employé.getDateDepart() == null ? null : Date.valueOf(employé.getDateDepart()));
			instruction.setString(3, employé.getNom());
			instruction.setString(4, employé.getPrenom());
			instruction.setString(5, employé.getMail());
			instruction.setInt(6, employé.getType());
			instruction.setInt(7, 40);
			instruction.executeUpdate();
			ResultSet idemployer = instruction.getGeneratedKeys();
			idemployer.next();*/
			return 0;
			}
			else {
				PreparedStatement instruction;
				instruction = connection.prepareStatement("INSERT INTO `employé` (`date_d'entré`,`date_de_sortie`,`nom_employe`,`prénom`,`mail`,`password`,`type`,`idligue`) values(?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
				instruction.setDate(1, employé.getDateArrivee() == null ? null : Date.valueOf(employé.getDateArrivee()));
				instruction.setDate(2, employé.getDateDepart() == null ? null : Date.valueOf(employé.getDateDepart()));
				instruction.setString(3, employé.getNom());
				instruction.setString(4, employé.getPrenom());
				instruction.setString(5, employé.getMail());
				instruction.setString(6, employé.getPrenom());
				instruction.setInt(7, employé.getType());
				instruction.setInt(8, employé.getidligue());
				instruction.executeUpdate();
				ResultSet idemployer = instruction.getGeneratedKeys();
				idemployer.next();
				return idemployer.getInt(1);
			}
			
		} 
		catch (SQLException exception) 
		{
			exception.printStackTrace();
			throw new SauvegardeImpossible(exception);
		}		
	}
	
	//delete de ligue et employé
	public int delete(Ligue ligue) throws SauvegardeImpossible{
		try 
		{
			PreparedStatement instruction;
			instruction = connection.prepareStatement("DELETE FROM ligue WHERE idligue = "+ligue.getId()+" ", Statement.RETURN_GENERATED_KEYS);		
			instruction.executeUpdate();
			ResultSet id = instruction.getGeneratedKeys();
			id.next();
			return id.getInt(1);
		} 
		catch (SQLException exception) 
		{
			exception.printStackTrace();
			throw new SauvegardeImpossible(exception);
		}
		
	}
	public int delete(Employe employé) throws SauvegardeImpossible{
		try 
		{
			PreparedStatement instruction;
			instruction = connection.prepareStatement("DELETE FROM employé WHERE idemployer = "+employé.getid()+"", Statement.RETURN_GENERATED_KEYS);		
			instruction.executeUpdate();
			ResultSet idemployer = instruction.getGeneratedKeys();
			idemployer.next();
			return idemployer.getInt(1);
		} 
		catch (SQLException exception) 
		{
			exception.printStackTrace();
			throw new SauvegardeImpossible(exception);
		}
		
	}
	
	//Update de ligue et employé
	@Override
	public int update(Ligue ligue) throws SauvegardeImpossible, SQLException {
		PreparedStatement instruction;
		instruction = connection.prepareStatement("UPDATE ligue SET nom = '"+ligue.getNom()+"' WHERE idligue = "+ligue.getId()+" ", Statement.RETURN_GENERATED_KEYS);		
		instruction.executeUpdate();
		return 0;
	}

	@Override
	public int update(Employe employé) throws SauvegardeImpossible, SQLException {
		PreparedStatement instruction;
		instruction = connection.prepareStatement("UPDATE ligue SET nom = '"+ employé.getNom()+"', SET prenom = '"+employé.getPrenom()+"', SET mail = '"+employé.getMail()+"', Set password ='"+employé.getPassword()+"' WHERE idligue = "+ employé.getid() +" ", Statement.RETURN_GENERATED_KEYS);		
		instruction.executeUpdate();
		return 0;
		// TODO Auto-generated method stub
	}
	//select ligue et employé
	@Override
	public String selectEmployé(Ligue ligue) throws SauvegardeImpossible, SQLException{
		String Employés ="";
		String requete = "SELECT nom_employe FROM employé , ligue  WHERE employé.idligue = ligue.idligue AND ligue.idligue = "+ligue.getId()+" ";
		Statement instruction = connection.createStatement();
		ResultSet  employeLigue = instruction.executeQuery(requete);
		while (employeLigue.next()) {
			int i = 1;
			Employés += "\n"+employeLigue.getString( i);
			i++;
	}
		return Employés;
	
	}

	@Override
	public int select(Ligue ligue) throws SauvegardeImpossible {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
