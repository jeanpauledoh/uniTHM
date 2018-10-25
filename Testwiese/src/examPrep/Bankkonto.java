package examPrep;
import java.util.Random;
import java.util.AbstractMap.SimpleImmutableEntry;

public class Bankkonto 
{
	private int guthaben;
	private int kontonummer;
	private String inhaber;
	private boolean isAbbuchung;
	
	public Bankkonto()
	{
		Random rand = new Random();
		kontonummer = rand.nextInt(10000000);
		guthaben = rand.nextInt(500);
		inhaber = "";
		isAbbuchung = false;
	}
	
	public Bankkonto(String inhaber)
	{
		this();
		this.inhaber = inhaber; 
	}
	
	public void betragEinzahlen(int betrag)
	{
		isAbbuchung = false;
		setNeuenBetrag(betrag, isAbbuchung);
	}
	
	private void setNeuenBetrag(int betrag, boolean isAbbuchung2) 
	{
		if(betrag < 0)
		{
			System.out.println("Auszahlung/Einzahlung negativer Beträge nicht möglich!");
		}
		else
		{
			if((isAbbuchung2) && (betrag < guthaben))
			{
				guthaben = guthaben - betrag;
				System.out.println("Der folgende Betrag wurde abgebucht: "+betrag);
			}
			else if(betrag > guthaben)
			{
				System.out.println("Auszahlung nicht möglich da Betrag "+betrag+" größer als das Guthaben "+guthaben+" ist");
			}
			else
			{
				guthaben = guthaben + betrag;
				System.out.println("Der folgende Betrag wurde eingezahlt: "+betrag);
			}
		}
		
	}

	public void betragAuszahlen(int betrag)
	{
		isAbbuchung = true;
		setNeuenBetrag(betrag, isAbbuchung);
	}
	
	public int aktGuthaben()
	{
		return getAktBetrag();
	}
	
	private int getAktBetrag() 
	{
		return guthaben;
	}

	public void inhaberSetzen(String neuerInhaber)
	{
		setInhaber(neuerInhaber);
	}

	private void setInhaber(String neuerInhaber) 
	{
		if(inhaber.isEmpty())
		{
			inhaber = neuerInhaber;
		}
		else
		{
			System.out.println("Es existiert bereits ein Inhaber des Kontos.");
		}
		
	}
	
	public void zeigeInfos()
	{
		System.out.println("Inhaber: "+inhaber+"\n"
				+"Kontonummer: "+kontonummer+"\n"
				+"Guthaben: "+guthaben);
	}
}
