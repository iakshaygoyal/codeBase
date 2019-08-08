package Hackathon;

import java.util.Scanner;

public class SameSumSubArray {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		boolean[] output=new boolean[t];
		for(int i=0;i<output.length;i++){
			int n=s.nextInt();
			int[] a=new int[n];
			for(int j=0;j<a.length;j++){
				a[j]=s.nextInt();
			}
			output[i]=sameSumSubArray(a,0,0,0);
		}
		for(int i=0;i<output.length;i++){
			System.out.println(output[i]);
		}

	}
	
	public static boolean sameSumSubArray(int[] a,int idx,int s1,int s2){
		if(idx==a.length){
			if(s1==s2){
				return true;
			}
			else{
				return false;
			}
		}
		boolean b1=false;
		boolean b2=false;
		if(a[idx]%5==0){
			 b1 = sameSumSubArray(a,idx+1,s1+a[idx],s2);
		}
		else if(a[idx]%3==0){
			 b2 = sameSumSubArray(a,idx+1,s1,s2+a[idx]);
		}
		else{
			 b1 = sameSumSubArray(a,idx+1,s1+a[idx],s2);
			 b2 = sameSumSubArray(a,idx+1,s1,s2+a[idx]);
		}
		if(b1==true || b2==true){
			return true;
		}
		else{
			return false;
		}
	}

}
