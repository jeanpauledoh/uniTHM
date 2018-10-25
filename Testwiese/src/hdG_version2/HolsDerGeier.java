package hdG_version2;
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
    private ArrayList<Integer> vonRandomGespielteKarten=new ArrayList<Integer>();
    
   /* Hier stehen die vom Geier gespielten Karten */    
    private ArrayList<Integer> vomGeierGespielteKarten=new ArrayList<Integer>();
    
    /* Punktestaende */
    private int punkte;
    private int randomPunkte;
    private int geierPunkte;    
    
    /* Das ist die Referenz Ihr Objekt */
    private Geier geier;
    private Random random;    
    
    
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
        //übergibt sich selbst
        geier=new Geier(this);
        random=new Random();                
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
     * Hier kann nach dem letzten Zug gefragt werden. Aber diese Methode ist so eigentlich nciht wirklich gelungen.
    */
    //WAT
    public int letzterZug(int nummer) {
        if (nummer==0)
         if (vonRandomGespielteKarten.size()>0)
            return vonRandomGespielteKarten.get(vonRandomGespielteKarten.size()-1);
         else
            return -99;
        else 
         if (vomGeierGespielteKarten.size()>0)        
            return vomGeierGespielteKarten.get(vomGeierGespielteKarten.size()-1);
         else
            return -99;
    }

    /**
     * Alles auf Null
    */        
    private void reset() {
       vomGeierGespielteKarten.clear();
       vonRandomGespielteKarten.clear();       
       ladeSpiel();                
       randomPunkte=0;
       geierPunkte=0;
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
           
           // die Züge der beiden Spieler
           int randomZug=random.gibKarte(naechsteKarte);
           int geierZug=geier.gibKarte(naechsteKarte);

           // Sicher ist sicher: Haben Sie diese Karten schon einmal gespielt?
           // Wenn ja: Jetzt ist aber Schluss
           // Wenn nein: Ich merke mit die Karte
           if (vomGeierGespielteKarten.contains(geierZug) )
                throw new Exception("GESCHUMMELT: Diese Karte wurde bereits gespielt");
           else
               vomGeierGespielteKarten.add(geierZug);  
               
           if ((geierZug<1)||(geierZug>15))
               throw new Exception("GESCHUMMELT: Diese Karte gibt es gar nicht");

           // Ich merke mir auch meinen Zug, falls Sie mich fragen wollen
           //Random in sie Exception miteinbezogen
           if (vonRandomGespielteKarten.contains(randomZug) )
                throw new Exception("GESCHUMMELT: Diese Karte wurde bereits gespielt");
           else
               vonRandomGespielteKarten.add(randomZug);  
               
           if ((randomZug<1)||(randomZug>15))
               throw new Exception("GESCHUMMELT: Diese Karte gibt es gar nicht");           

           // So sieht der aktuelle Zug aus
           System.out.println("Ausgespielte Karte: "+naechsteKarte);
           System.out.println("Random Karte: "+randomZug);
           System.out.println("Geier Karte: "+geierZug);

           // Wer kriegt die Punkte?           
           
           // Lösung: Es muss zwischen Maeuse- (nachesteKarte>0) und Geierkarten ((nachesteKarte<0) unterschieden werden.
           if (randomZug!=geierZug) {             
               if (punkte>0)
                    if (randomZug>geierZug)
                       randomPunkte=randomPunkte+punkte;
                    else 
                        geierPunkte=geierPunkte+punkte;                    
               else
                    if (randomZug<geierZug)
                       randomPunkte=randomPunkte+punkte;
                    else 
                        geierPunkte=geierPunkte+punkte;                    
               punkte=0;         
           } else
              System.out.println("Unentschieden - Punkte wandern in die naechste Runde");
           System.out.println("Spielstand: "+randomPunkte+" : "+geierPunkte);
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
