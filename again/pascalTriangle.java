package again;

import java.util.ArrayList;
import java.util.Scanner;

public class pascalTriangle {

	public static void main(String[] args) {
		Scanner s =new Scanner(System.in);
		int n = s.nextInt();
		int[] a =new int[10];
		a[0] = 1;
		int[] b =new int[10];
		b[0] = b[1] = 1;
		int[] temp =new int[10];
		int row = 1;
		while(row <= n){
			if(row == 1 || row == 2){
				for(int i=0; i<row; i++){
					System.out.print(a[i]+"\t");
				}
				temp = a;
				a = b; 
				b = temp;
				System.out.println();
				row++;
				continue;
			}
			
			for(int i=0; i<row; i++){
				if(i == 0 || i == row-1){
					a[i] = 1;
				}
				else{
					a[i] = b[i-1] + b[i];
				}
			}
			
			for(int i=0; i<row; i++){
				System.out.print(a[i]+"\t");
			}
			System.out.println();
			temp = a;
			a = b; 
			b = temp;
			row++;
		}

	}

}
