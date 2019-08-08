package suffixArray;
import java.util.*;
public class naive1 {

	static class pair implements Comparable<pair>{
		int i;
		String s;
		pair(int i,String s){
			this.i=i;
			this.s=s;
		}
		public int compareTo(pair p){
			return this.s.compareTo(p.s);
		}
	}
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		String s=in.next();
		int n=s.length();
		pair[] arr=new pair[n];
		for(int i=0;i<n;i++){
			arr[i]=new pair(i,s.substring(i,n));
		}
		Arrays.sort(arr);
		int[] arr1=new int[n];
		for(int i=0;i<n;i++){
			arr1[i]=arr[i].i;
		}
		System.out.println(Arrays.toString(arr1));
		
	}

}
