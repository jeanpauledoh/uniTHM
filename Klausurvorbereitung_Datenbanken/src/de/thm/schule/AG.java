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
public class AG 
{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY) 
	private int anr;
	private String bezeichnung;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Schueler> schueler = new ArrayList<Schueler>(); // an einer ag nehmen mehrere schueler teil
	
	public List<Schueler> getSchueler() 
	{
		return schueler;
	}

	public void setSchueler(List<Schueler> schueler) 
	{
		this.schueler = schueler;
	}
	
	public void addSchueler(Schueler newSchueler) 
	{
		//pruefung ob schueler bereits vorhanden
		if(!schueler.contains(newSchueler)) 
		{
			schueler.add(newSchueler);
		}
	}

	public int getAnr() 
	{
		return anr;
	}
	
	public void setAnr(int anr) 
	{
		this.anr = anr;
	}
	
	public String getBezeichnung() 
	{
		return bezeichnung;
	}
	
	public void setBezeichnung(String bezeichnung) 
	{
		this.bezeichnung = bezeichnung;
	}

	@Override
	public String toString() {
		return "AG [bezeichnung=" + bezeichnung + "]";
	}

	
}
