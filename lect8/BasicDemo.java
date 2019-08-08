package lect8;

public class BasicDemo {

	public static void main(String[] args) {
		Basic b1=new Basic();
		b1.n=2;
		b1.numstudents=10; //Warning
		System.out.println(b1.n + "," + b1.c + "," + b1.b + "," + b1.numstudents);
		Basic b2=new Basic();
		b2.n=3;
		b2.b=true;
		b2.numstudents=20; //Warning
		System.out.println(b1.n + "," + b1.c + "," + b1.b + "," + b1.numstudents);
		System.out.println(b2.n + "," + b2.c + "," + b2.b + "," + b2.numstudents);
		System.out.println(b2.m);
		Basic.numstudents=30; //No warning
		System.out.println(Basic.numstudents);
		System.out.println(Basic.m);

	}

}
