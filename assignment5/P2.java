package assignment5;

import java.util.Scanner;

public class P2 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter n :");
		int n=s.nextInt();
		int z=ZEROES(n);
		System.out.println(z);

	}
	//While coming up
//	public static int ZEROES(int n)
//	{
//		if(n==0)
//			return 0;
//		int z=ZEROES(n/10);
//		if(n%10==0)
//			return 1+z;
//		return z;
//	}

	//While going down
	public static int ZEROES(int n)
	{
		if(n==0)
			return 0;
		if(n%10==0){
			return 1+ZEROES(n/10);
		}
		else{
		return ZEROES(n/10);
		}
	}
}
