 package dpCorrect;
import java.util.*;
public class MatrixChainMultipication {

//	3
//	5
//	40 20 30 10 30
//	5
//	10 20 30 40 30
//	3
//	10 20 30
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			int n=scn.nextInt();
			int[] p=new int[n];
			for(int j=0;j<n;j++){
				p[j]=scn.nextInt();
			}
			System.out.println(mcm(p, n));
		}
	}
	
	static int mcm(int[] p,int n){
		int[][] dp=new int[n][n];
		for(int i=n-1;i>=0;i--){
			for(int j=0;j<n;j++){
				if(i>=j){
					continue;
				}
				else if(i+1==j){
					dp[i][j]=0;
				}
				else{
					int min=Integer.MAX_VALUE;
					for(int k=i+1;k<j;k++){
						int val=dp[i][k]+dp[k][j]+(p[i]*p[k]*p[j]);
						if(val<min){
							min=val;
						}
					}
					dp[i][j]=min;
				}
			}
		}
		return dp[0][n-1];
	}

}
