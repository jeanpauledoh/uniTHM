package ll1_GRAMMATIK2;

public class MultNode extends AST 
{

	public MultNode(AST left, Token multToken, AST right) 
	{
		super(multToken);
		// TODO Auto-generated constructor stub
		addChild(left);
		addChild(right);
	}

}
