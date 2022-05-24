package testsUnitaires;

import static commandLineMenus.rendering.examples.util.InOut.getString;


import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import personnel.*;

class testLigue 
{
	GestionPersonnel gestionPersonnel;
	
	public testLigue() {
		try {
			gestionPersonnel = GestionPersonnel.getGestionPersonnel();
		} catch (SauvegardeImpossible e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void createLigue() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		assertEquals("Fléchettes", ligue.getNom());
	}

	@Test
	void addEmploye() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty", LocalDate.parse("2022-01-14"), LocalDate.parse("2022-01-14")); 
		assertEquals(employe, ligue.getEmployes().first());
	}
	
	@Test
	void getNom() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		assertEquals("Fléchettes", ligue.getNom());
	}
	
	
	@Test
	void setNom() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("TestLigue");
		assertEquals("TestLigue", ligue.getNom());
		ligue.setNom("Tunisie");
		assertEquals("Tunisie", ligue.getNom());
	}
	
	@Test
	void getAdministrateur() throws SauvegardeImpossible 
	{
		Ligue ligue = gestionPersonnel.addLigue("Testligue");
		assertEquals("root   Date Arrivee : null Date Depart : null (super-utilisateur)", ligue.getAdministrateur().toString());
	}
	
	@Test
	void setAdministrateur() throws SauvegardeImpossible 
	{
		Ligue ligue = gestionPersonnel.addLigue("TestLigue");	
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty", LocalDate.parse("2022-01-14"), LocalDate.parse("2022-01-14"));
		ligue.setAdministrateur(employe);
		assertEquals(employe, ligue.getAdministrateur());
	}
	
	@Test
	void removeLigue() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("TestLigue");
		int debut = gestionPersonnel.getLigues().size();
		ligue.remove();
		int fin = gestionPersonnel.getLigues().size();
		assertEquals(debut - 1, fin);
	}
	
	@Test
	void compareToLigue() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("TestLigue");
		Ligue ligue1 = gestionPersonnel.addLigue("Testligue1");
		
		assertEquals(-32, ligue.compareTo(ligue1));
	}
	
	@Test
	void toStringLigue() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("TestLigue");
		assertEquals("TestLigue", ligue.toString());
	}
	
	
	
	
	
	
	
}
