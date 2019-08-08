import java.util.Scanner;

public class SumOfN {

	public static void main(String[] args) {
		System.out.println("Enter N -> ");

		Scanner s = new Scanner(System.in);
		int N = s.nextInt();

		int sum = 0, counter = 1;

		while (counter <= N) {
			sum = sum + counter;
			counter = counter + 1;
		}

		System.out.println(sum);
	}

}
