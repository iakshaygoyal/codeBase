package bitwiseOperations;
import java.util.*;
public class BasicConcepts {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		int i=scn.nextInt();
		System.out.println(getIthBit(n, i));
		System.out.println(setIthBit(n, i));
		System.out.println(clearIthBit(n, i));
	}
	
	static int getIthBit(int n,int i){
		int mask=(1<<i);
		return ((n&mask)==0)?0:1;
	}
	
	static int setIthBit(int n,int i){
		int mask=(1<<i);
		return n|mask;
	}
	
	static int clearIthBit(int n,int i){
		int mask=~(1<<i);
		return n&mask;
	}
}