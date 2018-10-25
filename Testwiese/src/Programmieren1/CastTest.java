package Programmieren1;
import java.lang.Exception;

public class CastTest {
	
	private int n;
	private int m;
	private float f;
	private char c;
	private double d;
	
	public CastTest()
	{
		n = 5;
		m = 62;
		f = 3.14f;
		c = 65;
		d = 2.1;
	}
	
	public CastTest(int newN, int newM, float newF, char newC)
	{
		n = newN; 
		m = newM; 
		f = newF; 
		c = newC;
	}
	
	public void testCastIntToChar()
	{
		//cast to char required
		c=(char) (n+m);
	}
	
	public void testCatstFloatToChar()
	{
		//cast to char required
		c=(char) f;
	}
	
	public void testCastFloatToInt()
	{
		//cast to int required
		n=m++ + (int) f;
	}
	
	public void testInt() throws Exception
	{
		 Exception exception = new Exception();
		 // other way to proof --> boolean funzt auch ohne expliziten cast
		 boolean test = (n==m);
		 boolean test2 = (n>m);
		if(n==m)
		{
			System.out.println("n and m are equal");
		}
		else if (m>n) 
		{
			System.out.println("m is greater than n");
		}
		else
		{
			throw exception;
		}
	}
	
	public void returnValues()
	{
		System.out.println("int n: "+n+", int m: "+m+", float f: "+f+", char c: "+c);
	}
	
	public void testForExam()
	{
		String result="2";
		
		d = (float) f + (int) n;
		
		int fromFloatToInt = (int) ((int) f+f);
		
		float test3 = (float) d;
		
		//int test = n.toString()+35; //nicht möglich da die methode toString nur auf einem Objekt aufgerufen werden kann
		
		boolean test2 = (n>52);
		
		int iRunAway = (int) (15.3 + 5.6);
		
		String wtf = n + result;
		
		System.out.println("From float to int: "+fromFloatToInt+" Is n greater then 52: "+test2+
				" from Double to int: "+iRunAway+" What das a String added to an int produce: "+wtf);
	}
	
	public String examDoit(int n, int m)
	{
		String result="";
		do 
		{
			result=(n%m)+result;
			n=n/m;
		} while (n>0);
		return result;
	}

}
