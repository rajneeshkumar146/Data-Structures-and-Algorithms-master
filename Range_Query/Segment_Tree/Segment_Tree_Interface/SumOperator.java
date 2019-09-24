package Segment_Tree;

public class SumOperator implements ISegmentOperator {

	@Override
	public int opertation(int left, int right) {

		return left + right;

	}

	@Override
	public int identity() {
		return 0;
	}

}
