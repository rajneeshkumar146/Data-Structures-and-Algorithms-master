package Stack;

import java.util.HashMap;
import java.util.LinkedList;

public class Max {
	public static void main(String[] args) {
		Max mfs = new Max();

		mfs.push(4);
		mfs.push(0);
		mfs.push(9);
		mfs.push(3);
		mfs.push(4);
		mfs.push(2);
		mfs.pop();
		mfs.push(6);
		mfs.pop();
		mfs.push(1);
		mfs.pop();
		mfs.push(4);
		mfs.pop();
		mfs.pop();
		mfs.pop();
		mfs.pop();
		mfs.pop();
		mfs.pop();
	}

	private LinkedList<Integer> queue;
	private HashMap<Integer, Integer> counter;
	private LinkedList<LinkedList<Integer>> frequencyAndItems;// it holds queue of element in the same frequency
	int max = 0;

	public Max() {
		queue = new LinkedList<>();
		counter = new HashMap<>();
		frequencyAndItems = new LinkedList<>();
		LinkedList<Integer> init = new LinkedList<>();
		init.add(Integer.MAX_VALUE);
		frequencyAndItems.add(init);

	}

	public void push(int x) {
		queue.add(x);
		Integer count = counter.get(x);
		if (count == null) {
			count = 1;
			counter.put(x, count);
		} else {
			count = count + 1;
			counter.put(x, count);
		}
		if (count == frequencyAndItems.size()) {
			LinkedList<Integer> a = new LinkedList<>();
			a.add(Integer.MAX_VALUE);
			frequencyAndItems.add(a);
		}
		try {
			frequencyAndItems.get(count).add(x);
		} catch (IndexOutOfBoundsException iex) {
			System.out.println(x + " " + count);
		}

	}

	public int pop() {

		int size = frequencyAndItems.size() - 1;
		// Get the max frequency
		LinkedList<Integer> maxFrequency = frequencyAndItems.get(size);
		// find the element to remove
		Integer item = maxFrequency.getLast();
		// Update the counter
		int c = counter.get(item);
		c = c - 1;
		counter.put(item, c);

		// get the position of the item in the queue
		int index = queue.lastIndexOf(item);
		// remove from the queue
		queue.remove(index);
		// remove the item from the frequency and item queue
		maxFrequency.removeLast();

		if (maxFrequency.size() == 1 & maxFrequency.getLast() == Integer.MAX_VALUE) {
			frequencyAndItems.removeLast();
		}
		return item;

	}
}