import java.util.Scanner;

public class p2_2 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter name : ");
		char name=s.next().charAt(0);
		System.out.println("Enter marks 1 : ");
		int m1=s.nextInt();
		System.out.println("Enter marks 2 : ");
		int m2=s.nextInt();
		System.out.println("Enter marks 3 : ");
		int m3=s.nextInt();
		int avg;
		System.out.println(name);
		if(m1<m2 && m1<m3)
		{
			avg=(m2+m3)/2;
		}
		else if(m2<m3)
		{
			avg=(m1+m3)/2;
		}
		else
			avg=(m1+m2)/2;
		System.out.println("Average : " + avg);
	}

}
