package prog1_eliza;
import java.io.*;
/**
 * Beschreiben Sie hier die Klasse FragenLeser.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class FragenLeser
{
	// Definieren Sie ab hier die Klassenvariablen f�r FragenLeser
	
	// Definieren Sie ab hier die Objektvariablen f�r FragenLeser

	// Definieren Sie ab hier die KOnstruktoren f�r FragenLeser
	/**
	 * Konstruktor f�r Objekte der Klasse FragenLeser
	 */
	public FragenLeser()
	{
		// Objektvariable initialisieren
	}

	// Definieren Sie ab hier die Methoden f�r FragenLeser
	/**
	 * Lies die n�chste Frage von der Konsole
	 * 
	 * @param  	-
	 * @return	die n�chste Frage
	 */	
    public static String liesString(){
             BufferedReader B =
             new BufferedReader(new InputStreamReader(System.in));
             try {
                 return B.readLine();                 
             } catch (Exception e) {
                 return "?";
             }
       }
	
	/**
	 * Methode gibt Prompt auf dem Bildschirm aus und liest die n�chste Frage
	 * 
	 * @param  	-
	 * @return	die n�chste Frage
	 */
	public String naechsteFrage() {
	    System.out.print("> ");
	    return liesString();
    }	    
	    
}
