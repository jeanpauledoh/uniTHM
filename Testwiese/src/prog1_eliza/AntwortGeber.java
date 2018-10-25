package prog1_eliza;
/**
 * Beschreiben Sie hier die Klasse AntwortGeber.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class AntwortGeber
{
    // Definieren Sie ab hier die Klassenvariablen für AntwortGeber
    
    // Definieren Sie ab hier die Objektvariablen für AntwortGeber
	int anzahlAntworten=0;
  
    // Definieren Sie ab hier die KOnstruktoren für AntwortGeber
    /**
     * Konstruktor für Objekte der Klasse AntwortGeber
     */
    public AntwortGeber()
    {
        // Objektvariable initialisieren
    }

    // Definieren Sie ab hier die Methoden für AntwortGeber
    /**
     * erzeugt eine Antwort
     * 
     * @param   dieFrage String
     * @return  die Antwort String   
     */
    public String gibAntwort(String dieFrage) {
        anzahlAntworten++;
        switch (anzahlAntworten%6) {
            case 0: return "Das vestehe ich nicht. Erklären Sie es bitte genauer!";            
            case 1: return "Seit wann haben Sie diese Probleme?";
            case 2: return "Was denken Sie, ist die Ursache dieser Probleme?";
            case 3: return "Das klingt interessant. Erzählen Sie mir mehr davon!";
            case 4: return "Erzählen Sie mir von Ihrer Mutter!";
            case 5: return "Weiß Ihre Frau davon!";
        }
        return "?";
    }      
}
