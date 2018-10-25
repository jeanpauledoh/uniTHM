package examPrep;

public class Power 
{
	int basis;
	int exponent;
	double iResult;
	String err;
	
	public Power()
	{
		iResult = 1;
		basis = 2;
		exponent = 1;
		err="Fehler";
	}
	
	public double power2(int neuerExp)
	{
		exponent = neuerExp;
		if(exponent < 0)
		{
			for(int i = -1;i>=exponent;i--)
			{
				iResult = iResult / basis;
				
			}
		}
		else if(exponent == 0)
		{
			return iResult;
		}
		else
		{
			for(int i = 1;i<=exponent;i++)
			{
				iResult = iResult * basis;
			}
		}
		return iResult;
	}
	
	public int quersumme(int zahl)
	{
		int qs = 0;
		if(zahl < 0)
		{
			System.out.println("Not happening");
			return 0;
		}
		else
		{
			while (0 != zahl) 
			{
				// addiere die letzte ziffer der uebergebenen zahl zur summe
				qs = qs + (zahl % 10); // rest der division mit 10 welcher gleichzeitig die ziffer repräsentier:(151 /10 = 15 R 1)
				// entferne die letzte ziffer der uebergebenen zahl
				zahl = zahl / 10; //abschneiden der letzten ziffer der übergeben zahl da im int nur ganzen zahlen gesprichert werden
				//d.h. 151 / 10 = 15,1 --> da es ein int ist: 15.
			}
			
		}
		return qs;
		
	}

}
