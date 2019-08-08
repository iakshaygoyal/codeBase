package bootcamp.dp;

import java.util.Arrays;

public class arraysSort {

	public static void main(String[] args) {
		int[] a=new int[]{5,4,3,2,1};
		Arrays.sort(a, 1, 3);
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
	}

}
