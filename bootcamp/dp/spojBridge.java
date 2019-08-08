package bootcamp.dp;
import java.util.*;
import java.lang.*;
public class spojBridge {

	public static class pair implements Comparable<pair>{
		int i1;
		int i2;
		pair(int i1,int i2){
			this.i1=i1;
			this.i2=i2;
		}
		pair(){}
		public int compareTo(pair p){
			return this.i2-p.i2;
		}
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		for(int i=0;i<t;i++){
			int n=s.nextInt();
			pair[] a=new pair[n];
			for(int j=0;j<n;j++){
				a[j]=new pair();
			}
			for(int j=0;j<n;j++){
				a[j].i1=s.nextInt();
			}
			for(int j=0;j<n;j++){
				a[j].i2=s.nextInt();
			}
			Arrays.sort(a);
			int[] b=new int[n];
			for(int j=0;j<n;j++){
				b[j]=a[j].i1;
			}
			int pi=0;
			int pv=a[0].i2;
			for(int j=1;j<n;j++){
				if(a[j].i2!=pv){
					if(pi!=j-1){
						Arrays.sort(b, pi, j);
					}
					pi=j;
					pv=a[j].i2;
				}
				else if(j==n-1){
					Arrays.sort(b, pi, j+1);
				}
			}
			int[] dp=new int[n];
			for(int j=0;j<n;j++){
				dp[j]=1;
			}
			for(int j=1;j<n;j++){
				for(int k=0;k<j;k++){
					if(b[k]<=b[j]){
						dp[j]=Math.max(dp[j], dp[k]+1);
					}
				}
			}
			int max=dp[0];
			for(int j=1;j<n;j++){
				if(dp[j]>max){
					max=dp[j];
				}
			}
			System.out.println(max);
		}
	}

}
