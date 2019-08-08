package patternSearching;
import java.util.*;
public class rabinKarp {

	// WORST CASE : O((m-n+1)*n) equivalent to O(m*n)
	// AVERAGE CASE : O(n+m)
	static int prime=101;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("cnt : "+rk(s.next(), s.next()));
	}
	
	static int rk(String T,String P){
		int m=T.length();
		int n=P.length();
		int cnt=0;
		int Thash=createHash(T, 0, n-1);
		int Phash=createHash(P, 0, n-1);
		for(int i=0;i<(m-n+1);i++){
			if(Thash==Phash){
				int j=0;
				while(j<n && T.charAt(i+j)==P.charAt(j)){
					j++;
				}
				if(j==n){
					cnt++;
					System.out.println(i);
				}
			}
			if(i<m-n){
				Thash=recreateHash(T, i, i+n, Thash);
			}
		}
		return cnt;
	}
	
	static int createHash(String s,int si,int fi){
		int retval=0;
		for(int i=si;i<=fi;i++){
			retval+=(s.charAt(i)*(Math.pow(prime,(i-si))));
		}
		return retval;
	}

	static int recreateHash(String s,int oidx,int nidx,int retval){
		retval-=(s.charAt(oidx));
		retval/=prime;
		retval+=(s.charAt(nidx)*Math.pow(prime,nidx-oidx-1));
		return retval;
	}
}
