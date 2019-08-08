package dp;

import java.util.Scanner;

public class kpsk {

	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		
		for(int i=0; i<t; i++){
		    int n = s.nextInt();
		    int w = s.nextInt();
		    int[] value = new int[n];
		    int[] weight = new int[n];
		    
		    for(int j=0; j<n; j++){
		        value[j] = s.nextInt();
		    }
		    
		    for(int j=0; j<n; j++){
		        weight[j] = s.nextInt();
		    }
		    
		    System.out.println(kp(value, weight, 0, w, new int[value.length][w + 1]));
		}
	}
	
	public static int kp(int[] value, int[] weight, int idx, int w, int[][] storage){
	    if(idx == value.length || w == 0){
	        return 0;
	    }
	    
	    if(storage[idx][w] != 0){
	        return storage[idx][w];
	    }
	    
	    if(weight[idx] > w){
	        storage[idx][w] = kp(value, weight, idx+1, w, storage);
	    }
	    else{
	    	storage[idx][w] = Math.max(kp(value, weight, idx+1, w-weight[idx], storage) + value[idx], kp(value, weight, idx+1, w, storage));
	    }
	    return storage[idx][w];
	}
}
