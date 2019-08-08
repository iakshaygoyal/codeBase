package Questions.Google;
import java.util.*;
public class Subarray_With_Given_Sum {

	public static void main (String[] args){
	    Scanner scn=new Scanner(System.in);
	    int t=scn.nextInt();
	    for(int i=0;i<t;i++){
	        int n=scn.nextInt();
	        int s=scn.nextInt();
	        int[] arr=new int[n];
	        for(int j=0;j<n;j++){
	            arr[j]=scn.nextInt();
	        }
	        subarraySum(arr,n,s);
	    }
	    scn.close();
	}
	
	static void subarraySum(int[] arr,int n,int s){
	    int cs=0;
	    int i=0,j=0;
	    for(j=0;j<n;j++){
	        cs+=(arr[j]);
	        while(cs>s){
	            cs-=(arr[i++]);
	        }
	        if(cs==s){
	            System.out.println((i+1)+" "+(j+1));
	            return;
	        }
	    }
	    System.out.println("-1");
	 }
}
