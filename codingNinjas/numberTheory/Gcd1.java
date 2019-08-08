package codingNinjas.numberTheory;
import java.util.*;
public class Gcd1 {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		System.out.println(gcd(scn.nextInt(), scn.nextInt()));
		scn.close();
	}
	
	static int gcd(int a,int b){
		if(b==0) return a;
		
		return gcd(b,a%b);
	}

}