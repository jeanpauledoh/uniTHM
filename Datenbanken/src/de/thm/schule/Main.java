package de.thm.schule;

import java.util.ArrayList;

public class Main 
{
	private static Schulverwaltung SCHUL = new Schulverwaltung();
	private static DummyFactory DF = new DummyFactory();
	
	public static void main(String args[])
	{
		ArrayList<Schueler> testArray = new ArrayList<Schueler>();
		
		System.out.println("Nothing to see here");
		//SCHUL.runEnt();
		//SCHUL.loadNewEntityLehrer("Bla", "Blub");
		//SCHUL.loadNewEntityKlasse("10x", testArray );
		//SCHUL.loadNewEntitySchueler("Lustig", "Peter");
		//SCHUL.dummy();
		//SCHUL.execQuerySchueler("select s from Schueler s");
		//SCHUL.execQuerySchueler2("Kilmister");
		//SCHUL.testDAO();
		//SCHUL.testDAO2();
		//SCHUL.testDAO3();
		//SCHUL.lehrerDAO();
		SCHUL.lehrerCB();
		SCHUL.klasseCB("11a");
		//SCHUL.testSchueler("10c");
		
	}

}
