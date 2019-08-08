package patternSearching;
import java.util.*;
public class kmp {

	//o(m+n)
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println(kmpfunc(s.next(), s.next()));
	}
	
	static int kmpfunc(String T,String P){
		int m=T.length();
		int n=P.length();
		int[] lps=new int[n];
		computelps(lps, P, n);
		int i=0;
		int j=0;
		int value=0;
		while(i<m){
			if(T.charAt(i)==P.charAt(j)){
				i++;
				j++;
			}
			else{
				if(j!=0){
					j=lps[j-1];
				}
				else{
					i++;
				}
			}
			if(j==n){
				System.out.println("idx : "+(i-n));
				value++;
				j=lps[j-1];
			}
		}
		return value;
	}
	
	static void computelps(int[] lps,String P,int n){
		int i=1;
		int j=0;
		while(i<n){
			if(P.charAt(i)==P.charAt(j)){
				lps[i]=j+1;
				i++;
				j++;
			}
			else{
				if(j!=0){
					j=lps[j-1];
				}
				else{
					lps[i]=0;
					i++;
				}
			}
		}
	}

}
