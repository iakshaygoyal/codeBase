package lect8;

public class StudentDemo {

	public static void main(String[] args){
//		Student.MaxStudentsAllowed = 1000;
		Student s1 = new Student("SM", 10);
		
//		s1.MaxStudentsAllowed = 100;
		
		Student s2 = new Student(s1);
		Student s3 = s2;
		
		System.out.println(Student.getNumStudents());
		System.out.println(s1.getName());
		
		System.out.println(s1.rollNo);
		
		s1.setName("AM");
		
		System.out.println(s1.getName());
		System.out.println(s2.getName());
		
		s3.setName("xyz");
		
		System.out.println(s2.getName());
		System.out.println(s3.getName());
		
		Student[] sArr = new Student[1000];
		
		for(int i = 0; i < 998; i++){
			System.out.println(Student.getNumStudents() + " students so far1");
			sArr[i] = new Student("", 10);
		}
		
		System.out.println("Successful Run");
	}
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Student s1 = new Student();
//		Student s2 = new Student();
//		
//		s1.name = "ABC";
//		s1.rollNo = 51322;
//		
//		s2.name = "GHI";
//		s2.rollNo = 51323;
//		
//		String name = "DEF";
//		int rollNo = 51314;
//		
////		System.out.println(s1.name + ", " + s1.rollNo + ", " + name + ", " + rollNo);
////		Fun1(s1, rollNo, name);
////		System.out.println(s1.name + ", " + s1.rollNo + ", " + name + ", " + rollNo);
//		
//		System.out.println(s1.name + ", " + s1.rollNo + ", " + s2.name + ", " + s2.rollNo);
//		Fun1(s1, s2.rollNo, s2.name);
//		System.out.println(s1.name + ", " + s1.rollNo + ", " + s2.name + ", " + s2.rollNo);
//	}
	
//	public static void Fun1(Student s, int rollNo, String name){
//		s.name = "Funwashed";
//		s.rollNo = 00000;
//		rollNo = 00000;
//		name = "Funwashed";
//	}
	
	

}
