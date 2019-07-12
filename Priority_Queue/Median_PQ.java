package Priority_Queue;

import java.util.Collections;
import java.util.PriorityQueue;

public class Median_PQ {

	PriorityQueue<Integer> min = new PriorityQueue<>(); // for larger val

	PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder()); // for smaller val

	int size = 0;

	public void add(int val) {
		if (min.size() != 0 || min.peek() > val) {

			min.add(val);

		} else if (max.size() != 0 || max.peek() < val) {

			max.add(val);

		} else {

			min.add(val);
		}

		if (min.size() - max.size() == 2) {
			max.add(min.remove());
		} else if (max.size() - min.size() == 2) {

			min.add(max.remove());
		}

		size++;

	}

	public int peek() {

		if (size == 0) {
			return -1;
		}

		return min.size() >= max.size() ? min.peek() : max.peek();

	}

	public int remove() {

		if (size == 0) {
			return -1;
		}

		return min.size() >= max.size() ? min.remove() : max.remove();

	}
}
