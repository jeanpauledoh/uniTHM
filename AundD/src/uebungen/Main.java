package uebungen;

import java.util.ArrayList;

public class Main 
{
	private static Rekursiv_ggt TESTEN = new Rekursiv_ggt();
	private static Rekursiv_Dualzahlen DUALTESTEN = new Rekursiv_Dualzahlen();
	private static Test1 TES = new Test1();
			
	public static void main(String args[]) 
	{
		System.out.println("Nothing to see here");
		//rek();
		//dualrek();
		test();
	}
	
	
	public static void test() 
	{
		System.out.println(TES.doit(10, -3));
	}
	public static void rek() 
	{
		TESTEN.nichtRek(8, 12);
		TESTEN.nichtnichtRek(8, 12);
	}
	
	public static void dualrek() 
	{
		DUALTESTEN.dualTest(5);
	}
	
	public static void justLooking()
	{
		Object obj = new Object();
		String strTEST = "Hallo123";
		int x = 4;
		ArrayList<Object> lstTest  = new ArrayList<>();
		ArrayList<Object> lstTest2  = new ArrayList<>();
		
		lstTest.add(obj);
		lstTest.add(strTEST);
		lstTest.add(x);
		
		System.out.println(lstTest);
		
		lstTest2.addAll(lstTest);
		
		System.out.println();
		
		
	}

}
