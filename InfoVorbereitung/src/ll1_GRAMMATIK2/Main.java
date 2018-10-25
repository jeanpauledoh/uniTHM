/**
 * 
 */
package ll1_GRAMMATIK2;

/**
 * @author jean-
 *
 */
public class Main 
{
	public static ListLexer LL;
	public static ListParser LP;
	/*
	 * Grammatik:
	 * list 	:	'['elements']';
	 * elements :	element (',' elements)*;
	 * element	:	NAME | list;
	 * NAME		:	('a'...'z' | 'A'...'Z')+;
	 */

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		test();
	}
	
	public static void test() 
	{
		LL = new ListLexer ("[NOAH]");
		//LL = new ListLexer ("1233"); <-- wird nicht erkannt
		LP = new ListParser(LL);
		LP.list();
		LP.root.toStringTree();
	}
	
}
