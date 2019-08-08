package bitwiseOperations.Geeks;

import java.util.*;
import java.lang.*;
import java.io.*;
class FirstRightMostSetBit{
	public static void main (String[] args){
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			int n=scn.nextInt();
			if(n==0){
			    System.out.println("0");
			    continue;
			}
			System.out.println((int)(Math.log(n&(-n))/Math.log(2))+1);
		}
	}
}