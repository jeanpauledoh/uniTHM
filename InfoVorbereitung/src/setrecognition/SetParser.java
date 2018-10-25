package setrecognition;

public class SetParser extends Parser {

	public SetParser(Lexer input) {
		super(input);
	}

	/** expression: term ('|' term)* */
	void expression() {
		term();
		while (lookahead.type == SetLexer.UNION) {
			match(SetLexer.UNION);
			term();
		}
	}

	/** atom ('&' atom)* */
	void term() {
		atom();
		while (lookahead.type == SetLexer.INTERSECTION) {
			match(SetLexer.INTERSECTION);
			atom();
		}
	}

	/** atom: SETNAME | IndivSet | '(' expression ')' */
	void atom() {
		if (lookahead.type == SetLexer.SETNAME) {
			match(SetLexer.SETNAME);
		} else if (lookahead.type == SetLexer.LCURL) {
			indivSet();
		} else if (lookahead.type == SetLexer.LBRACK) {
			match(SetLexer.LBRACK);
			expression();
			match(SetLexer.RBRACK);
		} else {
			throw new RuntimeException("Expected either " + input.getTokenName(SetLexer.SETNAME) + ", "
					+ input.getTokenName(SetLexer.LCURL) + " or " + input.getTokenName(SetLexer.LBRACK) + " but was "
					+ lookahead);
		}
	}

	/** indivSet: '{' (indiv (',' indiv)* )? '}' */
	void indivSet() {
		match(SetLexer.LCURL);
		if (lookahead.type == SetLexer.INDIVIDUAL) {
			match(SetLexer.INDIVIDUAL);
			while (lookahead.type == SetLexer.COMMA) {
				match(SetLexer.COMMA);
				match(SetLexer.INDIVIDUAL);
			}
		}
		match(SetLexer.RCURL);
	}
}
