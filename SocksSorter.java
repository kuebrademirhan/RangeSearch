import java.util.*;

class SocksSorter<T> {
	private final T[] things, otherThings;
	private final Comparator<T> comparator;

	SocksSorter(T[] things, Comparator<T> comparator) {
		if (things == null) {
			this.things = this.otherThings = null;
		} else {
			this.things = things;
			otherThings = Arrays.copyOf(things, things.length);
		}
		this.comparator = comparator;
	}

	public boolean sort(int from, int to) {
		if (things == null || from >= to) {
			return false;
		}
		int mid = (to + from) / 2;
		sort(from, mid);
		sort(mid + 1, to);
		int left = from;
		int right = mid + 1;
		int temp = from;
		while (left <= mid && right <= to) {
			int cmp = comparator.compare(things[left], things[right]);
			if (cmp <= 0) {
				otherThings[temp++] = things[left++];
			} else {
				otherThings[temp++] = things[right++];
			}
		}
		while (left <= mid) {
			otherThings[temp++] = things[left++];
		}
		int rest = from;
		while (rest < temp) {
			things[rest] = otherThings[rest];
			rest++;
		}
		return true;
	}
}
