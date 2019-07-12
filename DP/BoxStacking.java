package DP;

import java.util.Arrays;

public class BoxStacking {

	public static int maxHeight(Box[] arr, int n) {
		Box[] rot = new Box[n * 3];

		createAllRotation(arr, rot);

		Arrays.sort(rot);

		int t[] = new int[rot.length];
		int result[] = new int[rot.length];

		for (int i = 0; i < t.length; i++) {
			t[i] = rot[i].h;
			result[i] = i;
		}

		for (int i = 1; i < t.length; i++) {
			for (int j = 0; j < i; j++) {
				if (rot[i].l < rot[j].l && rot[i].w < rot[j].w) {

					if (t[j] + rot[i].h > t[i]) {
						t[i] = t[j] + rot[i].h;
						result[i] = j;
					}
				}

			}
		}

		int max = Integer.MIN_VALUE;

		for (int i = 0; i < t.length; i++) {
			if (t[i] > max) {
				max = t[i];
			}
		}

		return max;

	}

	private static void createAllRotation(Box[] arr, Box[] rot) {
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			rot[index++] = new Box(arr[i].h, Math.max(arr[i].l, arr[i].w), Math.min(arr[i].l, arr[i].w));
			rot[index++] = new Box(arr[i].l, Math.max(arr[i].h, arr[i].w), Math.min(arr[i].h, arr[i].w));
			rot[index++] = new Box(arr[i].w, Math.max(arr[i].l, arr[i].h), Math.min(arr[i].l, arr[i].h));
		}
	}

	static class Box implements Comparable<Box> {
		int h;
		int l;
		int w;

		public Box(int h, int l, int w) {
			this.h = h;
			this.l = l;
			this.w = w;
		}

		@Override
		public int compareTo(Box o) {
			if (this.l * this.w >= o.l * o.w) {
				return -1;
			} else {
				return 1;
			}
		}
	}

	public static void main(String[] args) {

		Box[] arr = new Box[2];
		arr[0] = new Box(3, 2, 5);
		arr[1] = new Box(1, 2, 4);

		// Box arr[] = { new Box(4, 6, 7), new Box(1, 2, 3), new Box(4, 5, 6), new
		// Box(10, 12, 32) };

		System.out.println("Ans :-" + maxHeight(arr, arr.length));
	}
}