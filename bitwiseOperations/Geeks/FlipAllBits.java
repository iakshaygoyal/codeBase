package bitwiseOperations.Geeks;
import java.util.*;
public class FlipAllBits {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			//flipping
			int n=scn.nextInt();
			System.out.println(Integer.toBinaryString(n));
			int len=Integer.toBinaryString(n).length();
			int mask=(1<<len)-1;
			n=n^mask;
			System.out.println(Integer.toBinaryString(n));
			
			//Reversing
			long m=scn.nextLong();
			System.out.println(Long.toBinaryString(m));
			while(m>0){
				System.out.print(m&1);
				m=m>>1;
			}
			System.out.println();
		}
	}

}