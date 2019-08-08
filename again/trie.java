package again;

import java.util.HashMap;

public class trie {
	private class Node{
		Character data;
		HashMap<Character, Node> map;
		boolean isTerminal;
		
		Node(char data){
			this.data=data;
			map = new HashMap<>();
			this.isTerminal=false;
		}
	}
	
	private Node root;
	private int size;
	
	public trie(){
		this.root = new Node('\0');
		this.size = 0;
	}
	
	public boolean contains(String s){
		Node temp = root;
		
		for(int i=0; i<s.length(); i++){
			if(temp.map.containsKey(s.charAt(i))){
				temp=temp.map.get(s.charAt(i));
			}
			else{
				return false;
			}
		}
		
		return temp.isTerminal;
	}
	
	public void add(String s){
		this.add(this.root, s);
	}
	
	private void add(Node node, String s){
		if(s.length()==0){
			if(node.isTerminal){
				return;
			}
			node.isTerminal=true;
			this.size++;
			return;
		}
		Node temp=node.map.get(s.charAt(0));
		
		if(temp == null){
			Node newNode = new Node(s.charAt(0));
			node.map.put(s.charAt(0), newNode);
			this.add(newNode, s.substring(1));
			return;
		}
		
		this.add(temp, s.substring(1));
	}
	
	public void remove(String s){
		this.remove(this.root, s);
	}
	
	private void remove(Node node, String s){
		if(s.length() == 0){
			if(!node.isTerminal){
				return;
			}
			node.isTerminal=false;
			this.size--;
			return;
		}
		Node temp=node.map.get(s.charAt(0));
		
		if(temp == null){
			return;
		}
		
		this.remove(temp, s.substring(1));
		
		if(temp.isTerminal == false && temp.map.size() == 0){
			node.map.remove(temp.data);
		}
	}

}
