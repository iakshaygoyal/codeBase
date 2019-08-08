package codingNinjas.numberTheory;
import java.util.*;
public class Gcd2 {

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
		Tri tri=gcdExtended(scn.nextInt(),scn.nextInt());
		System.out.println("gcd : "+tri.gcd);
		System.out.println("x : "+tri.x);
		System.out.println("y : "+tri.y);
		scn.close();
	}
	
	static Tri gcdExtended(int a,int b){
		if(b==0) return new Tri(a,1,0);
		
		Tri tri=gcdExtended(b,a%b);
		return new Tri(tri.gcd, tri.y, tri.x-((a/b)*tri.y));
	}

}