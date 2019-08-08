package again.oops;

public class stuDemo {

	public static void main(String[] args) {
		stu s1 = new stu();
		stu s2 = new stu();
		
		s1.name = "ABC";
		s1.rollNo = 51322;
		
		s2.name = "GHI";
		s2.rollNo = 51323;
		
		String name = "DEF";
		int rollNo = 51314;
		
		System.out.println(s1.name + ", " + s1.rollNo + ", " + name + ", " + rollNo);
		Fun1(s1, rollNo, name);
		System.out.println(s1.name + ", " + s1.rollNo + ", " + name + ", " + rollNo);
		
		System.out.println(s1.name + ", " + s1.rollNo + ", " + s2.name + ", " + s2.rollNo);
		Fun1(s1, s2.rollNo, s2.name);
		System.out.println(s1.name + ", " + s1.rollNo + ", " + s2.name + ", " + s2.rollNo);
	}
	
	public static void Fun1(stu s, int rollNo, String name){
		s.name = "Funwashed";
		s.rollNo = 00000;
		rollNo = 00000;
		name = "Funwashed";
	

}
}