package Recursion;

public class Angle_BW_hour_minute {

	public static void main(String[] args) {
		System.out.println(func(3, 30));

	}

	private static int func(int hour, int min) {

		if (hour < 0 || min < 0) {
			return -1;
		}

		if (hour == 12) {
			hour = 0;
		}

		if (min == 60) {
			min = 0;
			hour += 1;
		}

		int hourAngle = (int) ((hour * 60 + min) * 0.5);
		int minAngle = min * 6;

		int angle = Math.abs(hourAngle - minAngle);

		angle = Math.min(360 - angle, angle);

		return angle;
	}

}
