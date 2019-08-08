package again;

public class clientQueue {

	public static void main(String[] args) {
		queue<String> q = new queue<>();
		q.enqueue("akshay");
		q.enqueue("roy");
		q.enqueue("thea");
		q.enqueue("don");
		q.enqueue("sam");
		q.enqueue("sunny");
		q.enqueue("john");
		q.display();
		
		q.reverse();
		q.display();

	}

}
