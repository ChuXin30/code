package ch01;

import ConcurrencyInPractice.chap01.Sequence;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by asorokin on 21.06.2018.
 */
public class SequenceTest {

	@Test
	public void getNext() {
		final int MAX_ITERATIONS = 100000;
		final Sequence sequence = new Sequence();

		Thread th_1 = new Thread(() -> {
			for (int k = 0; k < MAX_ITERATIONS; k++)
				sequence.getNext();
		});

		Thread th_2 = new Thread(() -> {
			for (int k = 0; k < MAX_ITERATIONS; k++)
				sequence.getNext();
		});

		th_1.start();
		th_2.start();

		try {
			th_1.join();
			th_2.join();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(String.format("MAX_ITERATIONS * 2[%s] sequence.getValue()[%s]" ,MAX_ITERATIONS * 2, sequence.getValue()));
		assertEquals(MAX_ITERATIONS * 2, sequence.getValue());

	}
}
