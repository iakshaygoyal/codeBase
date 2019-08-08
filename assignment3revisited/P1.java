package assignment3revisited;

import java.util.Scanner;

public class P1 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter n :");
		int n=s.nextInt();
		int binary=REC_BINARY(n,0);
		System.out.println(binary);

	}
	public static void BINARY(int n)
	{
		int binary=0;
		int rem,m=1;
		while(n>0)
		{
			rem=n%2;
			binary=binary+(m*rem);
			m=m*10;
			n=n/2;
		}
		System.out.println(binary);
	}
	public static int REC_BINARY(int n,int p)
	{
		if(n==0)
			return 0;
		int n1=REC_BINARY(n/2,p+1);
		int rem=n%2;
		int binary=rem+(n1*10);
		return binary;
	}
}
