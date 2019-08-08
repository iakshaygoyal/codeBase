package bitwiseOperations;
import java.util.*;
public class Subsequence {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		String s=scn.next();
		char[] a=s.toCharArray();
		generateSubsets(a);
	}
	
	static void generateSubsets(char[] a){
		int n=a.length;
		int range=1<<n;
		for(int i=0;i<range;i++){
			filter(a, i);
		}
	}
	
	static void filter(char[] a,int n){
		int i=0;
		while(n>0){
			if((n&1)==1){
				System.out.print(a[i]);
			}
			i++;
			n=n>>1;
		}
		System.out.println();
	}

}