package importantConcepts;

import java.util.Scanner;

public class arrayOfObject {

	static class stu{
		int marks;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		stu[] arr = new stu[5];
//		error

//		The above statement creates the array which can hold references to five stu objects.
//		It doesn't create the stu objects themselves. They have to be created separately
//		using the constructor of the stu class. The array contains five memory spaces
//		in which the address of five stu objects may be stored. If we try to access the
//		stu objects even before creating them, run time errors would occur. For instance,
//		the following statement throws a NullPointerException during runtime which indicates
//		that arr[0] isn't yet pointing to a stu object. 
		
//		System.out.println(arr[0].marks); 
//		
		for(int i=0; i<5; i++){
			arr[i] = new stu();
		}
		System.out.println(arr[0].marks);
		
//		Enhanced for loop works in this case
		for(stu x : arr){
			x.marks = s.nextInt();
		}
		for(stu x : arr){
			System.out.println(x.marks);
		}
		
//		Enhanced for loop doesnt works in this case(only copies are stored in y)
		int[] arr1 = new int[5];
		for(int y : arr1){
			y = s.nextInt();
		}
		for(int y : arr1){
			System.out.println(y);
		}
	}

}
