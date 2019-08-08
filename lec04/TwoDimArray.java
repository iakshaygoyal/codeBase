package lec04;

import java.util.Scanner;

public class TwoDimArray {

	public static void main(String[] args) {
		int[][] a=TAKE_INPUT();
		PRINT_ARRAY(a);

	}
	public static int[][] TAKE_INPUT()
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter no. of rows : ");
		int rows=s.nextInt();
		int[][] a=new int[rows][];
		for(int i=0;i<rows;i++)
		{
			System.out.println("Enter no. of columns for "+(i+1)+"th row : ");
			int cols=s.nextInt();
			a[i]=new int[cols];
			for(int j=0;j<cols;j++)
			{
				System.out.println("Enter ("+i+"\t"+j+")th item :");
				a[i][j]=s.nextInt();
			}
		}
		return a;
	}
	public static void PRINT_ARRAY(int[][] a)
	{
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a[i].length;j++)
			{
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}

}
