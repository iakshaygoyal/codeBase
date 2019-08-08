package DpFinal;

import java.util.Scanner;

public class BinomialCoffecient {

	static int N=1000000007;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			int n=scn.nextInt();
			int r=scn.nextInt();
			System.out.println(bc(n, r));
		}
	}
	
	static int bc(int n,int r){
		int[][] dp=new int[n+1][r+1];
		for(int i=0;i<(n+1);i++){
			for(int j=0;j<(r+1);j++){
				if(j>i){
					continue;
				}
				else if(i==j || j==0){
					dp[i][j]=1;
				}
				else{
					dp[i][j]=(dp[i-1][j-1]+dp[i-1][j])%N;
				}
			}
		}
		return dp[n][r];
	}

}
