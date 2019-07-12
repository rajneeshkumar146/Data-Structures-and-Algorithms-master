package Stack;

public class Dynamic_Stack extends Stack {

	public Dynamic_Stack(int cap) {
		super(cap);
	}

	public void push(int val) {
		if (isFull()) {
			int[] oa = arr;

			arr = new int[2 * arr.length];

			for (int i = 0; i < oa.length; i++) {
				arr[i] = oa[i];
			}

		}

		super.push(val);
	}

}
