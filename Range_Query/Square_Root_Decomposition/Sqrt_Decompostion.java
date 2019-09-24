package SquareRoot_Decomposition;

import java.util.Arrays;

public class ArrayBasedSqrtDecompostion {

	private int[] arr;
	private int clusterSize = -1;
	private long[] ClusterArray;

	public void Build(int[] input, int size) {
		this.clusterSize = (int) Math.ceil(Math.sqrt(size)); // Cluster_Size.
		this.arr = new int[clusterSize * clusterSize];// Original_array.
		this.ClusterArray = new long[clusterSize]; // Array_That_contain_sum_of_cluster.

		int clusterIndex = -1;

		for (int i = 0; i < size; i++) { // building the decomposed array
			this.arr[i] = input[i];
			if (i % clusterSize == 0) { // Entring_new_cluster.
				clusterIndex++;
			}
			this.ClusterArray[clusterIndex] += input[i];
		}
	}

	public void Update(int index, int value) {
		int oldValue = arr[index];
		this.ClusterArray[index / clusterSize] += value - oldValue;
		this.arr[index] = value;
	}

	public long query(int left, int right) {
		long sum = 0;

		while (left < right && left % this.clusterSize != 0 && left != 0) {
			sum += this.arr[left];
			left++;
		}

		while ((left + this.clusterSize) <= right) {
			sum += this.ClusterArray[left / this.clusterSize];
			left += this.clusterSize;
		}

		while (left <= right) {
			sum += this.arr[left];
			left++;
		}

		return sum;
	}

	@Override
	public String toString() {
		return "SqrtDecomposition {\n" + "a=" + Arrays.toString(arr) + "\nCluster Array="
				+ Arrays.toString(ClusterArray) + "}";

	}

	public static void main(String[] args) {
		ArrayBasedSqrtDecompostion sqrt = new ArrayBasedSqrtDecompostion();
		int[] arr = { 1, 2, 6, 7, 9, 3, 1, 9 };
		int[] arr1 = { 1, 5, 2, 4, 6, 1, 3, 5, 7 };
		sqrt.Build(arr1, arr1.length);
		System.out.println(sqrt);
		System.out.println(sqrt.query(1, 6));
		sqrt.Update(5, 7);
		System.out.println(sqrt);
		System.out.println(sqrt.query(2, 6));
	}

}
