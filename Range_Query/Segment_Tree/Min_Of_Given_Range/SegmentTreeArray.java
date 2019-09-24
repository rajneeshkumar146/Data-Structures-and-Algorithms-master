package Tree.SegmentTree.MinOfGivenRange;

public class SegmentTreeArray {

	private int[] arr;
	private int height;
	private int InputArrSize;

	public SegmentTreeArray(int[] input) {
		this.height = (int) Math.ceil(Math.log(input.length) / Math.log(2));
		int size = (2 * (int) Math.pow(2, this.height)) - 1;

		this.arr = new int[size];
		this.InputArrSize = input.length;

		construction(input, 0, input.length - 1, 0);
	}

	private int construction(int[] input, int si, int ei, int i) {
		if (ei == si) {
			this.arr[i] = input[si];
			return input[si];
		}

		int mid = (si + ei) / 2;
		this.arr[i] = Math.min(construction(input, si, mid, 2 * i + 1), construction(input, mid + 1, ei, 2 * i + 2));
		return arr[i];
	}

	public void display() {
		display(this.arr.length, 0);
	}

	private void display(int n, int i) {
		if (i >= n) {
			return;
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
		if (si >= u && ei <= v) {
			return this.arr[i];
		} else if (si > v || ei < u) {
			return Integer.MAX_VALUE;
		} else {
			int mid = (ei + si) / 2;
			return Math.min(query(si, mid, 2 * i + 1, u, v), query(mid + 1, ei, 2 * i + 2, u, v));
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

		this.arr[i] = Math.min(this.arr[2 * i + 1], this.arr[2 * i + 2]);

	}

}
