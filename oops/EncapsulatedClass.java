package oops;
public class EncapsulatedClass {
	
	public static void main(String[] args) {
		Student student=new Student();
		
//		A private class member or constructor is accessible only within the body of the top level
//		class (§7.6) that encloses the declaration of the member or constructor. It is not inherited by subclasses.
//		This would give error.
		
//		student.name="abc";
//		student.roll_no=101;
//		student.age=10;
//		
//		System.out.println(student.name);
//		System.out.println(student.roll_no);
//		System.out.println(student.age);
		
		student.setName("abc");
		student.setRoll_no(101);
		student.setAge(10);
		System.out.println(student.getName());
		System.out.println(student.getRoll_no());
		System.out.println(student.getAge());
		System.out.println(Student.square(2));
	}
}
class Student{
	private String name;
	private int roll_no,age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRoll_no() {
		return roll_no;
	}
	public void setRoll_no(int roll_no) {
		this.roll_no = roll_no;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	static int square(int x){
		return x*x;
	}
}
