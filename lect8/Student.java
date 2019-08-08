package lect8;

public class Student {
	private String name;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		if (name != null && name != "") {
			this.name = name;
		}
		else{
			// throw exception
		}
	}

	public final int rollNo;

	private static int numStudents = 0;
	
//	public int getNumStudents(){
	// static and non-static all kind of data members are allowed
//		return Student.numStudents;
//	}
	
	public static int getNumStudents(){
		// this and non-static data members not allowed
		return Student.numStudents;
	}
	
	public static final int MaxStudentsAllowed = 1000;

	public Student(String name, int rollNo) {
		if(Student.numStudents == Student.MaxStudentsAllowed){
			throw new RuntimeException("Max limit reached");
		}
		Student.numStudents++;
		this.setName(name);
		this.rollNo = rollNo;
	}
	
	public Student(Student s){
		if(Student.numStudents == Student.MaxStudentsAllowed){
			throw new RuntimeException("Max limit reached");
		}
		Student.numStudents++;
		this.setName(s.name);
		this.rollNo = s.rollNo;
	}
}
