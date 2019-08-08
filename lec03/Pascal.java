package lec03;

import java.util.Scanner;

public class Pascal {

	public static void main(String[] args) {
		System.out.println("Enter n :");
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int row=0,col,value;
		while(row<n)
		{
			col=0;
			value=1;
			while(col<=row)
			{
				System.out.print(value+"\t");
				value=(value*(row-col))/(col+1);
				col++;
			}
			System.out.print("\n");
			row++;
		}
	}
}
