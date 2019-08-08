package assignmentHeapsandHashmap;

import java.util.ArrayList;

public class runningMedian {

	public static void main(String[] args) {
		int[] a={6,3,4,1,7,5,2};
		int[] b={12,4,5,3,8,7};
		ArrayList<Double> minHeap = new ArrayList<>();
		ArrayList<Double> maxHeap = new ArrayList<>();
		double median=0.0;
		for(int i:b){
			if(i>median){
				if(minHeap.size()>maxHeap.size()){
					addMax(maxHeap, removeMin(minHeap));
				}
				addMin(minHeap, i);
				if(minHeap.size() == maxHeap.size()){
					median=(minHeap.get(0) + maxHeap.get(0))/2;
				}
				else{
					median=minHeap.get(0);
				}
				System.out.println(median);
			}
			else{
				if(maxHeap.size()>minHeap.size()){
					addMin(minHeap, removeMax(maxHeap));
				}
				addMax(maxHeap, i);
				if(maxHeap.size() == minHeap.size()){
					median=(minHeap.get(0) + maxHeap.get(0))/2;
				}
				else{
					median=maxHeap.get(0);
				}
				System.out.println(median);
			}
		}
	}
	
	public static void addMin(ArrayList<Double> list, double item){
		list.add(item);
		upHeapifyMin(list, list.size()-1);
	}
	
	public static void upHeapifyMin(ArrayList<Double> list,int ci){
		if(ci==0){
			return;
		}
		int pi=(ci-1)/2;
		if(pi>=0 && list.get(ci) < list.get(pi)){
			swap(list, pi, ci);
			upHeapifyMin(list, pi);
		}
	}
	
	public static double removeMin(ArrayList<Double> list){
		double retval=list.get(0);
		swap(list,0,list.size()-1);
		list.remove(list.size()-1);
		downHeapifyMin(list, 0);
		return retval;
	}
	
	public static void downHeapifyMin(ArrayList<Double> list,int pi){
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
			downHeapifyMin(list, idx);
		}
	}
	
	public static void addMax(ArrayList<Double> list, double item){
		list.add(item);
		upHeapifyMax(list, list.size()-1);
	}
	
	public static void upHeapifyMax(ArrayList<Double> list,int ci){
		if(ci==0){
			return;
		}
		int pi=(ci-1)/2;
		if(pi>=0 && list.get(ci) > list.get(pi)){
			swap(list, pi, ci);
			upHeapifyMax(list, pi);
		}
	}
	
	public static double removeMax(ArrayList<Double> list){
		double retval=list.get(0);
		swap(list,0,list.size()-1);
		list.remove(list.size()-1);
		downHeapifyMax(list, 0);
		return retval;
	}
	
	public static void downHeapifyMax(ArrayList<Double> list,int pi){
		int idx=pi;
		int lci=2*pi+1;
		int rci=2*pi+2;
		if(lci<list.size() && list.get(lci) > list.get(idx)){
			idx=lci;
		}
		if(rci<list.size() && list.get(rci) > list.get(idx)){
			idx=rci;
		}
		if(idx != pi){
			swap(list, pi, idx);
			downHeapifyMax(list, idx);
		}
	}
	
	public static void swap(ArrayList<Double> list,int fi,int si){
		double temp=list.get(fi);
		list.set(fi, list.get(si));
		list.set(si, temp);
	}
}
