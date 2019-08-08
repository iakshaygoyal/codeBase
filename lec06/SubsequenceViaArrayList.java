package lec06;

import java.util.ArrayList;
import java.util.HashMap;

public class SubsequenceViaArrayList {

	public static void main(String[] args) {
		System.out.println(SUB("aba"));

	}
	public static ArrayList<String> SUB(String s)
	{
		if(s.length()==0){
			ArrayList<String> current=new ArrayList<String>();
			current.add("");
			return current;
		}
		
		ArrayList<String> smaller=SUB(s.substring(1));
		ArrayList<String> current=new ArrayList<>();
		for(int i=0;i<smaller.size();i++){
			current.add(smaller.get(i));
		}
		for(int i=0;i<smaller.size();i++){
			current.add(s.charAt(0)+smaller.get(i));
		}
		return current;
	}

}
