package Queue.DifferentQueues;
import java.util.*;
public class qusing2stka {
static class queue{
	Stack<Integer> stk1;
	Stack<Integer> stk2;
	
	queue(){
		stk1=new Stack<>();
		stk2=new Stack<>();
	}
	int size(){
		return stk1.size()+stk2.size();
	}
	
	boolean isEmpty(){
		return this.size()==0;
	}
	
	void enqueue(int data){
		stk1.push(data);
	}
	
	int front(){
		if(!stk2.isEmpty()){
			return stk2.peek();
		}
		while(!stk1.isEmpty()){
			stk2.push(stk1.pop());
		}
		return stk2.peek();
	}
	
	int dequeue(){
		if(!stk2.isEmpty()){
			return stk2.pop();
		}
		while(!stk1.isEmpty()){
			stk2.push(stk1.pop());
		}
		return stk2.pop();
	}
}
	public static void main(String[] args) {
		queue q=new queue();
		q.enqueue(5);
		q.enqueue(7);
		q.enqueue(1);
		System.out.println(q.front());
		q.enqueue(9);
		q.enqueue(8);
		while(!q.isEmpty()){
			System.out.println(q.dequeue());
		}
	}

}
