package lec07;

import java.util.ArrayList;
import java.util.HashMap;

public class Permutations {

	public static void main(String[] args) {
		System.out.println(PERMUTATION("abac"));

	}
	public static ArrayList<String> PERMUTATION(String s)
	{
		if(s.length()==1){ 
			ArrayList<String> current=new ArrayList<>() ;
			current.add(s);
			return current;
		}
		
		ArrayList<String> current=new ArrayList<>();
		HashMap<Character, Boolean> map = new HashMap<>();
		for(int i=0;i<s.length();i++){
			if(!map.containsKey(s.charAt(i))){
				map.put(s.charAt(i), true);
				char c=s.charAt(i);
				String rest=s.substring(0,i)+s.substring(i+1);
				ArrayList<String> smaller=PERMUTATION(rest);
			
				for(int j=0;j<smaller.size();j++){
					current.add(c+smaller.get(j));
				}
			}
		}
		return current;
	}
	


}
