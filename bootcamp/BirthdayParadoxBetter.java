package bootcamp;
import java.util.*;
public class BirthdayParadoxBetter {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter the probability : ");
		double prob=scn.nextDouble();
		System.out.println(Math.ceil(Math.sqrt(2*365*Math.log(1/(1-prob)))));
	}

}
