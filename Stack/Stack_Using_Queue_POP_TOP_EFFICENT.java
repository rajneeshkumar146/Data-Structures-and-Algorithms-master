package Stack;

import Queue.Dynamic_Queue;
import Queue.Queue;

public class Stack_Using_Queue_POP_TOP_EFFICENT {

	Dynamic_Queue dq;
	Dynamic_Queue hq;

	public Stack_Using_Queue_POP_TOP_EFFICENT(int size) {
		dq = new Dynamic_Queue(size);

		hq = new Dynamic_Queue(size);

	}

	public void push(int val) {

		if (dq.isEmpty()) {

			dq.enqueue(val);

		}

		else {

			Dynamic_Queue temp = hq;

			hq = dq;

			dq = temp;

			dq.enqueue(val);

			while (hq.size() > 0) {
				dq.enqueue(hq.dequeue());
			}
		}

	}

	public int pop() {
		return dq.dequeue();
	}

	public int size() {
		return dq.size();

	}

	public boolean isEmpty() {

		return dq.isEmpty();

	}

	public boolean isfull() {

		return dq.isFull();

	}

	public void display() {
		dq.display();
	}

	public int top() {

		return dq.front();

	}
}
