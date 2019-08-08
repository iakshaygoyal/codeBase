package assignment8;

import java.util.Scanner;

public class P6UsingArray {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] stockprice = new int[n];
		
		for(int i=0; i<n; i++){
			stockprice[i] = s.nextInt();
		}
		
		int[] span = new int[n];
		
		for(int i=0; i<n; i++){
			int max = 0;
			for(int j=0; j<i; j++){
				if(stockprice[j] <= stockprice[i]){
					max++;
				}
				else{
					if(max > span[i]){
						span[i] = max;
						max = 0;
					}
				}
			}
			if(max > span[i]){
				span[i] = max;
			}
		}
		
		for(int i=0; i<n; i++){
			System.out.println(span[i] + " ");
		}

	}

}
