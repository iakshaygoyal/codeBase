import java.util.Scanner;

public class sumofevenandodd {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int even=0,odd=0,counter =1;
		while(counter<=n)
		{
			if(counter%2==0)
			{
				even=even+counter;
			}
			else
			{
				odd=odd+counter;
			}
			counter=counter+1;
		}
		System.out.println(even);
		System.out.println(odd);
	}
}
