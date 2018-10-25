/**
 * 
 */
package ll1_GRAMMATIK;

/**
 * @author jean-
 *
 */
public class RuleNode extends ParseTree 
{
	
	public String name;
	/**
	 * 
	 */
	public RuleNode(String name) 
	{
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	
	/**
	 * @author jean-
	 * @description: dient zur Rückgabe des Namens
	 */
	@Override
	public String toString() 
	{
		return name;
	}

	@Override
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
