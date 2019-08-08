package bootcamp;
import java.util.HashMap;
public class trieDS {
	static class trie{
		private class Node{
			Character data;
			HashMap<Character, Node> children;
			boolean isTreminal;
			int cp;
			int cw;
			Node(Character data){
				this.data = data;
				children = new HashMap<>();
				isTreminal=false;
				cp=0;
				cw=0;
			}
		}
		private Node root;
		private int size;
		trie(){
			this.root = new Node('\0');
			this.size = 0;
		}
		
		public int size(){
			return this.size;
		}
		public boolean contains(String s){
			Node temp = this.root;
			for(int i=0; i<s.length(); i++){
				Node child = temp.children.get(s.charAt(i));
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
		private void add(Node node, String s){
			if(s.length() == 0){
				node.isTreminal = true;
				node.cw++;
				this.size++;
				return;
			}
			Node temp = node.children.get(s.charAt(0));
			if(temp == null){
				temp = new Node(s.charAt(0));
				node.children.put(s.charAt(0), temp);
			}
			temp.cp++;
			this.add(temp, s.substring(1));
		}
		
		public int countPrefix(String s){
			Node node=this.root;
			for(int i=0;i<s.length();i++){
				Node temp=node.children.get(s.charAt(i));
				if(temp==null){
					return 0;
				}
				node=temp;
			}
			return node.cp;
		}
		
		public int countWord(String s){
			Node node=this.root;
			for(int i=0;i<s.length();i++){
				Node temp=node.children.get(s.charAt(i));
				if(temp==null){
					return 0;
				}
				node=temp;
			}
			return node.cw;
		}
	}
	
	public static void main(String[] args){
		trie t=new trie();
		t.add("bear");
		t.add("be");
		t.add("beer");
		t.add("bra");
		t.add("brace");
		t.add("brake");
		t.add("bear");
		t.add("bear");
		System.out.println(t.size);
		System.out.println(t.contains("bee"));
		System.out.println(t.contains("beee"));
		System.out.println(t.contains("beer"));
		System.out.println(t.contains("bear"));
		
		System.out.println(t.countPrefix("br"));
		System.out.println(t.countPrefix("be"));
		System.out.println(t.countPrefix("bee"));
		System.out.println(t.countPrefix("brap"));
		
		System.out.println(t.countWord("be"));
		System.out.println(t.countWord("bear"));
		System.out.println(t.countWord("beer"));
		System.out.println(t.countWord("brac"));
	}
}