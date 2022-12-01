import java.util.Arrays;

public class RangeSearch {
	private final Range[] is;

	public RangeSearch(Range[] is) {
		if (is == null) {
			is = new Range[0];
		}
		this.is = Arrays.copyOf(is, is.length);
	}

	Range searchRange(int v) {
		int s = 0, m, e = is.length - 1; // start, middle, end
		while (s <= e) {
			m = (s + e) / 2;
			if (v < is[m].min) {
				e = m - 1;
			} else {
				if (v > is[m].max) {
					s = m + 1;
				} else {
					return is[m];
				}
			}
		}
		return null;
	}
}
