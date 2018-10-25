package setrecognition;

public class SetLexer extends Lexer{
	
	public static int SETNAME = 2; // name of a set
	public static int INDIVIDUAL = 3; // individual element
	public static int INTERSECTION = 4; // intersection operator
	public static int UNION = 5; // union operator
	public static int LBRACK = 6; // left bracket '('
	public static int RBRACK = 7; // right bracket ')'
	public static int LCURL = 8; // left curly brace '{'
	public static int RCURL = 9; // right curly brace '}'
	public static int COMMA = 10; // well... a comma... like this one: ','
	
	public static String[] tokenNames = {"n/a", "<EOF>", "SETNAME", "INDIVIDUAL", "INTERSECTION" , "UNION", 
			                             "LBRACK", "RBRACK", "LCURL", "RCURL"};
	
	public SetLexer(String input) {
		super(input);
	}
	
	boolean isUpperCaseLetter() {
		return c >= 'A' && c <= 'Z';
	}
	
	boolean isLowerCaseLetter() {
		return c >= 'a' && c <= 'z';
	}
	
	void WS() {
		while( c == ' ' || c == '\t' || c == '\n' || c == '\r') {
			consume();
		}
	}
	
	Token SETNAME() {
		StringBuffer buf = new StringBuffer();
		do {
			buf.append(c);
			consume();
		}while(isUpperCaseLetter());
		return new Token(SETNAME, buf.toString());
	}
	
	Token INDIVIDUAL() {
		StringBuffer buf = new StringBuffer();
		do {
			buf.append(c);
			consume();
		}while(isLowerCaseLetter());
		return new Token(INDIVIDUAL, buf.toString());
	}
	
	public Token nextToken() {
		while(c != EOF) {
			switch(c) {
				case ' ': case '\t': case '\n': case '\r': WS(); continue;
				case '&': consume(); return new Token(INTERSECTION, "&");
				case '|': consume(); return new Token(UNION, "|");
				case '(': consume(); return new Token(LBRACK, "(");
				case ')': consume(); return new Token(RBRACK, ")");
				case '{': consume(); return new Token(LCURL, "{");
				case '}': consume(); return new Token(RCURL, "}");
				case ',': consume(); return new Token(COMMA, ",");
				default:
					if(isUpperCaseLetter()) return SETNAME();
					else if(isLowerCaseLetter()) return INDIVIDUAL();
					else throw new RuntimeException("Invalid char: " + c);	
			}
		}
		return new Token(EOF_TYPE, "<EOF>");
	}
	
	public String getTokenName(int tokenType) {
		return tokenNames[tokenType];	
	}
}
