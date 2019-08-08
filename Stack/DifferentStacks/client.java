package Stack.DifferentStacks;

import Stack.Interfaces.iStack;
import Stack.Interfaces.stackEmptyException;
import Stack.Interfaces.stackOverflowException;

public class client {

	public static void main(String[] args) {
//		iStack<Integer> stk = new stackUsingArray<>(5);
//		iStack<Integer> stk = new stackUsingDynamicArray<>(5);
//		iStack<Integer> stk = new stackUsingLinkedList<>();
//		for(int i=0;i<7;i++){
//			try {
//				stk.push(i);
//				stk.display();
//			} catch (stackOverflowException e) {
//				System.out.println(e);
//			}
//		}
//		for(int i=0;i<10;i++){
//			try {
//				System.out.println(stk.top());
//				System.out.println(stk.pop());
//				stk.display();
//			} catch (stackEmptyException e) {
//				System.out.println(e);
//			}
//		}
		
//		System.out.println(stackUsingLinkedList.isBracketsBalanced("{a+(b+(c+d))+e+f}"));
		
//		iStack<Integer> stk = new stackUsingLinkedList<>();
//		for(int i=0;i<7;i++){
//			try {
//				stk.push(i);
//			} catch (stackOverflowException e) {
//				// Unreachable Code
//			}
//		}
//		stk.display();
//		stk.reverse();
//		stk.display();
//		System.out.println(stackUsingLinkedList.isDuplicateParenthesis("(c+d)"));
		System.out.println(stackUsingLinkedList.isDuplicateParenthesis("({a+(b+(c+d))+e+f})"));
		
//		char a='a';
//		char b='b';
//		String c=a+""+b;
//		System.out.println(c);
	}

}
