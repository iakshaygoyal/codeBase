package bitwiseOperations.Geeks;
import java.util.*;
public class Important1 {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		System.out.println(Integer.toBinaryString(n));
		System.out.println(Integer.toBinaryString(n<<1));
		System.out.println(Integer.toBinaryString(n>>1));
		System.out.println(Integer.toBinaryString(n>>>1));
	}

}
