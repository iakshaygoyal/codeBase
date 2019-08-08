package lect24;

public class client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(Fib(6).fibM);
//		System.out.println(Fib2(6, new int[7]));
//		System.out.println(countClimb(9).n1);
//		System.out.println(countClimb1(50));
//		System.out.println(countClimb2(9,  new int[10]));
//		System.out.println(lcs("abcdef", "agciejkfl"));
//		System.out.println(lcs1("abcdef", "agciejkfl", new int["abcdef".length()+1]["agciejkfl".length()+1]));
//		System.out.println(lcsIterative("abcdef", "agciejkfl"));
		System.out.println(editDistance("abc", "bdcfac"));
		System.out.println(editDistance1("abc", "bdcfac", new int["abc".length()+1]["bdcfac".length()+1]));

	}
	public static class FibPair{
		int fibM;
		int fibM1;
		
		FibPair(int fibM, int fibM1){
			this.fibM = fibM;
			this.fibM1 = fibM1;
		}
	}
	
	public static FibPair Fib(int num){
		if(num == 0){
			return new FibPair(0,0);
		}
		else if(num == 1){
			return new FibPair(1,0);
		}
		
		FibPair resultM1 = Fib(num - 1);
		int resultM = resultM1.fibM + resultM1.fibM1;
		
		return new FibPair(resultM, resultM1.fibM);
	}
	
	public static int Fib2(int num, int[] storage){
		if(num == 0 || num == 1){
			return num;
		}
		
		int retval;
		
		if(storage[num] != 0){
			retval = storage[num];
		}
		else{
			retval = Fib2(num - 1, storage) + Fib2(num - 2, storage);
			storage[num] = retval;
		}
		return retval;
	}
	
	public static class tri{
		int n1;
		int n2;
		int n3;
		
		tri(int n1, int n2, int n3){
			this.n1 = n1;
			this.n2 = n2;
			this.n3 = n3;
		}
	}
	
	
	public static tri countClimb(int num){
		if(num == 1){
			return new tri(1, 0, 0);
		}
		else if(num ==2){
			return new tri(2, 1, 0);
		}
		else if(num ==3){
			return new tri(4, 2, 1);
		}
		
		tri resultM1 = countClimb(num - 1);
		int resultM =resultM1.n1 + resultM1.n2 + resultM1.n3;
		return new tri(resultM, resultM1.n1, resultM1.n2);
	}
	

	public static int countClimb1(int num){
		if(num == 1){
			return 1;
		}
		else if(num == 2){
			return 2;
		}
		else if(num == 3){
			return 4;
		}
		
		return countClimb1(num - 1) + countClimb1(num - 2) + countClimb1(num - 3);
	}
	
	public static int countClimb2(int num, int[] storage){
		if(num == 1){
			return 1;
		}
		else if(num == 2){
			return 2;
		}
		else if(num == 3){
			return 4;
		}
		
		int retval;
		
		if(storage[num] != 0){
			retval =storage[num];
		}
		else{
			retval = countClimb2(num - 1, storage) + countClimb2(num - 2, storage) + countClimb2(num - 3, storage) ;
			storage[num] = retval;
		}
		return retval;
	}
	
	public static int lcs(String s1, String s2){
		if(s1.length() == 0 || s2.length() == 0){
			return 0;
		}
		
		int retval;
		
		if(s1.charAt(0) == s2.charAt(0)){
			retval = 1 + lcs(s1.substring(1), s2.substring(1));
		}
		else{
			int f1 = lcs(s1, s2.substring(1));
			int f2 = lcs(s1.substring(1), s2);
			
			retval = Math.max(f1, f2);
		}
		
		return retval;
	}
	
	public static int lcs1(String s1, String s2, int[][] storage){
		if(s1.length() == 0 || s2.length() == 0){
			return 0;
		}
		
		int retval;
		
		if(storage[s1.length()][s2.length()] != 0){
			retval = storage[s1.length()][s2.length()];
		}
		else{
			if(s1.charAt(0) == s2.charAt(0)){
				retval = 1 + lcs1(s1.substring(1), s2.substring(1), storage);
			}
			else{
				int f1 = lcs1(s1, s2.substring(1), storage);
				int f2 = lcs1(s1.substring(1), s2, storage);
				
				retval = Math.max(f1, f2);
				storage[s1.length()][s2.length()] = retval;
			}
		}
		return retval;
	}
	
//	public static int lcsIterative(String s1, String s2){
//		int[][] storage = new int[s1.length()+1][s2.length()+1];
//		
//		int i=0,j=0;
//		for(i=1; i < s1.length(); i++){
//			for(j=1; j < s2.length(); j++){
//				if(s1.charAt(s1.length() - i) == s2.charAt(s2.length() - j)){
//					storage[i][j] = 1 + storage[i-1][j-1];
//				}
//				else{
//					storage[i][j] = Math.max(storage[i-1][j], storage[i][j-1]);
//				}
//			}
//		}
//		return storage[i][j];
//	}
	
	public static int editDistance(String s1, String s2){
		if(s1.length() == 0){
			return s2.length();
		}
		else if(s2.length() == 0){
			return s1.length();
		}
		
		int retval = 0;
		
		if(s1.charAt(0) == s2.charAt(0)){
			retval = editDistance(s1.substring(1), s2.substring(1));
		}
		else{
			int f1 = 1 + editDistance(s1.substring(1), s2.substring(1));
			int f2 = 1 + editDistance(s1, s2.substring(1));
			int f3 = 1 + editDistance(s1.substring(1), s2);
			
			retval = Math.min(f1, Math.min(f2, f3));
		}
		
		return retval;
	}
	
	public static int editDistance1(String s1, String s2, int[][] storage){
		if(s1.length() == 0){
			return s2.length();
		}
		else if(s2.length() == 0){
			return s1.length();
		}
		
		int retval = 0;
		if(storage[s1.length()][s2.length()] != 0){
			return storage[s1.length()][s2.length()];
		}
		else{
			if(s1.charAt(0) == s2.charAt(0)){
				retval = editDistance(s1.substring(1), s2.substring(1));
			}
			else{
				int f1 = 1 + editDistance1(s1.substring(1), s2.substring(1),storage);
				int f2 = 1 + editDistance1(s1, s2.substring(1),storage);
				int f3 = 1 + editDistance1(s1.substring(1), s2,storage);
			
				retval = Math.min(f1, Math.min(f2, f3));
				storage[s1.length()][s2.length()] = retval;
			}
		}
		return retval;
	}
	
	public static int editDistanceIterative(String s1, String s2){
		int[][] storage = new int[s1.length()+1][s2.length()+1];
		
		int i=0,j=0;
		for(i=1; i < s1.length(); i++){
			for(j=1; j < s2.length(); j++){
				if(i==0){
					storage[i][j] = j;
					continue;
				}
				else if(j == 0){
					storage[i][j] = i;
				}
				else{
					if(s1.charAt(s1.length() - i) == s2.charAt(s2.length() - j))
				}
			}
		}
		return storage[i][j];
	}
}
