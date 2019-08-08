import java.util.Scanner;

public class ReverseOfaNumber {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter n : ");
		int n=s.nextInt();
		int rev=0,last;
		while(n>0)
		{
			last=n%10;
			rev=rev*10+last;
			n=n/10;
		}
		System.out.println("Reverse : "+rev);
	}

}
