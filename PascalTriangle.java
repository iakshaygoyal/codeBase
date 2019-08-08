import java.util.*;
public class PascalTriangle {

	public static void main(String[] args) {

		Scanner s=new Scanner(System.in);
		System.out.print("Enter n :");
		int n=s.nextInt();
		int row=1,col,i,j;
		int a[]=new int[20];
		int b[]=new int[20];
		while(row<=n)
		{
			col=1;
			i=0;
			j=0;
			while(col<=row)
			{
				if(col==1 || col==row)
				{
					System.out.print("1\t");
					b[col-1]=1;
				}
				else
				{
					System.out.print(a[i]+a[i+1]+"\t");
					b[col-1]=a[i]+a[i+1];
					i++;
				}
				col++;
			}
			while(j<row)
			{
				a[j]=b[j];
				j++;
			}
			row++;
			System.out.print("\n");
		}

	}

}
