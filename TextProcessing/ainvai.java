package TextProcessing;
import java.util.*;
public class ainvai {

	static class pair{
		int i1;int i2;
		pair(int i1,int i2){
			this.i1=i1;
			this.i2=i2;
		}
		public boolean equals(Object o){
			pair p=(pair)o;
			if(this.i1==p.i1 && this.i2==p.i2){
				return true;
			}
			return false;
		}
	}
	public static void main(String[] args) {
		HashMap<Integer,String> map=new HashMap<Integer,String>();
		map.put(2, "aa");
		map.put(3, "asda");
		map.put(4, "aaf");
		map.put(21, "aajjy");
		map.put(2, "asaa");
		HashMap<Integer,String> map1=new HashMap<>();
		map1=map;
		if(map==map1){
			System.out.println("true");
		}
		else{
			System.out.println("false");
		}
		
		HashMap<Integer,String> map2=new HashMap<Integer,String>();
		map2.put(2, "aa");
		map2.put(3, "asda");
		map2.put(4, "aaf");
		map2.put(21, "aajjy");
		map2.put(2, "asaa");
		if(map.equals(map2)){
			System.out.println("true");
		}
		else{
			System.out.println("false");
		}
		
		pair p=new pair(1,1);
		pair q=p;
		pair r=new pair(1,1);
		if(p.equals(r)){
			System.out.println("true");
		}
		else{
			System.out.println("false");
		}
	}

}
