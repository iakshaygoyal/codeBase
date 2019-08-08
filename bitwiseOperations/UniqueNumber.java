package bitwiseOperations;
import java.util.*;
public class UniqueNumber {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++){
			a[i]=scn.nextInt();
		}
		int val=0;
		for(int i=0;i<n;i++){
			val=(val^a[i]);
		}
		System.out.println(val);
	}

}
