package Questions;

import java.util.Scanner;

public class LISnlogn {
	public static void main (String[] args){
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			int n=scn.nextInt();
			int[] a=new int[n];
			for(int j=0;j<n;j++){
				a[j]=scn.nextInt();
			}
			System.out.println(lis(a, n));
		}
	}
	
	static int lis(int[] a,int n){
		int[] temp=new int[n];
		temp[0]=0;
		int idx=0;
		int len=1;
		for(int i=1;i<n;i++){
			if(a[i]>a[temp[idx]]){
				temp[++idx]=i;
				len++;
			}
			else{
				temp[ceil(temp, a, 0, idx, a[i])]=i;
			}
		}
		return len;
	}
	
	static int ceil(int[] temp,int[] a,int low,int high,int value){
		if(a[temp[low]]>=value){
			return low;
		}
		if(a[temp[high]]<value){
			return -1;
		}
		int mid=(low+high)/2;
		if(a[temp[mid]]==value){
			return mid;
		}
		else if(a[temp[mid]]>value){
			if(mid-1>=low && a[temp[mid-1]]<value){
				return mid;
			}
			return ceil(temp, a, low, mid-1, value);
		}
		else{
			return ceil(temp, a, mid+1, high, value);
		}
	}
}