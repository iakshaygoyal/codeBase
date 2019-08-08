package assignmentHeapsandHashmap;

import java.util.ArrayList;

public class cp1 {

	//O(NLOGK)
	public static void main(String[] args) {
		int[] a = {2,6,3,12,56,8};
		int k=2;
		ArrayList<Integer> minHeap = new ArrayList<>();
		int j=k+1;
		for(int i:a){
			if(j>0){
				minHeap.add(i);
				j--;
			}
			else{
				break;
			}
		}
		for(int i=minHeap.size()/2-1;i>=0;i--){
			downHeapify(minHeap, i);
		}
		k++;
		ArrayList<Integer> list = new ArrayList<>();
		for(;k<a.length;k++){
			list.add(remove(minHeap));
			add(minHeap, a[k]);
		}
		while(minHeap.size()>0){
			list.add(remove(minHeap));
		}
		System.out.println(list);
	}
	
	public static void add(ArrayList<Integer> list, int item){
		list.add(item);
		upHeapify(list, list.size()-1);
	}
	
	public static void upHeapify(ArrayList<Integer> list,int ci){
		if(ci==0){
			return;
		}
		int pi=(ci-1)/2;
		if(pi>=0 && list.get(ci) < list.get(pi)){
			swap(list, pi, ci);
			upHeapify(list, pi);
		}
	}
	
	public static int remove(ArrayList<Integer> list){
		int retval=list.get(0);
		swap(list,0,list.size()-1);
		list.remove(list.size()-1);
		downHeapify(list, 0);
		return retval;
	}
	
	public static void downHeapify(ArrayList<Integer> list,int pi){
		int idx=pi;
		int lci=2*pi+1;
		int rci=2*pi+2;
		if(lci<list.size() && list.get(lci) < list.get(idx)){
			idx=lci;
		}
		if(rci<list.size() && list.get(rci) < list.get(idx)){
			idx=rci;
		}
		if(idx != pi){
			swap(list, pi, idx);
			downHeapify(list, idx);
		}
	}
	
	public static void swap(ArrayList<Integer> list,int fi,int si){
		int temp=list.get(fi);
		list.set(fi, list.get(si));
		list.set(si, temp);
	}

}
