package Stack;

public class Stack {

	int[] arr;

	int tos = -1;

	public Stack(int cap) {

		arr = new int[cap];

	}

	public void push(int val) {

		if (tos == arr.length - 1) {
			System.out.println("Stack Overflow");
			return;
		}

		tos++;
		arr[tos] = val;

	}

	public int top() {
		return arr[tos];
	}

	public int pop() {

		if (tos == -1) {
			System.out.println("Stack Underflow");
			return -1;
		}

		int data = arr[tos];

		tos--;

		return data;

	}

	public boolean isEmpty() {
		if (tos == -1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isFull() {

		if (tos == arr.length - 1) {

			return true;

		}

		else {
			return false;

		}

	}

	public void displayStack() {

	}
}
