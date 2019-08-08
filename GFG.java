import java.util.*;
public class GFG {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int[] a={1,2,3,4,5};
		int[] b={1,1,1,1,1};
		a=b;
		b=new int[5];
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
	}
	

}