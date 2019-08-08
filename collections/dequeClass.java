package collections;
import java.util.*;
public class dequeClass {

	public static void main(String[] args) {
		Deque<String> deck=new ArrayDeque<>();
		deck.offerFirst("akshay");
		deck.offerFirst("rahul");
		deck.offerFirst("akshay");
		deck.offerLast("thea");
		System.out.println(deck);
		System.out.println(deck.peekFirst());
		System.out.println(deck.pollLast());
		System.out.println(deck.peekFirst());
	}

}
