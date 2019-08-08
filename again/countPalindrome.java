package again;

public class countPalindrome {

	public static void main(String[] args) {
		System.out.println(countPalindrome("cbbcb"));

	}
	
	public static int countPalindrome(String s){
		int retval = 0;
		
		//for odd-length palindrome
		for(int i=0; i<s.length(); i++){
			int j=0;
			
			while(i-j >= 0 && i+j<s.length()){
				if(s.charAt(i-j) == s.charAt(i+j)){
					retval++;
					j++;
				}
				else{
					break;
				}
			}
		}
		
		//for even-length palindrome
		for(int i=0; i<s.length()-1; i++){
			int j=0;
			
			while(i-j>=0 && i+j+1<s.length()){
				if(s.charAt(i-j) == s.charAt(i+j+1)){
					retval++;
					j++;
				}
				else{
					break;
				}
			}
		}
		
		return retval;
	}

}
