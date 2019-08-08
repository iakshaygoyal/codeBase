package lect11;

public class ClientLL {

	public static void main(String[] args) {
		LinkedList<String> list=new LinkedList<>();
		list.addLast("Hello");
		list.display();
		list.addLast("there");
		list.display();
		list.addLast("universe");
		list.display();
		
		list.addFirst("bingo");
		list.display();
		list.addFirst("whatelse");
		list.display();
		
		list.addAt("abracadabra", 3);
		list.display();
//		
//		while(!list.isEmpty()){
//		System.out.println(list.removeFirst());
//		list.display();
//	}
	
	System.out.println(list.removeAt(3));
	list.display();
	
	System.out.println(list.removeAt(3));
	list.display();
	
	System.out.println(list.removeAt(3));
	list.display();
	
	System.out.println(list.removeAt(2));
	list.display();
	
	
	System.out.println(list.removeAt(0));
	list.display();
	
	System.out.println(list.removeAt(0));
	list.display();

	}

}
