package lect13.stacks;

import java.util.Scanner;

import lect13.shared.*;
import lect13.stacks.*;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		IStack<String> stk = new StackUsingArrays<String>(5);
//		IStack<String> stk = new StackUsingDynamicArrays<String>(5);
//		IStack<String> stk = new StackUsingLinkedList<String>();
		StackUsingLinkedList<String> stk = new StackUsingLinkedList<String>();
		for(int i = 0; i < 6; i++){
			stk.push(i+"");
		}
//		
//		for(int i = 0; i < 7; i++){
//			try {
//				System.out.println(stk.top());
//				System.out.println(stk.pop());
//				stk.display();
//			} catch (StackEmptyException e) {
//				System.out.println(e);
//			}
//		}
		
		boolean b=StackUsingLinkedList.isBalanced("{a+b})");
		System.out.println(b);
//		stk.display();
//		stk.reverse();
//		stk.display();
		
	}

}
