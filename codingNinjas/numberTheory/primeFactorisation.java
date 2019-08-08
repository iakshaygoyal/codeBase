package codingNinjas.numberTheory;
import java.util.*;
public class primeFactorisation {
	
	//Can work for nos. upto 10^7 only
	//Complexity : O(logn) after creating sieve
	public static void main (String[] args){
	    int[] sp=new int[10000001];
	    sieve(sp);
	    Scanner scn=new Scanner(System.in);
	    int t=scn.nextInt();
	    for(int i=0;i<t;i++){
	        int n=scn.nextInt();
	        
	        while(n!=1){
	        	System.out.print(sp[n]+" ");
	            n/=sp[n];
	        }
	        System.out.println();
	    }
	    scn.close();
	}
	
	static void sieve(int[] sp){
	    for(int i=0;i<=10000000;i++){
	        sp[i]=i;
	    }
	    for(int i=2;i*i<=10000000;i++){
	        if(sp[i]==i){
	            for(int j=i*i;j<=10000000;j+=i){
	                if(sp[j]==j){
	                    sp[j]=i;
	                }
	            }
	        }
	    }
	}
}
