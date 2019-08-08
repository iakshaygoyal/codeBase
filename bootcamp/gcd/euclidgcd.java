package bootcamp.gcd;
import java.util.*;
import java.lang.*;
import java.io.*;
public class euclidgcd {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int a=s.nextInt();
		int b=s.nextInt();
		System.out.println(euclidgcdFunction(a, b));
	}
	
	public static int euclidgcdFunction(int a,int b){
		if(a==0){
			return b;
		}
		return euclidgcdFunction(b%a, a);
	}

}
