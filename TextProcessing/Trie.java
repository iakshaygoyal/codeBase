package TextProcessing;
import java.util.HashMap;
public class Trie {
	private class TrieNode{
		Character data;
		HashMap<Character, TrieNode> children;
		boolean isTreminal;
		
		TrieNode(Character data){
			this.data = data;
			children = new HashMap<>();
		}
	}
	private TrieNode root;
	private int size;
	
	Trie(){
		this.root = new TrieNode('\0');
		this.size = 0;
	}
	
	public boolean contains(String s){
		TrieNode temp = this.root;
		
		for(int i=0; i<s.length(); i++){
			TrieNode child = temp.children.get(s.charAt(i));
			
			if(child == null){
				return false;
			}
			
			temp = child;
		}
		
		return temp.isTreminal;
		
	}
	
	public void add(String s){
		this.add(this.root, s);
	}
	
	private void add(TrieNode node, String s){
		if(s.length() == 0){
			if(node.isTreminal){
				return;
			}
			node.isTreminal = true;
			this.size++;
			return;
		}
		TrieNode temp = node.children.get(s.charAt(0));
		
		if(temp == null){
			temp = new TrieNode(s.charAt(0));
			node.children.put(s.charAt(0), temp);
		}
		
		this.add(temp, s.substring(1));
	}
	
	public void remove(String s){
		this.remove(this.root, s);
	}
	
	private void remove(TrieNode node, String s){
		if(s.length() == 0){
			if(!node.isTreminal){
				return;
			}
			node.isTreminal = false;
			this.size--;
			return;
		}
		TrieNode temp = node.children.get(s.charAt(0));
		
		if(temp == null){
			return;
		}
		
		this.remove(temp, s.substring(1));
		
		if(temp.children.size() == 0 && !temp.isTreminal){
			node.children.remove(temp.data);
		}
	}

}
