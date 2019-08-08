package collections;
import java.util.*;
public class maps {

	public static void main(String[] args) {
		HashMap<Integer,String> map=new HashMap<>();
		map.put(11,"aks");
		map.put(21,"thea");
		map.put(1,"rob");
		map.put(12,"sam");
		System.out.println(map);
		Set<Integer> keys=map.keySet();
		System.out.println(keys);
		Collection<String> values=map.values();
		System.out.println(values);
		Set<Map.Entry<Integer, String>> entries=map.entrySet();
		System.out.println(entries);
		for(Map.Entry<Integer, String> e:map.entrySet()){
			System.out.println(e.getKey()+"  "+e.getValue());
		}
	}

}
