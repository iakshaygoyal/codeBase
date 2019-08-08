package bootcamp.linearReccurene;
import java.util.*;
import java.lang.*;
public class spogRecursiveSequence {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int c=s.nextInt();
		for(int i=0;i<c;i++){
			int k=s.nextInt();
			long[][] f=new long[k][1];
			for(int j=0;j<k;j++){
				f[j][0]=s.nextLong();
			}
			long[][] t=new long[k][k];
			for(int j=k-1;j>=0;j--){
				t[k-1][j]=s.nextLong();
			}
			
//			int count=0;
//			for(int j=k-2;j>=0;j--){
//				int count1=0;
//				for(int l=k-1;l>=0;l--){
//					if(count1==count){
//						t[j][l]=1;
//						break;
//					}
//					count1++;
//				}
//				count++;
//			}
			
			int row=0;
			int col=1;
			while(col<k){
				t[row++][col++]=1;
			}
			
			long n=s.nextLong();
			if(n<=k){
				System.out.println(f[(int)(n-1)][0]);
			}
			else{
				long[][] F=matrixMultiply(power(t, n-1), f);
				System.out.println(F[0][0]);
			}
		}
	}
	
	public static long[][] power(long[][] a,long n){
		if(n==1){
			return a;
		}
		if(n%2==0){
			long[][] temp=power(a, n/2);
			return matrixMultiply(temp, temp);
		}
		else{
			long[][] temp=power(a, n/2);
			return matrixMultiply(a, matrixMultiply(temp, temp));
		}
	}
	
	public static long[][] matrixMultiply(long[][] a,long[][] b){
		int l=a.length;
		int m=a[0].length;
		int n=b[0].length;
		long[][] c=new long[l][n];
		
		for(int i=0;i<l;i++){
			for(int j=0;j<n;j++){
				for(int k=0;k<m;k++){
					c[i][j]+=(a[i][k]*b[k][j])%1000000000;
				}
				c[i][j]%=1000000000;
			}
		}
		return c;
	}

}
