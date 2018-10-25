package Programmieren1;

public class Encode {
	
	private int iShift;
	private String strCode ="";
	private char[] tmpChar; 
	
	public String encodeMessage(String message, int shift)
	{
		iShift = shift;
		message = message.toUpperCase();
		tmpChar = message.toCharArray();
		
		for( int i = 0;  i < tmpChar.length; i++)
		{
			if(tmpChar[i] == 89)
			{
				tmpChar[i] =(char) 65; 
			}
			else if(tmpChar[i] == 90)
			{
				tmpChar[i] =(char) 66;
			}
			else if(tmpChar[i] == 32)
			{
				tmpChar[i] =(char) 32;
			}
			else
			{
				tmpChar[i] =(char) (tmpChar[i] + shift);
			}
			strCode += tmpChar[i];
		}
		
		
		return strCode;
	}
	
	public String decodeMessage(String message)
	{
		return "teste";
	}
}
 