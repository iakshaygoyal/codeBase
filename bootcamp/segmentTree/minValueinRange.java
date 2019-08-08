package bootcamp.segmentTree;
import java.util.*;
import java.lang.*;
public class minValueinRange {

	public static void main(String[] args) {
		int[] a=new int[]{4,2,0,8,1,5};
		int[] tree=new int[4*a.length+1];
		int[] lazy=new int[tree.length];
		build(tree, 1, a, 0, a.length-1);
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		for(int i=0;i<t;i++){
			char c=s.next().charAt(0);
			if(c=='Q'){
				int l=s.nextInt();
				int r=s.nextInt();
				System.out.println(queryLazy(tree,lazy, 1, 0, a.length-1, l, r));
			}
			else if(c=='U'){
				int l=s.nextInt();
				int r=s.nextInt();
				update(tree, 1, 0, a.length-1, l, r);
			}
			else{
				int l=s.nextInt();
				int r=s.nextInt();
				int value=s.nextInt();
				updateRangeLazy(tree,lazy, 1, 0, a.length-1, l, r, value);
			}
		}
	}
	
	public static int build(int[] tree,int node,int[] a,int si,int ei){
		if(si==ei){
			tree[node]=a[si];
			return tree[node];
		}
		else{
			int mid=(si+ei)/2;
			int left=build(tree, 2*node, a, si, mid);
			int right=build(tree, 2*node+1, a, mid+1, ei);
			tree[node]=Math.min(left, right);
			return tree[node];
		}
	}
	
	public static int query(int[] tree,int node,int si,int ei,int qsi,int qei){
		if(qsi<=si && qei>=ei){
			return tree[node];
		}
		if(qei<si || ei<qsi){
			return Integer.MAX_VALUE;
		}
		else{
			int mid=(si+ei)/2;
			int left=query(tree, 2*node, si, mid, qsi, qei);
			int right=query(tree, 2*node+1, mid+1, ei, qsi, qei);
			return Math.min(left, right);
		}
	}
	
	public static void update(int[] tree,int node,int si,int ei,int idx,int value){
		if(idx<si || idx>ei){
			return;
		}
		if(si==ei){
			tree[node]+=value;
			return;
		}
		int mid=(si+ei)/2;
		update(tree, 2*node, si, mid, idx, value);
		update(tree, 2*node+1, mid+1, ei, idx, value);
		tree[node]=Math.min(tree[2*node], tree[2*node+1]);
	}
	
	public static void updateRange(int[] tree,int node,int si,int ei,int l,int r,int value){
		if(ei<l || r<si){
			return;
		}
		if(si==ei){
			tree[node]+=value;
			return;
		}
		int mid=(si+ei)/2;
		updateRange(tree, 2*node, si, mid, l, r, value);
		updateRange(tree, 2*node+1, mid+1, ei, l, r, value);
		tree[node]=Math.min(tree[2*node], tree[2*node+1]);
	}

	public static void updateRangeLazy(int[] tree,int[] lazy,int node,int si,int ei,int l,int r,int value){
		if(lazy[node]!=0){
			tree[node]+=lazy[node];
			if(si!=ei){
				lazy[2*node]+=lazy[node];
				lazy[2*node+1]+=lazy[node];
			}
			lazy[node]=0;
		}
		if(ei<l || r<si){
			return;
		}
		if(l<=si && r>=ei){
			tree[node]+=value;
			if(si!=ei){
				lazy[2*node]+=value;
				lazy[2*node+1]+=value;
			}
			return;
		}
		int mid=(si+ei)/2;
		updateRangeLazy(tree, lazy, 2*node, si, mid, l, r, value);
		updateRangeLazy(tree, lazy, 2*node+1, mid+1, ei, l, r, value);
		tree[node]=Math.min(tree[2*node],tree[2*node+1]);
	}
	
	public static int queryLazy(int[] tree,int[] lazy,int node,int si,int ei,int qsi,int qei){
		if(lazy[node]!=0){
			tree[node]+=lazy[node];
			if(si!=ei){
				lazy[2*node]+=lazy[node];
				lazy[2*node+1]+=lazy[node];
			}
			lazy[node]=0;
		}
		if(qsi<=si && qei>=ei){
			return tree[node];
		}
		if(qei<si || ei<qsi){
			return Integer.MAX_VALUE;
		}
		int mid=(si+ei)/2;
		int left=queryLazy(tree, lazy, 2*node, si, mid, qsi, qei);
		int right=queryLazy(tree, lazy, 2*node+1, mid+1, ei, qsi, qei);
		return Math.min(left,right);
	}
}
