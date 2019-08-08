package assignment6;

import java.util.Scanner;

import lec03.ArrayBasic;

public class P10 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter number of stairs :");
		int n=s.nextInt();
		int[] a=new int[n+(n/2)+(n/3)];
		for(int i=0;i<n;i++)
			a[i]=1;
		for(int i=0;i<(n/2);i++)
			a[n+i]=2;
		for(int i=0;i<(n/3);i++)
			a[n+(n/2)+i]=3;
		ArrayBasic.PRINT_ARRAY(a);
		STAIRS(a,0,0,n,"");

	}

	public static void STAIRS(int[] a,int index,int total,int sum,String outputsofar)
	{
		if(index==a.length)
		{
			if(total==sum)
			System.out.println(outputsofar);
			return;
		}
		STAIRS(a,index+1,total,sum,outputsofar);
		STAIRS(a,index+1,total+a[index],sum,outputsofar+a[index]+",");
	}
}
