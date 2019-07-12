package Fenwick_Tree;

public class FenwickTree {

	int[] farr;

	public FenwickTree(int[] oarr) {
		farr = new int[oarr.length + 1];

		for (int i = 0; i <= oarr.length - 1; i++) {
			update(i, oarr[i]);
		}
	}

	public int query(int qsi, int qei) {
		return getPrefixSum(qei) - getPrefixSum(qsi - 1);

	}

	private int getPrefixSum(int idx) {

		idx++;

		int sum = 0;

		while (idx > 0) {
			sum += farr[idx];
			idx = idx - rsb(idx);

		}

		return sum;

	}

	public void update(int idx, int delta) {

		idx++;
		while (idx < farr.length) {
			farr[idx] += delta;
			idx = idx + rsb(idx);
		}

	}

	private int rsb(int x) {
		return x & -x;

	}

}
