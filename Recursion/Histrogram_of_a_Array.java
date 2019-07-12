package Recursion;

public class Histrogram_of_a_Array {

	public static void main(String[] agrs) {

		int[] arr = { 1, 30, 31, 71, 21, 40, 23, 45 };

		int size = 10;

		driver(arr, size);
	}

	public static void driver(int[] arr, int size) {

		sort(arr, 0, arr.length - 1);

		Histrogram_of_a_Array h = new Histrogram_of_a_Array(arr);

		int hi = size;

		for (int i = 1; i <= arr[arr.length - 1]; i += size, hi += size) {

			System.out.print(i + " to " + hi + " :- ");

			h.getCount(i, hi);

			System.out.println();
		}

	}

	public static int partition(int arr[], int low, int high) {

		int pivot = arr[high];

		int i = (low - 1);

		for (int j = low; j < high; j++) {

			if (arr[j] <= pivot) {
				i++;

				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;

		return i + 1;
	}

	public static void sort(int arr[], int low, int high) {
		if (low < high) {

			int pi = partition(arr, low, high);

			sort(arr, low, pi - 1);
			sort(arr, pi + 1, high);
		}
	}

	private class Node {
		int data;
		Node right;
		Node left;
	}

	private Node root;
	private int size = 0;

	public Histrogram_of_a_Array(int[] arr) {
		root = construct(arr, 0, arr.length - 1);
	}

	private Node construct(int[] arr, int lo, int hi) {

		if (lo > hi) {

			return null;
		}

		int mid = (lo + hi) / 2;

		Node node = new Node();

		node.data = arr[mid];

		size++;

		node.left = construct(arr, lo, mid - 1);

		node.right = construct(arr, mid + 1, hi);

		return node;

	}

	public void getCount(int lo, int hi) {

		System.out.println(getCount(root, lo, hi));

	}

	private int getCount(Node node, int low, int high) {

		if (node == null)
			return 0;

		if (node.data >= low && node.data <= high)
			
			return 1 + this.getCount(node.left, low, high) + this.getCount(node.right, low, high);

		else if (node.data < low)
			return this.getCount(node.right, low, high);
		else
			return this.getCount(node.left, low, high);
	}
}