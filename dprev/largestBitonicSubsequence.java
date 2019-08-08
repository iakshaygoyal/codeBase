package dprev;
import java.util.*;
public class largestBitonicSubsequence {
//	8
//	1 11 2 10 4 5 2 1
	
//	16
//	0 8 4 12 2 10 6 14 1 9 5 13 3 11 7 15
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int[] a=new int[n];
		Vector<Integer>[] a1=new Vector[n];
		Vector<Integer>[] a2=new Vector[n];
		for(int i=0;i<n;i++){
			a[i]=s.nextInt();
			a1[i]=new Vector<>(0,1);
			a1[i].add(a[i]);
			a2[i]=new Vector<>(0,1);
			a2[i].add(a[i]);
		}
		int[] dp1=new int[n];
		Arrays.fill(dp1, 1);
		for(int i=1;i<n;i++){
			for(int j=0;j<i;j++){
				if(a[j]<a[i] && dp1[j]+1>dp1[i]){
					dp1[i]=dp1[j]+1;
					a1[i]=new Vector<>(a1[j]);
					a1[i].add(a[i]);
				}
			}
		}
		int[] dp2=new int[n];
		Arrays.fill(dp2, 1);
		for(int i=n-2;i>=0;i--){
			for(int j=n-1;j>i;j--){
				if(a[j]<a[i] && dp2[j]+1>dp2[i]){
					dp2[i]=dp2[j]+1;
					a2[i]=new Vector<>(a2[j]);
					a2[i].add(a[i]);
				}
			}
		}
		int max=-1;
		Vector<Integer> vec=new Vector<>(0,1);
		for(int i=0;i<n;i++){
			if(dp1[i]+dp2[i]-1>max){
				max=dp1[i]+dp2[i]-1;
				vec=a1[i];
				Collections.reverse(a2[i]);
				a2[i].remove(0);
				vec.addAll(a2[i]);
			}
		}
		System.out.println(vec);
		System.out.println(max);
	}

}
