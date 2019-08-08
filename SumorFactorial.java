import java.util.Scanner;

public class SumorFactorial {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter n : ");
		int n=s.nextInt();
		int sum=0,fac=1,i=1;
		System.out.println("Enter your choice : ");
		int choice=s.nextInt();
		if(choice==1)
		{
			while(i<=n)
			{
				sum=sum+i;
				i++;
			}
			System.out.println("Sum : "+sum);
		}
		else if(choice==2)
		{
			while(n>i)
			{
				fac=fac*n;
				n--;
			}
			System.out.println("Facorial : "+fac);
		}
		else
			System.out.println("Wrong choice entered");
	}

}
