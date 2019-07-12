package Heap;

public class Heap_Client {

	public static void main(String[] args) {

		Heap min = new Heap(false);

		min.add(1000);
		min.add(700);
		min.add(600);
		min.add(750);
		min.add(10);
		min.add(2);
		min.add(547);
		min.add(1);

		while (min.size() > 0) {
			System.out.println(min.remove());
		}
	}

}
