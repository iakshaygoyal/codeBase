package Questions;
import java.util.*;
public class CeilInASortedArray {

	public static void main(String[] args) {
		int[] arr={1,14,43,46,46,67,76,123,323,434,455,656,776,1212,2323,3443,4545};
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			int n=scn.nextInt();
			System.out.println(ceil(arr, 0, arr.length-1, n));
		}
	}
	
	static int ceil(int[] arr,int low,int high,int n){
		if(arr[low]>=n){
			return arr[low];
		}
		if(arr[high]<n){
			return -1;
		}
		int mid=(low+high)/2;
		if(arr[mid]==n){
			return arr[mid];
		}
		else if(arr[mid]>n){
			if(mid-1>=low && arr[mid-1]<n){
				return arr[mid];
			}
			return ceil(arr, low, mid-1, n);
		}
		else{
			return ceil(arr, mid+1, high, n);
		}
	}
}