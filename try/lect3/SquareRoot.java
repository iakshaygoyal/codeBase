package lect3;

import java.util.Scanner;

public class SquareRoot {

	public static void main(String[] args) {
		System.out.println(3.11 + 0.01);
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Please enter the number: ");
		int N = s.nextInt();
		
		System.out.println("Please enter the precision: ");
		int precision = s.nextInt();
		
		double sqrt = 0;
		double increment = 1;
		
		int counter = 1;
		
		while(counter <= precision){
			while(sqrt * sqrt <= N){
				sqrt = sqrt + increment;
				
				System.out.println(sqrt);
			}
			
			sqrt = sqrt - increment;
			
			System.out.println(sqrt);
			
			increment = increment * 0.1;
			counter = counter + 1;
		}

		
		System.out.println(sqrt - increment);
		System.out.println((int)(sqrt - increment));
		
		
		/*
		int sqrt = 0;
		int increment = 1;
		
		while(sqrt * sqrt <= N){
			sqrt = sqrt + increment;
		}
		
		System.out.println(sqrt - increment);
		*/
		
		/*
		System.out.println("Please enter the precision: ");
		int precision = s.nextInt();
		
		double sqrt = 0;
		double increment = 1;
		
		int counter = 1;
		while(counter <= precision){
			increment = increment * 0.1;
			counter = counter + 1;
		}
		
		while(sqrt * sqrt <= N){
			sqrt = sqrt + increment;
		}
		
		System.out.println(sqrt - increment);
		*/
	}

}
