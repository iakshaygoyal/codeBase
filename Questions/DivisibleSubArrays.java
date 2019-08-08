package Questions;
import java.util.*;
public class DivisibleSubArrays {

	public static void main (String[] args){
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			int n=scn.nextInt();
			int k=scn.nextInt();
			int[] arr=new int[n];
			for(int j=0;j<n;j++){
				arr[j]=scn.nextInt();
			}
			System.out.println(countSubArrays(arr, n, k));
		}
		scn.close();
	}
	
	static int countSubArrays(int[] arr,int n,int k){
		int[] fq_arr=new int[k];
		fq_arr[0]=1;
		int sum=0;
		for(int i=0;i<n;i++){
			sum+=(arr[i]);
			fq_arr[(sum+k)%k]++;//if numbers are negative
		}
		int result=0;
		for(int i=0;i<k;i++){
			result+=((fq_arr[i]*(fq_arr[i]-1))/2);
		}
		return result;
	}
}