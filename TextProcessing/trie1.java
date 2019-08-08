package TextProcessing;
import java.util.*;
public class trie1 {
	
	//DOESN'T GIVE WORDS IN LEXICOGRAPHIC ORDER(FOR THIS YOU GOTTA CHANGE HASHMAP TO TREEMAP)
	
	static class trie{
		class Node{
			Character c;
			HashMap<Character,Node> map;
			boolean b;
			Node(Character c){
				this.c=c;
				this.map=new HashMap<>();
			}
//			public boolean equals(Object o){
//				Node n=(Node)o;
//				if(this.c==n.c && this.map.equals(n.map)){
//					return true;
//				}
//				return false;
//			}
		}
		Node root;
		int size;
		trie(){
			this.root=new Node('\0');
			this.size=0;
		}
		
		boolean contains(String s){
			Node temp=this.root;
			for(int i=0;i<s.length();i++){
				temp=temp.map.get(s.charAt(i));
				if(temp==null){
					return false;
				}
			}
			return temp.b;
		}
		
		void add(String s){
			this.add(this.root, s);
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
			Node temp=node.map.get(s.charAt(0));
			if(temp==null){
				temp=new Node(s.charAt(0));
				node.map.put(s.charAt(0), temp);
			}
			this.add(temp,s.substring(1));
		}
		
		void remove(String s){
			this.remove(this.root, s);
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
			Node temp=node.map.get(s.charAt(0));
			if(temp==null){
				return;
			}
			this.remove(temp, s.substring(1));
			if(temp.map.size()==0 && !temp.b){
				node.map.remove(temp.c);
			}
		}
		
		void printPrefixes(String s){
			Node node=this.root;
			for(int i=0;i<s.length();i++){
				node=node.map.get(s.charAt(i));
				if(node==null){
					return;
				}
			}
			printPrefixes(node,s);
		}
		void printPrefixes(Node node,String s){
			if(node.b==true){
				System.out.println(s);
			}
			for(Character c:node.map.keySet()){
				printPrefixes(node.map.get(c),s+c);
			}
		}
		
		void dictionary(){
			dictionary(this.root, "");
		}
		void dictionary(Node node,String s){
			if(node.b==true){
				System.out.println(s);
			}
			for(Character c:node.map.keySet()){
				dictionary(node.map.get(c),s+c);
			}
		}

		void nextWordDictionary(String s){
			Node node=this.root;
			Stack<Node> stk=new Stack<>();
			stk.push(node);
			for(int i=0;i<s.length();i++){
				node=node.map.get(s.charAt(i));
				stk.push(node);
				if(node==null){
					System.out.println("NOT PRESENT : "+s);
					return;
				}
			}
			int j=-1;
			int flag=0;
			while(!stk.isEmpty()){
				node=stk.pop();
				String s1=nextWordDictionary(node, j, flag, "");
				if(s1!=null){
					while(!stk.isEmpty()){
						s1=node.c+s1;
						node=stk.pop();
					}
					System.out.println(s1);
					flag=1;
					break;
				}
				else{
					j=node.c-'a';
				}
			}
			if(flag==0){
				System.out.println("LAST WORD : "+s);
			}
		}
		
		String nextWordDictionary(Node node,int j,int flag,String s){
			if(node.b==true && flag==1){
				return s;
			}
			for(int i=j+1;i<26;i++){
				if(node.map.containsKey((char)(i+'a'))){
					node=node.map.get((char)(i+'a'));
					return nextWordDictionary(node, -1, 1, s+node.c);
				}
			}
			return null;
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
		t.add("apple");
		t.add("hero");
		t.add("oneplus");
		t.add("camera");
		t.add("zing");
		t.add("dolby");
		t.add("dobbin");
		System.out.println("WORDS STARTING WITH be : ");
		t.printPrefixes("be");
		System.out.println("WORDS STARTING WITH do : ");
		t.printPrefixes("do");
		System.out.println("DICTIONARY :");
		t.dictionary();
		System.out.println();
		t.nextWordDictionary("zing");

	}

}
