package dp;

public class fibonacci {

	public static void main(String[] args) {
		System.out.println(fib(10));
		System.out.println(fib2(10).n2);
		System.out.println(fib3(10, new int[11]));
		System.out.println(fib4(10));

	}
	//2^n rest n
	public static int fib(int n){
		if(n<=2){
			return 1;
		}
		
		return fib(n-1)+fib(n-2);
	}
	
	// class is static since method is static
		private static class fibPair{
			int n1;
			int n2;
			
			fibPair(int n1, int n2){
				this.n1=n1;
				this.n2=n2;
			}
		}
		
		public static fibPair fib2(int n){
			if(n==1){
				return new fibPair(0, 1);
			}
			
			fibPair f1 = fib2(n-1);
			
			int num1 = f1.n2;
			int num2 = f1.n1 + f1.n2;
			
			return new fibPair(num1, num2);
		}
		
		//Top Down
		public static int fib3(int n, int[] storage){
			if(storage[n] != 0){
				return storage[n];
			}
			
			if(n<=2){
				storage[n]=1;
			}
			else{
				storage[n]=fib3(n-1, storage) + fib3(n-2, storage);
			}
			
			return storage[n];
		}
		
		//Bottoms Up
		public static int fib4(int n){
			int[] arr = new int[n+1];
			
			for(int i=1; i<=n; i++){
				if(i<=2){
					arr[i]=1;
				}
				else{
					arr[i]=arr[i-1] + arr[i-2];
				}
			}
			
			return arr[n];
		}

}
