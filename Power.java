import java.util.Scanner;

public class Power {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter x : ");
		float x=s.nextFloat();
		System.out.println("Enter n : ");
		int n=s.nextInt();
		float i=1;
		while(n>0)
		{
			i=i*x;
			n--;
		}
		System.out.println("Value : "+i);
	}

}
