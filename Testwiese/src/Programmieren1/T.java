package Programmieren1;

import java.sql.Time;
import java.time.LocalDateTime;

public class T 
{
	private int sec;
	private int hh;
	private int min;
	
	public void time()
	{
		hh = LocalDateTime.now().getHour() ;
		min = LocalDateTime.now().getMinute();
		sec = LocalDateTime.now().getSecond();
		System.out.println(hh+":"+min+":"+sec);
	}
	
	public void test()
	{
	 int x=0;
	 int y=0;
	 while (x<5) 
	 {
		 x=x+1;
		 y=y+x;
		 System.out.print(x+"+"+y+"-");
		 x=x+1;
	 }
	}	
}
