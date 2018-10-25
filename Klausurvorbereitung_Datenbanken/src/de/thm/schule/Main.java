/**
 * 
 */
package de.thm.schule;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author jean-
 *
 */
public class Main 
{
	private static Schulverwaltung SLV = new Schulverwaltung();
	private static JDBC_Connector JC = new JDBC_Connector("localhost", "3306", "jped86nr2");
	private static JDBC_Statementhandler JS = new JDBC_Statementhandler(JC.getconnection());
	private static OutputHandler JO = null; 
	private static Date date = new Date(99,12,2);
	private static Date date2 = new Date(79,12,1);
	private static Date date3 = new Date(69,3,4);
	

	/**
	 * @param args
	 * 
	 * Primary keys werden nicht im resultset registriert
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		//testConnection("select * from lehrer");
		//handleQuery();
		//jpaTestPersist();
		//jpaTestFind(999);
		//jpaTestUpdate("Frankfurter");
		//jpaTestDelete(0);
		//jpaTestFind(1);
		//jpaTestPersist2();
		//jpaTestPersist3();
		/*
		SLV.createDataAG();
		SLV.createDataKlasse();
		SLV.createDataLehrer();
		SLV.createDataSchueler();
		*/
		/*
		SLV.schuelerAgzuordnen(1,1);
		SLV.schuelerAgzuordnen(2,2);
		SLV.schuelerAgzuordnen(3,3);
		SLV.schuelerAgzuordnen(4,4);
		SLV.schuelerAgzuordnen(5,5);
		SLV.schuelerAgzuordnen(6,6);
		
		
		
		SLV.schuelerKlassezuordnen(1, 1);
		SLV.schuelerKlassezuordnen(1, 2);
		SLV.schuelerKlassezuordnen(1, 3);
		SLV.schuelerKlassezuordnen(1, 4);
		
		SLV.schuelerKlassezuordnen(2, 5);
		SLV.schuelerKlassezuordnen(2, 6);
		SLV.schuelerKlassezuordnen(2, 7);
		SLV.schuelerKlassezuordnen(2, 8);
		
		SLV.schuelerKlassezuordnen(3, 9);
		SLV.schuelerKlassezuordnen(3, 10);
		SLV.schuelerKlassezuordnen(3, 11);
		SLV.schuelerKlassezuordnen(3, 12);
		
		SLV.lehrerKlassezuordnen(1, 1);
		SLV.lehrerKlassezuordnen(2, 2);
		SLV.lehrerKlassezuordnen(3, 3);
		SLV.lehrerKlassezuordnen(4, 4);
		SLV.lehrerKlassezuordnen(5, 5);
		SLV.lehrerKlassezuordnen(6, 6);
		SLV.lehrerKlassezuordnen(7, 7);
		SLV.lehrerKlassezuordnen(8, 8);
		
		
		//SLV.updSchuelerAG(1, 4);
		//SLV.deleteSchueler(1);
		
		SLV.setLehrerDate(1, date);
		SLV.setLehrerDate(2, date2);
		SLV.setLehrerDate(3, date3);
		*/
		
		//auf grundlage der Vererbung
		
