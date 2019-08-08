package TextProcessing;
import java.util.*;
public class trie2 {
	
	//GIVES WORDS IN LEXICOGRAPHIC ORDER

	static class trie{
		class Node{
			Character c;
			Node[] a=new Node[26];
			boolean b;
			Node(Character c){
				this.c=c;
				for(int i=0;i<26;i++){
					a[i]=null;
				}
			}
		}
		Node root;
		int size;
		trie(){
			this.root=new Node('\0');
			this.size=0;
		}
		
		boolean contains(String s){
			Node node=this.root;
			for(int i=0;i<s.length();i++){
				node=node.a[s.charAt(i)-'a'];
				if(node==null){
					return false;
				}
			}
			return node.b;
		}
		
		void add(String s){
			add(this.root,s);
		}
		void add(Node node,String s){
			if(s.length()==0){
				if(node.b==true){
					return;
				}
				node.b=true;
				this.size++;
				return;
			}
			Node temp=node.a[s.charAt(0)-'a'];
			if(temp==null){
				temp=new Node(s.charAt(0));
				node.a[s.charAt(0)-'a']=temp;
			}
			add(temp,s.substring(1));
		}
		
		void remove(String s){
			remove(this.root, s);
		}
		void remove(Node node,String s){
			if(s.length()==0){
				if(node.b==false){
					return;
				}
				node.b=false;
				this.size--;
				return;
			}
			Node temp=node.a[s.charAt(0)-'a'];
			if(temp==null){
				return;
			}
			remove(temp,s.substring(1));
			if(temp.b==true){
				return;
			}
			int i;
			for(i=0;i<26;i++){
				if(temp.a[i]!=null){
					break;
				}
			}
			if(i==26){
				node.a[s.charAt(0)-'a']=null;
			}
		}
		
		void printPrefixes(String s){
			Node node=this.root;
			for(int i=0;i<s.length();i++){
				node=node.a[s.charAt(i)-'a'];
				if(node==null){
					return;
				}
			}
			printPrefixes(node, s);
		}
		void printPrefixes(Node node,String s){
			if(node.b==true){
				System.out.println(s);
			}
			for(int i=0;i<26;i++){
				if(node.a[i]!=null){
					printPrefixes(node.a[i],s+node.a[i].c);
				}
			}
		} 
		
		void dictionary(){
			dictionary(this.root, "");
		}
		void dictionary(Node node,String s){
			if(node.b==true){
				System.out.println(s);
			}
			for(int i=0;i<26;i++){
				if(node.a[i]!=null){
					dictionary(node.a[i],s+node.a[i].c);
				}
			}
		}
		
	}
	public static void main(String[] args) {
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
		System.out.println(t.contains("benullr"));

		t.add("does");
		t.add("don");
		t.add("do");
		t.add("doeskin");
		t.add("dock");
		t.add("donut");
		t.add("doxy");
		t.add("done");
		t.add("donkey");
		t.add("dont");
		t.add("doze");
		t.add("doom");
		t.add("dob");
		t.add("dolby");
		t.add("dobbin");
		t.add("apple");
		t.add("hero");
		t.add("oneplus");
		t.add("camera");
		t.add("zing");
//		System.out.println("WORDS STARTING WITH be : ");
//		t.printPrefixes("be");
//		System.out.println("WORDS STARTING WITH don : ");
//		t.printPrefixes("don");
		System.out.println("DICTIONARY :");
		t.dictionary();

	}

}