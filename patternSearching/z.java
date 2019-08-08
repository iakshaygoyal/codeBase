package patternSearching;
import java.util.*;
public class z {
//	aaabcxyzaaaabczaaczabbaaaaaabc
//    aaabc
	public static void main(String[] args){
		Scanner s=new Scanner(System.in);
		String T=s.next();
		String P=s.next();
		int m=T.length();
		int n=P.length();
		String s1=(P+'$')+T;
		int[] z=computez(s1);
		for(int i=0;i<z.length;i++){
			if(z[i]==n){
				System.out.print(i-n-1+"  ");
			}
		}
	}
	
	static int[] computez(String s){
		int n=s.length();
		int[] z=new int[n];
		int left=0;
		int right=0;
		for(int k=1;k<n;k++){
			if(k>right){
				left=right=k;
				while(right<n && s.charAt(right-left)==s.charAt(right)){
					right++;
				}
				z[k]=right-left;
				right--;
			}
			else{
				int k1=k-left;
				if(z[k1]+k<=right){
					z[k]=z[k1];
				}
				else{
					left=k;
					while(right<n && s.charAt(right-left)==s.charAt(right)){
						right++;
					}
					z[k]=right-left;
					right--;
				}
			}
		}
		return z;
	}
}
