import java.util.Scanner;

public class pattern5 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int row=1,col,value=n;
		while(row<=n)
		{
			col=1;
			while(col<=row)
			{
				System.out.print(value);
				col++;
			}
			value--;
			System.out.print("\n");
			row++;
		}

	}

}
