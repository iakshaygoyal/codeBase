package assignment8;

import java.util.Scanner;

public class spanArray {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] price = new int[n];
		
		for(int i=0; i<n; i++){
			price[i] = s.nextInt();
		}
		
		int[] span = new int[n];
		int[] stk = new int[n];
		int tos = -1;
		
		int j=n-1;
		while(j>=0){
			if(tos == -1 || price[j] < price[stk[tos]]){
				stk[++tos] = j--;
			}
			else{
				int idx = stk[tos--];
				span[idx] = idx - j;
			}
		}
		
		while(tos != -1){
			int idx = stk[tos--];
			span[idx] = idx - j;
		}
		
		for(int i=0; i<n; i++){
			System.out.print(span[i] + " ");
		}
	}

}
