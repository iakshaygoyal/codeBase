package bootcamp.segmentTree;
import java.util.*;
import java.lang.*;
public class maxSubArrayoveraRange {

	public static class node{
		int prefixSum;
		int suffixSum;
		int total;
		int maxSum;
		
		node(int prefixSum,int suffixSum,int total,int maxSum){
			this.prefixSum=prefixSum;
			this.suffixSum=suffixSum;
			this.total=total;
			this.maxSum=maxSum;
		}
		
		node(){};
	}
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int[] a=new int[]{2,-4,3,-1,6,7,2,-1,4,-7,3};
		node[] tree=new node[4*a.length+1];
		for(int i=0;i<tree.length;i++){
			tree[i]=new node();
		}
		build(tree, 1, a, 0, a.length-1);
		int t=s.nextInt();
		for(int i=0;i<t;i++){
			char c=s.next().charAt(0);
			int l=s.nextInt();
			int r=s.nextInt();
			if(c=='Q'){
				System.out.println(query(tree, 1, 0, a.length-1, l, r).maxSum);
			}
			else if(c=='U'){
				update(tree, 1, 0, a.length-1, l, r);
			}
			else{
				int value=s.nextInt();
				updateRange(tree, 1, 0, a.length-1, l, r, value);
			}
		}
	}
	
	public static node build(node[] tree,int idx,int[] a,int si,int ei){
		if(si==ei){
			tree[idx].prefixSum=a[si];
			tree[idx].suffixSum=a[si];
			tree[idx].total=a[si];
			tree[idx].maxSum=a[si];
			return tree[idx];
		}
		else{
			int mid=(si+ei)/2;
			node left=build(tree, 2*idx, a, si, mid);
			node right=build(tree, 2*idx+1, a, mid+1, ei);
			tree[idx].prefixSum=Math.max(left.prefixSum,left.total+right.prefixSum);
			tree[idx].suffixSum=Math.max(right.suffixSum, right.total+left.suffixSum);
			tree[idx].total=left.total+right.total;
			tree[idx].maxSum=Math.max(left.maxSum, Math.max(right.maxSum, left.suffixSum+right.prefixSum));
			return tree[idx];
		}
	}
	
	public static node query(node[] tree,int idx,int si,int ei,int qsi,int qei){
		if(qei<si || ei<qsi){
			return null;
		}
		if(qsi<=si && qei>=ei){
			return tree[idx];
		}
		int mid=(si+ei)/2;
		node left=query(tree, 2*idx, si, mid, qsi, qei);
		node right=query(tree, 2*idx+1, mid+1, ei, qsi, qei);
		if(left==null){
			return right;
		}
		else if(right==null){
			return left;
		}
		else{
			node retval=new node();
			retval.prefixSum=Math.max(left.prefixSum,left.total+right.prefixSum);
			retval.suffixSum=Math.max(right.suffixSum, right.total+left.suffixSum);
			retval.total=left.total+right.total;
			retval.maxSum=Math.max(left.maxSum, Math.max(right.maxSum, left.suffixSum+right.prefixSum));
			return retval;
		}
	}
	
	public static void update(node[] tree,int idx,int si,int ei,int i,int value){
		if(i<si || i>ei){
			return;
		}
		if(si==ei){
			tree[idx].prefixSum+=value;
			tree[idx].suffixSum+=value;
			tree[idx].total+=value;
			tree[idx].maxSum+=value;
			return;
		}
		int mid=(si+ei)/2;
		update(tree, 2*idx, si, mid, i, value);
		update(tree, 2*idx+1, mid+1, ei, i, value);
		node left=tree[2*idx];
		node right=tree[2*idx+1];
		tree[idx].prefixSum=Math.max(left.prefixSum,left.total+right.prefixSum);
		tree[idx].suffixSum=Math.max(right.suffixSum, right.total+left.suffixSum);
		tree[idx].total=left.total+right.total;
		tree[idx].maxSum=Math.max(left.maxSum, Math.max(right.maxSum, left.suffixSum+right.prefixSum));
	}
	
	public static void updateRange(node[] tree,int idx,int si,int ei,int l,int r,int value){
		if(r<si || ei<l){
			return;
		}
		if(si==ei){
			tree[idx].prefixSum+=value;
			tree[idx].suffixSum+=value;
			tree[idx].total+=value;
			tree[idx].maxSum+=value;
			return;
		}
		int mid=(si+ei)/2;
		updateRange(tree, 2*idx, si, mid, l,r, value);
		updateRange(tree, 2*idx+1, mid+1, ei, l,r, value);
		node left=tree[2*idx];
		node right=tree[2*idx+1];
		tree[idx].prefixSum=Math.max(left.prefixSum,left.total+right.prefixSum);
		tree[idx].suffixSum=Math.max(right.suffixSum, right.total+left.suffixSum);
		tree[idx].total=left.total+right.total;
		tree[idx].maxSum=Math.max(left.maxSum, Math.max(right.maxSum, left.suffixSum+right.prefixSum));
	}

}