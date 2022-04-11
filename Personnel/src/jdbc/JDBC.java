package jdbc;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
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
			System.out.println("Pilote JDBC non installé.");
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
	}
	
	@Override
    public GestionPersonnel getGestionPersonnel() throws SauvegardeImpossible {
        GestionPersonnel gestionPersonnel = new GestionPersonnel();

        try {
            String requete = "SELECT * FROM ligue";
            Statement instruction = connection.createStatement();
            ResultSet ligues = instruction.executeQuery(requete);

            while (ligues.next()) {
                gestionPersonnel.addLigue(ligues.getInt("idligue"), ligues.getString("nom"));
                PreparedStatement req = connection.prepareStatement("SELECT * FROM employ� WHERE idligue = ?");
                req.setInt(1, ligues.getInt("idligue"));
                ResultSet employe = req.executeQuery();
                Ligue ligue = gestionPersonnel.getLigues().last();

                while (employe.next()) {
                    int id = employe.getInt("idemployer");
                    String nom = employe.getString("nom_employe");
                    String prenom = employe.getString("pr�nom");
                    String mail = employe.getString("mail");
                    String password = employe.getString("password");
                    LocalDate date_arrivee = employe.getDate("date_d'entr�") != null ? LocalDate.parse(employe.getString("date_d'entr�")) : null;
                    LocalDate date_depart = employe.getDate("date_de_sortie") != null ? LocalDate.parse(employe.getString("date_de_sortie")) : null;
                    int type = employe.getType();
                    Employe employee = ligue.addEmploye(nom, prenom, mail, password, date_arrivee, date_depart,id);
                    if (employe.getBoolean("type")) {
                        ligue.setAdministrateur(employee);
                    }
                }
            }
        } catch (SQLException e) {
        	System.out.println(e);
        	throw new SauvegardeImpossible(e); 
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
			return id.getInt(1);  /* id de la ligue */
		} 
		catch (SQLException exception) 
		{
			exception.printStackTrace();
			throw new SauvegardeImpossible(exception);
		}		
	}

	@Override
	public int insert(Employe employ�) throws SauvegardeImpossible
	{
		try 
		{
				PreparedStatement instruction;
				instruction = connection.prepareStatement("INSERT INTO `employ�` (`date_d'entr�`,`date_de_sortie`,`nom_employe`,`pr�nom`,`mail`,`password`,`type`,`idligue`) values(?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
				instruction.setDate(1, employ�.getDateArrivee() == null ? null : Date.valueOf(employ�.getDateArrivee()));
				instruction.setDate(2, employ�.getDateDepart() == null ? null : Date.valueOf(employ�.getDateDepart()));
				instruction.setString(3, employ�.getNom());
				instruction.setString(4, employ�.getPrenom());
				instruction.setString(5, employ�.getMail());
				instruction.setString(6, employ�.getPrenom());
				instruction.setInt(7, employ�.getType());
				instruction.setInt(8, employ�.getIdLigue());
				instruction.executeUpdate();
				ResultSet idemploy� = instruction.getGeneratedKeys();
				idemploy�.next();
				return idemploy�.getInt(1);
			
		} 
		catch (SQLException exception) 
		{
			exception.printStackTrace();
			throw new SauvegardeImpossible(exception);
		}		
	}
	
	
	//Update de ligue et employ�  
	
	/* TODO  Faite une requette préparée ligne 167 et ligne 174, 175 et 176  nom = Alex',type='2 */
	
	@Override
	public void update(Ligue ligue) throws SauvegardeImpossible {
		
		try {
			PreparedStatement instruction;
			instruction = connection.prepareStatement("UPDATE ligue SET nom = '"+ligue.getNom()+"' WHERE idligue = "+ligue.getId()+" ", Statement.RETURN_GENERATED_KEYS);
			instruction.executeUpdate();
		} catch (SQLException e) {
			
			throw new SauvegardeImpossible(e);
		}		
		
	}

	@Override
	public void update(Employe employ�) throws SauvegardeImpossible {
		
		try {
			PreparedStatement instruction;
			instruction = connection.prepareStatement("UPDATE employ� SET nom_employe = '"+ employ�.getNom()+
					"', pr�nom = '"+employ�.getPrenom()+"',  mail = '"+employ�.getMail()+"',  password ='"+
					employ�.getPassword()+"', type = "+employ�.getType() +" WHERE idemploy� = "+ employ�.getid() +" ", Statement.RETURN_GENERATED_KEYS);
			instruction.executeUpdate();
		} catch (SQLException e) {
			
			throw new SauvegardeImpossible(e);
		}
		
	
	}
	

	@Override
	public void deleteEmploye(Employe employe) throws SauvegardeImpossible {
		try
		{
			PreparedStatement instruction;
			instruction = connection.prepareStatement("DELETE FROM employ� WHERE idemploy� = ?");
			instruction.setInt(1, employe.getid());
			instruction.executeUpdate();
		}
		catch (SQLException e) 
		{

			throw new SauvegardeImpossible(e);
		}
		
	}

	@Override
	public void deleteLigue(Ligue ligue) throws SauvegardeImpossible {
		try
		{
			PreparedStatement tableLigue;
			tableLigue = connection.prepareStatement("DELETE FROM ligue WHERE idligue = ?");
			tableLigue.setInt(1, ligue.getId());
			tableLigue.executeUpdate();;
		}
		catch (SQLException e) 
		{
			throw new SauvegardeImpossible(e);
		}
		
	}


	
}
