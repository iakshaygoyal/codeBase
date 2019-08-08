package bootcamp.linearReccurene;

import java.util.Scanner;

public class fib {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		for(long i=1;i<t;i++){
		System.out.println(f(i));
		}
	}
	
	public static long f(long n){
		long a=1;
		long b=1;
		for(int i=3;i<=n;i++){
			long temp=b;
			b=(b+a)%1000000007;
			a=temp;
		}
		return b;
	}

}
