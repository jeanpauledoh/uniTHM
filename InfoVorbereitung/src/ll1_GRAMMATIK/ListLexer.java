/**
 * 
 */
package ll1_GRAMMATIK;

/**
 * @author jean-
 *@description: alle anderen Token auﬂer EOF werden hier als statische
 *Variablen hinterlegt
 */
public class ListLexer extends Lexer 
{
	//variablen
	public static int NAME = 2;
	public static int COMMA = 3;
	public static int LBRACK = 4;
	public static int RBRACK = 5;
	
	public static String [] tokenNames =
		{"n/a", "<EOF>", "NAME", "COMMA", "LBRACK", "RBRACK"};
	
	/**
	 * @param input
	 * @description: nimmt den zu verarbeitenden input entgegen und ruft
	 * den Konsgtruktor der superklasse auf
	 */
	public ListLexer(String input) 
	{
		super(input);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @author jean-
	 * @return boolean
	 * @description: ¸berpr¸fung ob es sich bei dem aktuellen
	 * Eingabezeichen um einen Buchstaben handelt
	 */
	public boolean isLetter() 
	{
		return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
	}
	
	/**
	 * @author jean-
	 * @description: ¸berspringen von whitespaces und ‰hnlichem
	 */
	public void WS() 
	{
		while ( c == ' ' || c == '\t' || c == '\n' || c == '\r') 
		{
			consume();
		}
	}

	/* (non-Javadoc)
	 * @see ll1_GRAMMATIK.Lexer#nextToken()
	 * innerhalb einer schleife (solange das EOF nicht erreicht wird)
	 * ¸berpr¸fen wir das sktuelle zeichen mithilfe eines switches.
	 * Hier wird entsprechend dem Symbol reagiert Fixed-String-Symbole 
	 * wie klammern werden direkt gekennzeichnet
	 * und im default teil die Lexer-regel angewendet
	 * 
	 */
	@Override
	public Token nextToken() {
		// TODO Auto-generated method stub
		while ( c!= EOF) 
		{
			switch(c) 
			{
			case ' ':
			case '\t':
			case '\n':
			case '\r':
				WS();
				continue;
			case ',':
				consume();
				return new Token(COMMA, ",");
			case '[':
				consume();
				return new Token(LBRACK, "[");
			case ']':
				consume();
				return new Token(RBRACK, "]");
			default:
				if(isLetter()) 
				{
					return NAME();
				}
				else
				{
					throw new RuntimeException("Invalid char: " +c);
				}
			}
		}
		return new Token(EOF_TYPE, "<EOF>");
	}
	
	/**
	 * nach Lexerebene definiert
	 * NAME: ('a'...'z' | 'A'...'Z')+;
	 *@description: zusammenbau des namen-tokens nach der grammatikregel
	 */
	Token NAME() 
	{
		StringBuilder buf = new StringBuilder();
		do
		{
			buf.append(c);
			consume();
		}while(isLetter());
		return new Token (NAME, buf.toString());
	}

	/* (non-Javadoc)
	 * @see ll1_GRAMMATIK.Lexer#getTokenName(int)
	 */
	@Override
	public String getTokenName(int tt) {
		// TODO Auto-generated method stub
		return tokenNames[tt];
	}

}
