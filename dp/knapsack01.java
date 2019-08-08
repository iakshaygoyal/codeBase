package dp;

import java.util.ArrayList;
import java.util.Scanner;

import again.mergeSort;

public class knapsack01 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] p = new int[n];
		int[] w = new int[n];
		
		for(int i=0; i<n; i++){
			p[i] = s.nextInt();
		}
		
		for(int i=0; i<n ;i++){
			w[i] = s.nextInt();
		}
		
		int maxw = s.nextInt();
		
//		for(int i=0; i<n-1; i++){
//			for(int j=0; j<n-1-i; j++){
//				if(w[j] > w[j+1]){
//					int temp = w[j];
//					w[j] = w[j+1];
//					w[j+1] = temp;
//					
//					temp = p[j];
//					p[j] = p[j+1];
//					p[j+1] = temp;
//				}
//			}
//		}
//		ArrayList<Integer> al = kpsk01(p, w, 0, maxw, 0);
//		
//		
//		int maxp = al.get(0);
//		
//		for(int i=1; i<al.size(); i++){
//			if(al.get(i) > maxp){
//				maxp = al.get(i);
//			}
//		}
//		
//		System.out.println(maxp);

//		System.out.println(kpsk01(p, w, 0, maxw, 0));
//		System.out.println(kpsk02(p, w, 0, maxw));
		System.out.println(kpsk02(p, w, 0, maxw, new int[p.length + 1][maxw + 1]));
	}
	
	//No need of this approach(directly send the answer)
//	public static ArrayList<Integer> kpsk01(int[] p, int[] w, int idx, int maxw, int maxp){
//		if(idx == p.length || w[idx] > maxw){
//			ArrayList<Integer> retval = new ArrayList<>();
//			retval.add(maxp);
//			return retval;
//		}
//		
//		ArrayList<Integer> list1 = kpsk01(p, w, idx+1, maxw, maxp);
//		ArrayList<Integer> list2 = kpsk01(p, w, idx+1, maxw - w[idx], maxp + p[idx]);
//		
//		for(Integer i : list1){
//			list2.add(i);
//		}
//		
//		return list2;
//	}
	
	//Use below method(kpsk02)
//	public static int kpsk01(int[] p, int[] w, int idx, int maxw, int maxp){
//		if(idx == p.length){
//			return maxp;
//		}
//		
//		if(w[idx] > maxw){
//			return kpsk01(p, w, idx+1, maxw, maxp);
//		}
//		else{
//			return Math.max(kpsk01(p, w, idx+1, maxw, maxp), kpsk01(p, w, idx+1, maxw - w[idx], maxp + p[idx]));
//		}
//	}
	
//	public static int kpsk02(int[] p, int[] w, int idx, int maxw){
//		if(idx == p.length || maxw == 0){
//			return 0;
//		}
//		
//		if(w[idx] > maxw){
//			return kpsk02(p, w, idx+1, maxw);
//		}
//		else{
//			return Math.max(kpsk02(p, w, idx+1, maxw), p[idx] + kpsk02(p, w, idx+1, maxw - w[idx]));
//		}
//	}
	
	public static int kpsk02(int[] p, int[] w, int idx, int maxw, int[][] storage){
		if(storage[idx][maxw] != 0){
			return storage[idx][maxw];
		}
		
		int retval = 0;
		
		if(idx == p.length || maxw == 0){
			retval = 0;
		}
		else if(w[idx] > maxw){
			retval = kpsk02(p, w, idx+1, maxw, storage);
		}
		else{
			retval = Math.max(kpsk02(p, w, idx+1, maxw, storage), p[idx] + kpsk02(p, w, idx+1, maxw - w[idx], storage));
		}
		
		storage[idx][maxw] = retval;
		return retval;
	}

}
