package bootcamp.binarySearch;

import java.util.ArrayList;
import java.util.Scanner;

public class paintersPartition {

	public static void main(String[] args){
		Scanner s=new Scanner(System.in);
		int a=s.nextInt();
		int b=s.nextInt();
		int n=s.nextInt();
		ArrayList<Integer> list=new ArrayList<>();
		for(int i=0;i<n;i++){
			list.add(s.nextInt());
		}
		System.out.println(paint(a, b, list));
		System.out.println();
	}
	public static int paint(int a, int b, ArrayList<Integer> c) {
	    int max=Integer.MIN_VALUE;
	    int sum=0;
	    for(Integer i:c){
	        if(i>max){
	            max=i;
	        }
	        sum+=i;
	    }
	    long lo=(max*b) % 10000003;
	    long hi=(sum*b) % 10000003;
	    long retval=-1;
	    while(lo<=hi){
	        long mid=lo+(hi-lo)/2;
	        int cnt=countPainters(c,mid,b);
	        if(cnt==a){
	            retval=mid % 10000003;
	            hi=mid-1;
	        }
	        else if(cnt<a){
	            hi=mid-1;
	        }
	        else{
	            lo=mid+1;
	        }
	    }
	    return (int)retval;
	}
	
	public static int countPainters(ArrayList<Integer> c,long limit,int b){
	    int sum=0;
	    int cnt=1;
	    for(Integer i:c){
	        if(sum+(i*b)>limit){
	            cnt++;
	            sum=0;
	        }
	        sum+=(i*b);
	    }
	    return cnt;
	}

}