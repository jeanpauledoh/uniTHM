
public class Rucksack {
	static int masse[] = { 3, 4, 7, 8 };
	static int wert[] = { 4, 5,10, 11 };
	static int max = 14;
	static int optimum = 0;
	static int aufrufe = 0;
	static boolean feld[] = new boolean[masse.length];

	public static void main(String args[]) {
		weg(0, 0, 0);
		System.out.println(aufrufe);
	}

	static void weg(int n, int sum_masse, int sum_wert) {
		if (sum_masse > max) //abbruchbedingung des rekursiven aufrufs
			return;
		if (n == feld.length) {
			if (sum_wert > optimum) { // abbruchbedingung des rekursiven aufrufs
				optimum = sum_wert;
				ausgabe(sum_masse, sum_wert);
			}
		} else {
			aufrufe++;
			feld[n] = false;
			weg(n + 1, sum_masse, sum_wert); //rekusiver aufruf des false zweiges des codebaums
			feld[n] = true;
			weg(n + 1, sum_masse + masse[n], sum_wert + wert[n]); //rekusiver aufruf des true zweiges des codebaumes
		}
	}

	static void ausgabe(int sum_masse, int sum_wert) {
		String text = "";
		for (int i = 0; i < feld.length; i++)
			if (feld[i])
				text += masse[i] + " ";
		System.out.println("{" + text + "}   Masse:  " + sum_masse + "  Wert:  " + sum_wert);
	}
}
