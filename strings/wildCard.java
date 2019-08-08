package strings;
import java.util.*;
public class wildCard {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println(f(s.next(), s.next()));
	}
	
	static boolean f(String T,String P){
		int m=T.length();
		int n=P.length();
		int i=0;
		int j=0;
		int tidx=-1;
		int pidx=-1;
		while(i<m){
			if(j<n && (T.charAt(i)==P.charAt(j) || P.charAt(j)=='?')){
				i++;
				j++;
			}
			else if(j<n && (P.charAt(j)=='*')){
				while(j<n && P.charAt(j)=='*'){
					j++;
				}
				if(j==n){
					return true;
				}
				tidx=i;
				pidx=j;
			}
			else if((j==n || T.charAt(i)!=P.charAt(j)) && tidx!=-1){
				tidx++;
				i=tidx;
				j=pidx;
			}
			else{
				return false;
			}
		}
		while(j<n){
			if(P.charAt(j)!='*'){
				return false;
			}
		}
		return true;
	}

}
