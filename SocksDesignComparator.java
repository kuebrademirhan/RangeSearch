import java.util.Comparator;

class SocksDesignComparator implements Comparator<Sock> {
	@Override
	public int compare(Sock o1, Sock o2) {
		int result = 0;
		if (o1.d.length() == 0 && o2.d.length() != 0) {
			result = -1;
		}
		if (o1.d.length() != 0 && o2.d.length() == 0) {
			result = 1;
		}
		if (o1.d.length() != 0 && o2.d.length() != 0) {
			result = o1.d.compareTo(o2.d);
		}
		return result;
	}
}
