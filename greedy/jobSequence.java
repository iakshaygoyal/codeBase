package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class jobSequence {

	static class job implements Comparable<job>{
		char name;
		int profit;
		int deadline;
		@Override
		public int compareTo(job o) {
			return this.profit - o.profit;
		}
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		job[] arr = new job[n];
		for(int i=0; i<n; i++){
			arr[i] = new job();
		}
		for(job j : arr){
			j.name = s.next().charAt(0);
			j.profit = s.nextInt();
			j.deadline = s.nextInt();
		}
		Arrays.sort(arr);
		int p=0;
		for(int i=n-1,j=1; i>=0; i--){
			if(arr[i].deadline >= j){
				System.out.print(arr[i].name + ", ");
				p+=arr[i].profit;
				j++;
			}
		}
		System.out.println("END");
		System.out.println("Profit : " + p);
	}

}
