package testsUnitaires;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import personnel.*;

class TestEmploye {
	
	GestionPersonnel gestionPersonnel; 
	public TestEmploye() {
		try {
			gestionPersonnel = GestionPersonnel.getGestionPersonnel();
		} catch (SauvegardeImpossible e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated constructor stub
	}
	
	

	@Test
	void isAdmin() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("TestLigue");
		Employe employe = ligue.addEmploye("Lahmar", "Tabai", "lahmartabai@yahoo.fr", "azerty", LocalDate.parse("2022-01-14"), LocalDate.parse("2022-01-14")); 
		assertFalse(employe.estAdmin(ligue));
		ligue.setAdministrateur(employe);
		assertTrue(employe.estAdmin(ligue));
	}
	
	
	@Test
	void isRoot() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("TestLigue");
		Employe employe = ligue.addEmploye("Lahmar", "Tabai", "lahmartabai@yahoo.fr", "azerty", LocalDate.parse("2022-01-14"), LocalDate.parse("2022-01-14"));
		Employe root = gestionPersonnel.getRoot();
		assertFalse(employe.estRoot());
		assertTrue(root.estRoot());
	}
	
	@Test
	void getDateArrivee() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("TestLigue");
		Employe employe = ligue.addEmploye("Lahmar", "Tabai", "lahmartabai@yahoo.fr", "azerty", LocalDate.parse("1990-01-27"), LocalDate.parse("2022-01-14"));
		assertEquals(LocalDate.parse("1990-01-27"), employe.getDateArrivee());
	}
	
	@Test
	void setDateArrivee() throws SauvegardeImpossible, DateImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("TestLigue");
		Employe employe = ligue.addEmploye("Lahmar", "Tabai", "lahmartabai@yahoo.fr", "azerty", LocalDate.parse("1990-01-27"), LocalDate.parse("2022-01-14"));
		employe.setDateArrivee(LocalDate.parse("2000-02-01"));
		assertEquals(LocalDate.parse("2000-02-01"), employe.getDateArrivee());
	}
	
	@Test
	void getDateDepart() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("TestLigue");
		Employe employe = ligue.addEmploye("Lahmar", "Tabai", "lahmartabai@yahoo.fr", "azerty", LocalDate.parse("1990-01-27"), LocalDate.parse("2022-01-14"));
		assertEquals(LocalDate.parse("2022-01-14"), employe.getDateDepart());
	}
	
	@Test
	void setDateDepart() throws SauvegardeImpossible, DateImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("TestLigue");
		Employe employe = ligue.addEmploye("Lahmar", "Tabai", "lahmartabai@yahoo.fr", "azerty", LocalDate.parse("1990-01-27"), LocalDate.parse("2022-01-14"));
		employe.setDateDepart(LocalDate.parse("2022-02-01"));
		assertEquals(LocalDate.parse("2022-02-01"), employe.getDateDepart());
	}
	
	
	@Test
	void getNom() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("TestLigue");
		Employe employe = ligue.addEmploye("Lahmar", "Tabai", "lahmartabai@yahoo.fr", "azerty", LocalDate.parse("1990-01-27"), LocalDate.parse("2022-01-14"));
		assertEquals("Lahmar", employe.getNom());
	}
	
	
	@Test
	void setNom() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("TestLigue");
		Employe employe = ligue.addEmploye("Lahmar", "Tabai", "lahmartabai@yahoo.fr", "azerty", LocalDate.parse("1990-01-27"), LocalDate.parse("2022-01-14"));
		employe.setNom("Rouge");
		assertEquals("Rouge", employe.getNom());
	}
	
	@Test
	void getPrenom() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("TestLigue");
		Employe employe = ligue.addEmploye("Lahmar", "Tabai", "lahmartabai@yahoo.fr", "azerty", LocalDate.parse("1990-01-27"), LocalDate.parse("2022-01-14"));
		assertEquals("Tabai", employe.getPrenom());
	}
	
	@Test
	void setPrenom() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("TestLigue");
		Employe employe = ligue.addEmploye("Lahmar", "Tabai", "lahmartabai@yahoo.fr", "azerty", LocalDate.parse("1990-01-27"), LocalDate.parse("2022-01-14"));
		employe.setNom("Nafissa");
		assertEquals("Nafissa", employe.getNom());
	}
	
	
	@Test
	void getMail() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("TestLigue");
		Employe employe = ligue.addEmploye("Lahmar", "Tabai", "lahmartabai@yahoo.fr", "azerty", LocalDate.parse("1990-01-27"), LocalDate.parse("2022-01-14"));
		assertEquals("lahmartabai@yahoo.fr", employe.getMail());
	}
	
	@Test
	void setMail() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("TestLigue");
		Employe employe = ligue.addEmploye("Lahmar", "Tabai", "lahmartabai@yahoo.fr", "azerty", LocalDate.parse("1990-01-27"), LocalDate.parse("2022-01-14"));
		employe.setMail("tabai@live.fr");
		assertEquals("tabai@live.fr", employe.getMail());
	}
	
	
	@Test 
	void checkPassword() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("TestLigue");
		Employe employe = ligue.addEmploye("Lahmar", "Tabai", "lahmartabai@yahoo.fr", "azerty", LocalDate.parse("1990-01-27"), LocalDate.parse("2022-01-14"));
		assertFalse(employe.checkPassword("farfouri"));
		assertTrue(employe.checkPassword("azerty"));
	}
	
	
	@Test 
	void setPassword() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("TestLigue");
		Employe employe = ligue.addEmploye("Lahmar", "Tabai", "lahmartabai@yahoo.fr", "azerty", LocalDate.parse("1990-01-27"), LocalDate.parse("2022-01-14"));
		employe.setPassword("PeakyBlinders");
		assertFalse(employe.checkPassword("azerty"));
		assertTrue(employe.checkPassword("PeakyBlinders"));
	}
	
	
	@Test
	void getLigue() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("TestLigue");
		Employe employe = ligue.addEmploye("Lahmar", "Tabai", "lahmartabai@yahoo.fr", "azerty", LocalDate.parse("1990-01-27"), LocalDate.parse("2022-01-14"));
		assertEquals(ligue, employe.getLigue());
	}
	
	
	@Test
	void compareTo() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("TestLigue");
		Employe employe1 = ligue.addEmploye("Lahmar", "Tabai", "lahmartabai@yahoo.fr", "azerty", LocalDate.parse("1990-01-27"), LocalDate.parse("2022-01-14"));
		Employe employe2 = ligue.addEmploye("Lahmar", "Tabai", "lahmartabai@yahoo.fr", "azerty", LocalDate.parse("1990-01-27"), LocalDate.parse("2022-01-14"));
		Employe employe3 = ligue.addEmploye("Logtari", "Nafissa", "logtariNafissa@yahoo.fr", "l7ob", LocalDate.parse("2003-04-27"), LocalDate.parse("2050-01-14"));
		assertEquals(0, employe1.compareTo(employe2));
		assertEquals(-14, employe2.compareTo(employe3));	
	}
	
	@Test
	void toStringEmployee() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("TestLigue");
		Employe root = gestionPersonnel.getRoot();
		Employe employe = ligue.addEmploye("Lahmar", "Tabai", "lahmartabai@yahoo.fr", "azerty", LocalDate.parse("1990-01-27"), LocalDate.parse("2022-01-14"));
		assertEquals("root   Date Arrivee : null Date Depart : null (super-utilisateur)", root.toString());
		assertEquals("Lahmar Tabai lahmartabai@yahoo.fr Date Arrivee : 1990-01-27 Date Depart : 2022-01-14 (TestLigue)", employe.toString());
	}
	
	
	
	
	

}
