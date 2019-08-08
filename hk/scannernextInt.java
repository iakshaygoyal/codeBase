package hk;

import java.util.Scanner;

public class scannernextInt {
	 public static void main(String[] args) {
		 
		 	//1st approach
	        Scanner s = new Scanner(System.in);
	        int n = s.nextInt();
	        s.nextLine();
	        
	        String[] a = new String[n];
	        for(int i=0; i<n; i++){
	            a[i] = s.nextLine();
	        }
	        
	        int q = s.nextInt();
	        s.nextLine();
	        
	        int[] m = new int[q];
	        for(int i=0; i<q; i++){
	            String curr = s.nextLine();
	            
	            for(int j=0; j<n; j++){
	                if(curr.equals(a[j])){
	                    m[i]++;
	                }
	            }
	        }
	        
	        for(int i=0; i<q; i++){
	            System.out.println(m[i]);
	        }
		 
		 	// 2nd approach
//		 	Scanner s = new Scanner(System.in);
//	        int n = Integer.parseInt(s.nextLine());
//	        
//	        String[] a = new String[n];
//	        for(int i=0; i<n; i++){
//	            a[i] = s.nextLine();
//	        }
//	        int q = Integer.parseInt(s.nextLine());
//	        
//	        int[] m = new int[q];
//	        for(int i=0; i<q; i++){
//	            String curr = s.nextLine();
//	            
//	            for(int j=0; j<n; j++){
//	                if(curr.equals(a[j])){
//	                    m[i]++;
//	                }
//	            }
//	        }
//	        
//	        for(int i=0; i<q; i++){
//	            System.out.println(m[i]);
//	        }
	    }
}
