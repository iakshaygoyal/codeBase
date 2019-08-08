package lect8;

public class PalindromeDemo {

	public static void main(String[] args) {
		System.out.println(countPalindromes("cbbcbc"));
	}
	
	public static int countPalindromes(String str){
		int np = 0;
		
		// for odd length palindromes
		for(int i = 0; i < str.length(); i++){
			int j = 0;
			while(i - j >= 0 && 
				  i + j < str.length() && 
				  str.charAt(i - j) == str.charAt(i + j)){
				np++;
				j++;
			}
		}
		
		// for event length palindromes
		for(int i = 1; i < str.length(); i++){
			int j = 1;
			while(i - j >= 0 && 
				  i + j - 1 < str.length() && 
				  str.charAt(i - j) == str.charAt(i + j - 1)){
					np++;
					j++;
				}
		}
		
		return np;
	}

}
