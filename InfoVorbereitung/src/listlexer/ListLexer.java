package listlexer;

public class ListLexer extends Lexer {
	
	public static int NAME = 2;
	public static int COMMA = 3;
	public static int LBRACK = 4;
	public static int RBRACK = 5;

	public static String[] tokenNames = 
		{"n/a", "<EOF>", "NAME", "COMMA", "LBRACK", "RBRACK"};
	
	public ListLexer(String input) {
		super(input);
	}
	
	boolean isLetter() {
		return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
	}
	
	void WS() {
		while (c == ' ' || c == '\t' || c == '\n' || c == '\r')
			consume();
	}
	
	Token NAME() {
		StringBuffer buf = new StringBuffer();
		do {
			buf.append(c);
			consume();
		}while(isLetter());
		return new Token(NAME, buf.toString());
	}
	
	@Override
	public Token nextToken() {
		System.out.println("c: " + c);
		while(c != EOF) {
			switch(c) {
				case ' ': case '\t': case '\n': case '\r': WS(); continue;
				case ',': consume(); return new Token(COMMA, ",");
				case '[': consume(); return new Token(LBRACK, "[");
				case ']': consume(); return new Token(RBRACK, "]");
				default:	
					if(isLetter()) return NAME();
					throw new RuntimeException("Invalid char: " + c);
			}
		}
		return new Token(EOF_TYPE, "<EOF>");
	}


	public  String getTokenName(int tokenType) {
		return tokenNames[tokenType];
	}
	

}
