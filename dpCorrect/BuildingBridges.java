package dpCorrect;
import java.util.*;
public class BuildingBridges {

	static class Pair implements Comparable<Pair>{
		int first;
		int second;
		Pair(int first,int second){
			this.first=first;
			this.second=second;
		}
		public int compareTo(Pair p){
			if(this.second!=p.second){
				return this.second-p.second;
			}
			return this.first-p.first;
		}
	}
	
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			int n=scn.nextInt();
			Pair[] arr=new Pair[n];
			for(int j=0;j<n;j++){
				arr[j]=new Pair(scn.nextInt(),scn.nextInt());
			}
			Arrays.sort(arr);
			int[] dp=new int[n];
			Arrays.fill(dp, 1);
			for(int j=1;j<n;j++){
				for(int k=0;k<j;k++){
					if(arr[k].first<=arr[j].first && dp[k]+1>dp[j]){
						dp[j]=dp[k]+1;
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
