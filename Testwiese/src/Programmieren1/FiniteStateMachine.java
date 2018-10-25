package Programmieren1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FiniteStateMachine 
{
	public enum States {START,S1,END,FAIL};
	
	public static boolean sm(String s) 
	{
		States state = States.START;
		int i=0;	
		
		while (i<s.length() && state!=States.FAIL) 
		{	
			char c = s.charAt(i++);
			switch(state)
			{
			case START:
				state = c == 'a' ? States.S1 : States.FAIL; 
				break;
			case S1:
			case END:
				state = c == 'e' ? States.END : States.FAIL;
				break;
			case FAIL:
				return false;
			}

		}
		return state == States.END;
	}
}
