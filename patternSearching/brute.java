package patternSearching;
import java.util.*;
import java.lang.*;
import java.io.*;

//O((m-n+1)*n) equivalent to O(m*n)

class brute {
	public static void main (String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("cnt : "+bruteForce(s.next(), s.next()));
	}
	
	static int bruteForce(String T,String P){
		int m=T.length();
		int n=P.length();
		int cnt=0;
		for(int i=0;i<(m-n+1);i++){
			int j=0;
			while(j<n && T.charAt(i+j)==P.charAt(j)){
				j++;
			}
			if(j==n){
				cnt++;
				System.out.println(i+" ");
			}
		}
		return cnt;
	}
}