package again.oops;

public class stu1Demo {

		public static void main(String[] args){
//			stu1.Maxstu1sAllowed = 1000;
			stu1 s1 = new stu1("SM",10);
			
//			s1.Maxstu1sAllowed = 100;
			
			stu1 s2 = new stu1(s1);
			stu1 s3 = s2;
			
			System.out.println(stu1.getnumstu1());
			System.out.println(s1.getName());
			
			System.out.println(s1.rollNo);
			
			s1.setName("AM");
			
			System.out.println(s1.getName());
			System.out.println(s2.getName());
			
			s3.setName("xyz");
			
			System.out.println(s2.getName());
			System.out.println(s3.getName());
			
			stu1[] sArr = new stu1[1000];
			
			for(int i = 0; i < 998; i++){
				System.out.println(stu1.getnumstu1() + " stu1s so far1");
				sArr[i] = new stu1("", 10);
			}
			
			System.out.println("Successful Run");

	}

}
