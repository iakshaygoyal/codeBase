package Hackathon;

import java.util.Scanner;

public class BankProblem {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		int[] output=new int[t];
		for(int i=0;i<t;i++){
			int n=s.nextInt();
			output[i]=dollar(n);
		}
		for(int i=0;i<t;i++){
			System.out.println(output[i]);
		}

	}
	
	public static int dollar(int n){
		if(n<12){
			return n;
		}
		else{
			return dollar(n/2)+dollar(n/3)+dollar(n/4);
		}
	}

}
