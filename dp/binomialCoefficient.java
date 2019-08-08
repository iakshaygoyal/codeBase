package dp;

import java.util.Scanner;

public class binomialCoefficient {

	public static void main(String[] args) {
		Scanner s =new Scanner(System.in);
		int n = s.nextInt();
		int k = s.nextInt();
//		System.out.println(bc(n, k));
		System.out.println(bc(n, k, new long[n+1][k+1] ));

	}
	
	public static int bc(int n, int k){
		if(k == 0 || n == k){
			return 1;
		}
		return bc(n-1, k-1) + bc(n-1, k);
	}
	
	public static long bc(int n, int k, long[][] storage){
		if(storage[n][k] != 0){
			return storage[n][k];
		}
		
		long retval = 0;
		
		if(k == 0 || n == k){
			retval = 1;
		}
		else{
			retval = bc(n-1, k-1, storage) + bc(n-1, k, storage);
		}
		storage[n][k] = retval;
		return retval;
	}

}
