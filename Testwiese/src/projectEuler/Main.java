package projectEuler;
import projectEuler.*;
import Programmieren1.FirstTest;
import ownExceptions.NotInitializedException;

public class Main 
{
	private static Multiplesofand5 MULTI = new Multiplesofand5();
	
	public static void main(String args[])
	{
		System.out.println("This is the testsite for the eulerProject");
		multi();
	}
	
	public static void multi()
	{
		MULTI.routine(1000);
	}
}