import java.util.Scanner;
public class Soution{

	
	public static void main(String[] args) {
      Scanner scn=new Scanner(System.in);
      int t=scn.nextInt();
      for(int i=0;i<t;i++){
        long a=scn.nextLong();
        long b=scn.nextLong();
        long d=scn.nextLong();
        
        long g=gcd(a,b).gcd;
        if(d%g!=0){
          System.out.println("0");
          continue;
        }
        if(d==0){
          System.out.println("1");
          continue;
        }
        
        a/=g;
		b/=g;
		d/=g;
        
        long inv=modInverse(b,a);
//        System.out.println("g : "+g);
//        System.out.println("inv : "+inv);
        long y1=((d%a) * inv)%a;
        if(d<y1*b){
          System.out.println("0");
          continue;
        }
        long n=((d/b) - y1)/a;
        System.out.println(n+1);
      }
	}
  
  static class Tri{
    long gcd,x,y;
    
    Tri(long gcd,long x,long y){
      this.gcd=gcd;
      this.x=x;
      this.y=y;
    }
  }
  
  static long modInverse(long a,long m){
    long inv=gcd(a,m).x;
    return ((inv)%m + m)%m;
  }
  
  static Tri gcd(long a,long b){
    if(b==0) return new Tri(a,1,0);
    
    Tri tri=gcd(b,a%b);
    return new Tri(tri.gcd, tri.y, tri.x-((a/b)*tri.y));
  }

}