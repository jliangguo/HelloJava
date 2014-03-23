package com.gjl.algorithms.fibonacci;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.gjl.algorithms.util.StopWatch;

/**
 * Fast Fibonacci.
 * 
 * @author Administrator
 * 
 */
public class Fibonacci {
	private final Map<Integer, Long> cache = new ConcurrentHashMap<Integer, Long>();

	/**
	 * 快速计算方法，即加缓存的方法优化。
	 * 
	 * @param n
	 * @return
	 */
	public Long fast_fib(int n) {
		if (0 == n || 1 == n) {
			return (long) n;
		}

		Long result = cache.get(n);
		if (null == result) {
			synchronized (cache) {
				result = cache.get(n);
				if (null == result) {
					// System.out.println("calculating fib(" + n + ")");
					result = fast_fib(n - 2) + fast_fib(n - 1);
					cache.put(n, result);
				}
			}
		}

		return result;
	}

	/**
	 * 慢速计算方法。
	 * 
	 * @param n
	 * @return
	 */
	public Long slow_fib(int n) {
		if (0 == n || 1 == n) {
			return (long) n;
		}
		// System.out.println("calculating fib(" + n + ")");
		return slow_fib(n - 2) + slow_fib(n - 1);
	}

	public static void main(String[] args) {
		int n = 50;
		StopWatch timer = new StopWatch();
		Fibonacci fib = new Fibonacci();
		// Fast
		timer.start();
		System.out.println("fib(" + n + ") = " + fib.fast_fib(n));
		timer.stop();
		System.out.println("It takes " + timer.getTime() + " milliseconds.");
		System.out.println();

		// Slow
		timer.reset();
		timer.start();
		System.out.println("fib(" + n + ") = " + fib.slow_fib(n));
		timer.stop();
		System.out.println("It takes " + timer.getTime() + " milliseconds.");

	}

}
