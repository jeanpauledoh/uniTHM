package Programmieren1;

public class Sternchen {
	private String star = "*";
	
	public void sternCon()
	{
		for(int i = 1; i<=20;i++)
		{
			for(int j = 0; j<i;j++)
			{
				System.out.print(star);
			}
			System.out.println("");
		}
	}
	

}
