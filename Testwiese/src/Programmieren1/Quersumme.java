package Programmieren1;

public class Quersumme 
{
	private String intAsString;
	private int result;
	
	public Quersumme(Integer input)
	{
		intAsString = input.toString();
	}
	
	public void test()
	{
		int stringlength = intAsString.length();
		for(int i = 0; i< stringlength; i++)
		{
			result  = result + Integer.parseInt(intAsString.substring(i,i+1));
		}
		System.out.println(stringlength);
		System.out.println(Integer.parseInt(intAsString.substring(1,2)));
		System.out.println(result);
	}
	

}
