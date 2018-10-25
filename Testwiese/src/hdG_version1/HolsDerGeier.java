package hdG_version1;
import java.util.ArrayList;
/**
 * Beschreiben Sie hier die Klasse HolsDerGeier.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */


public class HolsDerGeier {
    /**
    * Hier definieren Sie die Attribute Ihrer Klasse
    * Beispiel:   private <Typ> Name_des_Attributs
    */
       
    /* Hier stehen die Geier- und Maeusekarten */
    private ArrayList<Integer> nochZuVergebendeGeierKarten=new ArrayList<Integer>();

   /* Hier stehen die vom Computer gespielten Karten */
    private ArrayList<Integer> gespielteKarten=new ArrayList<Integer>();
    /* Hier stehen die Karten, die noch nicht vom Compuert gespielt wurden */
    private ArrayList<Integer> nochNichtGespielt=new ArrayList<Integer>();
    
   /* Hier stehen die vom Geier gespielten Karten */    
    private ArrayList<Integer> vomGegnerGespielteKarten=new ArrayList<Integer>();
    
    /* Punktestaende */
    private int punkte;
    private int meinePunkte;
    private int gegnersPunkte;        
    
    /* Das ist die Referenz Ihr Objekt */
    private Geier geier=new Geier();
    
    
    /**
     * Hier definieren Sie den Konstruktor fuer Objekte Ihrer Klasse (falls Sie einen eigenen brauchen) HolsDerGeier
    */
    public HolsDerGeier()  {
    }

    
    
    /**
     * Neu laden der Karten
    */
    private void ladeSpiel() {
        //  Geier- und Maeusekarten
        for (int i=-5;i<=10;i++) 
            if (i!=0) {
                nochZuVergebendeGeierKarten.add(i);                        
            }
        //  Meine Karten            
        for (int i=1;i<=15;i++)            
            nochNichtGespielt.add(i);            
            
    }
   
    /**   
     *  Spiele zufaellig eine Karte
    */
    private int spieleZufallskarte() {
        int nochVorhanden=nochNichtGespielt.size();            
        int index=(int) (Math.random()*nochVorhanden);
        int ret=nochNichtGespielt.remove(index);
        return ret;
    }
    
    /**    
     *  Spiele zufaellig die naechste Geier- bzw. Maeusekarte    
    */
    private int spieleNaechsteKarte() {
        int nochNichtVergeben=nochZuVergebendeGeierKarten.size();            
        int index=(int) (Math.random()*nochNichtVergeben);
        int ret=nochZuVergebendeGeierKarten.remove(index);
        return ret;
    }    
    
    /**
     * Hier koennen Sie nach meinem letzten Zug fragen
    */    
    public int letzterZug() {
        return gespielteKarten.get(gespielteKarten.size()-1);
    }

    /**
     * Alles auf Null
    */        
    private void reset() {
       gespielteKarten.clear();
       vomGegnerGespielteKarten.clear();
       ladeSpiel();                
       meinePunkte=0;
       gegnersPunkte=0;
    }

    
    /**
     * Starte ein neues Spiel
    */        
    public void naechstesSpiel() {
       System.out.println("===============");
       System.out.println("= NEUES SPIEL, ES STEHT 0:0 =");       
       System.out.println("===============");       
       reset();
    }
    
    
    /**
     * Der naechste Spielzug wird ausgefuehrt.
     * Dazu wird:
     *  - Neue Geier- oder Maeusekarte ermittelt
     *  - Zufaellig eine Karte vom Computer gespielt
     *  - Der Geier gefragt und geprueft, ob er schummelt
     *  - Ausgewertet und der Punktestand gefuehrt
    */            
    public void naechsterZug() throws Exception {       
       if (!nochZuVergebendeGeierKarten.isEmpty()) {
           
           // naechste Geier- Maeusekarte
           int naechsteKarte=spieleNaechsteKarte();
           punkte+=naechsteKarte;
           
           // Zufallszug des Computers
           int meinZug=spieleZufallskarte();
           
           // Aufurf Ihrer Methode!!!!
           int derGegner=geier.gibKarte(naechsteKarte);  

           // Sicher ist sicher: Haben Sie diese Karten schon einmal gespielt?
           // Wenn ja: Jetzt ist aber Schluss
           // Wenn nein: Ich merke mit die Karte
           if (vomGegnerGespielteKarten.contains(derGegner))
                throw new Exception("GESCHUMMELT: Diese Karte wurde bereits gespielt");
           else
               vomGegnerGespielteKarten.add(derGegner);  
               
           if ((derGegner<1)||(derGegner>15))
               throw new Exception("GESCHUMMELT: Diese Karte gibt es gar nicht");

           // Ich merke mir auch meinen Zug, falls Sie mich fragen wollen
           gespielteKarten.add(meinZug);

           // So sieht der aktuelle Zug aus
           System.out.println("Ausgespielte Karte: "+naechsteKarte);
           System.out.println("Meine Karte: "+meinZug);
           System.out.println("Ihre Karte: "+derGegner);

           // Wer kriegt die Punkte?           
           
           // Lösung: Es muss zwischen Maeuse- (nachesteKarte>0) und Geierkarten ((nachesteKarte<0) unterschieden werden.
           if (meinZug!=derGegner) {             
               if (punkte>0)
                    if (meinZug>derGegner)
                        meinePunkte=meinePunkte+punkte;
                    else 
                        gegnersPunkte=gegnersPunkte+punkte;                    
               else
                    if (meinZug<derGegner)
                        meinePunkte=meinePunkte+punkte;
                    else 
                        gegnersPunkte=gegnersPunkte+punkte;                    
               punkte=0;
            } else
              System.out.println("Unentschieden - Die Punkte wandern in die nächste Runde");
           System.out.println("Spielstand: "+meinePunkte+" : "+gegnersPunkte);
       } else
           System.out.println("Spiel ist zu Ende. Sie muessen zuerst die Methode neues Siel aufrufen");
       
    }  
    
    /**
     * Hier kann ein vollstaendiges Spiel durchgefuehrt werden!
    */            
    public void ganzesSpiel() throws Exception {
       if (nochZuVergebendeGeierKarten.isEmpty())
            naechstesSpiel();
        while (!nochZuVergebendeGeierKarten.isEmpty()) {
            naechsterZug();
        }
    }
    
}
