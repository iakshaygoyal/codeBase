package BST;

import java.util.Scanner;

public class almostSortedArray {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n=s.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++){
			a[i]=s.nextInt();
		}
		int curr=-1,next=-1;
		for(int i=0;i<n-1;i++){
			if(a[i]>a[i+1]){
				if(curr==-1){
					curr=i;
				}
				else{
					next=i+1;
				}
			}
		}
		if(next!=-1){
			int temp=a[curr];
			a[curr]=a[next];
			a[next]=temp;
		}
		else{
			int temp=a[curr];
			a[curr]=a[curr+1];
			a[curr+1]=temp;
		}
		for(int i=0;i<n;i++){
			System.out.print(a[i]+" ");
		}
	}

}
