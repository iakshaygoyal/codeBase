package Questions.Google;
import java.util.*;

public class WordBreak_Trie {
	static class Trie{
		class Node{
			Character c;
			HashMap<Character,Node> map;
			boolean b;
			
			Node(Character c){
				this.c=c;
				this.map=new HashMap<>();
			}
		}
		
		Node root;
		int size;
		
		Trie(){
			this.root=new Node('\0');
			this.size=0;
		}
		
		boolean contains(String s){
			Node node=root;
			for(int i=0;i<s.length();i++){
				node=node.map.get(s.charAt(i));
				if(node==null){
					return false;
				}
			}
			return node.b;
		}
		
		void add(String s){
			add(root,s);
		}
		void add(Node node,String s){
			if(s.length()==0){
				if(node.b){
					return;
				}
				node.b=true;
				size++;
				return;
			}
			
			Node temp=node.map.get(s.charAt(0));
			if(temp==null){
				temp=new Node(s.charAt(0));
				node.map.put(s.charAt(0), temp);
			}
			add(temp,s.substring(1));
		}
	}

	static Trie trie;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			int n=scn.nextInt();
			trie=new Trie();
			for(int j=0;j<n;j++){
				trie.add(scn.next());
			}
			String s=scn.next();
			
			if(wb(s)){
				System.out.println("1");
			}
			else{
				System.out.println("0");
			}
		}
		scn.close();
	}
	
	
	static boolean wb(String s){
		int n=s.length();
		boolean[][] dp=new boolean[n][n];
		for(int i=(n-1);i>=0;i--){
			for(int j=0;j<n;j++){
				if(i>j){
					continue;
				}
				else if(isPresent(s.substring(i, j+1))){
					dp[i][j]=true;
				}
				else{
					dp[i][j]=false;
					for(int k=i;k<j;k++){
						if(dp[i][k] && dp[k+1][j]){
							dp[i][j]=true;
						}
					}
				}
			}
		}
		return dp[0][n-1];
	}
	
	static boolean isPresent(String s){
		if(trie.contains(s)){
			return true;
		}
		return false;
	}
	
}