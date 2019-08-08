package Queue.DifferentQueues;
import java.util.*;
public class stkusing2qa {
	static class stack{
		Queue<Integer> q1;
		Queue<Integer> q2;
		stack(){
			q1=new LinkedList<>();
			q2=new LinkedList<>();
		}
		
		int size(){
			return q1.size()+q2.size();
		}
		
		boolean isEmpty(){
			return this.size()==0;
		}
		
		void push(int data){
			q1.offer(data);
		}
		
		int pop(){
			while(q1.size()!=1){
				q2.offer(q1.poll());
			}
			int val=q1.poll();
			
			q1=q2;
			q2=new LinkedList<>();
			return val;
		}
		
		int peek(){
			while(q1.size()!=1){
				q2.offer(q1.poll());
			}
			int val=q1.peek();
			q2.offer(q1.poll());
			q1=q2;
			q2=new LinkedList<>();
			return val;
		}
	}

	public static void main(String[] args) {
		stack stk=new stack();
		stk.push(3);
		stk.push(7);
		stk.push(1);
		System.out.println(stk.peek());
		stk.push(0);
		stk.push(9);
		while(!stk.isEmpty()){
			System.out.println(stk.peek());
			System.out.println(stk.pop());
		}
	}

}