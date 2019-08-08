package codingNinjas.numberTheory;

import java.util.Scanner;

public class ModularExponentiation {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		long a=scn.nextLong();
		long b=scn.nextLong();
		long c=scn.nextLong();
		System.out.println(modRecursive(a,b,c));
		System.out.println(modIterative(a, b, c));
		scn.close();
	}
	
	static long modRecursive(long a,long b,long c){
		if(b==0){
			return 1;
		}
		
		if(b%2==0){
			return modRecursive((a*a)%c, b/2, c);
		}
		else{
			return ( (a%c) * modRecursive((a*a)%c, b/2, c) )%c;
		}
	}
	
	static long modIterative(long a,long b,long c){
		long ans=1;
		while(b!=0){
			if((b&1)==1){
				ans=((ans%c) * (a%c))%c;
			}
			a=((a%c) * (a%c))%c;
			b>>=1;
		}
		return ans;
	}
}