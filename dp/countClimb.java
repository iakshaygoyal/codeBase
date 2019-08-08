package dp;

public class countClimb {

	public static void main(String[] args) {
		System.out.println(cc(4));
////		System.out.println(cc2(5).n3);
//		System.out.println(cc3(5, new int[6]));

	}
	
	public static int cc(int n){
		if(n==1){
			return 1;
		}
		else if(n==2){
			return 2;
		}
		else if(n==3){
			return 4;
		}
		return cc(n-1) + cc(n-2) + cc(n-3);
	}
	
	private static class ccPair{
		int n1;
		int n2;
		int n3;
		
		ccPair(int n1, int n2, int n3){
			this.n1=n1;
			this.n2=n2;
			this.n3=n3;
		}
	}
	
	public static ccPair cc2(int n){
		if(n==1){
			return new ccPair(0, 0, 1);
		}
		else if(n==2){
			return new ccPair(0, 1, 2);
		}
		else if(n==3){
			return new ccPair(1, 2, 4);
		}
		ccPair c1 = cc2(n-1);
		int num1 = c1.n2;
		int num2 = c1.n3;
		int num3 = c1.n1 + c1.n2 + c1.n3;
		
		return new ccPair(num1, num2, num3);
	}
	
	public static int cc3(int n, int[] storage){
		if(storage[n] != 0){
			return storage[n];
		}
		
		int retval;
		
		if(n==1){
			retval = 1;
		}
		else if(n==2){
			retval = 2;
		}
		else if(n==3){
			retval = 4;
		}
		else{
			retval = cc3(n-1, storage) + cc3(n-2, storage) + cc3(n-3, storage);
		}
		storage[n] = retval;
		
		return retval;
	}

}
