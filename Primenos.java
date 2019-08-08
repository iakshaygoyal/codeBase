import java.util.Scanner;

public class Primenos {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int i=2,j;
		while(i<=n)
		{
			j=2;
			while(j<i)
			{
				if(i%j==0)
				{
					break;
				}
				j++;
			}
			if(j==i)
			{
				System.out.println(i);
			}
			i++;
		}
	}

}
