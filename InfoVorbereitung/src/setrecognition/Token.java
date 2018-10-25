package setrecognition;

public class Token {
	int type;
	String text;
	
	public Token(int type, String text) {
		this.type = type;
		this.text = text;
	}
	
	public String toString() {
		String tName = SetLexer.tokenNames[type];
		return "<'" + text + "', " + tName + ">";
	}
}
