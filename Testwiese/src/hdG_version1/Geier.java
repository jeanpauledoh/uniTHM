package hdG_version1;
/**
 * Beschreiben Sie hier die Klasse Geier.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Geier {
    /**
    * Hier definieren Sie die Attribute Ihrer Klasse
    * Beispiel:   private <Typ> Name_des_Attributs
    */

    /**
     * Hier definieren Sie den Konstruktor fuer Objekte Ihrer Klasse (falls Sie einen eigenen brauchen) Geier
    */
    public Geier()
    {
    }

    public int gibKarte(int naechsteKarte) {
    	
        if (naechsteKarte<0)
            return naechsteKarte+6;
        return naechsteKarte+5;
        
    }
    
    
}
