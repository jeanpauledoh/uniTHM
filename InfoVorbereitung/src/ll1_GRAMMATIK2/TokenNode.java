/**
 * 
 */
package ll1_GRAMMATIK2;

/**
 * @author jean-
 *
 */
public class TokenNode extends ParseTree 
{
	
	public Token token;

	/**
	 * 
	 */
	public TokenNode(Token token) 
	{
		// TODO Auto-generated constructor stub
		this.token = token;
	}
	
	/**
	 * @author jean-
	 * @description: dient der rückgabe des tokentyps
	 */
	@Override
	public String toString() 
	{
		return ListLexer.tokenNames[token.type];
	}

	@Override
	public String toStringTree() 
	{

		if(children == null || children.size() == 0) 
		{
			return this.toString();
		}
		StringBuilder buf = new StringBuilder();
		buf.append("(");
		buf.append(this.toString() + " ");
		for(int i = 0; i < children.size(); i++) 
		{
			if(i>0) 
			{
				buf.append(' ');
			}
			buf.append(children.get(i).toStringTree());
		}
		
		buf.append(')');
		System.out.println(buf.toString());
		return buf.toString();
	}
	
}
