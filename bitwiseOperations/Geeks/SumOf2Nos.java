package bitwiseOperations.Geeks;
import java.util.*;
public class SumOf2Nos {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int a=scn.nextInt();
		int b=scn.nextInt();
		System.out.println(add(a,b));
	}
	
	static int add(int a,int b){
		if(b==0){
			return a;
		}
		return add((a^b),((a&b)<<1));
	}

}
