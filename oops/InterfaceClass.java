package oops;

interface Shape{
	void draw();
}

class Circle implements Shape{

	@Override
	public void draw() {
		System.out.println("Drawing Circle");
	}
	
}

class Rectangle implements Shape{

	@Override
	public void draw() {
		System.out.println("Drawing Rectangle");
	}
	
}

public class InterfaceClass {

	public static void main(String[] args) {
		Shape shape1=new Circle();
		shape1.draw();
		
		Shape shape2=new Rectangle();
		shape2.draw();
	}

}