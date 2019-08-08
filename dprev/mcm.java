package dprev;
import java.util.*;
public class mcm {

//	30
//	5 3 6 2 6 2 8 3 6 8 3 1 5 8 6 3 12 23 6 8 5 6 3 5 2 6 2 6 8 9
	
	static int N=1000000000;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++){
			a[i]=s.nextInt();
		}
//		System.out.println(mcm(a,0,n-1));
//		System.out.println(mcm1(a,0,n-1,new int[n][n]));
		System.out.println(mcm2(a, n));
	}
	
	static int mcm(int[] a,int si,int fi){
		if(si+1==fi){
			return 0;
		}
		int min=N;
		for(int i=si+1;i<fi;i++){
			int c1=mcm(a,si,i);
			int c2=mcm(a,i,fi);
			int c3=a[si]*a[i]*a[fi];
			int t=c1+c2+c3;
			if(t<min){
				min=t;
			}
		}
		return min;
	}

	static int mcm1(int[] a,int si,int fi,int[][] dp){
		if(dp[si][fi]!=0){
			return dp[si][fi];
		}
		if(si+1==fi){
			return dp[si][fi]=0;
		}
		int min=N;
		for(int i=si+1;i<fi;i++){
			int c1=mcm1(a,si,i,dp);
			int c2=mcm1(a,i,fi,dp);
			int c3=a[si]*a[i]*a[fi];
			int t=c1+c2+c3;
			if(t<min){
				min=t;
			}
		}
		return dp[si][fi]=min;
	}
	
	static int mcm2(int[] a,int n){
		int[][] dp=new int[n][n];
		String[][] sarr=new String[n][n];
		for(int i=0;i<n-1;i++){
			sarr[i][i+1]="a"+(i+1);
		}
		for(int i=n-1;i>=0;i--){
			for(int j=0;j<n;j++){
				if(i>=(j-1)){
					dp[i][j]=0;
				}
				else{
					int min=N;
					String s="";
					for(int k=i+1;k<j;k++){
						int val=dp[i][k]+dp[k][j]+(a[i]*a[k]*a[j]);
						String s1="("+sarr[i][k]+"*"+sarr[k][j]+")";
						if(val<min){
							min=val;
							s=s1;
						}
					}
					dp[i][j]=min;
					sarr[i][j]=s;
				}
			}
		}
		System.out.println(sarr[0][n-1]);
		return dp[0][n-1];
	}
}