		/*
		SLV.schuelerAgzuordnen(1,11);
		SLV.schuelerAgzuordnen(2,12);
		SLV.schuelerAgzuordnen(3,13);
		SLV.schuelerAgzuordnen(4,14);
		SLV.schuelerAgzuordnen(5,15);
		SLV.schuelerAgzuordnen(6,16);
		
		SLV.schuelerKlassezuordnen(1, 11);
		SLV.schuelerKlassezuordnen(1, 12);
		SLV.schuelerKlassezuordnen(1, 13);
		SLV.schuelerKlassezuordnen(1, 14);
		
		SLV.schuelerKlassezuordnen(2, 15);
		SLV.schuelerKlassezuordnen(2, 16);
		SLV.schuelerKlassezuordnen(2, 17);
		SLV.schuelerKlassezuordnen(2, 18);
		
		SLV.schuelerKlassezuordnen(3, 19);
		SLV.schuelerKlassezuordnen(3, 20);
		SLV.schuelerKlassezuordnen(3, 21);
		SLV.schuelerKlassezuordnen(3, 22);
		
		SLV.lehrerKlassezuordnen(1, 1);
		SLV.lehrerKlassezuordnen(2, 2);
		SLV.lehrerKlassezuordnen(3, 3);
		SLV.lehrerKlassezuordnen(4, 4);
		SLV.lehrerKlassezuordnen(5, 5);
		SLV.lehrerKlassezuordnen(6, 6);
		SLV.lehrerKlassezuordnen(7, 7);
		SLV.lehrerKlassezuordnen(8, 8);
		
		SLV.setLehrerDate(1, date);
		SLV.setLehrerDate(2, date2);
		SLV.setLehrerDate(3, date3);
		SLV.setLehrerDate(4, date2);
		SLV.setLehrerDate(5, date);
		SLV.setLehrerDate(6, date);
		SLV.setLehrerDate(7, date2);
		SLV.setLehrerDate(8, date3);
		*/
		/*
		SLV.updLehrerTitel(2, "Dr.");
		SLV.updLehrerTitel(4, "Med.");
		SLV.updLehrerTitel(5, "Prof.");
		SLV.updLehrerTitel(7, "Prof.");
		SLV.updLehrerTitel(8, "Clown.");
		*/
		//anyQuery("select s from Schueler s");
		//anyQuery("select l from Lehrer l");
		//typedQuery("select s from Schueler s");
		//typedQueryWithParameterNAME("Hetfield"); 
		//testNamedQuery("Kilmister");
		testPunktNotation(1);
		//provoke Exception
		//typedQuery("select l from Lehrer l"); //--> as Expected de.thm.schule.Lehrer cannot be cast to de.thm.schule.Schueler
		
		jpaCloseConnection();
		
		// --> aktuller Stand: Testdaten sind drinne und persistence auf create-table umgestellt
		// --> aktueller Stand: Referentielle integrität eingeführt, auf create-Table umgestellt
		// --> aktueller Stand: Vererbung eingeführt und Daten wieder miteinander verknüpft, auf create-Table umgestellt
	}
	
	public static void testConnection(String strQuery) 
	{
		JS.testStatement(strQuery);
	}
	
	public static void handleQuery() 
	{
		JO= new OutputHandler(JS.preparedStatement("Dr.", 1950));
		JO.handlmanualySchueler(JS.easyStatementAufagbe1("select vorname, nachname, gebdatum from schueler"));
		JS.preparedStatementSchueler();
	}
	
	public static void jpaTestPersist() 
	{
		SLV.testLehrerPersist();
		
	}
	public static void jpaTestPersist2() 
	{
		SLV.testLehrerPersistWithOutPnr();
		
	}
	
	public static void jpaTestPersist3() 
	{
		SLV.testLehrerPersistWithOutPnr2();
		
	}
	
	public static void jpaTestFind(int pnr) 
	{
		SLV.testfindLehrerbyPnr(pnr);
	}
	
	public static void jpaTestUpdate(String newLastname) 
	{
		SLV.testUpdateLehrerLastname(newLastname);
	}
	
	public static void jpaTestDelete(int pnr) 
	{
		SLV.testDeleteLehrerbyPnr(pnr);
	}
	
	public static void jpaCloseConnection() 
	{
		SLV.closeConnection();
	}
	
	public static void changeDate() 
	{
		System.out.println(date.toString());
	}
	
	public static void anyQuery(String stm) 
	{
		List<Object> lstResult = SLV.nonTypedQuery(stm);
		for (Object o : lstResult) 
		{
			System.out.println(o.toString());
		}
	}
	
	public static void typedQuery(String stm) 
	{
		List<Schueler> lstResult = SLV.TypedQuerySchueler(stm);
		for (Schueler s : lstResult) 
		{
			System.out.println(s.toString());
		}
	}
	
	public static void typedQueryWithParameterNAME(String name) 
	{
		List<Schueler> lstResult = SLV.tQsearchByNameSchueler(name);
		for (Schueler s : lstResult) 
		{
			System.out.println(s.toString());
		}
	}
	
	public static void testNamedQuery(String name) 
	{
		List<Lehrer> lstResult = SLV.namedQueryLehrerbyName(name);
		for (Lehrer l : lstResult) 
		{
			System.out.println(l.toString());
		}
	}
	
	public static void testPunktNotation(int agname) 
	{
		List<Schueler> lstResult = SLV.searchSchuelerInAg(agname);
		for (Schueler s : lstResult) 
		{
			System.out.println(s.toString());
		}
	}

}
