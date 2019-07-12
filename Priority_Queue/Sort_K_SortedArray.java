package Priority_Queue;

import java.util.PriorityQueue;

public class Sort_K_SortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = { 10, 9, 8, 7, 4, 70, 60, 50 };

		int k = 4;

		func(arr, k + 1);

	}

	private static void func(int[] arr, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int i;
		for (i = 0; i < k; i++) {
			pq.add(arr[i]);
		}

		int j = 0;
		i = k;
		while (j < arr.length && pq.size() > 0) {
			arr[j] = pq.remove();
			j++;
			if (i < arr.length) {
				pq.add(arr[i]);
				i++;
			}
		}

		for (int val : arr) {
			System.out.print(val + " ");
		}

	}

}
