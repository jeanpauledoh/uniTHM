package hdG_version3;
/**
 * Beschreiben Sie hier die Klasse QuickAndDirty.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class QuickAndDirty extends Random {
    

    private HolsDerGeier myHolsDerGeier; 
   
    private int[] zuege=new int[15]; 
    private int index;
    /**
     * Hier definieren Sie den Konstruktor fuer Objekte Ihrer Klasse (falls Sie einen eigenen brauchen) Geier
    */
    public QuickAndDirty(HolsDerGeier ref)
    {
        myHolsDerGeier=ref;
    }

    /**
     * Hier definieren Sie den Konstruktor fuer Objekte Ihrer Klasse (falls Sie einen eigenen brauchen) QuickAndDirty
    */
    public QuickAndDirty()
    {
    }

    public int gibKarte(int naechsteKarte) {
        
        int lk=myHolsDerGeier.letzterZug(1);
        if (lk!=-99) {
            zuege[index]=lk;
            index=index+1;
        }
        //System.out.println();
        //for (int i=0;i<zuege.length;i++)
        //    System.out.print(zuege[i]+" ");
        if (naechsteKarte<0)
            return naechsteKarte+6;
        if (naechsteKarte==10)
          return 6;  
        else 
          return naechsteKarte+6;
        
    }

    
}
