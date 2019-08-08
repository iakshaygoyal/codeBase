package importantConcepts;

import java.util.*;
import java.lang.*;
public class subsetJagged {
	
	public static void main (String[] args){
	    int[] input={5,4,3};
	    int[][] arr=subsets(input);
	    for(int i=0;i<arr.length;i++){
	    	for(int j=0;j<arr[i].length;j++){
	    		System.out.print(arr[i][j]+" ");
	    	}
	    	System.out.println();
	    }
	}
	
  public static int[][] subsets(int input[]) {
    return fill(input,0);
  }
  
  static int[][] fill(int[] input,int idx){
    if(idx==input.length){
      return new int[1][0];
    }
    
    int[][] small=fill(input,idx+1);
    
    int[][] arr=new int[2*small.length][];
    int i;
    for(i=0;i<small.length;i++){
      arr[i]=new int[small[i].length];
      for(int j=0;j<small[i].length;j++){
        arr[i][j]=small[i][j];
      }
    }
    
    for(int k=0;k<small.length;k++){
      arr[i+k]=new int[small[k].length+1];
      arr[i+k][0]=input[idx];
      for(int j=0;j<small[k].length;j++){
        arr[i+k][j+1]=small[k][j];
      }
    }
    
    return arr;
  }
  
}