package Segment_Tree;

public class ProductOperator implements ISegmentOperator {

	@Override
	public int opertation(int left, int right) {

		return left * right;

	}

	@Override
	public int identity() {
		return 1;
	}

}
