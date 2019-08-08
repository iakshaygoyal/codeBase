package bitwiseOperations;
import java.util.*;
public class OddOrEven {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		if((n&1)==1){
			System.out.println("ODD");
		}
		if((n&1)==0){
			System.out.println("EVEN");
		}
	}

}
