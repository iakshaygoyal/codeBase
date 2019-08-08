package dp;

import java.util.Scanner;

public class subsetSumProblem {
	 static int sum;
		public static void main (String[] args) {
			Scanner s = new Scanner(System.in);
			int t = s.nextInt();
			for(int i=0; i<t; i++){
			    int n = s.nextInt();
			    int[] arr = new int[n];
			    sum = 0;
			    for(int j=0; j<n; j++){
			        arr[j] = s.nextInt();
			        sum+=arr[j];
			    }
			    if(sum % 2 == 0){
			        if(pp(arr, 0, 0, new Object[arr.length][sum/2+1])){
			        System.out.println("YES");
			    }
			    else{
			        System.out.println("NO");
			    }
			    }
			    else{
			        System.out.println("NO");
			    }
			}
		}
		
		public static boolean pp(int[] arr, int si, int current, Object[][] storage){
		    if(si == arr.length){
		        if(current == sum/2){
		            return true;
		        }
		        else{
		            return false;
		        }
		    }
		    if(storage[si][current] != null){
		        return (boolean)storage[si][current];
		    }
		    else{
		        if(current + arr[si] > sum/2){
		            storage[si][current] = pp(arr, si+1, current, storage);
		        }
		        else{
		            storage[si][current] = (  pp(arr, si+1, current, storage) || pp(arr, si+1, current + arr[si], storage)  );
		        }
		        return (boolean)storage[si][current];
		    }
		}

}
