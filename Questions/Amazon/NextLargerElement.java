package Questions.Amazon;
import java.util.*;
public class NextLargerElement {

	public static void main (String[] args){
	    Scanner scn=new Scanner(System.in);
	    int t=scn.nextInt();
	    for(int a=0;a<t;a++){
	        int n=scn.nextInt();
	        int[] arr=new int[n];
	        for(int j=0;j<n;j++){
	            arr[j]=scn.nextInt();
	        }
	        int[] larger_arr=new int[n];
	        Arrays.fill(larger_arr,-1);
	        
	        Stack<Integer> stk=new Stack<>();
	        for(int i=0;i<n;i++){
	            if(stk.isEmpty() || arr[i]<=arr[stk.peek()]){
	                stk.push(i);
	            }
	            else{
	                while(!stk.isEmpty() && arr[i]>arr[stk.peek()]){
	                    larger_arr[stk.pop()]=arr[i];
	                }
	                stk.push(i);
	            }
	        }
	        
	        for(int i=0;i<n;i++){
	            System.out.print(larger_arr[i]+" ");
	        }
	        System.out.println();
	    }
	}
}