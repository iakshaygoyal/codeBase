package again;

import java.util.Scanner;

//Bad complexity(Problem of DP)
public class pascalTriangle2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int row = 0;
		while(row<n){
			int col = 0;
			while(col<=row){
				System.out.print(F(row,col)+"\t");
				col++;
			}
			System.out.println();
			row++;
		}

	}
	
	public static int F(int row, int col){
		if(col == 0){
			return 1;
		}
		int retval = (F(row,col-1)*(row - (col-1)))/((col-1) + 1);
		return retval;
	}

}
