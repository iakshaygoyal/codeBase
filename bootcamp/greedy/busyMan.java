package bootcamp.greedy;
import java.util.*;
import java.lang.*;
public class busyMan {
	public static class pair implements Comparable<pair>{
		int st;
		int ft;
		
		pair(int st,int ft){
			this.st=st;
			this.ft=ft;
		}
		
		public int compareTo(pair p){
			return this.ft-p.ft;
		}
	}
	public static void main (String[] args) {
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			int n=scn.nextInt();
			pair[] arr=new pair[n];
			for(int j=0;j<n;j++){
				arr[j]=new pair(scn.nextInt(),scn.nextInt());
			}
			Arrays.sort(arr);
			int ft=Integer.MIN_VALUE;
			int cnt=0;
			for(pair p:arr){
				if(p.st>=ft){
					cnt++;
					ft=p.ft;
				}
			}
			System.out.println(cnt);
		}
	}
}
