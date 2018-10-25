package ownExceptions;

public class PotentialOverflowException extends Exception
{
	private String strError = "Error: ResultSet could get to big";
	public PotentialOverflowException()
	{
		super();
	}
		
	@Override
	public String toString()
	{
		return "PotentialOverflowException: "+strError;
	}
}
