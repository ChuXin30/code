package ConcurrencyInPractice.chap01;

import ConcurrencyInPractice.annotations.GuardedBy;
import ConcurrencyInPractice.annotations.ThreadSafe;


/**
 * Sequence
 *
 * @author Brian Goetz and Tim Peierls
 */

@ThreadSafe
public class Sequence {
	@GuardedBy("this")
	private int nextValue;

	public  int getValue() {
		return nextValue;
	}

	public synchronized int getNext() {
		return nextValue++;
	}
}
