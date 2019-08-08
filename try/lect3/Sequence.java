package lect3;

import java.util.Scanner;

public class Sequence {

	public static void main(String[] args) {
		int current, prev, N;
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Please enter number of numbers: ");
		N = s.nextInt();
		
		System.out.println("Enter first number: ");
		prev = s.nextInt();
		
		boolean goingDown = true;
		int counter = 2;
		
		while(counter <= N){
			System.out.println("Enter number: ");
			current = s.nextInt();
			
			if(goingDown){
				if(current >= prev){
					goingDown = false;
				}
			}
			else{
				if(current <= prev){
					System.out.println("Invalid");
					return;
				}
			}
			
			prev = current;
			counter = counter + 1;
		}
				
		System.out.println("Valid pattern");
	}

}
