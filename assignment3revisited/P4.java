package assignment3revisited;

import java.util.Scanner;

public class P4 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter String :");
		String str=s.nextLine();
		HIGHEST_CHAR(str);

	}
	public static void HIGHEST_CHAR(String s)
	{
		int[] a=new int[256];
		for(int i=0;i<s.length();i++)
		{
			a[(int) s.charAt(i)]++;
		}
		int largest=a[0];
		char c=(char) 0;
		for(int i=1;i<a.length;i++)
		{
			if(a[i]>largest && (char) i != ' '){
				largest=a[i];
				c=(char) i;
			}
		}
		System.out.println("Char : " + c);
		System.out.println("No. of times : "+largest);
	}

}
