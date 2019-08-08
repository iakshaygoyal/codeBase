package again;

public class mergeSort {

	public static void main(String[] args) {
		int[] a = new int[]{5,4,3,2,1};
		ms(a, 0, a.length-1);
		
		for(int i=0; i<a.length; i++){
			System.out.print(a[i] + ", ");
		}
		System.out.println("END");

	}
	
	public static void ms(int[] arr, int lo, int hi){
		if(lo>=hi){
			return;
		}
		
		int mid=(lo + hi)/2;
		ms(arr, lo, mid);
		ms(arr, mid+1, hi);
		merge(arr, lo, mid, hi);
	}
	
	public static void merge(int[] arr, int lo, int mid, int hi){
		int[] b = new int[arr.length];
		int i=lo,j=mid+1,k=lo;
		
		while(i<=mid && j<=hi){
			if(arr[i] < arr[j]){
				b[k] = arr[i];
				k++;
				i++;
			}
			else{
				b[k] = arr[j];
				k++;
				j++;
			}
		}
		
		while(i<=mid){
			b[k] = arr[i];
			k++;
			i++;
		}
		
		while(j<=hi){
			b[k] = arr[j];
			k++;
			j++;
		}
		
		for(int l=lo; l<=hi; l++){
			arr[l] = b[l];
		}
	}

}
