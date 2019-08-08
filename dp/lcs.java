package dp;

public class lcs {

	public static void main(String[] args) {
//		System.out.println(lcs("abdcegh", "acsdlmerg"));
//		System.out.println(lcs2("abdcegh", "acsdlmerg"));

		 System.out.println(lcs("abcdef", "agciejkfl"));
//		 System.out.println(lcs2("abcdef", "agciejkfl"));
//		 System.out.println(lcs3("abcdef", "agciejkfl", new int["abcdef".length()+1]["agciejkfl".length()+1]));
	}
	
	public static int lcs(String s1, String s2){
		int[][] arr = new int[s1.length()+1][s2.length()+1];
		
		int i=1,j=1;
		for(i=1; i<=s1.length(); i++){
			for(j=1; j<=s2.length(); j++){
				if(s1.charAt(i-1) == s2.charAt(j-1)){
					arr[i][j] = arr[i-1][j-1] + 1;
				}
				else{
					arr[i][j] = Math.max(arr[i-1][j], arr[i][j-1]);
				}
			}
		}
		
		String s = "";
		i=s1.length();
		j=s2.length();
		
		while(i>0 && j>0){
			if(s1.charAt(i-1) == s2.charAt(j-1)){
				s+=s1.charAt(i-1);
				i--;
				j--;
			}
			else{
				if(arr[i][j-1] > arr[i-1][j]){
					j--;
				}
				else{
					i--;
				}
			}
		}
		
		StringBuffer x = new StringBuffer(s);
		x.reverse();
		System.out.println(x);
		
		return arr[s1.length()][s2.length()];
	}
	
	public static int lcs2(String s1, String s2){
		if(s1.length()==0 || s2.length() == 0){
			return 0;
		}
		
		if(s1.charAt(0) == s2.charAt(0)){
			return 1 + lcs2(s1.substring(1), s2.substring(1));
		}
		else{
			return Math.max(lcs2(s1.substring(1), s2), lcs2(s1, s2.substring(1)));
		}
	}
	
	public static int lcs3(String s1, String s2, int[][] storage){
		if(storage[s1.length()][s2.length()] != 0){
			return storage[s1.length()][s2.length()];
		}
		
		int retval;
		
		if(s1.length() == 0 || s2.length() == 0){
			retval = 0;
		}
		else if(s1.charAt(0) == s2.charAt(0)){
			retval = 1 + lcs3(s1.substring(1), s2.substring(1), storage);
		}
		else{
			retval = Math.max(lcs3(s1.substring(1), s2, storage), lcs3(s1, s2.substring(1), storage));
		}
		
		storage[s1.length()][s2.length()] = retval;
		return retval;
	}

}
