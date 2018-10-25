package Programmieren1;
import ownExceptions.TestException;
import ownExceptions.NotInitializedException;

public class Power {
	
	private int iParam;
	private int result;
	private boolean isSet;
	
	public Power()
	{
		isSet = false;
	}
	
	public Power(int e)
	{
		isSet = true;
		iParam = e;
	}
	
	public void setInputVariable(int input)
	{
		isSet = true;
		iParam = input;
	}
	
	private void routine() throws TestException
	{
		if(iParam < -20)
		{
			TestException exception = new TestException();
			throw exception ;
		}
		else if(iParam == 0)
		{
			result = 1;
		}
		else if (iParam >-20 && iParam < 0)
		{
			iParam = iParam *(-2)/2;
			result = iParam;
			for(int i = 1; i<iParam; i++)
			{
				result = result * iParam;
			}
			
		}
		else
		{
			result = iParam;
			for(int i = 1; i<iParam; i++)
			{
				result = result * iParam;
			}
		}
	}
	
	public void start() throws NotInitializedException
	{
		if(!isSet)
		{
			NotInitializedException exception = new NotInitializedException();
			throw exception;
		}
		else
		{
			try
			{
				routine();
				System.out.println(result);
			}
			catch (TestException e) 
			{
				System.out.println(e.toString());
			}
		}
	}
	

}
