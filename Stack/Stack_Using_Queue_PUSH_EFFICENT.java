package Stack;

import Queue.Dynamic_Queue;

public class Stack_Using_Queue_PUSH_EFFICENT {

	Dynamic_Queue dq;
	Dynamic_Queue hq;

	public Stack_Using_Queue_PUSH_EFFICENT(int val) {

		dq = new Dynamic_Queue(val);

		hq = new Dynamic_Queue(val);

	}

	public void push(int data) {
		dq.enqueue(data);
	}

	public int pop() {

		while (dq.size() - 1 > 0) {

			hq.enqueue(dq.dequeue());

		}

		int res = dq.dequeue();

		dq = hq;

		dq.size();

		return res;

	}

	public int size() {

		return dq.size();

	}

	public boolean isEmpty() {

		return dq.isEmpty();

	}

	public boolean isFull() {
		return dq.isFull();
	}

	public int top() {
		while (dq.size() - 1 > 0) {

			hq.enqueue(dq.dequeue());

		}

		int res = dq.dequeue();

		hq.enqueue(res);

		dq = hq;

		return res;
	}

	public void display() {

		for (int i = dq.size(); i > 0; i++) {

		}

	}
}
