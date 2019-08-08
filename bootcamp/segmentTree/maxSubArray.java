package bootcamp.segmentTree;
import java.util.*;
public class maxSubArray {

	public static void main(String[] args) {
//		int[] a=new int[]{2,-4,3,-1,6,7,2,-1,4,-7,3};
		int[] a=new int[]{-3,-4,-11,-51,-34};
//		System.out.println(brute(a));
		System.out.println(kadane(a));
	}
	
	//COMPLEXITY-O(N^3)
	public static int brute(int[] a){
		int max=Integer.MIN_VALUE;
		for(int i=0;i<a.length;i++){
			int localmax=Integer.MIN_VALUE;
			for(int j=i;j<a.length;j++){
				int sum=0;
				for(int k=i;k<=j;k++){
					sum+=a[k];
				}
				if(sum>localmax){
					localmax=sum;
				}
			}
			if(localmax>max){
				max=localmax;
			}
		}
		return max;
	}
	
	//COMPLEXITY-O(N)
	public static int kadane(int[] a){
		int max=Integer.MIN_VALUE;
		List<Integer> l1=new ArrayList<>();
		List<Integer> l2=new ArrayList<>();
		max=Integer.MIN_VALUE;
		int curr=0;
		for(int i=0;i<a.length;i++){
			l1.add(a[i]);
			curr+=a[i];
			if(curr>max){
				l2=new ArrayList<>(l1);
				max=curr;
			}
			if(curr<0){
				l1=new ArrayList<>();
				curr=0;
			}
		}
		System.out.println(l2);
		return max;
	}

}