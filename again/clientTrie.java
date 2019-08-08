package again;

import java.util.HashMap;

public class clientTrie {

	public static void main(String[] args) {
//		System.out.println(bruteForceSearch("akshay", "aks"));
//		System.out.println(boyerMoore("akshay", "aks"));
		
		trie t = new trie();
		t.add("bear");
		t.add("bell");
		t.add("bid");
		t.add("bull");
		t.add("buy");
		t.add("sell");
		t.add("stop");
		t.add("stock");
		
		System.out.println(t.contains("buy"));
		System.out.println(t.contains("sel"));
		
		t.remove("sel");
		System.out.println(t.contains("sell"));
		
		System.out.println(t.contains("stock"));
		System.out.println(t.contains("stop"));
		t.remove("stock");
		System.out.println(t.contains("stock"));
		System.out.println(t.contains("stop"));

	}
	
	public static int bruteForceSearch(String source, String pattern){
		int retval=-1;
		
		for(int i=0; i<source.length()-pattern.length()+1; i++){
			int j;
			for(j=0; j<pattern.length(); j++){
				if(source.charAt(i+j) != pattern.charAt(j)){
					break;
				}
			}
			if(j == pattern.length()){
				retval=i;
				break;
			}
		}
		
		return retval;
	}
	
	public static int boyerMoore(String source, String pattern){
		int retval=-1;
		int i=0;
		HashMap<Character, Integer> map = helper(pattern);
		while(i<source.length()-pattern.length()+1){
			int j=pattern.length()-1;
			
			while(j>=0){
				if(source.charAt(i+j) != pattern.charAt(j)){
					char current=source.charAt(i+j);
					if(!map.containsKey(current)){
						i=i+j+1;
					}
					else{
						int idx=map.get(current);
						if(j>idx){
							i=i+j-idx;
						}
						else{
							i=i+1;
						}
					}
					break;
				}
				j--;
			}
			if(j==-1){
				retval=i;
				break;
			}
		}
		
		return retval;
	}
	
	public static HashMap<Character, Integer> helper(String s){
		HashMap<Character, Integer> map = new HashMap<>();
		
		for(int i=0; i<s.length(); i++){
			map.put(s.charAt(i), i);
		}
		
		return map;
	}

}
