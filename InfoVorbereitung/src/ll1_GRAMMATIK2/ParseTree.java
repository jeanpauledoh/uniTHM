/**
 * 
 */
package ll1_GRAMMATIK2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jean-
 * @description: ParseTree zum aufzeigen des Syntaxbaums 
 * bzw. nachvollziehen. Dient der Textrepräsentation 
 */
public abstract class ParseTree 
{
	public List<ParseTree> children;
	
	public RuleNode addChild(String value) 
	{
		RuleNode r = new RuleNode(value);
		addChild(value);
		return r;
	}
	
	public TokenNode addChild(Token value) 
	{
		TokenNode t = new TokenNode(value);
		addChild(t);
		return t;
	}
	
	public void addChild(ParseTree t) 
	{
		if(children == null) 
		{
			children = new ArrayList<ParseTree>();
			
		}
		children.add(t);
	}
	
	/**
	 * @author jean-
	 * @description: dient zur ausgabe des Syntaxtrees
	 */
	public abstract String toStringTree();
		
}


