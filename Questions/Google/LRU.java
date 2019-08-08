package Questions.Google;
import java.util.*;
public class LRU {

	/*
	Please note that it's Function problem i.e.
	you need to write your solution in the form of Function(s) only.
	Driver Code to call/invoke your function would be added by GfG's Online Judge.*/

	/*You are required to complete below class */
	static class LRUCache {
	    
		class Node{
		    int key;
		    int value;
		    Node next;
		    Node prev;
		    
		    Node(int key,int value){
		        this.key=key;
		        this.value=value;
		    }
		}
		
	    int capacity;
	    HashMap<Integer,Node> map;
	    Node head;
	    Node tail;
	    
	    /*Initialize an LRU cache with size N */
	    public LRUCache(int N) {
	       this.capacity=N;
	       this.map=new HashMap<>();
	       this.head=null;
	       this.tail=null;
	    }
	    
	    /*Returns the value of the key x if 
	     present else returns -1 */
	    public int get(int x) {
	       if(map.containsKey(x)){
	           Node node=map.get(x);
	           remove(node);
	           setHead(node);
	           return node.value;
	       }
	       return -1;
	    }
	    
	    void remove(Node node){
	        if(node.prev!=null){
	            node.prev.next=node.next;
	        }
	        else{
	            head=node.next;
	        }
	        
	        if(node.next!=null){
	            node.next.prev=node.prev;
	        }
	        else{
	            tail=node.prev;
	        }
	    }
	    
	    void setHead(Node node){
	        node.next=head;
	        node.prev=null;
	        
	        if(head!=null){
	            head.prev=node;
	        }
	        head=node;
	        if(tail==null){
	            tail=node;
	        }
	    }
	    
	    /*Sets the key x with value y in the LRU cache */
	    public void set(int x, int y) {
	       //Your code here
	       if(map.containsKey(x)){
	           Node node=map.get(x);
	           node.value=y;
	           remove(node);
	           setHead(node);
	       }
	       else{
	           Node node=new Node(x,y);
	           if(map.size()==capacity){
	               map.remove(tail.key);
	               remove(tail);
	           }
	           setHead(node);
	           map.put(x,node);
	       }
	    }
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			LRUCache cache=new LRUCache(scn.nextInt());
			int q=scn.nextInt();
			for(int j=0;j<q;j++){
				String s=scn.next();
				if(s.equals("SET")){
					int x=scn.nextInt();
					int y=scn.nextInt();
					cache.set(x, y);
				}
				else if(s.equals("GET")){
					int x=scn.nextInt();
					System.out.print(cache.get(x)+" ");
				}
			}
			System.out.println();
		}
		scn.close();
	}

}
