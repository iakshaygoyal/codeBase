package codingNinjas.numberTheory;

import java.util.Scanner;

public class primeFactorisation1 {

	
	//Works in O(sqrt(n)) which is bad as far as cp is considered but can find it log n also
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			long n=scn.nextLong();
			
			while(n%2==0){
				System.out.print("2 ");
				n/=2;
			}
			
			for(int j=3;j*j<=n;j+=2){
				while(n%j==0){
					System.out.print(j+" ");
					n/=j;
				}
			}
			if(n>1){
				System.out.println(n);
			}
		}
		scn.close();
	}

}
