package bootcamp.dp;
import java.util.*;
public class permutation {

	public static void main(String[] args) {
		System.out.println(per("1231"));
		per1("1231","");
		System.out.println();
		per2(new int[]{1,2,3,1},0);
	}
	
	public static ArrayList<String> per(String s){
		if(s.length()==0){
			ArrayList<String> al=new ArrayList<>();
			al.add("");
			return al;
		}
		HashSet<Character> visited=new HashSet<>();
		ArrayList<String> big=new ArrayList<>();
		for(int i=0;i<s.length();i++){
			if(!visited.contains(s.charAt(i))){
				visited.add(s.charAt(i));
				char c = s.charAt(i);
				String rest=s.substring(0, i)+s.substring(i+1);
				ArrayList<String> small=per(rest);
				for(String str:small){
					big.add(c+str);
				}
			}
		}
		return big;
	}
	
	public static void per1(String s,String op){
		if(s.length()==0){
			System.out.print(op+", ");
		}
		HashSet<Character> visited=new HashSet<>();
		for(int i=0;i<s.length();i++){
			if(!visited.contains(s.charAt(i))){
				visited.add(s.charAt(i));
				char c = s.charAt(i);
				String rest=s.substring(0, i)+s.substring(i+1);
				per1(rest,op+c);
			}
		}
	}
	
	public static void per2(int[] a,int idx){
		if(idx==a.length){
			for(int i=0;i<a.length;i++){
				System.out.print(a[i]);
			}
			System.out.print(", ");
		}
		HashSet<Integer> visited=new HashSet<>();
		for(int i=idx;i<a.length;i++){
			if(!visited.contains(a[i])){
				visited.add(a[i]);
				swap(a,idx,i);
				per2(a,idx+1);
				swap(a,idx,i);
			}
		}
	}
	
	public static void swap(int[] a,int i,int j){
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
}