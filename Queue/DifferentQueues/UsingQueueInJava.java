package Queue.DifferentQueues;

import java.util.*;

public class UsingQueueInJava {

	public static void main(String[] args) {
		Queue<String> q=new LinkedList<>();
		Random rand=new Random();
		for(int i=0;i<10;i++){
			q.offer(rand.nextInt(100)+"");
			System.out.print(q.peek()+" ");
		}
		System.out.println();
		System.out.println(q.toString());
		while(!q.isEmpty()){
			System.out.println(q.poll());
		}
	}

}
