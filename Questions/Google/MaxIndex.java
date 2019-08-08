package Questions.Google;
import java.util.*;
public class MaxIndex {

	public static void main (String[] args){
	    Scanner scn=new Scanner(System.in);
	    int t=scn.nextInt();
	    for(int i=0;i<t;i++){
	        int n=scn.nextInt();
	        int[] arr=new int[n];
	        for(int j=0;j<n;j++){
	            arr[j]=scn.nextInt();
	        }
	        
	        int[] lmin=new int[n];
	        lmin[0]=arr[0];
	        for(int j=1;j<n;j++){
	            lmin[j]=Math.min(lmin[j-1],arr[j]);
	        }
	        
	        int[] rmax=new int[n];
	        rmax[n-1]=arr[n-1];
	        for(int j=(n-2);j>=0;j--){
	            rmax[j]=Math.max(rmax[j+1],arr[j]);
	        }
	        
	        int max=0;
	        int j=0,k=0;
	        while(j<n && k<n){
	            if(lmin[j]<=rmax[k]){
	                max=Math.max(max,(k-j));
	                k++;
	            }
	            else{
	                j++;
	            }
	        }
	        System.out.println(max);
	    }
	    scn.close();
	}
}