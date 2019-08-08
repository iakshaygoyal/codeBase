import java.util.Scanner;

public class Binary2Deimal {

	public static void main(String[] args) {
//		int a=31;
//		int mask=1<<a;
//		long mask1=1<<a;
//		System.out.println(Integer.toBinaryString(mask));
//		System.out.println(Long.toBinaryString(mask));
		
		System.out.println((long)(1l<<31));
		
		
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int sum=0,m=1,last;
		while(n>0)
		{
			last=n%10;
			sum=sum+m*last;
			m=2*m;
			n=n/10;
		}
		System.out.println("Value : "+sum);
	}

}
