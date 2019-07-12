package Heap;

import java.util.ArrayList;

public class Heap {

	ArrayList<Integer> data = new ArrayList();

	private boolean isMin;

	public Heap(boolean ismin) {

		this.isMin = ismin;

	}

	public void add(int val) {
		data.add(val);

		upheapify(data.size() - 1);

	}

	private void upheapify(int ci) {

		if (ci == 0) {
			return;
		}

		int pi = (ci - 1) / 2;

		if (isHP(ci, pi) > 0) {

			swap(ci, pi);

			upheapify(pi);

		}
	}

	public int remove() {
		
		int val = data.get(0);
		swap(0, data.size() - 1);

		data.remove(data.size() - 1);
		downheapify(0);

		return val;

	}

	private void downheapify(int pi) {

		int li = 2 * pi + 1;

		int ri = 2 * pi + 2;

		int maxi = pi;
		if (li < data.size() && isHP(li, maxi) > 0) {

			maxi = li;

		}

		if (ri < data.size() && isHP(ri, maxi) > 0) {

			maxi = ri;

		}

		if (maxi != pi) {
			swap(pi, maxi);

			downheapify(maxi);
		}
	}

	private int isHP(int i, int j) {

		if (isMin) {
			return (data.get(i) - data.get(j)) * -1;

		} else {
			return data.get(i) - data.get(j);
		}

	}

	private void swap(int i, int j) {
		int ith = data.get(i);

		int jth = data.get(j);

		data.set(i, jth);
		data.set(j, ith);
	}

	public int size() {
		return data.size();
	}
}