package Stack;

import java.util.Stack;

public class RectangleArea {

	public static void main(String[] args) {

		int minElement = Integer.MIN_VALUE;

	}

	public static void func(int[][] arr) {

		int h[] = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {

				if (arr[i][j] != 0) {
					h[j] += arr[i][j];
				}
			}

		}
		System.out.println(maxareahistogram(h));
	}

	public static int maxareahistogram(int[] arr) {
		Stack<Integer> st = new Stack<>();

		int[] templ = new int[arr.length];
		int[] tempr = new int[arr.length];

		templ[0] = 0;
		st.push(0);
		for (int i = 1; i < arr.length; i++) {
			while (st.size() > 0 && arr[st.peek()] > arr[i]) {
				st.pop();
			}
			if (st.size() == 0) {
				templ[i] = 0;
			} else {
				templ[i] = st.peek() + 1;
			}
			st.push(i);
		}
		st = new Stack<>();
		tempr[arr.length - 1] = arr.length - 1;
		st.push(arr.length - 1);
		for (int i = arr.length - 2; i >= 0; i--) {
			while (st.size() > 0 && arr[i] < arr[st.peek()]) {
				st.pop();
			}
			if (st.size() == 0) {
				tempr[i] = arr.length - 1;
			} else {
				tempr[i] = st.peek() - 1;
			}
			st.push(i);
		}
		int diff = 0;
		int left = 0;

		while (left < arr.length) {
			diff = Math.max(diff, ((tempr[left] - templ[left] + 1) * arr[left]));
			left++;
		}
		return diff;
	}
}
