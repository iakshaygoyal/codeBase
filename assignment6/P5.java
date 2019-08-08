package assignment6;

import java.util.Scanner;

public class P5 {

	public static void main(String[] args) {
		int[] a=new int[] {1,2,3,4,5};
		Scanner s=new Scanner(System.in);
		System.out.println("Enter sum :");
		int sum=s.nextInt();
		PRINT_SUBSET_SUM(a,0,sum,"");

	}
	public static void PRINT_SUBSET_SUM(int[] a,int index,int sum,String outputsofar){
		if(index==a.length)
		{
			if(sum == 0)
			System.out.println(outputsofar);
			return;
		}
		if(sum < 0){
			return;
		}
		PRINT_SUBSET_SUM(a,index+1,sum,outputsofar);
		PRINT_SUBSET_SUM(a,index+1,sum-a[index],outputsofar+a[index]+",");
	}

}
