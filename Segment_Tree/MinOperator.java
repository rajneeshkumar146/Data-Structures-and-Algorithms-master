package Segment_Tree;

public class MinOperator implements ISegmentOperator {

	@Override
	public int opertation(int left, int right) {

		return Math.min(left, right);

	}

	@Override
	public int identity() {

		return Integer.MAX_VALUE;
	}

}
