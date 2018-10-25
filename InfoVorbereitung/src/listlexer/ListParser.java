package listlexer;

public class ListParser extends Parser {
	
	ParseTree root;
	ParseTree currentNode;
	
	public void match(int x) {
		currentNode.addChild(lookahead);
		super.match(x);
	}
	
	public ListParser(Lexer input) {
		super(input);
	}
	
	/** list: '[' elements ']'; */
	void list() {
		RuleNode r = new RuleNode("List");
		if(root == null) 
			root = r;
		else
			currentNode.addChild(r);
		ParseTree _save = currentNode;
		currentNode = r;
		// begin old code
		match(ListLexer.LBRACK); 
		elements();
		match(ListLexer.RBRACK);
		// end old code
		currentNode = _save;
	}
	
	/** elements: element (',' element)* */
	void elements() {
		RuleNode r = new RuleNode("Elements");
		if(root == null) root = r;
		else currentNode.addChild(r);
		ParseTree _save = currentNode;
		currentNode = r;
		// begin old code
		element();
		while(lookahead.type == ListLexer.COMMA) {
			match(ListLexer.COMMA);
			element();
		}
		// end old code
		currentNode = _save;
	}
	
	/** element: name | list */
	void element() {
		RuleNode r = new RuleNode("Element");
		if(root == null) root = r;
		else currentNode.addChild(r);
		ParseTree _save = currentNode;
		currentNode = r;
		// begin old code
		if(lookahead.type == ListLexer.NAME)
			match(ListLexer.NAME);
		else if(lookahead.type == ListLexer.LBRACK) list();
		else throw new RuntimeException("Expected name or list but was " + lookahead);
		// end old code
		currentNode = _save;
	}
	
	
}
