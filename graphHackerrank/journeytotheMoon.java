package graphHackerrank;
import java.util.*;
import java.lang.*;
public class journeytotheMoon {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int i=s.nextInt();
		ArrayList<HashSet<Integer>> list=new ArrayList<>();
		for(int j=0;j<i;j++){
			int a=s.nextInt();
			int b=s.nextInt();
			int fi=-1;
			int si=-1;
			for(int k=0;k<list.size();k++){
				HashSet<Integer> set=list.get(k);
				if(set.contains(a)){
					fi=k;
				}
				if(set.contains(b)){
					si=k;
				}
			}
			if(fi!=-1 && si!=-1){
				HashSet<Integer> newSet=new HashSet<>();
				newSet.addAll(list.get(fi));
				newSet.addAll(list.get(si));
				HashSet<Integer> s1=list.get(fi);
				HashSet<Integer> s2=list.get(si);
				list.remove(s1);
				list.remove(s2);
				list.add(newSet);
			}
			else if(fi!=-1){
				list.get(fi).add(b);
			}
			else if(si!=-1){
				list.get(si).add(a);
			}
			else{
				HashSet<Integer> newSet=new HashSet<>();
				newSet.add(a);
				newSet.add(b);
				list.add(newSet);
			}
		}
		ArrayList<Integer> list1=new ArrayList<>();
		int size=0;
		for(int j=0;j<list.size();j++){
			list1.add(list.get(j).size());
			size+=list1.get(j);
		}
		if(n>size){
			for(int j=0;j<(n-size);j++){
				list1.add(1);
			}
		}
		long value=0;
		for(int j=0;j<list1.size()-1;j++){
			for(int k=j+1;k<list1.size();k++){
				value+=(list1.get(j)*list1.get(k));
			}
		}
		System.out.println(value);
	}

}
