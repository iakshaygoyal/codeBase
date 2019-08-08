package bitwiseOperations.Geeks;
import java.util.*;
public class PowerOf2 {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			int n=scn.nextInt();
			System.out.println(isPowerOf2(n));
			
			//Integer.bitCount can also be used
		}
	}
	
	static boolean isPowerOf2(int n){
		int cnt=0;
		while(n>0){
			n=(n&(n-1));
			cnt++;
			if(cnt>1){
				return false;
			}
		}
		return true;
	}

}
