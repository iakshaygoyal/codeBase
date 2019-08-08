package codingNinjas.numberTheory;
import java.util.*;
public class multiplicativeModInverse {

	static class Tri{
		int gcd,x,y;
		
		Tri(int gcd,int x,int y){
			this.gcd=gcd;
			this.x=x;
			this.y=y;
		}
	}
	
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		System.out.println(modInverse(scn.nextInt(),scn.nextInt()));
		scn.close();
	}
	
	static int modInverse(int a,int m){
		Tri tri=gcd(a,m);
		if(tri.gcd!=1){
			return -1;
		}
		return (tri.x%m + m)%m;
	}
	
	static Tri gcd(int a,int b){
		if(b==0) return new Tri(a,1,0);
		
		Tri tri=gcd(b,a%b);
		return new Tri(tri.gcd, tri.y, tri.x-((a/b)*tri.y));
	}

}
