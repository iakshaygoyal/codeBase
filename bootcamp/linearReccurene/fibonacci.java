package bootcamp.linearReccurene;
import java.util.*;
import java.lang.*;
import java.io.*;
public class fibonacci {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		long T=s.nextLong();
		for(long i=0;i<T;i++){
			long n=s.nextLong();
			long[][] f=new long[][]{{1},{1}};
			long[][] t=new long[][]{{0,1},{1,1}};
			long[][] F=matrixMultiply(power(t, n-1), f);
			System.out.println(F[0][0]);
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
		long m=a.length;
		long n=a[0].length;
		long p=b[0].length;
		long[][] c=new long[(int) m][(int) p];
		for(int i=0;i<m;i++){
			for(int j=0;j<p;j++){
				for(int k=0;k<n;k++){
					c[i][j]+=((a[i][k] * b[k][j])%1000000007);
				}
				c[i][j]%=1000000007 ;
			}
		}
		return c;
	}
}
