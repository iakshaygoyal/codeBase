package importantConcepts;
import java.util.*;

public class Using_Maps {

	static class C implements Comparator<Integer>{

		@Override
		public int compare(Integer i1, Integer i2) {
			return i2-i1;
		}
		
	}
	
	public static void main (String[] args){
		Integer[] arr={12,34,6,1,56,12213,556,12,45,1};
		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr,new Comparator<Integer>(){

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}});
		
		System.out.println(Arrays.toString(arr));
		
		
		TreeMap<Integer,Vector<Integer>> map=new TreeMap<>();
		
		Vector<Integer> vector=new Vector<>();
		vector.add(3);
		vector.add(31);
		vector.add(113);
		vector.add(67);
		vector.add(342);
		
		Vector<Integer> vector1=new Vector<>();
		vector1.add(133);
		vector1.add(311);
		vector1.add(54);
		vector1.add(133);
		vector1.add(123);
		
		Vector<Integer> vector2=new Vector<>();
		vector2.add(3);
		vector2.add(3121);
		vector2.add(67);
		vector2.add(783);
		vector2.add(1893);
		
		map.put(2,vector);
		map.put(4,vector2);
		map.put(3,vector1);
		
		for(Integer i:map.keySet()){
			System.out.println(i);
		}
		System.out.println();
		
		for(Vector<Integer> vec:map.values()){
			System.out.println(vec);
		}
		System.out.println();
		
		
		for(Map.Entry<Integer, Vector<Integer>> et:map.entrySet()){
			System.out.println(et.getKey()+" "+et.getValue());
		}
		
		TreeSet<Integer> set=new TreeSet<>(new Comparator<Integer>(){
			public int compare(Integer i1,Integer i2){
				return i2-i1;
			}
		});
		set.add(3);
		set.add(1112);
		set.add(222);
		set.add(1);
		set.add(4);
		set.add(0);
		System.out.println(set);
		
		
		HashMap<Integer,Integer> map1=new HashMap<>();
		map1.put(1,2);
		map1.put(2,3);
		map1.put(44,21);
		map1.put(11,211);
		map1.put(10,21);
		
		ArrayList<Integer> list=(ArrayList<Integer>)map1.values();
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(0));
		}
		
		LinkedList<Integer> ll=new LinkedList<>();
		
	}
}