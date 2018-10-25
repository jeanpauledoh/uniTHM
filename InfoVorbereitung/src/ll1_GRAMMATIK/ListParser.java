/**
 * 
 */
package ll1_GRAMMATIK;

/**
 * @author jean-
 * @description: enthält den Parsingcode für die Grammatik
 */
public class ListParser extends Parser 
{
	ParseTree root;								//referenz auf die Wurzel des Baumes
	ParseTree currentNode;						//speichert jeweils den aktuellen knoten
	/**
	 * @param input
	 * @description: ruft den constructor der superklasse auf um den eingabeinput
	 * nach den grammatikregeln mithilfe der tokens zu verarbeiten
	 */
	public ListParser(Lexer input) 
	{
		super(input);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @author jean-
	 * @description: das aktuelle zu matchende TOken wird als Kind dem
	 * aktuellen knoten hinzugefügt
	 */
	@Override
	public void match(int x) {
		// TODO Auto-generated method stub
		currentNode.addChild(lookahead);
		super.match(x);
	}
	
	/*
	 * muster:
	 * void <<rule>>()
	 * {
	 * 		RuleNode r = new RuleNode("<<rule>>");
	 * 		if(root == null)
	 * 		{
	 * 			root = r;
	 * 		}
	 * 		else
	 * 		{
	 * 			currentNode.addChild(r);	
	 * 		}
	 * 		ParseTree _save = currentNode;
	 * 		currentNode = r;
	 * 		<<normal-rule-code>>
	 * 		currentNode = _save;
	 * }	
	 */

	/**
	 * list: '['elements']';
	 * list besteht aus einer öffnenden klammer 'elements' und
	 * einer schließenden klammer
	 * Anpassung des Codes zur darstellung im syntaxbaum
	 */
	void list() 
	{
		RuleNode r = new RuleNode("List");
		if(root == null) 
		{
			root = r;
		}
		else
		{
			currentNode.addChild(r);
		}
		ParseTree _save = currentNode;
		currentNode = r;
		//old code
		match(ListLexer.LBRACK);
		elements();
		match(ListLexer.RBRACK);
		//end
		currentNode = _save;
	}
	
	/**
	 * elements: element(','element)*;
	 * elements besteht aus 'element' und kleiner oder unendlich
	 * vielen durch ein komma getrennten verknüpfungen von element
	 * Anpassung des Codes zur darstellung im syntaxbaum
	 */
	void elements()
	{
		RuleNode r = new RuleNode("Elements");
		if(root == null) 
		{
			root = r;
		}
		else 
		{
			currentNode.addChild(r);
		}
		ParseTree _save = currentNode;
		currentNode = r;
		//old code
		element();
		while (lookahead.type == ListLexer.COMMA) 
		{
			match(ListLexer.COMMA); element();
		}
		//end
		currentNode =_save;
	}
	
	/**
	 * element: name | list;
	 * element besteht aus name oder einer weiteren liste
	 * Anpassung des Codes zur darstellung im syntaxbaum
	 */
	void element() 
	{
		RuleNode r = new RuleNode("Element");
		if(root == null) 
		{
			root = r;
		}
		else 
		{
			currentNode.addChild(r);
		}
		ParseTree _save = currentNode;
		//old code
		if (lookahead.type == ListLexer.NAME) 
		{
			match(ListLexer.NAME);
		}
		else if(lookahead.type == ListLexer.LBRACK) 
		{
			list();
		}
		else 
		{
			throw new RuntimeException("Expected name or list but was" + lookahead);
		}
		//end
		currentNode = _save;
	}

}
 