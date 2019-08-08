package disjoint_Set;
public class DisjointSetArray {

	static class DisjointSet{
		int[] parent,rank;
		
		DisjointSet(int n) {
			parent=new int[n];
			rank=new int[n];
			for(int i=0;i<n;i++){
				parent[i]=i;
			}
		}
		
		int find(int i){
			if(parent[i]!=i){
				parent[i]=find(parent[i]);
			}
			return parent[i];
		}
		
		void union(int i,int j){
			int root1=find(i);
			int root2=find(j);
			
			if(root1==root2) return;
			
			if(rank[root1]>rank[root2]){
				parent[root2]=root1;
			}
			else if(rank[root1]<rank[root2]){
				parent[root1]=root2;
			}
			else{
				parent[root1]=root2;
				rank[root2]++;
			}
		}
	}
	
	public static void main(String[] args) {
		DisjointSet ds=new DisjointSet(7);
		
		ds.union(0, 1);
		ds.union(1, 2);
		ds.union(3, 4);
		ds.union(5, 6);
		ds.union(4, 5);
		ds.union(2, 6);
		
		System.out.println(ds.find(0));
		System.out.println(ds.find(1));
		System.out.println(ds.find(2));
		System.out.println(ds.find(3));
		System.out.println(ds.find(4));
		System.out.println(ds.find(5));
		System.out.println(ds.find(6));
	}
}
