package BitTactics;

public class Tricks {

	public static void main(String[] args) {

		int n = 80;
		System.out.println(ExtractLowestSetBit(n));
		System.out.println(ExtractLowestSetBit_2(n));

	}

	// simple.
	private static int countBits(int n) {
		int count = 1;
		while (n != 0) {
			count++;
			n >>= 1;
		}
		return count;
	}

	// simple
	private static int countSetBits(int n) {
		int count = 0;
		while (n != 0) {
			count += (n & 1);
			n >>= 1;
		}
		return count;
	}

	// on->on,off->on
	private static int OnOffBit(int n, int k) {
		int mask = 1 << k;
		n |= (mask);
		return n;
	}

	// on->off,off->off
	private static int OffOnBit(int n, int k) {
		int mask = 1 << k;
		n = (n & (~mask));
		return n;
	}

	private static boolean checkOnOff(int x, int bitno) {
		int mask = 1;
		mask <<= bitno;
		return ((x & mask) == 0) ? false : true;
	}

	private static boolean IsPowOf2(int n) {

		return (n != 0) && (n & (n - 1)) == 0;
	}

	private static boolean IsPowOf4(int n) {

		if (IsPowOf2(n)) {
			int count = 0;
			while (n != 1) {
				n >>= 1;
				count++;
			}

			return (count & 1) == 1 ? false : true;
		}
		return false;
	}

	// clear the lowest set bit of x
	private static int ClearLowestSetBit(int n) {
		return n & (n - 1);
	}

	// extracts_the_lowest_set_bit_of_x_(all_others_are_clear)._Pretty_patterns_when_applied_to_a_linear_sequence.
	private static int ExtractLowestSetBit(int n) {
		return n & ~(n - 1);
	}

	// extracts_the_lowest_set_bit_of_x_(all_others_are_clear)._Pretty_patterns_when_applied_to_a_linear_sequence.
	private static int ExtractLowestSetBit_2(int n) {
		return n & -n;
	}

	private static int countOfBitsByAbsortion(int n) {
		int count = 0;
		while (n != 0) {
			n = n & (n - 1); // jump on set bit only.
			count++;
		}

		return count;
	}

	private static int revesebit(int n) {
		int ans = 0;
		while (n != 0) {
			ans |= n & 1;
			n = n >> 1;
			ans <<= 1;
		}

		return ans;
	}

	private static void swap(int x, int y) {
		x = x ^ y;
		y = x ^ y;
		x = x ^ y;

	}
}
