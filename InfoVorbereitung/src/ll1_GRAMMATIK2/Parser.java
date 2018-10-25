/**
 * 
 */
package ll1_GRAMMATIK2;

/**
 * @author jean-
 * @description: der parser wird vom lexer mit tokens versorgt
 */
public abstract class Parser 
{
	Lexer input;							//hier kommen die tokens her
	Token lookahead;						//welches Token ist das nächste?
	
	/**
	 * @author jean-
	 * @description: constructor der klasse (Lexer wird gesetzt)
	 * 
	 */
	public Parser(Lexer input) 
	{
		this.input = input;
		consume();							//initialisierung des lookaheads
	}
	
	/**
	 * @author jean-
	 * @description: lookahead wird noch grammatik der Sprache gematched
	 * @param int Token_Type
	 */
	public void match(int x) 
	{
		if(lookahead.type == x) 
		{
			consume();
		}
		else 
		{
			throw new RuntimeException("Expectiong " + input.getTokenName(x) +
					"; but was " + lookahead);
		}
	}
	
	public void consume() 
	{
		lookahead = input.nextToken();
	}
}
