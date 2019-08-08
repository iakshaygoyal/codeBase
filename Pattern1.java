import java.util.Scanner;

public class Pattern1 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int row=1,col,value=1;
		while(row<=n)
		{
			col=1;
			while(col<=n-row)
			{
				System.out.print(" ");
				col=col+1;
			}
			col=1;
			value=row;
			while(col<=row)
			{
				System.out.print(value);
				col=col+1;
				value=value+1;
			}
			col=1;
			value=value-2;
			while(col<row)
			{
				System.out.print(value);
				value=value-1;
				col=col+1;
			}
			System.out.print("\n");
			row=row+1;
		}

	}

}
