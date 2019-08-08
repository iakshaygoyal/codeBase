package bitwiseOperations.Geeks;
import java.util.*;
import java.lang.*;
import java.io.*;
class MaxPowerOf2
 {
	public static void main (String[] args){
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			int n=scn.nextInt();
			System.out.println(maxPowerOf2(n));
			System.out.println((int)(Math.pow(2, (int)(Math.log(n)/Math.log(2)))));
		}
	}
	
	static int maxPowerOf2(int n){
		int res=0;
		int i=0;
		while(true){
			int val=1<<i;
			if(val>n){
				break;
			}
			res=val;
			i++;
		}
		return res;
	}
}
