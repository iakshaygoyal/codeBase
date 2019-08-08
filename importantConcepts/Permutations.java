package importantConcepts;
import java.util.*;

public class Permutations {
	public static void main (String[] args){
		Scanner scn=new Scanner(System.in);
//		String s=scn.next();
//		ArrayList<String> list=permutation(s);
//		System.out.println(list);
//		System.out.println(list.size());
//		
//		permutation(s, "");
		
		int[] arr={2,32,2};
		permutationArray(arr, 0);
		scn.close();
	}
	
	static ArrayList<String> permutation(String s){
		if(s.length()==0){
			ArrayList<String> list=new ArrayList<>();
			list.add("");
			return list;
		}
		
		HashSet<Character> set=new HashSet<>();
		ArrayList<String> list2=new ArrayList<>();
		for(int i=0;i<s.length();i++){
			char c=s.charAt(i);
			if(!set.contains(c)){
				set.add(c);
				String rest=s.substring(0, i)+s.substring(i+1);
				ArrayList<String> list1=permutation(rest);
				for(int j=0;j<list1.size();j++){
					list2.add(c+list1.get(j));
				}
			}
		}
		return list2;
	}
	
	static void permutation(String s,String op){
		if(s.length()==0){
			System.out.println(op);
			return;
		}
		HashSet<Character> set=new HashSet<>();
		for(int i=0;i<s.length();i++){
			char c=s.charAt(i);
			if(!set.contains(c)){
				set.add(c);
				String rest=s.substring(0, i)+s.substring(i+1);
				permutation(rest, op+c);
			}
		}
	}
	
	static void permutationArray(int[] arr,int idx){
		if(idx==arr.length){
			for(int i=0;i<arr.length;i++){
				System.out.print(arr[i]+" ");
			}
			System.out.println();
		}
		HashSet<Integer> set=new HashSet<>();
		for(int i=idx;i<arr.length;i++){
			if(!set.contains(arr[i])){
				set.add(arr[i]);
				
				int temp=arr[i];
				arr[i]=arr[idx];
				arr[idx]=temp;
				
				permutationArray(arr, idx+1);
				
				temp=arr[i];
				arr[i]=arr[idx];
				arr[idx]=temp;
			}
		}
	}
}