package dpCorrect;
import java.util.*;
public class LongestBitonicSubsequence {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			int n=scn.nextInt();
			int[] a=new int[n];
			for(int j=0;j<n;j++){
				a[j]=scn.nextInt();
			}
			System.out.println(lbs(a, n));
		}
	}
	static int lbs(int[] a,int n){
		int[] dp1=new int[n];
		int[] dp2=new int[n];
		Arrays.fill(dp1, 1);
		Arrays.fill(dp2, 1);
		for(int i=1;i<n;i++){
			for(int j=0;j<i;j++){
				if(a[j]<a[i] && dp1[j]+1>dp1[i]){
					dp1[i]=dp1[j]+1;
				}
			}
		}
		int k=0;
		while(k<n/2){
			int temp=a[k];
			a[k]=a[n-1-k];
			a[n-1-k]=temp;
			k++;
		}
		for(int i=1;i<n;i++){
			for(int j=0;j<i;j++){
				if(a[j]<a[i] && dp2[j]+1>dp2[i]){
					dp2[i]=dp2[j]+1;
				}
			}
		}
		int max=-1;
		for(int i=0;i<n;i++){
			if(dp1[i]+dp2[n-1-i]-1>max){
				max=dp1[i]+dp2[n-1-i]-1;
			}
		}
		return max;
	}

}
