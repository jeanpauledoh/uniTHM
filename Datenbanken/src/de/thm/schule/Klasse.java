package de.thm.schule;

import java.util.ArrayList;
import javax.persistence.*;

@Entity
public class Klasse{

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int KNr;
	private String bezeichnung;
	@OneToOne (mappedBy = "klasse")
	private Lehrer lehrer;
	@OneToMany (mappedBy = "klasse", cascade = CascadeType.REMOVE)
	private ArrayList<Schueler> schueler;
	
		public ArrayList<Schueler> getSchueler() {
		return schueler;
	}

	public void setSchueler(ArrayList<Schueler> schueler) {
		this.schueler = schueler;
	}

	public Lehrer getLehrer() {
		return lehrer;
	}

	public void setLehrer(Lehrer lehrer) {
		this.lehrer = lehrer;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}
	
	public void setKNr(int KNr)
	{
		this.KNr=KNr;
	}
	
	public int getKNr()
	{
		return KNr;
	}

}
