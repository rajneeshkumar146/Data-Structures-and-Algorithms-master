package Stack;

import java.util.Stack;

public class LongestValidParanthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "())(())))(()))()(()()())";

		func(str);

	}

	public static void func(String str) {
		int countermax = 0;
		Stack<Integer> stack = new Stack<Integer>();
		// we push -1 so that if the stack comes to the end, we can measure
		// the distance from -1
		stack.push(-1);
		for (int i = 0; i < str.length(); i++) {
			// if the char at the index is ) , we pop and measure the distance of
			// current index from stack top, which gives us previous element before (
			if ((str.charAt(i) == ')') && (!stack.isEmpty())) {
				stack.pop();
				if ((!stack.isEmpty()) && (i - stack.peek()) > countermax) {
					// we update the max counter
					countermax = i - stack.peek();
				}
			} else {
				stack.push(i);
			}
		}
		System.out.println(countermax);
	}

}
