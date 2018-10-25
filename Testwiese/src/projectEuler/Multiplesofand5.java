package projectEuler;

public class Multiplesofand5 
{
	private int iResult = 0;
	
	public void routine(int upperBoarder)
	{
		int numberInQ = 0;
		for(int i = 1; i < upperBoarder;i++)
		{
			numberInQ = i;
			if((numberInQ % 3 == 0) || (numberInQ % 5 == 0))
			{
				iResult = numberInQ + iResult;
			}
		}
		
		System.out.println(iResult);
	}

}
