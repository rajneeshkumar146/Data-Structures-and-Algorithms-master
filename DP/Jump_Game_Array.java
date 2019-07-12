package DP;

public class Jump_Game_Array {
	public static void main(String[] args) {
		int[] arr = { 2, 3, 1, 1, 4 };
		System.out.println(jump(arr));
	}

	public static int jump(int[] arr) {

		int ladder = 0;
		int stair = 1;
		int jump = 0;

		for (int idx = 0; idx < arr.length; idx++) {
			if (idx == arr.length - 1) {
				return jump;
			}

			ladder = Math.max(ladder, idx + arr[idx]);

			stair--;

			if (stair == 0) {
				jump++;
				stair = ladder - idx;
				if (stair == 0)
					return -1;
			}
		}
		return jump;
	}

	public boolean canJump(int[] nums) {
		int lastPos = nums.length - 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			if (i + nums[i] >= lastPos) {
				lastPos = i;
			}
		}
		return lastPos == 0;
	}

}
