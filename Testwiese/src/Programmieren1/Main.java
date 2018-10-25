package Programmieren1;
import Programmieren1.*;
import ownExceptions.NotInitializedException;

public class Main 
{
	private static FirstTest FIRSTTEST = new FirstTest();
	private static Codeinvestigation K1 = new Codeinvestigation();
	private static CastTest CASTEST = new CastTest();
	private static DebuggerTest DEBUGGERTEST = new DebuggerTest();
	private static Fakultaet FAKULTAET = new Fakultaet();
	private static Power POWER = new Power();
	private static Quersumme QUERSUMME = new Quersumme(15);
	private static Prime PRIME = new Prime();
	private static Sternchen STERNCHEN = new Sternchen();
	private static T T = new T();
	private static Encode  ENCODE = new Encode();
	private static RegExTest REG = new RegExTest();
	private static FiniteStateMachine FSM = new FiniteStateMachine();
	private static Matrix MAT = new Matrix();
	private static Palindrome PAL = new Palindrome();
	
	public static void main(String args[])
	{
		star();
	}
	
	private static void palindrome()
	{
		System.out.println(PAL.isPalindrome("renner"));
	}
	
	private static void matrix()
	{
		int matrize[][] = new int[][] {{2,4,6,8},{4,14,8,6},{6,8,14,4},{8,6,4,2}};
		System.out.println(MAT.isSymmetric(matrize));
	}
	
	private static void fsm()
	{
		System.out.println(FSM.sm("abe"));
	}
	
	private static void regex()
	{
		REG.matching();
	}
	
	private static void encode()
	{
		System.out.println(ENCODE.encodeMessage("Herpy Derp", 2));
	}
	
	private static void t()
	{
		T.test();
	}
	
	private static void star()
	{
		STERNCHEN.sternCon();
	}
	
	private static void prime()
	{
		PRIME.isPrime(13);
		PRIME.nextPrime(11);
	}
	
	private static void quersumme()
	{
		QUERSUMME.test();
	}
	
	private static void power()
	{
		POWER.setInputVariable(-22);
		try
		{
			POWER.start();
		}
		catch (NotInitializedException e)
		{
			System.out.println(e.toString());	
		}
	}
	
	private static void faktultaet()
	{
		FAKULTAET.showValue();
		FAKULTAET.doStuff();
	}
	private static void debuggerTest()
	{
		DEBUGGERTEST.m();
	}
	
	private static void firstTest()
	{
		FIRSTTEST.test();
	}
	
	private static void codeInvestigation(int zahl)
	{
		K1.m(zahl);
		System.out.println(K1.getResult());
	}
	
	private static void castTest()
	{
		//CASTEST.testCastFloatToInt();
		//CASTEST.testForExam();
		System.out.println(CASTEST.examDoit(64, 4));
		System.out.println(2%3);
	}
	
}