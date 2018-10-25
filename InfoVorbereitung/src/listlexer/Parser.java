package listlexer;

public class Parser {
	Lexer input;
	Token lookahead;
	
	public Parser(Lexer input) {
		this.input = input;
		consume();
	}
	
	public void match(int x) {
		if(lookahead.type == x) {
			consume();
		}
		else {
			throw new RuntimeException("Expecting " + input.getTokenName(x));
		}
	}
	
	public void consume() {lookahead = input.nextToken();}
}
