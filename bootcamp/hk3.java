package bootcamp;
import java.util.*;
import java.lang.*;
public class hk3 {

	 static int[] c;
	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int s = in.nextInt();
	        for(int a0 = 0; a0 < s; a0++){
	            int n = in.nextInt();
	            int e = in.nextInt();
	            int[] b = new int[e];
	            for(int b_i=0; b_i < e; b_i++){
	                b[b_i] = in.nextInt();
	            }
	            c=new int[e];
	            for(int i=0;i<e;i++){
	            	c[i]=b[i];
	            }
	            System.out.println(f(b,n,0,b[0],new long[2001][2001]));
	        }
	    }
	 public static long f(int[] b,int n,int idx,int value,long[][] dp){
	 if(n==0){
		 return 1;
	 }
	 if(dp[n][idx]!=0){
		 return dp[n][idx];
	 }
	 long retval=0;
	 for(int i=0;i<b.length;i++){
		 if(i!=idx){
			 b[idx]=c[idx];
		 }
		 if(i==idx){
			 b[idx]=value;
		 }
		 if(b[i]>0){
			 b[i]-=1;
			 int j=idx;
			 int v=value;
			 retval+=(f(b,n-1,i,b[i],dp)%(1000000000+7));
			 b[i]+=1;
			 idx=j;
			 value=v;
		 }
	 }
	 return dp[n][idx]=retval%=(1000000000+7);
 }
//	 public static long f1(int[] b,int n,int idx,int value){
//		 if(n==0){
//			 return 1;
//		 }
//		 
//		 long retval=0;
//		 for(int i=0;i<b.length;i++){
//			 if(i!=idx){
//				 b[idx]=c[idx];
//			 }
//			 if(i==idx){
//				 b[idx]=value;
//			 }
//			 if(b[i]>0){
//				 b[i]-=1;
//				 int j=idx;
//				 int v=value;
//				 retval+=(f(b,n-1,i,b[i])%(1000000000+7));
//				 b[i]+=1;
//				 idx=j;
//				 value=v;
//			 }
//		 }
//		 return retval%=(1000000000+7);
//	 }
}
