package Queue.DifferentQueues;

import Queue.Interfaces.iQueue;
import Queue.Interfaces.queueEmptyException;
import Queue.Interfaces.queueOverflowException;

public class client {

	public static void main(String[] args) {
//		iQueue<Integer> q=new queueUsingArray<>();
//		iQueue<Integer> q=new queueUsingDynamicArray<>();
		iQueue<Integer> q=new queueUsingLinkedList<>();
		for(int i=0;i<7;i++){
			try {
				q.enqueue(i);
				q.display();
			} catch (queueOverflowException e) {
				System.out.println(e);
			}
		}
//		for(int i=0;i<10;i++){
//			try {
//				q.dequeue();
//				q.display();
//			} catch (queueEmptyException e) {
//				System.out.println(e);
//			}
//		}
//		
		q.display();
//		q.reverse();
		q.display();

	}

}
