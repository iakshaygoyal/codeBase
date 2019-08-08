package bootcamp.gcd;
import java.util.*;
public class spogMAIN74Euclidsalgorithmrevisited {

	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		for(int i=0;i<t;i++){
			long n=s.nextLong();
			if(n==0){
				System.out.println(1);
			}
			if(n==1){
				System.out.println(2);
			}
			else{
				long[][] f=new long[][]{{1},{1}};
				long[][] T=new long[][]{{0,1},{1,1}};
				long m=n+3;
				long[][] F=matrixMultiply(power(T, m-1), f);
				System.out.println(F[0][0]);
			}
		}
	}
	
	public static long[][] power(long[][] a,long n){
		if(n==0){
			return a;
		}
		if(n==1){
			return a;
		}
		if(n%2==0){
			long[][] b=power(a,n/2);
			return matrixMultiply(b, b);
		}
		else{
			long[][] b=power(a,n/2);
			return matrixMultiply(a, matrixMultiply(b, b));
		}
	}
	
	public static long[][] matrixMultiply(long[][] a,long[][] b){
		int m=a.length;
		int n=a[0].length;
		int p=b[0].length;
		long[][] c=new long[m][p];
		for(int i=0;i<m;i++){
			for(int j=0;j<p;j++){
				for(int k=0;k<n;k++){
					c[i][j]+=((a[i][k] * b[k][j])%1000000007);
				}
				c[i][j]%=1000000007;
			}
		}
		return c;
	}
}