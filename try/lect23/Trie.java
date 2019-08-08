package lect23;
import java.util.HashMap;

public class Trie {
	private class TrieNode {
		Character data;
		HashMap<Character, TrieNode> children;
		boolean isTerminal;
		
		TrieNode(char data){
			this.data = data;
			this.children = new HashMap<>();
			this.isTerminal = false;
		}
	}
	
	private TrieNode root;
	private int size;
	
	public Trie(){
		this.root = new TrieNode('\0');
		this.size = 0;
	}
	
	public void addWord(String word){
		this.addWord(this.root, word);
	}
	
	private void addWord(TrieNode node, String word){
		if(word.length() == 0){
			if(node.isTerminal){
				return;
			}
			
			node.isTerminal = true;
			this.size++;
			return;
		}
		
		TrieNode child = node.children.get(word.charAt(0));
		
		if(child == null){
			child = new TrieNode(word.charAt(0));
			node.children.put(word.charAt(0), child);
		}
		
		this.addWord(child, word.substring(1));
	}
	
	public void removeWord(String word){
		this.removeWord(this.root, word);
	}
	
	private void removeWord(TrieNode node, String word){
		if(word.length() == 0){
			if(!node.isTerminal){
				return;
			}
			
			node.isTerminal = false;
			this.size--;
			return;
		}
		
		TrieNode child = node.children.get(word.charAt(0));
		
		if(child == null){
			return;
		}
		
		this.removeWord(child, word.substring(1));
		
		if(!child.isTerminal && child.children.size() == 0){
			node.children.remove(word.charAt(0));
		}
	}
	
	public boolean containsWord(String word){
		TrieNode temp = this.root;
		
		for(int i = 0; i < word.length(); i++){
			TrieNode child = temp.children.get(word.charAt(i));
			
			if(child == null){
				return false;
			}
			
			temp = child;
		}
		
		return temp.isTerminal;
	}
}
