/**
 * 
 */
package ll1_GRAMMATIK2;

/**
 * @author jean-
 *
 */
public class Token 
{	
	public int type;		//bezeichnet den Token-Type
	public String text;		//beinhaltet die Tokenbeschreibung
	
	/**
	 * @author jean-
	 * @description: Hier wird das Token initialisiert und die
	 * entsprechenden Variablen werden gesetzt
	 */
	public Token(int type, String text) 
	{
		this.type = type;
		this.text = text;
	}

	/**
	 *@author jean-
	 *@return String
	 *@description: Hier werden alle Tokens ausgegeben die es gibt 
	 */
	@Override
	public String toString() 
	{
		String tname = ListLexer.tokenNames[type];
		return "<'" + tname + "," + text + ">";
	}
}
