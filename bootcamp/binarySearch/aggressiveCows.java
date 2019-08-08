package bootcamp.binarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class aggressiveCows {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		for(int i=0;i<t;i++){
			int n=s.nextInt();
			int c=s.nextInt();
			List<Long> l=new ArrayList<>();
			for(int j=0;j<n;j++){
				l.add(s.nextLong());
			}
			Collections.sort(l);
			System.out.println(binarySearch(l, c));
		}
	}
	
	public static long binarySearch(List<Long> l,int c){
		long min=Long.MAX_VALUE;
		long y=l.get(0);
		for(int i=1;i<l.size();i++){
			long x=l.get(i);
			if((x-y)<min){
				min=x-y;
			}
			y=x;
		}
		long lo=min;
		long hi=l.get(l.size()-1)-l.get(0);
		long retval=-1;
		while(lo<=hi){
			long mid=lo+(hi-lo)/2;
			int cnt=countCows(l, mid);
			if(cnt==c){
				retval=mid;
				lo=mid+1;
			}
			else if(cnt<c){
				hi=mid-1;
			}
			else{
				lo=mid+1;
			}
		}
		return retval;
	}
	
	public static int countCows(List<Long> l,long dist){
		long y=l.get(0);
		int cnt=1;
		for(int i=1;i<l.size();i++){
			long x=l.get(i);
			if((x-y)>=dist){
				cnt++;
				y=x;
			}
		}
		return cnt;
	}

}