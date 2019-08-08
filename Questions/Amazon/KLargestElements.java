package Questions.Amazon;
import java.util.*;

public class KLargestElements {
	
	static ArrayList<Integer> heap;
	public static void main (String[] args){
	 //code
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			heap=new ArrayList<>();
			int n=scn.nextInt();
			int k=scn.nextInt();
			for(int j=0;j<n;j++){
//				add(scn.nextInt());
				heap.add(scn.nextInt());
			}
			create(n);
			for(int j=0;j<k;j++){
				System.out.print(remove()+" ");
			}
			System.out.println();
		}
	}
	
	static void create(int n){
		for(int i=n/2-1;i>=0;i--){
			downHeapify(i);
		}
	}
	
//	static void add(int data){
//		heap.add(data);
//		upHeapify(heap.size()-1);
//	}
//	
//	static void upHeapify(int ci){
//		if(ci==0){
//			return;
//		}
//		int pi=(ci-1)/2;
//		if(heap.get(ci)>heap.get(pi)){
//			Collections.swap(heap, pi, ci);
//			upHeapify(pi);
//		}
//	}
	
	static int remove(){
		int retval=heap.get(0);
		Collections.swap(heap, 0, heap.size()-1);
		heap.remove(heap.size()-1);
		downHeapify(0);
		return retval;
	}
	
	static void downHeapify(int pi){
		int lci=2*pi+1;
		int rci=2*pi+2;
		int mini=pi;
		
		if(lci<heap.size() && heap.get(lci)>heap.get(mini)){
			mini=lci;
		}
		if(rci<heap.size() && heap.get(rci)>heap.get(mini)){
			mini=rci;
		}
		if(mini!=pi){
			Collections.swap(heap, mini, pi);
			downHeapify(mini);
		}
	}
	
}