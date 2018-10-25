package hdG_version3;
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
   
    private HolsDerGeier myHolsDerGeier; 
   
    /**
     * Hier definieren Sie den Konstruktor fuer Objekte Ihrer Klasse (falls Sie einen eigenen brauchen) Geier
    */
    public Geier(HolsDerGeier ref)
    {
        myHolsDerGeier=ref;
    }

    public int gibKarte(int naechsteKarte) {
        
        myHolsDerGeier.letzterZug(0);
        if (naechsteKarte<0)
            return naechsteKarte+6;
        return naechsteKarte+5;
        
    }
    
    
}
