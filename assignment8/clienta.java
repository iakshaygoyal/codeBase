package assignment8;

import java.util.Random;

import Queue.Interfaces.queueEmptyException;
import Queue.Interfaces.queueOverflowException;
import Stack.Interfaces.stackOverflowException;

public class clienta {

	public static void main(String[] args) {
//		queueUsing2Stacksa<Integer> cue = new queueUsing2Stacksa<>();
//		queueUsing2Stacksb<Integer> cue = new queueUsing2Stacksb<>();
//		
		Random rand = new Random();
//		for(int i=0;i<6;i++){
//			try {
//				cue.enqueue(rand.nextInt(100));
//				cue.display();
//			} catch (queueOverflowException e) {
//				// Unreachable Code
//			}
//		}
//		for(int i=0;i<10;i++){
//			
//			try {
//				System.out.println(cue.front());
//				System.out.println(cue.dequeue());
//				cue.display();
//			} catch (queueEmptyException e) {
//				System.out.println(e);
//			}
//		}
//		
//		stackUsing2Queuesa<Integer> stk = new stackUsing2Queuesa<>();
		stackUsing2Queuesb<Integer> stk = new stackUsing2Queuesb<>();
		for(int i=0;i<5;i++){
			try {
				stk.push(rand.nextInt(100));
				stk.display();
			} catch (stackOverflowException e) {
				//Unreachable Code
			}
		}
		for(int i=0;i<7;i++){
			try{
				System.out.println(stk.top());
				System.out.println(stk.pop());
				stk.display();
			}catch(Exception ex){
				System.out.println(ex);
			}
		}

	}
}
