package ch02;

import ConcurrencyInPractice.chap02.CountingFactorizer;
import ConcurrencyInPractice.chap02.UnsafeCountingFactorizer;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author chenhao
 * @date 2023/2/5 17:09
 */
public class CountingFactorizerTest {

    @Test
    public void tets() {
        CountingFactorizer factorizer = new CountingFactorizer();
        ExecutorService executor = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 100000; i++) {
            Runnable worker = new FactorizerWorkerThread(factorizer);
            executor.execute(worker);
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
        }

        factorizer.getCount();
        System.out.println(factorizer.getCount());

    }

    private class FactorizerWorkerThread implements Runnable {
        CountingFactorizer factorizer;

        public FactorizerWorkerThread(CountingFactorizer factorizer) {
            this.factorizer = factorizer;
        }

        @Override
        public void run() {
            this.factorizer.service(null, null);
        }
    }
}
