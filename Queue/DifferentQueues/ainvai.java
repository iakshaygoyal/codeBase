package Queue.DifferentQueues;
import java.util.*;
public class ainvai {

	static class Comp implements Comparator<Integer>{

		@Override
		public int compare(Integer arg0, Integer arg1) {
			return arg1-arg0;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		Queue<Integer> q=new LinkedList<>();
		q.offer(3);
		q.offer(4);
		q.offer(1);
		q.offer(2);
		q.offer(0);
		while(!q.isEmpty()){
			System.out.println(q);
			System.out.print(q.poll()+" ");
		}
		System.out.println("END\n");
		
		Queue<Integer> q1=new PriorityQueue<>(new Comp());
		q1.offer(3);
		q1.offer(4);
		q1.offer(1);
		q1.offer(2);
		q1.offer(0);
		while(!q1.isEmpty()){
			System.out.println(q1);
			System.out.print(q1.poll()+" ");
		}
		System.out.println("END");
		
	}

}
