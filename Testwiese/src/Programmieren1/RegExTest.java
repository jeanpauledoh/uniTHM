package Programmieren1;
import java.util.regex.*;

public class RegExTest 
{
	public void matching()
	{
		//Pattern p = Pattern.compile("[^\\s]+u[^\\s]*");
		Pattern p = Pattern.compile("\\b\\w+?u\\w*\\b");
		String seq="aaaae";
		String seq2="alter falter du kleiner hund";
		Matcher m = p.matcher(seq2);
		while(m.find())
		{
			System.out.println(m.group()+m.start()+m.end());
		}
		boolean b = m.matches();
		System.out.println(b);
	}

}
