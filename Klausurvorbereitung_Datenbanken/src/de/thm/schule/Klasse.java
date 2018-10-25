/**
 * 
 */
package de.thm.schule;

import java.util.*;

import javax.persistence.*;

/**
 * @author jean-
 *
 */
@Entity
public class Klasse 
{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int knr;
	private int klassenlehrer;
	private String bezeichnung;
	
	@OneToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Lehrer lehrer;
	
	@OneToMany (mappedBy = "klasse", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	//private Schueler schueler;  <--- eine klasse hat MEHRERE Schueler
	private List<Schueler> schueler = new ArrayList<Schueler>();
	
	public Lehrer getLehrer() 
	{
		return lehrer;
	}

	public void setLehrer(Lehrer lehrer) 
	{
		this.lehrer = lehrer;
	}

	public List<Schueler> getSchueler() 
	{
		return schueler;
	}
	
	public void setSchueler(List<Schueler> newSchueler) 
	{
		this.schueler = newSchueler;
	}

	public void addSchueler(Schueler newSchueler) 
	{
		//dopplungen vermeiden
		if(!schueler.contains(newSchueler)) 
		{
			schueler.add(newSchueler);
		}
		
	}

	public int getKnr() 
	{
		return knr;
	}
	
	public void setKnr(int knr) 
	{
		this.knr = knr;
	}
	
	public int getKlassenlehrer() 
	{
		return klassenlehrer;
	}
	
	public void setKlassenlehrer(int klassenlehrer) 
	{
		this.klassenlehrer = klassenlehrer;
	}
	
	
	
	@Override
	public String toString() {
		return "Klasse [bezeichnung=" + bezeichnung + "]";
	}

	public String getBezeichnung() 
	{
		return bezeichnung;
	}
	
	public void setBezeichnung(String bezeichnung)
	{
		this.bezeichnung = bezeichnung;
	}
	

}
