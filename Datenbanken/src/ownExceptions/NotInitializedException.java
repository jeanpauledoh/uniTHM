package ownExceptions;
import java.lang.Exception;

public class NotInitializedException extends Exception
{
	private String strError = "Error: Variable not Initialized";
	public NotInitializedException()
	{
		super();
	}
	
@Override
	public String toString()
	{
		return strError;
	}
}

