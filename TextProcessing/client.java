package TextProcessing;

import java.util.HashMap;

public class client {

	public static void main(String[] args) {
//		System.out.println(bruteForceSearch("akshay", "ha"));
//		System.out.println(bayerMooreSearch("akshay", "sha"));
		
		Trie trie = new Trie();
		trie.add("bear");
		trie.add("bell");
		trie.add("bid");
		trie.add("bull");
		trie.add("buy");
		trie.add("sell");
		trie.add("stop");
		trie.add("stock");
		
		System.out.println(trie.contains("buy"));
		System.out.println(trie.contains("sel"));
		
		trie.remove("sel");
		System.out.println(trie.contains("sell"));
		
		System.out.println(trie.contains("stock"));
		System.out.println(trie.contains("stop"));
		trie.remove("stock");
		System.out.println(trie.contains("stock"));
		System.out.println(trie.contains("stop"));

	}
	
	public static int bruteForceSearch(String source, String pattern){
		int retval = -1;
		int i=0;
		
		while(i <= source.length() - pattern.length()){
			int j=0;
			while(j < pattern.length()){
				if(source.charAt(i+j) != pattern.charAt(j)){
					break;
				}
				j++;
			}
			if(j == pattern.length()){
				retval = i;
				break;
			}
			i++;
		}
		
		return retval;
	}
	
	public static int bruteForceSearch1(String source, String pattern){
		int retval = -1;
		int i=0;
		
		while(i <= source.length() - pattern.length()){
			int j=pattern.length() - 1;
			while(j >= 0){
				if(source.charAt(i+j) != pattern.charAt(j)){
					break;
				}
				j--;
			}
			if(j == -1){
				retval = i;
				break;
			}
			i++;
		}
		
		return retval;
	}
	
	public static int boyerMooreSearch(String source, String pattern){
		int retval = -1;
		HashMap<Character, Integer> map = helper(pattern);
		int i=0;
		
		while(i <= source.length() - pattern.length()){
			int j = pattern.length() - 1; 
			while(j >= 0){
				if(source.charAt(i+j) != pattern.charAt(j)){
					if(!map.containsKey(source.charAt(i+j))){
						i = i + j + 1;
					}
					else{
						int idx = map.get(source.charAt(i+j));
						
						if(j > idx){
							i = i + j - idx;
						}
						else{
							i = i + 1;
						}
					}
					break;
				}
				j--;
			}
			if(j == -1){
				retval = i;
				break;
			}
		}
		
		return retval;
	}
	
	public static HashMap<Character, Integer> helper(String pattern){
		HashMap<Character, Integer> map = new HashMap<>();
		
		for(int i=0; i<pattern.length() - 1; i++){
			map.put(pattern.charAt(i), i);
		}
		
		return map;
	}

}
