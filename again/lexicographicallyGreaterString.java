package again;

public class lexicographicallyGreaterString {

	public static void main(String[] args) {
		System.out.println(lexicographicallyGreaterString("bacd", 0));

	}
	
	public static int lexicographicallyGreaterString(String s, int output){
		if(s.length() == 0){
			return 0;
		}
		
		for(int i=0; i<s.length(); i++){
			char currentChar=s.charAt(i);
			String rest=s.substring(0, i)+s.substring(i+1, s.length());
			if(currentChar > s.charAt(0)){
				output+=factorial(s.length()-1);
			}
			else if(currentChar < s.charAt(0)){
				continue;
			}
			else{
				output+=lexicographicallyGreaterString(rest, output);
			}
		}
		return output;
	}
	
	public static int factorial(int n){
		if(n==0){
			return 1;
		}
		int f1=factorial(n-1);
		int f2=f1*n;
		return f2;
	}

}
