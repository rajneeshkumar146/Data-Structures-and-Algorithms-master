package Recursion;

import java.util.Stack;

public class Maximum_Rectangular_Area_in_Histogram {

	public static void main(String[] args) {
		int input[] = { 6, 2, 5, 4, 5, 1, 6 };

		System.out.println(func(input));
	}

	public static int func(int[] arr) {

		Stack<Integer> stack = new Stack<Integer>();

		int maxarea = -2;
		int area = -1;
		int i = 0;

		while (i < arr.length) {

			if (stack.isEmpty() || arr[stack.peek()] <= arr[i]) {

				stack.add(i);
				i++;
			} else {

				int top = stack.pop();

				if (stack.isEmpty()) {
					area = arr[top] * i;
				} else {
					area = arr[top] * (i - stack.peek() - 1);
				}

				maxarea = Math.max(area, maxarea);

			}

		}

		while (!stack.isEmpty()) {
			int top = stack.pop();

			if (stack.isEmpty()) {
				area = arr[top] * i;
			} else {
				area = arr[top] * (i - stack.peek() - 1);
			}

			maxarea = Math.max(area, maxarea);

		}
		return maxarea;
	}

}