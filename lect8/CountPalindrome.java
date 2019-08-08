package lect8;

public class CountPalindrome {

	public static void main(String[] args) {
		int n=COUNT_PALINDROME("abbcba");
		System.out.println(n);

	}
	public static int COUNT_PALINDROME(String s)
	{
		int n=0;
		//For odd length palindrome
		for(int i=0;i<s.length();i++)
		{
			n++;
			for(int j=1;j<=s.length()/2;j++)
			{
				if(i-j<0 || i+j>=s.length())
					break;
				if(s.charAt(i-j)==s.charAt(i+j))
					n++;
				else
					break;
			}
		}
		//For even length palindrome
		for(int i=1;i<s.length();i++)
		{
			for(int j=1;j<=s.length()/2;j++)
			{
				if(i-j<0 || i+j-1>=s.length())
					break;
				if(s.charAt(i-j)==s.charAt(i+j-1))
					n++;
				else
					break;
			}
		}
		return n;
	}

}
