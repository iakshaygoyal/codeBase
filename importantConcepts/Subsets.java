package importantConcepts;

import java.util.ArrayList;
import java.util.Scanner;

public class Subsets {

	public static void main (String[] args){
		Scanner scn=new Scanner(System.in);
//		String s=scn.next();
//		System.out.println(subset(s));
		
		int[] arr={3,5,12,111};
		subsetArray(arr, 0, "");
		scn.close();
	}
	
	static ArrayList<String> subset(String s){
		if(s.length()==0){
			ArrayList<String> list=new ArrayList<>();
			list.add("");
			return list;
		}
		ArrayList<String> list1=subset(s.substring(1));
		ArrayList<String> list2=new ArrayList<>();
		list2.addAll(list1);
		for(int i=0;i<list1.size();i++){
			list2.add(s.charAt(0)+list1.get(i));
		}
		return list2;
	}
	
	static void subsetArray(int[] arr,int idx,String s){
		if(idx==arr.length){
			System.out.println(s);
			return;
		}
		subsetArray(arr, idx+1, s);
		subsetArray(arr, idx+1, s+arr[idx]+", ");
	}
	
}