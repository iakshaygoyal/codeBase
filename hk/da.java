package hk;

import java.util.ArrayList;
import java.util.Scanner;

public class da {

	 public static void main(String[] args) {
	        Scanner s = new Scanner(System.in);
	        ArrayList<ArrayList<Integer>> seqList = new ArrayList<>();
	        int lastAns = 0;
	        int n = s.nextInt();
	        for(int i=0; i<n; i++){
	            seqList.add(new ArrayList<>());
	        }
	        int q = s.nextInt();
	        for(int i=0; i<q; i++){
	            int[] a = new int[3];
	            
	            for(int j=0; j<3; j++){
	                a[j] = s.nextInt();
	            }
	            
	            if(a[0] == 1){
	                ArrayList<Integer> current = seqList.get((a[1] ^ lastAns) % n);
	                current.add(a[2]);
	            }
	            else if(a[0] == 2){
	                ArrayList<Integer> current = seqList.get((a[1] ^ lastAns) % n);
	                int val = current.get(a[2] % n);
	                lastAns = val;
	                System.out.println(lastAns);
	            }
	        }
	 }
	
}
