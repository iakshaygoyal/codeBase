package bootcamp.graphs;
import java.util.*;
import bootcamp.graphs.directedGraphClass.directedGraph.vertex;
import java.lang.*;
public class heapMapDataStructure1{
	public class node implements Comparable<node>{
		Integer dist;
		vertex v;
		node(Integer dist,vertex v){
			this.dist=dist;
			this.v=v;
		}
		public int compareTo(node n1){
			return (int)n1.dist-(int)this.dist;
		}
	}
	ArrayList<node> data;
	HashMap<vertex,Integer> map;
	
	public heapMapDataStructure1() {
		data=new ArrayList<>();
		map=new HashMap<>();
	}
	
	public int size(){
		return this.data.size();
	}
	
	public boolean isEmpty(){
		return this.size()==0;
	}
	
	public void add(Integer dist,vertex v){
		node newNode=new node(dist,v);
		data.add(newNode);
		Object o=this.size()-1;
		map.put(v, (Integer)o);
		this.upheapify(data.size()-1);
	}
	
	public void upheapify(int ci){
		if(ci==0){
			return;
		}
		int pi=(ci-1)/2;
		if(data.get(ci).compareTo(data.get(pi)) > 0){
			swap(pi,ci);
			upheapify(pi);
		}
	}
	
	public node remove(){
		node retval=data.get(0);
		swap(0,data.size()-1);
		vertex val=data.get(data.size()-1).v;
		map.remove(val);
		data.remove(data.size()-1);
		downheapify(0);
		return retval;
	}
	
	public void downheapify(int pi){
		int lci=2*pi+1;
		int rci=2*pi+2;
		int idx=pi;
		if(lci<this.size() && data.get(lci).compareTo(data.get(idx)) > 0){
			idx=lci;
		}
		if(rci<this.size() && data.get(rci).compareTo(data.get(idx)) > 0){
			idx=rci;
		}
		if(idx!=pi){
			swap(pi,idx);
			downheapify(idx);
		}
	}
	
	public void swap(int fi,int si){
		vertex val1=data.get(fi).v;
		vertex val2=data.get(si).v;
		Object o1=si;
		Object o2=fi;
		map.put(val1,(Integer)o1);
		map.put(val2, (Integer)o2);
		node temp=data.get(fi);
		data.set(fi,data.get(si));
		data.set(si, temp);
	}
	
	public boolean contains(vertex v){
		if(map.containsKey(v)){
			return true;
		}
		return false;
	}
	
	public void decrease(Integer dist,vertex v){
		Integer idx=map.get(v);
		node newNode=new node(dist,v);
		data.set(idx, newNode);
//		data.get(idx).dist=dist;
		upheapify((int)idx);
	}
	
	public Integer get(vertex v){
		Integer idx=map.get(v);
		return data.get(idx).dist;
	}
}
