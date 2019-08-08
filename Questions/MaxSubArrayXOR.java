package Questions;
import java.util.*;

//6
//8 1 2 12 7 6
//15

public class MaxSubArrayXOR {

	static class Trie{
		class Node{
			int data;
			Node[] arr=new Node[2];
			
			Node(){
				this.data=0;
				this.arr[0]=null;
				this.arr[1]=null;
			}
		}
		
		private Node root;
		
		Trie(){
			this.root=new Node();
		}
		
		void add(int pre_xor){
			Node node=this.root;
			for(int i=31;i>=0;i--){
				int val=(((1<<i)&pre_xor)==0) ? 0 : 1;
				if(node.arr[val]==null){
					node.arr[val]=new Node();
				}
				node=node.arr[val];
			}
			node.data=pre_xor;
		}
		
		int maxXOR(int[] a,int n){
			int pre_xor=0;
			int retval=Integer.MIN_VALUE;
			this.add(0);
			
			for(int i=0;i<n;i++){
				pre_xor=a[i]^pre_xor;
				this.add(pre_xor);
				retval=Math.max(retval, query(pre_xor));
			}
			
			return retval;
		}
		
		int query(int pre_xor){
			Node node=this.root;
			for(int i=31;i>=0;i--){
				int val=(((1<<i)&pre_xor)==0) ? 0 : 1;
				if(node.arr[1-val]!=null){
					node=node.arr[1-val];
				}
				else if(node.arr[val]!=null){
					node=node.arr[val];
				}
			}
			return node.data^pre_xor;
		}
	}
	
	public static void main(String[] args) {
		Trie t=new Trie();
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++){
			a[i]=scn.nextInt();
		}
		System.out.println(t.maxXOR(a, n));
	}

}
