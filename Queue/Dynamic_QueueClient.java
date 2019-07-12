package Queue;

public class Dynamic_QueueClient {

	public static void main(String[] args) {
		Queue q = new Dynamic_Queue(5);

		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);

		q.display();

		q.dequeue();
		q.dequeue();

		q.display();

		q.enqueue(60);
		q.enqueue(70);

		q.enqueue(80);

		q.display();

	}

}
