package dp;

import java.util.Scanner;

public class eggDrop {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int k = s.nextInt();
		
//		System.out.println(ed(n, k));
		System.out.println(ed(n, k, new int[n + 1][k + 1]));

	}
	
	public static int ed(int n, int k){
		if(n == 1){
			return k;
		}
		else if(k == 0){
			return 0;
		}
		
		int retval = Integer.MAX_VALUE;
		
		for(int i=1; i<=k; i++){
			int current = 1 + Math.max(ed(n, k - i), ed(n - 1, i - 1));
			
			if(current < retval){
				retval = current;
			}
		}
		
		return retval;
	}
	
	public static int ed(int n, int k, int[][] storage){
		if(storage[n][k] != 0){
			return storage[n][k];
		}
		
		int retval = Integer.MAX_VALUE;
		
		if(n == 1){
			retval = k;
		}
		else if(k == 0){
			retval = 0;
		}
		else{
			for(int i=1; i<=k; i++){
				int current = 1 + Math.max(ed(n, k - i, storage), ed(n - 1, i - 1, storage));
				
				if(current < retval){
					retval = current;
				}
			}
		}
		
		storage[n][k] = retval;
		return retval;
	}
}
