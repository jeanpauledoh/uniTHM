package setrecognition;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainList {
	public static void main(String[] args) {
		System.out.println("Willkommen zum ListLexer-Programm. Bitte geben Sie einen zu �berpr�fenden Satz ein.");
		System.out.println("'q!' beendet die Eingabe.");

		boolean finished = false;

		BufferedReader keyboardInput = new BufferedReader(new InputStreamReader(System.in));
		String inputLine;

		while (!finished) {
			try {
				inputLine = keyboardInput.readLine();
				System.out.println("inputLine: " + inputLine);
				if (inputLine.equals("q!")) {
					System.out.println("Programm wird beendet.");
					finished = true;
				} else {
					ListLexer ll = new ListLexer(inputLine);
					ListParser lp = new ListParser(ll);
					try {
						lp.list();
						System.out.println("Wort gehoert zur List-Sprache.");
					} catch (Exception e) {
						System.out.println("Eingabe ist kein gueltiges Wort der List-Sprache");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
