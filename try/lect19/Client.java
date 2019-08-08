package lect19;

public class Client {

	public static void main(String[] args) {
		try {
			// PriorityQueue<Integer, String> pq = new Heap<>(true);
			//
			// pq.add(7, "UK");
			// pq.add(6, "Spain");
			// pq.add(5, "France");
			// pq.add(10, "India");
			// pq.add(9, "US");
			// pq.add(8, "China");
			// pq.add(4, "Belgium");
			// pq.add(3, "Egypt");
			//
			// pq.display();
			//
			// while (!pq.isEmpty()) {
			// System.out.println(pq.remove() + ", ");
			// pq.display();
			// }
			//
			// System.out.println("O-N heap constructor");
			// pq = new Heap<>(false, new Integer[] { 7, 6, 5, 10, 9, 8, 4, 3 },
			// new String[] { "UK", "Spain", "France", "India", "US", "China",
			// "Belgium", "Egypt" });
			//
			// pq.display();
			//
			// while (!pq.isEmpty()) {
			// System.out.println(pq.remove() + ", ");
			// pq.display();
			// }

//			int[] arr = { 5, 8, -1, 3, 6, 7, 33, -2 };
//			heapSort(arr);
//
//			for (int i = 0; i < arr.length; i++) {
//				System.out.print(arr[i] + ", ");
//			}
//			System.out.println("END");

			System.out.println(successorPermutation("2413"));
		} catch (Exception ex) {
			// never going to come her
		}
	}

	public static void heapSort(int[] arr) {
		int n = arr.length;

		for (int i = n / 2 - 1; i >= 0; i--) {
			downHeapify(arr, i, n);
		}

		for (int i = n - 1; i > 0; i--) {
			int temp = arr[i];
			arr[i] = arr[0];
			arr[0] = temp;

			downHeapify(arr, 0, i);
		}
	}

	public static void downHeapify(int[] arr, int pi, int lp) {
		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;

		int maxIndex = pi;

		if (lci < lp && arr[maxIndex] < arr[lci]) {
			maxIndex = lci;
		}

		if (rci < lp && arr[maxIndex] < arr[rci]) {
			maxIndex = rci;
		}

		if (maxIndex != pi) {
			int temp = arr[maxIndex];
			arr[maxIndex] = arr[pi];
			arr[pi] = temp;

			downHeapify(arr, maxIndex, lp);
		}
	}

	public static Integer kthSmallest(int k, Integer[] arr) throws Exception {
		PriorityQueue<Integer, Integer> minHeap = new Heap<>(true);

		minHeap.add(arr[0], 0);
		int counter = 1;

		while (counter < k) {
			Integer pi = minHeap.remove();

			minHeap.add(arr[2 * pi + 1], 2 * pi + 1);
			minHeap.add(arr[2 * pi + 2], 2 * pi + 2);

			counter++;
		}

		return arr[minHeap.remove()];
	}

	public static class Pair {
		boolean targetFound;
		boolean successorFound;
		String successor;
	}

	public static String successorPermutation(String num) {
		Pair obj = new Pair();
		
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < num.length(); i++){
			int j = 0;
			
			for(;j < sb.length(); j++){
				if(num.charAt(i) < sb.charAt(j)){
					break;
				}
			}
			
			sb.insert(j, num.charAt(i));
		}
		
		
		successorPermutation(sb.toString(), "", obj, num);
		return obj.successor;
	}

	public static void successorPermutation(String num, String osf, Pair obj, String oNum) {
		if (num.equals("")) {
			if (!obj.targetFound && osf.equals(oNum)) {
				obj.targetFound = true;
			}
			else if(obj.targetFound && !obj.successorFound){
				obj.successorFound = true;
				obj.successor = osf;
			}
			
			return;
		}

		for (int i = 0; i < num.length(); i++) {
			Character cc = num.charAt(i);
			String ros = num.substring(0, i) + num.substring(i + 1);

			successorPermutation(ros, osf + cc, obj, oNum);
		}
	}
}
