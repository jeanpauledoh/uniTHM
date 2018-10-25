package Programmieren1;

public class Palindrome 
{
	public boolean isPalindrome(String word)
	{
		boolean isPalindrome = false;
		int wordlengthToCheck = word.length() / 2;
		word = word.toLowerCase();
		
		for(int i = 0; i < wordlengthToCheck;i++)
		{
				if(word.charAt(i) == word.charAt(word.length()-(i+1)))
				{
					isPalindrome = true;
				}
		}
		
		return isPalindrome;
	}

}
