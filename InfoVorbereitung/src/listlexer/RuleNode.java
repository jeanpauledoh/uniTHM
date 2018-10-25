package listlexer;

public class RuleNode extends ParseTree {
	public String name;
	public RuleNode(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name != null ? name : "nil";
	}
	
	public String toStringTree() {
		if(children == null || children.size() == 0) return this.toString();
		StringBuilder buf = new StringBuilder();
		buf.append("(");
		buf.append(this.toString() + " ");
		for(int i = 0; i < children.size(); i++) {
			if(i > 0)buf.append(' ');
			buf.append(children.get(i).toStringTree());
		}
		buf.append(')');
		return buf.toString();
	}
	
	
}
