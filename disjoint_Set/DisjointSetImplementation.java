package disjoint_Set;
import java.util.*;
public class DisjointSetImplementation {

	static class DisjointSet{
		class Node{
			long data;
			Node parent;
			int rank;
		}
		
		HashMap<Long,Node> map=new HashMap<>();
		
		void makeSet(long data){
			Node node=new Node();
			node.data=data;
			node.parent=node;
			node.rank=0;
			map.put(data, node);
		}
		
		void union(long data1,long data2){
			Node root1=findSet(map.get(data1));
			Node root2=findSet(map.get(data2));
			
			if(root1==root2) return;
			
			if(root1.rank>=root2.rank){
				root1.rank=(root1.rank==root2.rank) ? root1.rank+1 : root1.rank;
				root2.parent=root1;
			}
			else{
				root1.parent=root2;
			}
		}
		
		long findSet(long data){
			return findSet(map.get(data)).data;
		}
		
		private Node findSet(Node node){
			if(node.parent!=node){
				node.parent=findSet(node.parent);
			}
			return node.parent;
		}
	}
	
	public static void main(String[] args) {
		DisjointSet ds=new DisjointSet();
		ds.makeSet(1);
		ds.makeSet(2);
		ds.makeSet(3);
		ds.makeSet(4);
		ds.makeSet(5);
		ds.makeSet(6);
		ds.makeSet(7);
		
		ds.union(1, 2);
		ds.union(2, 3);
		ds.union(4, 5);
		ds.union(6, 7);
		ds.union(5, 6);
		ds.union(3, 7);
		
		System.out.println(ds.findSet(1));
		System.out.println(ds.findSet(2));
		System.out.println(ds.findSet(3));
		System.out.println(ds.findSet(4));
		System.out.println(ds.findSet(5));
		System.out.println(ds.findSet(6));
		System.out.println(ds.findSet(7));
	}

}
