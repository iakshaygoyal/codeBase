package oops;

class XYZ{
	int add(int a,int b){
		return a+b;
	}
	
	int add(int a,int b,int c){
		return a+b+c;
	}
}

public class CompiletimePolymorphism {

	public static void main(String[] args) {
		XYZ xyz=new XYZ();
		System.out.println(xyz.add(2, 3));
		System.out.println(xyz.add(2, 3, 4));
	}
}