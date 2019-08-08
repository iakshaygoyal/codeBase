package lect13;

import lect13.shared.*;
import lect13.stacks.*;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		IStack<String> stk = new StackUsingArrays<String>(5);
//		IStack<String> stk = new StackUsingDynamicArrays<String>(5);
		IStack<String> stk = new StackUsingLinkedLists<String>();
		
		for(int i = 0; i < 6; i++){
			try {
				stk.push(i + "");
				stk.display();
			} catch (StackOverflowException e) {
				System.out.println(e);
			}
		}
		
		for(int i = 0; i < 7; i++){
			try {
				System.out.println(stk.top());
				System.out.println(stk.pop());
				stk.display();
			} catch (StackEmptyException e) {
				System.out.println(e);
			}
		}
	}

}
