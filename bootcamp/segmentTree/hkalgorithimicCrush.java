package bootcamp.segmentTree;
import java.util.*;
public class hkalgorithimicCrush {

	 public static void main(String[] args) {
	        Scanner s=new Scanner(System.in);
	        int n=s.nextInt();
	        int m=s.nextInt();
	        long[] tree=new long[4*n+1];
	        for(int i=0;i<m;i++){
	            update(tree,1,1,n,s.nextInt(),s.nextInt(),s.nextLong());
	        }
	        for(int i=0;i<tree.length;i++){
	        	System.out.print(tree[i]+" ");
	        }
	        System.out.println(tree[1]);
	    }
	    
	    public static void update(long[] tree,int node,int si,int ei,int a,int b,long k){
	        if(b<si || ei<a){
	            return;
	        }
	        if(si==ei){
	            tree[node]+=k;
	            return;
	        }
	        int mid=(si+ei)/2;
	        update(tree,2*node,si,mid,a,b,k);
	        update(tree,2*node+1,mid+1,ei,a,b,k);
	        tree[node]=Math.max(tree[2*node],tree[2*node+1]);
	    }

}
