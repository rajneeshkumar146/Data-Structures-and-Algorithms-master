package Queue;

public class Queue {

	int[] arr;
	int front = 0;
	int size = 0;

	public Queue(int cap) {
		arr = new int[cap];
	}

	public void enqueue(int data) {

		if (size == arr.length - 1) {

			System.out.println("Queue is full");

			return;
		}

		int rear = (front + size) % arr.length;

		arr[rear] = data;

		size++;

	}

	public int dequeue() {

		if (size == 0) {
			System.out.println("Queue under Flow");

			return -1;

		}

		int res = arr[front];
		front = (front + 1) % arr.length;

		size--;

		return res;

	}

	public int front() {
		return front;

	}

	public int size() {
		return size;

	}

	public boolean isEmpty() {

		if (size == 0) {
			return true;
		} else {

			return false;

		}

	}

	public boolean isFull() {

		if (size == arr.length - 1) {
			return true;
		} else {

			return false;

		}
	}

	public void display() {

		for (int i = 0; i < this.size; i++) {
			System.out.println(arr[(front + i) % arr.length]);
		}

		System.out.println();

	}
}