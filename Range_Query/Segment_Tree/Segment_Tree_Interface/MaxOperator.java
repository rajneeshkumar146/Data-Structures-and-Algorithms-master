package Segment_Tree;

public class MaxOperator implements ISegmentOperator {

	@Override
	public int opertation(int left, int right) {

		return Math.max(left, right);

	}

	@Override
	public int identity() {
		return Integer.MIN_VALUE;
	}

}
