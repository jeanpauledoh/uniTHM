package uebungen;

public class Test1 
{
	public  int doit(int a, int b) 
	{
		if(b<0) 
		{
			b = b * (-1);
		}
		while (b > 0) 
		{
			a--;
			b--;
		}
		return a;
	}
}
