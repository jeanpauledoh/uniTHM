package de.thm.schule;

import java.util.ArrayList;
import javax.persistence.*;


@Entity
public class Schueler {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int SNr;
	private String nachname;
	private String vorname;
	@ManyToOne(cascade = CascadeType.REFRESH)
	private Klasse klasse;
	@ManyToMany (mappedBy = "schueler", cascade = CascadeType.REMOVE)
	private ArrayList<AG> ags;

	public ArrayList<AG> getAgs() {
		return ags;
	}

	public void setAgs(ArrayList<AG> ags) {
		this.ags = ags;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public Klasse getKlasse() {
		return klasse;
	}

	public void setKlasse(Klasse klasse) {
		this.klasse = klasse;
	}
	
	public void setSNr(int snr)
	{
		this.SNr = snr;
	}
	
	public int getSNr()
	{
		return SNr;
	}
	
	public void getInfo()
	{
		System.out.println(SNr+" ;"+nachname+" ;"+vorname);
	}

}
