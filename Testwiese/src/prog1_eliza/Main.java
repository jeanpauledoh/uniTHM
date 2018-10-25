package prog1_eliza;
import prog1_eliza.Dialogsteuerung;

public class Main {
	
	private static Dialogsteuerung DIALOGSTEUERUNG = new Dialogsteuerung();
	
	public static void main(String args[])
	{
		testGame();
	}
	
	public static void testGame()
	{
		DIALOGSTEUERUNG.starteDialog();
	}

}
