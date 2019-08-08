package hk;

import java.util.Scanner;

public class waiter {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int q = s.nextInt();
		int[] arr = primeArray(q);
		
		for(int i=0; i<q; i++){
			System.out.println(arr[i]);
		}

	}
	public static int[] primeArray(int q){
        int[] arr = new int[q];
        
        int k=0;
        for(int i=2; k<q; i++){
            int j;
            for(j=2; j<=(i/2); j++){
                if(i % j == 0){
                    break;
                }
            }
            if(j==(i/2) + 1){
                arr[k++] = i;
            }
        }
        
        return arr;
    }

}
