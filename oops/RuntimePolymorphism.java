package oops;

class Animal{
	void eat(){
		System.out.println("eating");
	}
}

class Dog extends Animal{
	void eat(){
		System.out.println("Dog is eating");
	}
}

public class RuntimePolymorphism {

	public static void main(String[] args) {
		Animal a=new Animal();
		a.eat();
		
		Dog a2=new Dog();
		a2.eat();
		
		
		//This is Runtime Polymorphism i.e. Over-ridden method is called by the reference of the parent class.
		Animal a3=new Dog();
		a3.eat();
	}

}