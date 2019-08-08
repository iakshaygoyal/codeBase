package bitwiseOperations.Geeks;
import java.util.*;
public class Adding1ToNo {

//	5
//	154 54 87 4 96
	
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int a=0;a<t;a++){
			int n=scn.nextInt();
			int i;
			for(i=0;i<32;i++){
				if(!isSet(n, i)){
					break;
				}
			}
			for(int j=0;j<i;j++){
				n=clear(n, j);
			}
			n=set(n, i);
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
		return  n&mask;
	}

}
