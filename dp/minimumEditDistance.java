package dp;

public class minimumEditDistance {

	public static void main(String[] args) {
//		System.out.println(med("abcdef", "azced"));
//		System.out.println(med2("abcdef", "azced"));
//		System.out.println(med3("abcdef", "azced", new int["abcdef".length() + 1]["azced".length() + 1]));
//		System.out.println(editDistanceIterative("abcdef", "azced"));
		
//		System.out.println(editDistanceIterative("abche", "bbghi"));
		System.out.println(med2("akshaygoyal", "akshay"));

	}
	
	//Tabulation
	public static int med(String s1, String s2){
		int[][] arr = new int[s1.length()+1][s2.length()+1];
		
		for(int i=0; i<=s1.length(); i++){
			for(int j=0; j<=s2.length(); j++){
				if(i == 0){
					arr[i][j] = j;
				}
				else if(j == 0){
					arr[i][j] = i;
				}
				else if(s1.charAt(i-1) == s2.charAt(j-1)){
					arr[i][j] = arr[i-1][j-1];
				}
				else{
					int factor1 = arr[i][j-1];
					int factor2 = arr[i-1][j];
					int factor3 = arr[i-1][j-1];
					
					arr[i][j] = Math.min(factor1, Math.min(factor2, factor3)) + 1;
				}
			}
		}
		
		return arr[s1.length()][s2.length()];
	}
	
	public static int med2(String s1, String s2){
		if(s1.length() == 0 || s2.length()==0){
			return s1.length() == 0 ? s2.length() : s1.length();
		}
		
		if(s1.charAt(0) == s2.charAt(0)){
			return med2(s1.substring(1), s2.substring(1));
		}
		else{
			int factor1 = med2(s1.substring(1), s2);//deletion in s1
			int factor2 = med2(s1, s2.substring(1));//insertion in s1
			int factor3 = med2(s1.substring(1), s2.substring(1));// replacement
			
			return Math.min(factor1, Math.min(factor2, factor3)) + 1;
		}
	}
	
	//Memoization
	public static int med3(String s1, String s2, int[][] storage){
		if(storage[s1.length()][s2.length()] != 0){
			return storage[s1.length()][s2.length()];
		}
		
		int retval;
		
		if(s1.charAt(0) == s2.charAt(0)){
			retval = med2(s1.substring(1), s2.substring(1));
		}
		else{
			int factor1 = med3(s1.substring(1), s2, storage);
			int factor2 = med3(s1, s2.substring(1), storage);
			int factor3 = med3(s1.substring(1), s2.substring(1), storage);
			
			retval = Math.min(factor1, Math.min(factor2, factor3)) + 1;
		}
		
		storage[s1.length()][s2.length()] = retval;
		return retval;
	}
	
	//Direction is opposite but filling array in correct sequence
	public static int editDistanceIterative(String s1, String s2) {
		int[][] storage = new int[s1.length() + 1][s2.length() + 1];

		for (int i = 0; i <= s1.length(); i++) {
			for (int j = 0; j <= s2.length(); j++) {
				if (i == 0) {
					storage[i][j] = j;
					continue;
				} else if (j == 0) {
					storage[i][j] = i;
					continue;
				}

				if (s1.charAt(s1.length() - i) == s2.charAt(s2.length() - j)) {
					storage[i][j] = storage[i - 1][j - 1];
				} else {
					int costRp = 1 + storage[i - 1][j - 1];
					int costRm = 1 + storage[i - 1][j];
					int costAd = 1 + storage[i][j - 1];

					storage[i][j] = Math.min(costRp, Math.min(costRm, costAd));
				}
			}
		}

		return storage[s1.length()][s2.length()];
	}

}
