package ll1_GRAMMATIK2;

public class PlusNode extends AST 
{

	public PlusNode(AST left, Token plusToken, AST right) 
	{
		super(plusToken);
		// TODO Auto-generated constructor stub
		addChild(left);
		addChild(right);
	}

}
