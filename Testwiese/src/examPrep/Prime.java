package examPrep;

import java.util.ArrayList;

public class Prime 
{
	private boolean isPrime;

	public Prime()
	{
		isPrime = true;
	}
	
	public void isPrime(int checkNumber)
	{
		for(int i = 1; i <=(checkNumber / 2); i++)
		{
			if((checkNumber%i == 0) && (i != 1))
			{
				isPrime = false;
			}
		}
		
		if(isPrime)
		{
			System.out.println(checkNumber+ " is Prime");
			//return checkNumber;
		}
		else
		{
			System.out.println(checkNumber+ " is not Prime");
			//return checkNumber;
		}
	}
	
	public void primfactors(int checknumber)
	{
		ArrayList<Integer> tmpNumbers = new ArrayList<>();
		for(int i = 2; i<(checknumber/2);i++)
		{
			if(checknumber%i == 0)
			{
				tmpNumbers.add(i);
			}
		}
		
		System.out.println("Primfaktorzerlegung von: "+checknumber);
		for(int i = 0; i < tmpNumbers.size(); i++)
		{
			System.out.println(tmpNumbers.get(i));
		}
		
 	}
	
	
	
	public int nextPrime(int checkNumber)
	{
		for(int i = checkNumber+1; i <= (checkNumber + 10); i++) // --> ab der zahl +1 wird geprüft was die nächste primzahl ist
		{
			for(int j = 1; j <=(i / 2); j++) // --> geschachtelte for schleife welche für jedes i prüft ob dieses i durch ein j (1 bis (i/2)) teibar ist
			{
				if((i%j == 0) && (j != 1))
				{
					break; // wenn teilbarkeit besteht, nächstes i
				}
			}
			
		}
		
		return 0;
	}
	
	public void test()
	{
		int a=9, b=5;
		for (int i=1;i<6;i++) {
		 a--;
		 boolean booli=a>b;
		 System.out.println(!booli?a%2:b%2);
		}

	}
}
