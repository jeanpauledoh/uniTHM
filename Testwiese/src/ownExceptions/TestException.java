package ownExceptions;
import java.lang.Exception;

public class TestException extends Exception
{
	private String strError = "FEHLER";
	public TestException()
	{
		super();
	}
	
@Override
	public String toString()
	{
		return strError;
	}
}
