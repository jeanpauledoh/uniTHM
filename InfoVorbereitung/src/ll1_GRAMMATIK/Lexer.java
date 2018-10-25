/**
 * 
 */
package ll1_GRAMMATIK;

/**
 * @author jean-
 * @description: beherbergt die wichtigsten Methoden zur verarbeitung
 * der vorliegenden Eingabe. Bsp.: consume(), march()
 */
public abstract class Lexer 
{
	//variablen
	public static final char EOF = (char) -1; 	// bezeichnet das Ende
	public static final int EOF_TYPE = 1;		// integer-Wert für EOF
	String input;								// die Eingabe
	int p = 0;									// position des Eingabecursors
	char c;										// aktuelles Eingabzeichen unter dem cursor


	/**
	*@author jean-
	*@description: constructor
	*/
	public Lexer(String input) 
	{
		this.input = input;						//setzen des ersten inputcharacters
		c = input.charAt(p);
	}

	//methodsection
	/**
	 * @author jean-
	 * @description: inkrementiert die aktuelle characterposition
	 * und aktualisiert das aktuelle Eingabezeichen
	 */
	public void consume() 
	{
		p++;
		if(p >= input.length()) 
		{
			c = EOF;							// EOF, wenn p über länge des inputs liegt
		}
		else 
		{
			c = input.charAt(p);
		}
	}
	
	public void match(char x) 
	{
		if(c == x) 								// matchen des inputs nach der Grammatik der Sprache
		{
			consume();
		}
		else 
		{
			throw new RuntimeException( "expected "+ x +"but was" + c);
		}
	}
	
	public abstract Token nextToken(); 			// beide Methoden werden in der Subklasse implementiert
	public abstract String getTokenName(int tt);
}