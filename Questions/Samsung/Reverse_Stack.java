package Questions.Samsung;
import java.util.*;
public class Reverse_Stack {

	public static void main(String[] args) {
		Stack<Integer> stk=new Stack<>();
		stk.push(1);
		stk.push(2);
		stk.push(3);
		stk.push(4);
		stk.push(5);
		System.out.println(stk);
		reverse(stk);
		System.out.println(stk);
	}
	
	 static void reverse(Stack<Integer> stk){
		if(stk.isEmpty()){
			return;
		}
		int temp=stk.pop();
		reverse(stk);
		insertAtBottom(stk, temp);
	}
	
	static void insertAtBottom(Stack<Integer> stk,int temp){
		if(stk.isEmpty()){
			stk.push(temp);
			return;
		}
		int data=stk.pop();
		insertAtBottom(stk, temp);
		stk.push(data);
	}

}
