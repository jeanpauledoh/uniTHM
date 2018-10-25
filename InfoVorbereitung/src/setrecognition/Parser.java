package setrecognition;

public class Parser {
	Lexer input;
	Token lookahead;
	
	public Parser(Lexer input) {
		this.input = input;
		consume();
	}
	
	public void match(int x ) {
		if(lookahead.type == x) {
			consume();
		}else {
			throw new RuntimeException("Parsing exception. Expected " + input.getTokenName(x) + " but was " + lookahead);
		}
	}
	
	public void consume() {
		this.lookahead = input.nextToken();
	}
}
