package uebungen;

public class Rekursiv_Dualzahlen 
{
	private String zahlD = "";
	
	public void dualTest(int zahl) 
	{
		
		//append des Stringbuilders funzt nicht
		StringBuilder strb = new StringBuilder(zahlD);
		if(zahl == 0) 
		{
			System.out.println(strb); 
		}
		else
		{
			int moduloErg = 0;
			int neueZahl = 0;
						
			moduloErg = zahl%2;
			neueZahl = zahl / 2;
			String moduloString ="" + moduloErg;
			
			System.out.println(moduloErg);
			
			strb.append(moduloString);
			dualTest(neueZahl);
		}
	}

}
