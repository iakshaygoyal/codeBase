package assignment3revisited;

import java.util.Arrays;

public class P5 {

	public static void main(String[] args) {
		String[] x={"akshay","ayush","thea","roy","mukul"};
//		Arrays.sort(x);
//		for(String s:x){
//			System.out.println(s);
//		}
		String[] y=SORT_LENGTH(x);
		for(String value:y){
			System.out.println(value);
		}

	}
	public static String[] SORT_LENGTH(String [] x)
	{
		for(int i=0;i<x.length-1;i++)
		{
			for(int j=0;j<x.length-1-i;j++)
			{
				if(x[j].length()>x[j+1].length())
				{
					String temp=x[j];
					x[j]=x[j+1];
					x[j+1]=temp;
				}
			}
		}
		return x;
	}

}
