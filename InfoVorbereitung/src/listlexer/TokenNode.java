package listlexer;

public class TokenNode extends ParseTree {
	public Token token;
	
	public TokenNode(Token token) {
		this.token = token;
	}
	
	public String toString() {
		return ListLexer.tokenNames[token.type];
	}
	
	public String toStringTree() {
		if(children == null || children.size() == 0) return this.toString();
		StringBuilder buf = new StringBuilder();
		buf.append("(");
		buf.append(this.toString()+ " ");
		for(int i = 0; i < children.size(); i++) {
			if(i > 0)buf.append(' ');
			buf.append(children.get(i).toStringTree());
		}
		buf.append(')');
		return buf.toString();
	}
}
