package Questions.Samsung;
import java.util.*;
public class Sort_Stack {

	public static void main(String[] args) {
		Stack<Integer> stk=new Stack<>();
		stk.push(1);
		stk.push(7);
		stk.push(5);
		stk.push(4);
		stk.push(9);
		System.out.println(stk);
		sort(stk);
		System.out.println(stk);
	}
	
	static void sort(Stack<Integer> stk){
		if(stk.isEmpty()){
			return;
		}
		int temp=stk.pop();
		sort(stk);
		insert(stk, temp);
	}
	
	static void insert(Stack<Integer> stk,int data){
		if(stk.isEmpty() || data>stk.peek()){
			stk.push(data);
		}
		else{
			int temp=stk.pop();
			insert(stk, data);
			stk.push(temp);
		}
	}

}
