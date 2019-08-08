package dpCorrect;
import java.util.*;
public class MaxLengthChain {

	static class Pair implements Comparable<Pair>{
		int first;
		int second;
		Pair(int first,int second){
			this.first=first;
			this.second=second;
		}
		@Override
		public int compareTo(Pair p) {
			return this.second-p.second;
		}
		Pair(){}
	}
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			int n=scn.nextInt();
			Pair[] a=new Pair[n];
			for(int j=0;j<n;j++){
				a[j]=new Pair();
			}
			for(int j=0;j<n;j++){
				a[j].first=scn.nextInt();
				a[j].second=scn.nextInt();
			}
			Arrays.sort(a);
			int cnt=0;
			int previousFinishTime=Integer.MIN_VALUE;
			for(int j=0;j<n;j++){
				if(a[j].first>=previousFinishTime){
					cnt++;
					previousFinishTime=a[j].second;
				}
			}
			System.out.println(cnt);
		}
	}

}
