import java.util.Scanner;

public class primeornot {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int counter=2;
		while(counter<n)
		{
			if(n%counter==0)
			{
				System.out.println("Not Prime");
				return;
			}
			counter=counter+1;
		}
			System.out.println("Prime");

	}

}
