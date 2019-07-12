package Special_DS_O1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

//https://www.geeksforgeeks.org/design-a-data-structure-that-supports-insert-delete-search-and-getrandom-in-constant-time/

public class Special_DS {

	ArrayList<Integer> list;
	HashMap<Integer, Integer> map;

	public Special_DS() {
		list = new ArrayList<Integer>();
		map = new HashMap<Integer, Integer>();
	}

	public void insert(int val) {
		if (map.containsKey(val)) {
			System.out.println("Value Already Present");
			return;
		}
		int s = list.size();
		list.add(val);
		map.put(val, s);
	}

	public void delete(int val) {

		if (!map.containsKey(val)) {
			System.out.print("Value Not Present");
			return;
		}

		int idx = map.get(val);

		map.remove(val);

		int size = list.size();
		int lastVal = list.get(size - 1);

		Collections.swap(list, idx, size - 1);

		list.remove(size - 1);

		map.put(lastVal, idx);

	}

	public int getRandom() {

		Random random = new Random();

		return list.get(random.nextInt(list.size()));
	}

	public int search(int val) {
		return map.get(val);
	}
}
