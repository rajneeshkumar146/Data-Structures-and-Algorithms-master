package Priority_Queue;

import java.util.Collections;
import java.util.PriorityQueue;

public class Median_Of_Input_Stream {

	PriorityQueue<Integer> min;
	PriorityQueue<Integer> max;

	public Median_Of_Input_Stream() {
		min = new PriorityQueue<>();
		max = new PriorityQueue<>(Collections.reverseOrder());
	}

	public void addNum(int num) {

		max.add(num);
		min.add(max.poll());

		if (max.size() < min.size()) {
			max.add(min.poll());
		}

	}

	public double findMedian() {

		return max.size() == min.size() ? (min.peek() + max.peek()) / 2.0 : max.poll();
	}
}
