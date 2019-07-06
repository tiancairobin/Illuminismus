package com.finalhome.robin.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Reflection {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<Helper> clazz = Helper.class;
		Helper helper = new Helper();
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("Please input mode: 0 - plain, 1 - reversed, or \"exit\" to exit");
			String mode = scanner.nextLine();
			if("0".equals(mode)) {
				System.out.println("Mode Plain");
			} else if ("1".equals(mode)) {
				System.out.println("Mode Reversed");
			} else if ("exit".equalsIgnoreCase(mode)){
				System.out.println("system exit");
				System.exit(0);
			} else {
				System.out.println("Mode unknown");
				break;
			}
			System.out.println("Please input string");
			String str = scanner.nextLine();
			if("0".equals(mode)) {
				Method m = clazz.getMethod("plain", String.class);
				System.out.println(m.invoke(helper, str));
			} else {
				Method m = clazz.getMethod("reverse", String.class);
				System.out.println(m.invoke(helper, str));
			}
		}
		scanner.close();
	}
}
