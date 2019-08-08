package Heap;

import again.heap;

public class client {

	public static void main(String[] args) {
//		try{
//		PriorityQueue<Integer,String> pq = new Heap<>(false);
//		pq.add(10, "india");
//		pq.add(9, "us");
//		pq.add(8, "uk");
//		pq.add(7, "pakistan");
//		pq.add(6, "brazil");
//		pq.add(5, "china");
//		pq.display();
//		pq.remove();
//		pq.display();
//		pq.remove();
//		pq.display();
//		pq.remove();
//		pq.display();
//		pq.remove();
//		pq.display();
//		pq.remove();
//		pq.display();
//		}catch(Exception ex){
//			
//		}
		
		
		PriorityQueue<Integer, String> pq = new Heap<>(false); 
		pq.add(5, "akshay");
		pq.add(7, "roy");
		pq.add(1, "thea");
		pq.add(4, "nee");
		pq.add(2, "rob");
		pq.add(6, "bob");
		pq.add(3, "sucker");
		pq.display();
		
		while(!pq.isEmpty()){
			try {
				System.out.println(pq.remove()+", ");
				pq.display();
			} catch (Exception e) {
				// Unreachable Code
			}
		}
		
//		int[] arr = {3,6,1,8,-4,12,8,5,54,87,-33};
//		heapSort(arr);
//		for(int i=0;i<arr.length;i++){
//			System.out.print(arr[i]+", ");
//		}
//		System.out.println("END");

	}
	
	public static void heapSort(int[] arr){
		int n = arr.length;
		
		for(int i = n/2-1; i>=0; i--){
			downHeapify(arr, i, n);
		}
		
		for(int i = n-1; i>0; i--){
			int temp = arr[i];
			arr[i] = arr[0];
			arr[0] = temp;
			
			downHeapify(arr, 0, i);
		}
	}
	
	public static void downHeapify(int[] arr, int pi, int fi){
		int minIndex = pi;
		int lci = 2*pi+1;
		int rci = 2*pi+2;
		
		if(lci<fi && arr[lci] > arr[minIndex]){
			minIndex = lci;
		}
		
		if(rci<fi && arr[rci] > arr[minIndex]){
			minIndex = rci;
		}
		
		if(minIndex != pi){
			int temp = arr[pi];
			arr[pi] = arr[minIndex];
			arr[minIndex] = temp;
			
			downHeapify(arr, minIndex, fi);
		}
		
	}

}
