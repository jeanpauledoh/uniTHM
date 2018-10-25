package prog1_eliza;

/**
 * Beschreiben Sie hier die Klasse AntwortGeber.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class BessererAntwortGeber extends AntwortGeber
{
    public BessererAntwortGeber()
    {
        super();
    }
    // Definieren Sie ab hier die Methoden für AntwortGeber
    /**
     * erzeugt eine Antwort
     * 
     * @param   dieFrage String
     * @return  die Antwort String   s
     */
    public String gibAntwort(String dieFrage) {
    	int test = (int) Math.random() * 100;
        switch ((int) (Math.random() * 100)%6) 
        /*--> es wird erst der wert zwischen 0...1 und dann castet er 
         * zum int dadruch entsteht ohne die klammern immer eine 0
         */
        {
            case 0: return "Das vestehe ich nicht. Erklären Sie es bitte genauer!";            
            case 1: return "Seit wann haben Sie diese Probleme?";
            case 2: return "Was denken Sie, ist die Ursache dieser Probleme?";
            case 3: return "Das klingt interessant. Erzählen Sie mir mehr davon!";
            case 4: return "Erzählen Sie mir von Ihrer Mutter!";
            case 5: return "Weiß Ihre Frau davon!";
            case 6: return "Bischte Behindert?";
            case 7: return "Ich wäre auch sauer wäre ich sie?";
            case 8: return "Ramanam! DingDong! Ramanam DingdingDong!";
            case 9: return "Ich habe keine Ahnnung wovon Sie reden.";
            case 10: return "Sie verschwenden meine Zeit.";
        }
        return "?";
    }      
}
