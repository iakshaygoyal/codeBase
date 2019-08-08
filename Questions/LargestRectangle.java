package Questions;
import java.util.*;
public class LargestRectangle {

	public static void main (String[] args){
	    Scanner scn=new Scanner(System.in);
	    int t=scn.nextInt();
	    for(int i=0;i<t;i++){
	        int n=scn.nextInt();
	        int[] arr=new int[n+1];
	        for(int j=0;j<(n);j++){
	            arr[j]=scn.nextInt();
	        }
	        arr[n]=0;
	        System.out.println(maxArea(arr,n));
	    }
	}
	
	static int maxArea(int[] arr,int n){
	    Stack<Integer> stk=new Stack<>();
	    int max=0;
	    for(int i=0;i<(n+1);i++){
	        while(!stk.isEmpty() && arr[i]<arr[stk.peek()]){
	           int ht=arr[stk.pop()];
	           int j=-1;
	           if(!stk.isEmpty()){
	               j=stk.peek();
	           }
	           int val=(i-j-1)*ht;
	           max=Math.max(max,val);
	        }
            stk.push(i);
	    }
	    return max;
	}
}