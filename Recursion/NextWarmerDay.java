package Recursion;

import java.util.Stack;
import java.util.*;

public class NextWarmerDay {

	public static void main(String[] args) {

		int[] temp = { 8, 73, 74, 75, 71, 69, 72, 76, 73 };
		int res[] = findwarmertemp(temp);

		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}
	}

	private static int[] findwarmertemp(int[] temp) {
		int[] result = new int[temp.length];

		Stack<Integer> stack = new Stack<>();

		for (int i = temp.length - 1; i >= 0; i--) {

			if (stack.size() > 0 && temp[i] >= temp[stack.peek()]) {
				stack.pop();
			}

			if (stack.size() == 0) {
				result[i] = 0;
			} else {
				result[i] = stack.peek() - i;
			}
			stack.push(i);
		}
		return result;
	}
}