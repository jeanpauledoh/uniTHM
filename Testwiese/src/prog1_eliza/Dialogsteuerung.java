package prog1_eliza;
import java.util.ArrayList;
/**
 * Beschreiben Sie hier die Klasse Dialogsteuerung.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Dialogsteuerung
{
    // Definieren Sie ab hier die Klassenvariablen f�r Dialogsteuerung
    
    // Definieren Sie ab hier die Objektvariablen f�r Dialogsteuerung
    private FragenLeser leser;
    private AntwortGeber antworter;
    private ArrayList<String> beleidigungen;

    // Definieren Sie ab hier die KOnstruktoren f�r Dialogsteuerung
    /**
     * Konstruktor f�r Objekte der Klasse Dialogsteuerung
     */
    public Dialogsteuerung()
    {
        // Objektvariable initialisieren
        leser=new FragenLeser();
        //antworter=new AntwortGeber();
        antworter=new BessererAntwortGeber(); 
    }

    // Definieren Sie ab hier die Methoden f�r Dialogsteuerung
    /**
     * Gibt Willkommensbotschaft aus
     */    
    private void sagHallo() {
        System.out.println("Guten Tag. Nehmen Sie Platz.");
        System.out.println("Wie kann ich Ihnen helfen?");        
    }
    /**
     * Gibt Willkommensbotschaft aus
     */    
    private void sagAufwiedersehen() {
        System.out.println("Sch�n, dass Sie da waren. Sie schaffen das schon!");
        System.out.println("Bis zur n�chsten Sitzung und denken Sie an die Rechnung.");        
    }
    
    private void beleidige()
    {
    	System.out.println("Sie haben mich beleidigt.");
    	System.out.println("Sie sind kein netter Mensch.");
    }
    /**
     * Startet die Kommunikation und steuert die Kommunikation.
     */
    public void starteDialog() {
        
        boolean fertig=false;
        sagHallo();
        
        while (!fertig) {
            String frage=leser.naechsteFrage();            
            if (frage.startsWith("bye")) {
                fertig=true;
            } else {
                String antwort=antworter.gibAntwort(frage);
                System.out.println(antwort);
            }
            if ((frage.toLowerCase().contains("arsch") || frage.toLowerCase().contains("nutte")))
            		{
            			beleidige();
            		}
       }
       sagAufwiedersehen();
    }
}