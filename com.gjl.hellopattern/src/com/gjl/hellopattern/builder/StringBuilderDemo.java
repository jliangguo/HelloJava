package com.gjl.hellopattern.builder;

public class StringBuilderDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder("Start: ");
		for (int i = 0; i < 10; i++) {
			sb.append(i);
		}
		sb.append("...End");
		System.out.println(sb.toString());
	}

}
