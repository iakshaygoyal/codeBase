package lec06;

import java.util.Scanner;

public class Pattern {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter n :");
		int n=s.nextInt();
		PATTERN(n,1,1);

	}
	public static void PATTERN(int n,int row,int col)
	{
		if(row>n)
			return;
		else
		{
			if(col>row)
			{
				System.out.println();
				PATTERN(n,row+1,1);
			}
			else
			{
				System.out.print("1"+"\t");
				PATTERN(n,row,col+1);
			}
		}
	}

}
