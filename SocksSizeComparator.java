import java.util.Comparator;

class SocksSizeComparator implements Comparator<Sock> {
	@Override
	public int compare(Sock s1, Sock s2) {
		if (s1.s < s2.s) {
			return -1;
		} else {
			if (s1.s > s2.s) {
				return 1;
			} else {
				return 0;
			}
		}
	}
}
