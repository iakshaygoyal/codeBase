package bitwiseOperations;
import java.util.*;
public class TotalSetBits {

	//Use any of the last 2
	
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			int n=scn.nextInt();
			System.out.println(countBits(n));
			System.out.println(countBits1(n));
			System.out.println(countBits2(n));
		}
	}
	
	static int countBits(int n){
		int cnt=0;
		while(n>0){
			cnt+=(n&1);
			n=n>>1;
		}
		return cnt;
	}
	
	static int countBits1(int n){
		int cnt=0;
		while(n>0){
			cnt++;
			n=(n&(n-1));
		}
		return cnt;
	}
	
	static int countBits2(int n){
		int cnt=0;
		while(n>0){
			cnt++;
			int p=(n&(-n));
			n-=p;
		}
		return cnt;
	}

}
