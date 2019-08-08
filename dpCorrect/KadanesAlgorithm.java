package dpCorrect;
import java.util.*;
public class KadanesAlgorithm {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			int n=scn.nextInt();
			int[] arr=new int[n];
			for(int j=0;j<n;j++){
				arr[j]=scn.nextInt();
			}
			System.out.println(ka(arr, n));
		}
	}
	
	static int ka(int[] arr,int n){
		int max=Integer.MIN_VALUE;
		int curr=0;
		for(int i=0;i<n;i++){
			curr+=(arr[i]);
			if(curr>max){
				max=curr;
			}
			if(curr<0){
				curr=0;
			}
		}
		return max;
	}

}
