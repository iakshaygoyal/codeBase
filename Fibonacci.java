import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int prev_val=0,val=1;
//		while(n>0)
//		{
//			System.out.print(val+", ");
//			val=val+prev_val;
//			prev_val=val-prev_val;
//			n--;
//		}
//		System.out.println("END");
		
		while(n>1)
		{
			val=val+prev_val;
			prev_val=val-prev_val;
			n--;
		}
		System.out.println(val);
	}

}
