package again;

import java.io.*;
import java.util.*;

public class swapNode {

	 public static void main(String[] args) {
		 
//		 11
//		 2 3 4 -1 5 -1 6 -1 7 8 -1 9 -1 -1 10 11 -1 -1 -1 -1 -1 -1
//		 3
//		 2 3 -1 -1 -1 -1
		 
	        Scanner s = new Scanner(System.in);
	        int n = s.nextInt();
	        int[][] input = new int[n][2];
	        
	        for(int i=0; i<n; i++){
	            for(int j=0; j<2; j++){
	                input[i][j] = s.nextInt();
	            }
	        }
	        
	        int[] myinput = new int[100000000];
	        myinput[1]=1;
	        int j=1, k=2;
	        int row=0;
	        
	        while(row<n){
	            if(myinput[j++] != -1){
	                myinput[k++] = input[row][0];
	                myinput[k++] = input[row][1];
	                row++;
	            }
	            else{
	                myinput[k++] = -1;
	                myinput[k++] = -1;
	            }
	        }
	        
	        j=1;
	        while(myinput[j] != 0){
	        	System.out.print(myinput[j++] + " ");
	        } 
	        System.out.println();
	        inorder(myinput, 1);
	        System.out.println();
	        height(myinput, 1);
	        System.out.println(height(myinput, 1));
	        swappingHelper(myinput, 2);
	        inorder(myinput, 1);
	        System.out.println();
	        
//	        int t = s.nextInt();
//	        for(int i=0; i<t; i++){
//	            int h = s.nextInt();
//	            swappingHelper(myinput, h);
//	            inorder(myinput, 1);
//		        System.out.println();
//	        }
	    }

	    public static void inorder(int[] myinput, int idx){
	        if(myinput[idx] == 0){
	            return;
	        }
	        inorder(myinput, 2*idx);
	        if(myinput[idx] != -1){
	            System.out.print(myinput[idx] + " ");
	        }
	        inorder(myinput, 2*idx + 1);
	    }

	    public static void swap(int[] myinput, int idx1, int idx2){
	        int temp = myinput[idx1];
	        myinput[idx1] = myinput[idx2];
	        myinput[idx2] = temp;
	    }
	    
	    public static void swappingHelper(int[] myinput, int depth){
	    	int ht = height(myinput, 1);
	    	System.out.println("ht : "+ht);
	    	int n = 2;
	    	int orginaldepth = depth;
	    	while(depth < ht + 1){
	    		int numoftimes = (int)Math.pow(2, depth-1);
	    		int idx = (int)Math.pow(2, depth);
	    		while(numoftimes > 0){
	    			swapping(myinput, idx, idx + 1);
	    			idx = idx + 2;
	    			numoftimes--;
	    		}
	    		depth=(n*orginaldepth);
	    		n++;
	    	}
	    }
	    
	    public static void swapping(int[] myinput, int idx1, int idx2){
	        if(myinput[idx1] == 0 || myinput[idx2] == 0){
	            return;
	        }
	        swap(myinput, idx1, idx2);
	        swapping(myinput, 2*idx1, 2*idx2);
	        swapping(myinput, (2*idx1)+1, (2*idx2)+1); 
	    }
	    
	    public static int height(int[] myinput, int idx){
	    	if(myinput[idx] == 0 || myinput[idx] == -1){
	    		return -1;
	    	}
	    	
	    	int leftht = height(myinput, 2*idx);
	    	int rightht = height(myinput, 2*idx + 1);
	    	
	    	return Math.max(leftht, rightht) + 1;
	    }
	    
	}