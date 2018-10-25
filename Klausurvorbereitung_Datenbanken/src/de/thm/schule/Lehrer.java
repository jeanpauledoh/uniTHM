/**
 * 
 */
package de.thm.schule;
import java.util.Date;

import javax.persistence.*;

/**
 * @author jean-
 *
 */
@Entity
@NamedQuery(name = "LEHRER_BY_NACHNAME", query = "select l from Lehrer l where l.nachname = :name")
@DiscriminatorValue("L")
public class Lehrer extends Person
{
	private String titel;
	
	@Temporal(TemporalType.DATE)
	private Date gebDatum;
	
	@OneToOne(mappedBy = "lehrer", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private Klasse klasse;
	
	public Lehrer() 
	{
		
	}
	
	public Klasse getKlasse() 
	{
		return klasse;
	}

	public Date getGebDatum() {
		return gebDatum;
	}

	public void setGebDatum(Date gebDatum) {
		this.gebDatum = gebDatum;
	}

	public void setKlasse(Klasse klasse) 
	{
		this.klasse = klasse;
	}
	
	public String getTitel() 
	{
		return titel;
	}
	
	public void setTitel(String newTitel) 
	{
		titel=newTitel;
	}

	@Override
	public String toString() {
		return "Lehrer [titel=" + titel + ", getNachname()=" + getNachname() + ", getVorname()=" + getVorname() + "]";
	}
	
	
	
}
