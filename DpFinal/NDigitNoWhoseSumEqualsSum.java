package DpFinal;
import java.util.*;
public class NDigitNoWhoseSumEqualsSum {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		int sum=scn.nextInt();
		System.out.println(totalNumbers(n, sum));
	}
	
	static int totalNumbers(int n,int sum){
		int[][][] dp=new int[n+1][sum+1][2];
		for(int i=0;i<(n+1);i++){
			for(int j=0;j<(sum+1);j++){
				for(int k=0;k<2;k++){
					if(i==0 && j==0){
						dp[i][j][k]=1;
					}
					else if(i==0){
						dp[i][j][k]=0;
					}
					else{
						for(int l=k;l<10;l++){
							if(l>j){
								break;
							}
							dp[i][j][k]+=(dp[i-1][j-l][0]);
						}
					}
				}
			}
		}
		return dp[n][sum][1];
	}
}