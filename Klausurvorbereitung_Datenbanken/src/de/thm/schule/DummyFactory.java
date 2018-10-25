/**
 * 
 */
package de.thm.schule;


/**
 * @author jean-
 *
 */


public class DummyFactory 
{
	
	public static Lehrer createLehrer() 
	{
		Lehrer lehrer = new Lehrer();
		lehrer.setVorname(getRandom(vornamen));
		lehrer.setNachname(getRandom(nachnamen));
		return lehrer;
	}

	public static Klasse createKlasse() 
	{
		Klasse klasse = new Klasse();
		klasse.setBezeichnung(getRandom(klassen));
		return klasse;
	}

	public static Schueler createSchueler() 
	{
		Schueler schueler = new Schueler();
		schueler.setVorname(getRandom(vornamen));
		schueler.setNachname(getRandom(nachnamen));
		return schueler;
	}

	public static AG createAG() 
	{
		AG ag = new AG();
		ag.setBezeichnung(getRandom(ags));
		return ag;

	}

	private static String getRandom(String[] strings) 
	{
		return strings[(int) (Math.random() * strings.length)];
	}

	private static final String[] vornamen = { "Kirk", "James", "Lars", "Robert", "Elvis", "Lemmy", "Bruce", "Tony" };
	private static final String[] nachnamen = { "Hammett", "Hetfield", "Ulrich", "Trujillo", "Presley", "Kilmister", "Dickinson", "Iommy" };
	private static final String[] ags = { "Gitarre", "Gesang", "Schlagzeug", "Bass", "Keyboard", "Triangel" };
	private static final String[] klassen = { "11a", "12b", "10c", "9d" };
}
