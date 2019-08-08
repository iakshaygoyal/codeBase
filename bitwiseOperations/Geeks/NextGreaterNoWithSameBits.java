package bitwiseOperations.Geeks;
import java.util.*;

//5
//10 92 91 12 27

public class NextGreaterNoWithSameBits {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int a=0;a<t;a++){
			int n=scn.nextInt();
			int i;
			for(i=0;i<32;i++){
				if(isSet(n, i)){
					break;
				}
			}
			int j;
			for(j=i+1;j<32;j++){
				if(!isSet(n, j)){
					break;
				}
			}
			int l=0;
			for(int k=i;k<(j-1);k++){
				n=clear(n, k);
				n=set(n, l++);
			}
			n=clear(n, j-1);
			n=set(n, j);
			System.out.println(n);
		}
	}
	
	static boolean isSet(int n,int i){
		int mask=(1<<i);
		if((n&mask)==0){
			return false;
		}
		return true;
	}
	
	static int set(int n,int i){
		int mask=(1<<i);
		return n|mask;
	}
	
	static int clear(int n,int i){
		int mask=(~(1<<i));
		return n&mask;
	}

}
