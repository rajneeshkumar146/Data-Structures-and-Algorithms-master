package LRU_Cache;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache_Deque {
	static Deque<Integer> dq;

	static HashMap<Integer, Integer> hm;

	static int size = 0;

	public LRUCache_Deque(int N) {
		dq = new LinkedList<>();
		hm = new HashMap<>();
		size = N;

	}

	public static int get(int x) {
		if (!hm.containsKey(x)) {
			return -1;
		} else {
			dq.remove(x);
			dq.addFirst(x);
			return hm.get(x);
		}
	}

	public static void set(int x, int y) {
		if (!hm.containsKey(x)) {
			if (dq.size() >= size) {
				int peek = dq.peekLast();
				dq.removeLast();
				hm.remove(peek);
			}
			dq.addFirst(x);
			hm.put(x, y);
		} else {
			dq.remove(x);
			dq.addFirst(x);
			hm.put(x, y);
		}
	}
}
