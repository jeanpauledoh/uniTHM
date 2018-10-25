package Programmieren1;

import java.util.ArrayList;

public class Felge 
{
	private String bezeichnung;
	private String hersteller;
	private double durchmesser;
	private ArrayList<Object> zugelassenFuer = new ArrayList<>();
	private ArrayList<Felge> existenteFelgen = new ArrayList<Felge>();
	
	public Felge()
	{
		existenteFelgen.add(this);
	}
	
	public void setBezeichnung(String neueBezeichnung)
	{
		bezeichnungSetzen(neueBezeichnung);
	}
	
	private void bezeichnungSetzen(String neueBezeichnung) 
	{
		if(bezeichnung.isEmpty())
		{
			bezeichnung = neueBezeichnung;
		}
		
	}

//	public void setFahrzeug(Fahrzeug beliebiges)
	{
//		fahrzeugHinzufuegen(beliebiges);
	}
	
//	private void fahrzeugHinzufuegen(Fahrzeug beliebiges) 
	{
//		if(beliebiges instanceof Fahrzeug)
		{
//			zugelassenFuer.add(beliebiges);
		}
		
	}

	public void getFahrzeuge()
	{
		zugelasseneFahrzeuge();
	}

	private void zugelasseneFahrzeuge() 
	{
		zugelassenFuer.toString();
	}
	
	

}
