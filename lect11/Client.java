package lect11;

public class Client {

	public static void main(String[] args) {
		Pair<Integer> pInts = new Pair<>(2,3);
		
		System.out.println(pInts.one + pInts.two);
		
		Pair<Float> pFloats = new Pair<Float>(1.0f, 2.0f);
		
		Pair2<Integer, String> pComb = new Pair2<Integer, String>(1, "Hello");
		Integer gB = pComb.one;
//		pComb.
		
		Pair<Pair<Integer>> pPair = new Pair<Pair<Integer>>(null,null);
		pPair.one = new Pair<Integer>(1, 2);
		pPair.two = new Pair<Integer>(3, 4);
		
		Car[] cars = {new Car(100, 1000), new Car(50, 50), new Car(500, 500), new Car(10, 100)};
		
		for(int i = 0; i < cars.length; i++){
			System.out.println(cars[i]);
		}
		
		bubbleSort(cars);
		
		System.out.println("**********************************");
		for(int i = 0; i < cars.length; i++){
			System.out.println(cars[i]);
		}
		System.out.println("**********************************");
		
		DynamicArray<Integer> dAInts = new DynamicArray<>();
		DynamicArray<Float> dAFloats = new DynamicArray<>();
		
		dAInts.compareAverages(dAFloats);
		
		RawPair pair3 = new RawPair(111, "Hello");
		Integer gettingBack = (Integer)pair3.one;
		System.out.println(gettingBack);
		
		//Here we cannot use int datatype
		Integer[] a={5,4,3,2,1};
		bubbleSort(a);
		for(int i=0; i<a.length; i++){
			System.out.println(a[i]);
		}
	}

	public static <T extends Comparable<T>> void bubbleSort(T[] arr){
		int counter = 1;
		
		while(counter <= arr.length - 1){
			for(int i = 0; i < arr.length - counter; i++){
				if(arr[i].compareTo(arr[i + 1]) > 0){
					T temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
			
			counter = counter + 1;
		}
	}
	
	
}
