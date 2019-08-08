package bootcamp;
import java.util.*;
import java.lang.*;
import java.io.*;
public class birthdayParadox {

	public static void main(String[] args){
		Scanner s=new Scanner(System.in);
		System.out.println("Enter probability for people to have same birthdays : ");
		double n=s.nextDouble();
		n=1.0-n;
		double p=1.0;
		int cnt=0;
		while(p>n){
			p*=((365.0-cnt)/365.0);
			cnt++;
		}
		System.out.println("people : "+cnt);
	}
}
