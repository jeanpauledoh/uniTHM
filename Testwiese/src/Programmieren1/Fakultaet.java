package Programmieren1;
import java.util.Random;

public class Fakultaet {
	
	private boolean isRandom;
	private int inputN;
	
	public Fakultaet()
	{
		isRandom = true;
		Random rand = new Random();
		inputN = rand.nextInt(10);
	}
	
	public Fakultaet(int input)
	{
		inputN = input;
	}
	
	private int routine(int input)
	{
		int result = 1;
		if(input == 1)
		{
			return result;
		}
		else
		{
			for(int i = 1; i <= input; i++ )
			{
				result = result * i;
			}
		}
		return result;
	}
	
	public void showValue()
	{
		if(isRandom)
		{
			System.out.println("Random Value: "+inputN);
		}
		else
		{
			System.out.println(inputN);
		}
	}
	
	public void doStuff()
	{
		System.out.println(routine(inputN));
	}
}
