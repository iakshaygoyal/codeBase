package assignment7;

import java.util.Arrays;

public class ainvay {

	public static void main(String[] args) {
		int[] a={0,-1,5,4,3,2,1,8,7,9,2,4,-3,-7,12,14,-3};
		System.out.println(Arrays.toString(a));
//		rbs(a,0,a.length-1);
//		rss(a,0,0);
		ris(a,1,1);
		System.out.println(Arrays.toString(a));
	}
	
	public static void bs(int[] a){
		for(int i=0;i<a.length-1;i++){
			for(int j=0;j<a.length-1-i;j++){
				if(a[j]>a[j+1]){
					swap(a,j,j+1);
				}
			}
		}
	}
	
	public static void ss(int[] a){
		for(int i=0;i<a.length-1;i++){
			for(int j=i;j<a.length-1;j++){
				if(a[i]>a[j+1]){
					swap(a,i,j+1);
				}
			}
		}
	}
	
	public static void is(int[] a){
		for(int i=1;i<a.length;i++){
			for(int j=i;j>0;j--){
				if(a[j-1]>a[j]){
					swap(a,j-1,j);
				}
				else{
					break;
				}
			}
		}
	}
	
	public static void swap(int[] a,int fi,int si){
		int temp=a[fi];
		a[fi]=a[si];
		a[si]=temp;
	}
	
	public static void rbs(int[] a,int fi,int li){
		if(li==0){
			return;
		}
		if(fi==li){
			rbs(a,0,li-1);
		}
		else{
			if(a[fi]>a[fi+1]){
				swap(a,fi,fi+1);
			}
			rbs(a,fi+1,li);
		}
	}
	
	public static void rss(int[] a,int fi,int pfi){
		if(pfi==a.length-1){
			return;
		}
		if(fi==a.length-1){
			rss(a,pfi+1,pfi+1);
		}
		else{
			if(a[pfi]>a[fi+1]){
				swap(a,pfi,fi+1);
			}
			rss(a,fi+1,pfi);
		}
	}
	
	public static void ris(int[] a,int fi,int pfi){
		if(fi==a.length){
			return;
		}
		if(fi==0){
			ris(a,pfi+1,pfi+1);
		}
		else{
			if(a[fi-1]>a[fi]){
				swap(a,fi-1,fi);
				ris(a,fi-1,pfi);
			}
			else{
				ris(a,pfi+1,pfi+1);
			}
		}
	}

}
