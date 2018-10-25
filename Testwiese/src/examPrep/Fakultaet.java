package examPrep;

public class Fakultaet 
{
	private int iZuFalkutieren;
	private int iResult;
	
	public Fakultaet(int zahl)
	{
		iZuFalkutieren = zahl;
		iResult = 1;
	}
	
	public int fakultieren()
	{
		if (iZuFalkutieren == 0)
		{
			System.out.println("0! = 1");
		}
		else if(iZuFalkutieren < 0)
		{
			System.out.println("Fakultierung für Negative Zahlen nicht vorgesehen");
			return 0;
		}
		else
		{
			for(int i = 1;i<=iZuFalkutieren;i++)
			{
				iResult = iResult*i; 
			}
		}
		return iResult;
	}

}
