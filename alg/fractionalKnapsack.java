package alg;

import java.util.Scanner;

public class fractionalKnapsack {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		double[] p = new double[n];
		double[] w = new double[n];
		
		for(int i=0; i<n; i++){
			p[i] = s.nextDouble();
		}
		
		for(int i=0; i<n ;i++){
			w[i] = s.nextDouble();
		}
		
		for(int i=0; i<n-1; i++){
			for(int j=0; j<n-1-i; j++){
				if((p[j] / w[j]) > (p[j+1] / w[j+1])){
					double temp = p[j];
					p[j] = p[j+1];
					p[j+1] = temp;
					
					temp = w[j];
					w[j] = w[j+1];
					w[j+1] = temp;
				}
			}
		}
		
		double profit = 0;
		double wt = s.nextDouble();
		
		for(int i=n-1; i>=0; i--){
			if(wt > w[i]){
				wt-=w[i];
				profit+=p[i];
			}
			else{
				double ratio=wt/w[i];
				profit+=(ratio * p[i]);
				break;
			}
		}
		
		System.out.println(profit);
	}
}
