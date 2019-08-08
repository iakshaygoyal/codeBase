package lec03;

import java.util.Scanner;

public class New1 {

	public static int z = 10;
	
	public static void main(String[] args) {
		Greeter();
		
		System.out.println("Hello main");
		
		Greeter();
		
		Fun();
		
		int x = 5;
		

		
		System.out.println(x);
		System.out.println(z);
		increment(x);
		System.out.println(x);
		System.out.println(z);
		
		char c = 'z';
		Mix(x, c);
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter number");
		int num = s.nextInt();
		
		boolean isPrime = IsPrime(num);
		
		if(isPrime){
			System.out.println(num + " is prime");
		}
		else{
			System.out.println(num + " is not prime");
		}
	}
	
	public static void Greeter(){
		System.out.println("Hello Greeter");
	}
	
	public static void Fun(){
		System.out.println("Fun - l1");
		NestedFun();
		System.out.println("Fun - l3");
	}
	
	public static void NestedFun(){
		System.out.println("NestedFun - l1");

		System.out.println("NestedFun - l3");
	}

	public static void increment(int n){
		System.out.println(n);
		n = n + 1;
		z = z + 1;
		System.out.println(n);
	}
	
	public static void Mix(int xx, char cc){
//		System.out.println(x);
		System.out.println(xx);
		System.out.println(cc);
	}
	
	public static void MoreFun(){
		int x = 5;
//		int z = 15;
//		
//		System.out.println(z);
		if(true){
			System.out.println(x);
			
		
		}
		else{
			System.out.println(x);
		}
		

		
	}
	
	public static boolean IsPrime(int num){
		boolean retVal = true;
		
		int i = 2;
		while( i <= num / 2){
			if(num % i == 0){
				retVal = false;
				break;
			}
			
			i = i + 1;
		}
		
		return retVal;
	}
}
