package bitwiseOperations.Geeks;
import java.util.*;
import java.lang.*;
import java.io.*;
class BinaryNoMultipleOf3{
	public static void main (String[] args){
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			String s=scn.next();
			int oddcnt=0;
			int evencnt=0;
			for(int j=0;j<s.length();j++){
				if((j&1)==0){
					evencnt+=(s.charAt(j)-'0');
				}
				else{
					oddcnt+=(s.charAt(j)-'0');
				}
			}
			if(Math.abs(evencnt-oddcnt)%3==0){
				System.out.println("1");
			}
			else{
				System.out.println("0");
			}
		}
	}
}
