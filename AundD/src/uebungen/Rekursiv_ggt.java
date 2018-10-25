package uebungen;
import java.util.ArrayList;

public class Rekursiv_ggt 
{
	public void nichtRek(int zahl1, int zahl2) 
	{
		int ggt = 0;
		ArrayList<Integer> teiler = new ArrayList<Integer>();
		
		for(int i = 1; i<=zahl1;i++) 
		{
			if(zahl1%i == 0) 
			{
				teiler.add(i);
			}
		}
		
		for(int i = 1; i <= teiler.size()-1; i++) 
		{
			if (zahl2%teiler.get(i) == 0) 
			{
				ggt=teiler.get(i);
			}
		}
		
		System.out.println(ggt);
	}
	
	public void nichtnichtRek(int zahl1, int zahl2) 
	{
		int rest = zahl1 % zahl2;
		if (rest == 0) 
		{
			System.out.println(zahl2);
		}
		else 
		{
			nichtnichtRek(zahl2, rest);
		}
	}

}
