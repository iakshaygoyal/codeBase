package Questions.Amazon;
import java.util.*;
public class SlidingWindow {

	public static void main (String[] args){
	    Scanner scn=new Scanner(System.in);
	    int t=scn.nextInt();
	    for(int i=0;i<t;i++){
	        int n=scn.nextInt();
	        int k=scn.nextInt();
	        int[] arr=new int[n];
	        for(int j=0;j<n;j++){
	            arr[j]=scn.nextInt();
	        }
	        Deque<Integer> deck=new ArrayDeque<>();
	        for(int j=0;j<k;j++){
	            while(!deck.isEmpty() && arr[j]>=arr[deck.peekLast()]){
	                deck.pollLast();
	            }
	            deck.offerLast(j);
	        }
	        for(int j=k;j<n;j++){
	            System.out.print(arr[deck.peekFirst()]+" ");
	            while(!deck.isEmpty() && deck.peekFirst()<=(j-k)){
	                deck.pollFirst();
	            }
	            while(!deck.isEmpty() && arr[j]>=arr[deck.peekLast()]){
	                deck.pollLast();
	            }
	            deck.offerLast(j);
	        }
	        System.out.println(arr[deck.peekFirst()]);
	    }
	    scn.close();
	}
}