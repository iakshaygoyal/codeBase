package again;

import java.util.Scanner;

public class patern {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int row = 1;
		int value = 1;
		while(row <= n){
			int col = 1;
			while(col <= n-row){
				System.out.print(" ");
				col++;
			}
			col = 1;
			
			while(col <= row){
				System.out.print(value);
				value++;
				col++;
			}
			col=1;
			value = value-2;
			
			while(col < row){
				System.out.print(value);
				value--;
				col++;
			}
			System.out.println();
			value = value+2;
			row++;
		}

	}

}
