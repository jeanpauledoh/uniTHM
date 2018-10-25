package Programmieren1;
import java.util.ArrayList;

public class Prime {
	
	private ArrayList<Integer> tmpInput;
	private boolean flag;
	private boolean flag2;
	
	public Prime()
	{
		
	}
	
	public void isPrime(int input)
	{
		tmpInput = new ArrayList<>();
		for (int i = 1; i<=(input/2);i++)
		{
			flag = false;
			while(input%i != 0)
			{
				flag = true;
				break;
			}
			if(!flag && i>1)
			{
				tmpInput.add(i);
			}
		}
		
		if((input%1 == 0) && (input%input == 0))
		{
			if(tmpInput.isEmpty())
			{
				System.out.println(input+" is prime");
			}
			else
			{
				System.out.println(input+" is not prime.Here are other dividers: "+tmpInput.toString());
			}
		}	
	}
	
	public void nextPrime(int input)
	{
		int nextPrime = 0;
		for(int i = input +1; i<20; i++)
		{
			flag2 = false;
			while(!flag2)
			{
				for (int j = 1; j<=(input/2);j++)
				{
					while(input%j != 0)
					{
						flag2 = true;
						nextPrime = i;
						break;
					}
				}	
			}
			
			System.out.println("nextPrime: "+nextPrime);
		}
		
	}
}

