package de.thm.schule;
import javax.persistence.*;

@Entity
public class Lehrer{

	private String nachname;
	private String vorname;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int PNr;
	
	public Lehrer() 
	{
		
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
	
	public int getPNr()
	{
		return PNr;
	}
	
	public void setPNr(int pnr)
	{
		this.PNr = pnr;
	}
	
	public void getInfo()
	{
		System.out.println(PNr+" ;"+nachname+" ;"+vorname);
	}
}
