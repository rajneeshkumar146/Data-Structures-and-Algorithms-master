package Stack;

import java.util.Stack;;

public class MinStack {
	static int minElement;

	static Stack<Integer> stack = new Stack<Integer>();

	public static void push(int val) {
		if (stack.isEmpty()) {
			stack.add(val);
			minElement = val;
		} else {
			if (val < minElement) {
				stack.push(2 * val - minElement);
				minElement = val;
			} else {
				stack.push(val);
			}
		}

	}

	public static int pop() {

		if (stack.isEmpty()) {
			System.out.println("Stack is Empty");
			return -1;
		} else {
			int temp = stack.pop();
			if (temp < minElement) {
				int min = minElement;
				minElement = 2 * minElement - temp;
				return min;
			}
			return temp;

		}

	}

	public static int getMin() {
		if (stack.size() == 0)
			return -1;
		return minElement;
	}
}