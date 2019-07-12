package Comparable;

import java.util.Arrays;

public class Car_CA {

	private static class Car implements Comparable<Car> {
		int speed;
		int price;
		String name;

		Car(int speed, int price, String name) {
			this.speed = speed;

			this.price = price;

			this.name = name;
		}

		public void display() {
			System.out.println(speed + " ; " + price + " ; " + name);

		}

		@Override
		public int compareTo(Car o) {
			return o.speed - this.speed;
		}

	}

	public static void main(String[] args) {

		Car[] cars = new Car[5];

		cars[0] = new Car(100, 50, "A");
		cars[1] = new Car(200, 40, "B");
		cars[2] = new Car(600, 30, "C");
		cars[3] = new Car(400, 20, "D");
		cars[4] = new Car(500, 10, "E");

		Arrays.sort(cars);

		for (Car val : cars) {
			val.display();
		}

	}
}
