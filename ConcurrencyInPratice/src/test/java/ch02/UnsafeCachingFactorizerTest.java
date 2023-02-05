package ch02;

import ConcurrencyInPractice.chap02.FactorizerUtils;
import ConcurrencyInPractice.chap02.UnsafeCachingFactorizer;
import ConcurrencyInPractice.chap02.UsrServletRequest;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

/**
 * Created by asorokin on 02.07.2018.
 */
public class UnsafeCachingFactorizerTest {
	UnsafeCachingFactorizer cachingFactorizer = new UnsafeCachingFactorizer();
	final int MAX_ITERATIONS = 2;
	BigInteger[] cache_result_1;
	BigInteger[] cache_result_2;
	BigInteger[] cache_result_3;
	BigInteger[] cache_result_4;

	@Test
	public void testCachedFactorize() {
		Thread th_1 = new Thread(() -> {
			for (int k = 0; k < MAX_ITERATIONS; k++) {
				// Эмуляция вызова сервлета
				cachingFactorizer.service(new UsrServletRequest(new BigInteger("2")), null);
				// Запоминаем состояние кэша
				cache_result_1 = cachingFactorizer.getLastFactors();
				// Пауза, чтобы другой поток мог внести изменения в кэш, таким образом эмулируем
				FactorizerUtils.sleep();
				// Повторный вызов сервлета, с надеждой, что он сможет взять значение из кэша
				cachingFactorizer.service(new UsrServletRequest(new BigInteger("2")), null);
				FactorizerUtils.sleep();
				cache_result_2 = cachingFactorizer.getLastFactors();
			}
		});

		Thread th_2 = new Thread(() -> {
			for (int k = 0; k < MAX_ITERATIONS; k++) {
				cachingFactorizer.service(new UsrServletRequest(new BigInteger("4")), null);
				FactorizerUtils.sleep();
				cachingFactorizer.service(new UsrServletRequest(new BigInteger("4")), null);
				FactorizerUtils.sleep();
				cache_result_4 = cachingFactorizer.getLastFactors();
			}
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

		assertEquals(cache_result_1[0], cache_result_2[0]);
	}
}
