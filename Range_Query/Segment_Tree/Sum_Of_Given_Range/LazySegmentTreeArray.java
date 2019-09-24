package Tree.SegmentTree.SumOfGivenRange;

public class LazySegmentTreeArray {

	private int[] arr;
	private int[] lazy;
	private int height;
	private int InputArrSize;

	public LazySegmentTreeArray(int[] input) {
		this.height = (int) Math.ceil(Math.log(input.length) / Math.log(2));
		int size = (2 * (int) Math.pow(2, this.height)) - 1;

		this.arr = new int[size];
		this.lazy = new int[size];
		this.InputArrSize = input.length;

		construction(input, 0, input.length - 1, 0);
	}

	private int construction(int[] input, int si, int ei, int i) {
		if (ei == si) {
			this.arr[i] = input[si];
			return input[si];
		}

		int mid = (si + ei) / 2;
		this.arr[i] = (construction(input, si, mid, 2 * i + 1) + construction(input, mid + 1, ei, 2 * i + 2));
		return arr[i];
	}

	public void display() {
		display(this.arr.length, 0);
	}

	private void display(int n, int i) {
		if (i >= n) {
			return;
		}

		if (lazy[i] != 0) {
			arr[i] += lazy[i];

			if (arr[2 * i + 1] != 0 && arr[2 * i + 2] != 0) {// if not a leaf
																// node
				// update childs as per requirement as above.
				lazy[2 * i + 1] += lazy[i];
				lazy[2 * i + 2] += lazy[i];
			}
			lazy[i] = 0;
		}

		String str = "";
		if ((2 * i + 1) < n) {
			str += this.arr[2 * i + 1] + "";
		} else {
			str += ".";
		}

		str += " => " + this.arr[i] + " <= ";

		if ((2 * i + 2) < n) {
			str += this.arr[2 * i + 2] + "";
		} else {
			str += ".";
		}

		System.out.println(str);
		display(n, 2 * i + 1);
		display(n, 2 * i + 2);
	}

	public long query(int u, int v) {
		if (u < 0 || v >= this.InputArrSize || u > v) {
			return -1;
		}
		return query(0, this.InputArrSize - 1, 0, u, v);
	}

	private long query(int si, int ei, int i, int u, int v) {

		// make sure all propagation is done at pos. If not update tree
		// at pos and mark its children for lazy propagation.
		if (lazy[i] != 0) {
			arr[i] += lazy[i];

			if (si != ei) {// if not a leaf node
				// update childs as per requirement as above.
				lazy[2 * i + 1] += lazy[i];
				lazy[2 * i + 2] += lazy[i];
			}
			lazy[i] = 0;
		}

		if (si >= u && ei <= v) {
			return this.arr[i];
		} else if (si > v || ei < u) {
			return Integer.MAX_VALUE;
		} else {
			int mid = (ei + si) / 2;
			return (query(si, mid, 2 * i + 1, u, v) + query(mid + 1, ei, 2 * i + 2, u, v));
		}
	}

	public void update(int pos, int delta) {
		if (pos >= this.InputArrSize || pos < 0) {
			return;
		}
		update(0, this.InputArrSize - 1, 0, pos, delta);

	}

	private void update(int si, int ei, int i, int pos, int delta) {

		int mid = (si + ei) / 2;
		if (pos == si && pos == ei) {
			this.arr[i] += delta;
			return;
		} else if (pos >= si && pos <= mid) {
			update(si, mid, 2 * i + 1, pos, delta);
		} else if (pos > mid && pos <= ei) {
			update(mid + 1, ei, 2 * i + 2, pos, delta);
		}

		this.arr[i] = (this.arr[2 * i + 1] + this.arr[2 * i + 2]);

	}

	public void updateInRange(int u, int v, int delta) {
		if (u < 0 || v >= this.InputArrSize || u > v) {
			return;
		}
		updateInRange(0, this.InputArrSize - 1, 0, u, v, delta);

	}

	private void updateInRange(int si, int ei, int i, int u, int v, int delta) {

		// make sure all propagation is done at pos. If not update tree
		// at pos and mark its children for lazy propagation.
		if (lazy[i] != 0) {
			arr[i] += lazy[i];

			if (si != ei) {// if not a leaf node
				// update childs as per requirement as above.
				lazy[2 * i + 1] += lazy[i];
				lazy[2 * i + 2] += lazy[i];
			}
			lazy[i] = 0;
		}

		// check if no-overlap.
		if (si > v || ei < u) {
			return;
		}

		if (si >= u && ei <= v) {
			arr[i] += delta;
			if (si != ei) {
				lazy[2 * i + 1] += delta;
				lazy[2 * i + 2] += delta;
			}
			return;

		}

		// If partial-overlap.
		int mid = (ei + si) / 2;
		updateInRange(si, mid, 2 * i + 1, u, v, delta);
		updateInRange(mid + 1, ei, 2 * i + 2, u, v, delta);

		this.arr[i] = (this.arr[2 * i + 1] + this.arr[2 * i + 2]);

	}

}