package setrecognition;

public class ListParser extends Parser {

	public ListParser(Lexer input) {
		super(input);
	}

	/** list: '[' elements ']'; */
	void list() {
		match(ListLexer.LBRACK);
		elements();
		match(ListLexer.RBRACK);
	}

	/** elements: element (',' element)*; */
	void elements() {
		element();
		while (lookahead.type == ListLexer.COMMA) {
			match(ListLexer.COMMA);
			element();
		}
	}

	void element() {
		if (lookahead.type == ListLexer.NAME)
			match(ListLexer.NAME);
		else if (lookahead.type == ListLexer.LBRACK)
			list();
		else
			throw new RuntimeException("Expected name or list but was " + lookahead);
	}

}
