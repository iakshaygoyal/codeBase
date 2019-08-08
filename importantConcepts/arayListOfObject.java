package importantConcepts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class arayListOfObject {

	// class is static
	public static class Node implements Comparable<Node>{
		int data1;
		int data2;
		
		Node(int data1, int data2){
			this.data1 = data1;
			this.data2 = data2;
		}
		
		public String toString(){
			return this.data1 + " " + this.data2;
		}

		@Override
		public int compareTo(Node arg0) {
			return this.data1-arg0.data1;
		}
		
		public boolean equals(Object o){
			Node node=(Node)o;
			if(this.data1==node.data1&&this.data2==node.data2){
				return true;
			}
			return false;
		}
	}
	
	public static class ncomparator implements Comparator<Node>{

		@Override
		public int compare(Node node1, Node node2) {
			return node1.data1-node2.data1;
		}
		
	}
	
	public static class rcomparator implements Comparator<Node>{

		@Override
		public int compare(Node node1, Node node2) {
			return node1.data2-node2.data2;
		}
		
	}
	
	public static void main(String[] args) {
		ArrayList<Node> list = new ArrayList<>();
		Node x = new Node(1,7);
		list.add(x);
		list.add(new Node(2,3));
		list.add(new Node(7,9));
		list.add(new Node(5,14));
		list.add(new Node(11,10));
		System.out.println(list);
		Node n1=new Node(2,3);
		System.out.println(list.contains(n1));
//		Collections.sort(list);
//		System.out.println(list);
		Comparator<Node> c=new ncomparator();
		Comparator<Node> r=new rcomparator();
		Collections.sort(list, c);
		System.out.println(list);
		Collections.sort(list, r);
		System.out.println(list);
	}

}
