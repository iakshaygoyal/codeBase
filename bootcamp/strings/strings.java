package bootcamp.strings;

public class strings {

	public static void main(String[] args) {

		//Intern Pool
		String s1 = "hello";
		String s2 = "hello";
		String s3 = new String("hello");
		
		
		//Checking values
		System.out.println(s1.equals(s2));
		System.out.println(s2.equals(s3));
		System.out.println(s3.equals(s1));
		System.out.println();
		
		
		//Checking addresses
		System.out.println(s1 == s2);
		System.out.println(s2 == s3);
		System.out.println(s3 == s1);
		System.out.println();
		
		
		//Immutable
		String s4 = "bye";
		String s5 = "bye";
		s4 = s4 + "e";
		System.out.println(s4);
		System.out.println(s5);
		System.out.println(s4.equals(s5));
		System.out.println(s4 == s5);
		System.out.println();
		
		
		//Concat
		String s6 = "bye";
		String s7 = "bye";
		String s8 = s6.concat(s7);
		System.out.println(s6);
		System.out.println(s7);
		System.out.println(s8);
		System.out.println();
		
		
		//indexOf
		System.out.println(s1.indexOf(1));
		System.out.println(s1.indexOf('e'));
		System.out.println(s1.indexOf('l'));
		System.out.println(s1.indexOf("lo"));
		System.out.println();
		
		
		//startsWith
		System.out.println(s1.startsWith("hel"));
		System.out.println(s1.startsWith("ello"));
		System.out.println();
		
		
		//endsWith
		System.out.println(s1.endsWith("lo"));
		System.out.println(s1.endsWith("ell"));
		System.out.println();
		
		
		//contains
		System.out.println(s1.contains("as"));
		System.out.println(s1.contains("el"));
		System.out.println();
		
		
		//substring(does not include the last character)
		System.out.println(s1.substring(1, 3));
		System.out.println();
		
		
		//comaparision
		s1=new String("akshay");
		s2=new String("thea");
		System.out.println(s1.equals(s2));
		System.out.println(s1==s2);
		System.out.println(s1.compareTo(s2));
		System.out.println();
		
		
		//to lowercase and uppercase
		System.out.println(s1.toLowerCase());
		System.out.println(s1.toUpperCase());
		System.out.println(s1);
		
		
		//trim(to remove back and front spaces)
		s1=new String(" Akshay  ");
		System.out.println(s1);
		System.out.println(s1.trim());
		System.out.println();
		
		
		//valueOf()
		int x=10;
		s1=String.valueOf(x);
		s1+=10;
		System.out.println(s1);		
		System.out.println();
		
		//replace
		s1=new String("hey my name is akshay . akshay is great .");
		s1.replace("akshay", "thea");
		System.out.println(s1.replace("akshay", "thea"));
		System.out.println(s1);
		System.out.println();


	}

}
