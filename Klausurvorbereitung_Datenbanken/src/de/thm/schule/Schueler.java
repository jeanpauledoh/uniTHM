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
@DiscriminatorValue("S")
public class Schueler extends Person
{
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Klasse klasse;
	
	@ManyToMany (mappedBy = "schueler", fetch = FetchType.EAGER)
	private List<AG> ag = new ArrayList<AG>(); // ein schueler kann mehrere ags besuchen
	
	public Klasse getKlasse() 
	{
		return klasse;
	}

	public void setKlasse(Klasse klasse)
	{
		this.klasse = klasse;
	}
	
	@Override
	public String toString() {
		return "Schueler [getNachname()=" + getNachname() + ", getVorname()="
				+ getVorname() + "]";
	}

	public void addAg(AG newAg) 
	{
		//pruefung ob ag bereits vorhanden
		if(!ag.contains(newAg)) 
		{
			ag.add(newAg);
		}
	}

	public List<AG> getAg() 
	{
		return ag;
	}

	public void setAg(List<AG> ag) 
	{
		this.ag = ag;
	}

}
