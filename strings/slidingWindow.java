package strings;
import java.util.*;
public class slidingWindow {
//	9
//	3
//	1 2 3 1 4 5 2 3 6
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int k=s.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++){
			a[i]=s.nextInt();
		}
		f(a, n, k);
	}
	
	static void f(int[] a,int n,int k){
		Deque<Integer> deck=new ArrayDeque<>();
		int i;
		for(i=0;i<k;i++){
			while(!deck.isEmpty() && a[i]>=a[deck.peekLast()]){
				deck.pollLast();
			}
			deck.offerLast(i);
		}
		for(;i<n;i++){
			System.out.print(a[deck.peekFirst()]+" ");
			while(!deck.isEmpty() && deck.peekFirst()<=(i-k)){
				deck.pollFirst();
			}
			while(!deck.isEmpty() && a[i]>=a[deck.peekLast()]){
				deck.pollLast();
			}
			deck.offerLast(i);
		}
		System.out.print(a[deck.peekFirst()]);
	}

}
