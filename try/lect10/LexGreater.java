package lect10;

public class LexGreater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lexGreater("abcd"));
	}
	
	public static int lexGreater(String str){
		int[] fArr = new int[str.length() - 1];
		
		int initFactorial = 1;
		for(int i = 0; i < fArr.length; i++){
			fArr[i] = initFactorial;
			initFactorial = initFactorial * (i + 2);
		}
		
		return lexGreater(str, fArr);
	}
	
	public static int lexGreater(String str, int[] fArr){
		int retVal = 0;
		
		for(int i = 0; i < str.length() - 1; i++){
			int countLargerChars = 0;
			
			for(int j = i + 1; j < str.length(); j++){
				if(str.charAt(j) > str.charAt(i)){
					countLargerChars++;
				}
			}
			
			retVal += countLargerChars * fArr[str.length() - i - 2];
		}
		
		return retVal;
	}

}
