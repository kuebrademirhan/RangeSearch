public class Sock {
	final double s; // size
	final String d; // design

	Sock(double s, String d) {
		if (s <= 0) {
			s = 0;
		}
		if (d == null) {
			d = "";
		}
		this.s = s;
		this.d = d;
	}

	@Override
	public String toString() {
		String string = "s=" + s + ",d=" + d;
		if (d.length() == 0) {
			string = "s=" + s + ",d=[uni]";
		}
		return string;
	}
}
