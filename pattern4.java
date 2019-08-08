import java.util.Scanner;

public class pattern4 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int row = 1, col, value = 1;
		while (row <= n) {
			if (row == 1) {
				System.out.print(value);
				System.out.print("\n");
				row++;
				continue;
			}
			col = 1;
			while (col <= row) {
				if (col == 1 || col == row) {
					System.out.print(value);
					col++;
				} else {
					System.out.print("0");
					col++;
				}
			}
			System.out.print("\n");
			row++;
			value++;
		}

	}

}