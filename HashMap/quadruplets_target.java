package HashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class quadruplets_target {

	public static ArrayList<ArrayList<Integer>> fourSum(int[] nums, int target) {

		Arrays.sort(nums);

		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < nums.length; i++) {

			for (int j = i + 1; j < nums.length; j++) {
				int newTarget = target - nums[i] - nums[j];

				int l = j + 1;
				int r = nums.length - 1;

				while (l < r) {

					if (nums[l] + nums[r] == newTarget) {
						ArrayList<Integer> sum = new ArrayList<Integer>();
						sum.add(nums[i]);
						sum.add(nums[j]);
						sum.add(nums[l]);
						sum.add(nums[r]);
						ans.add(sum);
					}

					while (l < r && nums[l] != nums[l + 1]) {
						l++;
					}

					while (l < r && nums[r] != nums[l - 1]) {
						r--;
					}

				}

				while (j < nums.length - 1 && nums[j] != nums[j + 1]) {
					j++;
				}

			}

			while (i < nums.length - 1 && nums[i] != nums[i + 1]) {
				i++;
			}

		}

		return ans;

		// write your code here
	}

	// -----------------------------------------------------

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int target = sc.nextInt();
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		ArrayList<ArrayList<Integer>> ans = fourSum(arr, target);

		for (ArrayList<Integer> a : ans) {
			for (int element : a) {
				System.out.print(element + ",");
			}
			System.out.println();
		}

	}

}