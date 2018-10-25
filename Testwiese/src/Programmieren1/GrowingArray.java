package Programmieren1;

public class GrowingArray {

private Object[] myArray;
private int w;
private int n;
private int b;
private int a;
	
public GrowingArray()
{
	n=0;
	w=myArray.length;
	a=4;
	b=2;
}

public void pushBack(Object o)
{
		if(n==w)
		{
			Object [] newArray = myArray.clone();
			myArray = new Object[b*n];
			//for schleife durchgehen und jedes element einzeln zuweisen
			myArray = newArray;
		}
		
		myArray[n] = o;
		n++;
}

public Object popBack()
{
	Object[] tmpArray = myArray.clone();
	myArray[n-1] = null;
	n--;
	if(n <=(w/a))
	{
		Object [] newArray = myArray.clone();
		myArray = new Object[b*n];
		//for schleife durchgehen und jedes element einzeln zuweisen
		myArray = newArray;
	}
	
	return tmpArray[n-1];
}

public Object get(int i)
{
	return myArray[i];
}

public int size()
{
	return n;
}
	//ertsellen einer Gernersichen klasse für diese beispiel
}
