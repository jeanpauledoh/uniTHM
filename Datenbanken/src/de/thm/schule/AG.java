package de.thm.schule;
import javax.persistence.*;

import java.util.ArrayList;
@Entity
public class AG {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ANr;
	private String bezeichnung;
	@ManyToMany
	private ArrayList<Schueler> schueler;

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public ArrayList<Schueler> getSchueler() {
		return schueler;
	}

	public void setSchueler(ArrayList<Schueler> schueler) {
		this.schueler = schueler;
	}
	
	public int getAnr()
	{
		return ANr;
	}
	
	public void setANr(int anr)
	{
		this.ANr = anr;
	}

}
