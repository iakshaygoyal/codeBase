package visa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

	public static void main(String[] args) {
		List<String> list=new ArrayList<>();
		list.add("rohit");
		list.add("jon");
		list.add("thea");
		list.add("washington");
		list.add("crow");
		list.add("jack");
		list.add("jane");
		list.add("crow");
		list.add("sophia");
		list.add("chris");
		list.add("dan");
		list.add("handerson");
		System.out.println(list);
		
		List<String> strings=list.stream().filter(s->s.length()>4).collect(Collectors.toList());
		System.out.println(strings);
		
//		Integer[] arr={1,2,3,4};
//		Stream.of(arr);
//		List<Integer> integers=Arrays.stream(arr).collect(Collectors.toList());
//		System.out.println(integers);
	}

}
