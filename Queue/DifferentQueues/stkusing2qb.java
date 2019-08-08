package Queue.DifferentQueues;
import java.util.*;
public class stkusing2qb {

	static class stack{
		Queue<Integer> q1;
		Queue<Integer>q2;
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
			while(!q1.isEmpty()){
				q2.offer(q1.poll());
			}
			q1.offer(data);
			while(!q2.isEmpty()){
				q1.offer(q2.poll());
			}
		}
		
		int pop(){
			return q1.poll();
		}
		
		int peek(){
			return q1.peek();
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
