package visa;
import java.util.*;
public class LambdaDemo {

	public static void main(String[] args) {
		List<String> list=new ArrayList<>();
		list.add("rohit");
		list.add("jon");
		list.add("thea");
		list.add("washington");
		list.add("crow");
		list.add("jack");
		
		System.out.println(list);
		
		Collections.sort(list);
		System.out.println(list);
		
//		Collections.sort(list, new Comparator<String>() {
//
//			@Override
//			public int compare(String o1, String o2) {
//				return o1.length()-o2.length();
//			}
//		});
		
		Collections.sort(list, (o1, o2)->o1.length()-o2.length());
		System.out.println(list);
		
//		Collections.sort(list, (o1,o2)->compareLastCharacter(o1, o2));
//		System.out.println(list);
		
		LambdaDemo demo=new LambdaDemo();
		Collections.sort(list, demo::compareLastCharacter);
		System.out.println(list);
	}
	
	int compareLastCharacter(String o1,String o2){
		return o1.charAt(o1.length()-1) - o2.charAt(o2.length()-1);
	}

}