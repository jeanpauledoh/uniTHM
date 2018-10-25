package Programmieren1;


/**
 * Beschreiben Sie hier die Klasse K1.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Codeinvestigation
{
	private int ergebnis;
    // Definieren Sie ab hier die Klassenvariablen für K1
    
    // Definieren Sie ab hier die Objektvariablen für K1

    // Definieren Sie ab hier die KOnstruktoren für K1
    /**
     * Konstruktor für Objekte der Klasse K1
     */
    public Codeinvestigation()
    {
        // Objektvariable initialisieren
    }

    // Definieren Sie ab hier die Methoden für K1
    /**
     * Diese Methode leistet ... Ja, was leistet Sie denn eigentlich?
     * 
     * @param   Parameter n
     * @return  Rückgabewert...
     */
    void m(int n) {
        
        ergebnis = n ;
        while (n!=1) {
            n=n-1 ;
            ergebnis = ergebnis * n ;
        }
    }
    
    public int getResult()
    {
    	return ergebnis;
    }
}
