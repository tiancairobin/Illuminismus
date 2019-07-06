package com.finalhome.robin.illuminismus.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

/**
 * <p> n stairs, for each step, one can climb 1 or 2 stairs. How many ways are there? </p>
 * <p> top-down version. O(n)
 * @author robinwu
 *
 */
public class DynamicProgrammingTopDown {

	Map<Long, Long> map = new HashMap<Long, Long>();
	
	public long f(Long n) {
		if(n == 1) {
			return 1;
		} else if (n == 2) {
			return 2;
		} else {
			if(map.containsKey(n)) {
				return map.get(n);
			} else {
				Long v = f(n-1) + f(n-2);
				map.put(n, v);
				return v;
			}
		}
	}
	
	public static void main(String[] args) {
		DynamicProgrammingTopDown dp = new DynamicProgrammingTopDown();
		long start = System.currentTimeMillis();
		System.out.println("Application Started");
		System.out.println(dp.f(1000L));
		long end = System.currentTimeMillis();
		long e = end - start;
		System.out.println("Application Ended, Time Elapsed: " + e);
	}

}