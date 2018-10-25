/**
 * 
 */
package ll1_GRAMMATIK2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jean-
 *
 */
public abstract class AST 
{
	Token token;
	List<AST> children;
	
	public AST (Token token) 
	{
		this.token = token;
	}
	
	public int getNodeType() 
	{
		return token.type;
	}
	
	public void addChild(AST t) 
	{
		if(children == null) 
		{
			children = new ArrayList<AST>();
		}
		children.add(t);
	}

	@Override
	public String toString() 
	{
		return "AST [token=" + token + ", children=" + children + "]";
	}
	
	public String toStringTree() 
	{
		if(children == null || children.size() == 0) 
		{
			return this.toString();
		}
		StringBuilder buf = new StringBuilder();
		buf.append("(");
		buf.append(this.toString() + " ");
		for(int i = 0; i < children.size(); i++) 
		{
			if(i>0) 
			{
				buf.append(' ');
			}
			buf.append(children.get(i).toStringTree());
		}
		
		buf.append(')');
		System.out.println(buf.toString());
		return buf.toString();
	}
	

}
