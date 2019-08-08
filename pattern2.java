import java.util.Scanner;

public class pattern2 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int row=1,col;
		while(row<=n)
		{
			col=1;
			while(col<=row)
			{
				System.out.print("1");
				col++;
			}
			System.out.print("\n");
			row++;
		}
	}

}
