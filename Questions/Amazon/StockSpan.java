package Questions.Amazon;

import java.util.Scanner;
import java.util.Stack;

public class StockSpan {

	public static void main (String[] args){
	    Scanner scn=new Scanner(System.in);
	    int t=scn.nextInt();
	    for(int i=0;i<t;i++){
	        int n=scn.nextInt();
	        int[] arr=new int[n+1];
	        for(int j=0;j<n;j++){
	            arr[j]=scn.nextInt();
	        }
	        arr[n]=Integer.MAX_VALUE;
	        stockSpan(arr,n);
	    }
	    scn.close();
	}
	
	static void stockSpan(int[] arr,int n){
	    int[] span=new int[n];
	    Stack<Integer> stk=new Stack<>();
	    for(int i=0;i<(n+1);i++){
	       while(!stk.isEmpty() && arr[i]>=arr[stk.peek()]){
	           int j=stk.pop();
	           int k=-1;
	           if(!stk.isEmpty()){
	               k=stk.peek();
	           }
	           span[j]=j-k;
	       }
	       stk.push(i);
	    }
	    for(int i=0;i<n;i++){
	        System.out.print(span[i]+" ");
	    }
	    System.out.println();
	}
}