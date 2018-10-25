package examPrep;

public class Main {
	
	private static Gluehbirne BIRNE = new Gluehbirne();
	private static Bankkonto BANK = new Bankkonto();
	private static DebuggTest DEB = new DebuggTest();
	private static Fakultaet FAK = new Fakultaet(-4);
	private static Power POW = new Power();
	private static Prime PRI = new  Prime();
	
	public static void main(String args[])
	{
		//birnenTest();
		//bankkonto();
		//debugtest();
		//fakultierung();
		//exponentierung(1234);
		checkPrime(16);
	}
	
	public static void birnenTest()
	{
		BIRNE.gluehbirneAus();
		BIRNE.gluehbirneZustand();
	}
	
	public static void bankkonto()
	{
		BANK.zeigeInfos();
		BANK.betragEinzahlen(150);
		System.out.println(BANK.aktGuthaben());
		BANK.betragAuszahlen(150);
		System.out.println(BANK.aktGuthaben());
		BANK.inhaberSetzen("Jean-Paul Edoh");
		BANK.zeigeInfos();
	}
	
	public static void debugtest()
	{
		DEB.m();
	}
	
	public static void fakultierung()
	{
		System.out.println(FAK.fakultieren());
	}
	
	public static void exponentierung(int zahl)
	{
		System.out.println(POW.power2(zahl));
		System.out.println(POW.quersumme(zahl));
	}
	
	public static void checkPrime(int zahl)
	{
		//PRI.isPrime(zahl);
		//PRI.nextPrime(zahl);
		//PRI.primfactors(zahl);
		PRI.test();
	}
}
