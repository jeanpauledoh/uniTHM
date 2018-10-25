package hdG_version1;
import hdG_version1.HolsDerGeier;

public class Main {
	
	private static HolsDerGeier HOLSDERGEIER = new HolsDerGeier();
	
	public static void main(String args[])
	{
		testGame();
	}
	
	public static void testGame()
	{
		try {
			HOLSDERGEIER.ganzesSpiel();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
