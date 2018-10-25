package examPrep;

public class Gluehbirne 
{
	private boolean anaus;
	
	public Gluehbirne()
	{
		anaus = false;
	}
	
	public boolean gluehbirneAn()
	{
		return setgluehbirneAn();
	}
	
	private boolean setgluehbirneAn() 
	{
		if(!anaus)
		{
			anaus = true;
		}
		else
		{
			System.out.println("Ist bereits an.");
		}
		
		return anaus;
		
	}

	public boolean gluehbirneAus()
	{
		return setGluehbirneAus();
	}
	
	private boolean setGluehbirneAus() 
	{
		if(anaus)
		{
			anaus = false;
		}
		else
		{
			System.out.println("Ist bereits aus.");
		}
		
		return anaus;
		
	}

	public boolean gluehbirneZustand()
	{
		return getGluehbirneZustand();
	}

	private boolean getGluehbirneZustand() 
	{
		if(anaus)
		{
			System.out.println("Ist angeschaltet");
		}
		else
		{
			System.out.println("Ist ausgeschaltet");
		}
		return anaus;
		
	}

}
