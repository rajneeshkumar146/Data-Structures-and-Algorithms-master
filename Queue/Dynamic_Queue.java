package Queue;

public class Dynamic_Queue extends Queue {

	public Dynamic_Queue(int val) {
		super(val);
	}

	public void enqueue(int data) {

		if (size == arr.length - 1) {

			int[] oa = arr;

			arr = new int[oa.length * 2];
			for (int i = 0; i < this.size; i++) {
				arr[i] = oa[(front + i) % oa.length];

			}
			front = 0;

		}

		super.enqueue(data);

	}

}
