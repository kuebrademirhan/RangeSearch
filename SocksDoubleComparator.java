import java.util.Comparator;

class SocksDoubleComparator implements Comparator<Sock> {
	final Comparator<Sock> ssc, sdc;

	public SocksDoubleComparator(SocksSizeComparator ssc, SocksDesignComparator sdc) {
		this.ssc = ssc;
		this.sdc = sdc;
	}

	@Override
	public int compare(Sock s1, Sock s2) {
		int gvRes = ssc.compare(s1, s2);
		if (gvRes != 0) {
			return gvRes;
		} else {
			int mvRes = sdc.compare(s1, s2);
			return mvRes;
		}
	}
}
