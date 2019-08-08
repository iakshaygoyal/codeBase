package again;

import Heap.PriorityQueue;

public class clientHeap {

	public static void main(String[] args) {
//		PriorityQueue<Integer, String> pq = new heap<>(false); 
//		pq.add(5, "akshay");
//		pq.add(7, "roy");
//		pq.add(1, "thea");
//		pq.add(4, "nee");
//		pq.add(2, "rob");
//		pq.add(6, "bob");
//		pq.add(3, "sucker");
//		pq.display();
//		
//		while(!pq.isEmpty()){
//			try {
//				System.out.println(pq.remove()+", ");
//				pq.display();
//			} catch (Exception e) {
//				// Unreachable Code
//			}
//		}
		
//		PriorityQueue<Integer, String> pq1 = new heap<>(true, new Integer[] {5,7,1,4,2,6,3}, new String[] {"akshay", "roy", "thea", "nee", "rob", "bob", "sucker"});
//		
//		pq1.display();
//		
//		while(!pq1.isEmpty()){
//			try {
//				System.out.println(pq1.remove()+", ");
//				pq1.display();
//			} catch (Exception e) {
//				// Unreachable Code
//			}
//		}
		
		int[] arr = new int[]{7,6,8,5,4,3,2,1};
		heapSort(arr);
		for(int value : arr){
			System.out.print(value+", ");
		}
		System.out.println("END");

	}
	
	public static void heapSort(int[] arr){
		// n
		for(int i=(arr.length/2)-1; i>=0; i--){
			downHeapify(arr, i, arr.length);
		}
		
		// nlogn
		for(int i=0; i<arr.length-1; i++){
			int temp = arr[0];
			arr[0] = arr[arr.length-1-i];
			arr[arr.length-1-i] = temp;
			
			downHeapify(arr, 0, arr.length-1-i);
		}
	}
	
	public static void downHeapify(int[] arr, int pi, int fi){
		int lci=(2*pi)+1;
		int rci=(2*pi)+2;
		int currenti=pi;
		
		if(lci < fi && arr[lci] > arr[currenti]){
			currenti=lci;
		}
		
		if(rci < fi && arr[rci] > arr[currenti]){
			currenti=rci;
		}
		
		if(currenti != pi){
			int temp = arr[pi];
			arr[pi] = arr[currenti];
			arr[currenti] = temp;
			
			downHeapify(arr, currenti, fi);
		}
	}
}
