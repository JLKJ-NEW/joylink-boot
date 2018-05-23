package com.joylink.userms.util;

import java.util.Random;
import java.util.UUID;

public class RandomGenerator {
	
	private RandomGenerator() {}
	
	private static Random random = new Random(System.currentTimeMillis());
	
	/**
	 * 获取len位数字符串
	 * @param len
	 * @return
	 */
	public static String getByLen(int len) {
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<len; ++i) {
			sb.append(random.nextInt(10));
		}
		return sb.toString();
	}
	
	/**
	 * 获取UUID
	 * @return
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString();
	}
	
}
