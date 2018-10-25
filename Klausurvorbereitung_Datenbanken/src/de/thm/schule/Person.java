/**
 * 
 */
package de.thm.schule;

import javax.persistence.*;

/**
 * @author jean-
 *
 */
@Entity
@Inheritance (strategy = InheritanceType.JOINED)
@DiscriminatorColumn (name = "PERSON_TYPE")
public abstract class Person 
{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY) //automatische generierung des primärschlüssels <-- damit dies funktionier muss die persistence														// owner der tabelle sein
	private int pnr;
	private String nachname;
	private String vorname;
	public int getPnr() 
	{
		return pnr;
	}
	
	public void setPnr(int pnr) 
	{
		this.pnr = pnr;
	}
	
	public String getNachname() 
	{
		return nachname;
	}
	
	public void setNachname(String nachname) 
	{
		this.nachname = nachname;
	}
	
	public String getVorname() 
	{
		return vorname;
	}
	
	public void setVorname(String vorname) 
	{
		this.vorname = vorname;
	}

	@Override
	public String toString() {
		return "Person [nachname=" + nachname + ", vorname=" + vorname + "]";
	}

	
}
