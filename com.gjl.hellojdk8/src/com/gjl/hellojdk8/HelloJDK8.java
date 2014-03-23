package com.gjl.hellojdk8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HelloJDK8 {

	public static void main(String[] args) {
		// ============================ 接口默认实现 ===================
		Formula formula = new Formula() {

			@Override
			public double calculate(int a) {
				return sqrt(a * 100);
			}

		};
		double d1 = formula.calculate(100);
		double d2 = formula.sqrt(16);

		System.out.println("d1 = " + d1);
		System.out.println("d2 = " + d2);

		// ============================ Lambda表达式 ===================
		// before jdk8
		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
		Collections.sort(names, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}

		});
		System.out.println(names.toString());

		// jdk8
		List<String> names2 = Arrays.asList("peter", "anna", "mike", "xenia");
		// Collections.sort(names2, (String a, String b) -> {
		// return b.compareTo(a);
		// });
		Collections.sort(names2, (a, b) -> b.compareTo(a));
		System.out.println(names2.toString());

		// ============================ 函数式编程 ===================
		Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
		Integer converted = converter.convert("123");
		System.out.println(converted);

	}

}

interface Formula {
	double calculate(int a);

	default double sqrt(int a) {
		return Math.sqrt(a);
	}
}

@FunctionalInterface
interface Converter<F, T> {
	T convert(F from);
}