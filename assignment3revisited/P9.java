package assignment3revisited;

import java.util.Scanner;

import again.mergeSort;
import lec03.ArrayBasic;

public class P9 {

	public static void main(String[] args) {
		int[] a=ArrayBasic.TAKE_INPUT();
		Scanner s=new Scanner(System.in);
		System.out.println("Enter sum :");
		int sum=s.nextInt();
		triplet(a,sum);

	}
	
	public static void triplet(int[] arr, int data){
		mergeSort.ms(arr, 0, arr.length-1);
		
		for(int i=0; i<arr.length-2; i++){
			int j=i+1;
			int k=arr.length-1;
			
			while(j<k){
				if(arr[i] + arr[j] + arr[k] == data){
					System.out.println(arr[i] + ", "+ arr[j] + ", " + arr[k] + " END\n");
					j++;
					k--;
				}
				else if(arr[i] + arr[j] + arr[k] < data){
					j++;
				}
				else{
					k--;
				}
			}
		}
	}

}
