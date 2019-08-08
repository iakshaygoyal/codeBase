package lect14;

import java.util.Random;

import lect13.*;
import lect13.shared.*;
import lect13.stacks.*;
import lect13.queues.*;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		IStack<Integer> stk = new StackUsingLinkedLists<>();
//		Random rand = new Random();
//		
//		for(int i = 0; i < 10; i++){
//			try {
//				stk.push(rand.nextInt(100));
//			} catch (StackOverflowException e) {
//				// unreachable
//			}
//		}
//		
//		stk.display();
//		stk.reverse();
//		stk.display();
		System.out.println("Testing array queue");
		testQueue(new QueueUsingArrays<Integer>(5));
		System.out.println("Testing dynamic array queue");
		testQueue(new QueueUsingDynamicArrays<Integer>(5));
		System.out.println("Testing linked lists queue");
		testQueue(new QueueUsingLinkedLists<Integer>());
	}

	public static boolean isBalanced(String exp) {
		IStack<Character> stk = new StackUsingLinkedLists<>();

		for (int i = 0; i < exp.length(); i++) {
			Character current = exp.charAt(i);

			if ("({[".indexOf(current) != -1) {
				try {
					stk.push(current);
				} catch (StackOverflowException e) {
					// never going to come here
				}
			} else if (")}]".indexOf(current) != -1) {
				try {
					Character tos = stk.top();

					// if("({[".indexOf(tos) != ")}]".indexOf(current)){
					//
					// }
					if ((current == ')' && tos != '(') || (current == '}' && tos != '{')
							|| (current == ']' && tos != '[')) {
						return false; // mismatch
					} else {
						stk.pop();
					}
				} catch (StackEmptyException ex) {
					return false; // more closing brackets
				}
			}
		}
		
		return stk.isEmpty(); // false of more opening brackets
	}

	public static <T> void testQueue(IQueue<T> queue){
		Random rand = new Random();
		
		for(Integer i = 0; i < 10; i++){
			try {
				queue.enqueue((T)i);
				queue.display();
			} catch (QueueOverflowException e) {
				System.out.println(e);
			}
		}
		
		for(Integer i = 0; i < 10; i++){
			try {
				System.out.println(queue.front());
				System.out.println(queue.dequeue());
				queue.display();
			} catch (QueueEmptyException e) {
				System.out.println(e);
			}
		}
	}
}
