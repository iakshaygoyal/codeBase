//Accessing private data members through static functions
package LL;

public class imp2 {
	private int x;
	private int y;
	
	public static void fun(imp2 a,imp2 b){
		a.x=1;
		a.y=2;
		b.x=3;
		b.y=4;
		System.out.println(a.x+b.x);
		
	}

}
