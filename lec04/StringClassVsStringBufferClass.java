package lec04;

public class StringClassVsStringBufferClass {

	public static void main(String[] args) {
		int n=100000;
		
		//Complexity n
		StringBuffer s1 = new StringBuffer();
		for(int i=0; i<n; i++){
			s1.append(i+", ");
		}
		System.out.println(s1);
		
		//Complexity n^2
		String s = "";
		for(int i=0; i<n; i++){
			s=s+i+", ";
		}
		System.out.println(s);	

		StringBuilder s2=new StringBuilder("akshay");
		System.out.println(s2);
		
	}

}
