import java.util.Scanner;

public class Decimal2Binary {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter n : ");
		int n=s.nextInt();
		int rem,binary=0,m=1;
		while(n>0)
		{
			rem=n%2;
			rem=m*rem;
			binary=binary+rem;
			n=n/2;
			m=m*10;
		}
		System.out.println("Binary : "+binary);
	}

}
