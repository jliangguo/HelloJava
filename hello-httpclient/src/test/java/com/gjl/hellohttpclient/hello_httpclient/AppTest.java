package com.gjl.hellohttpclient.hello_httpclient;

import junit.framework.TestCase;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * Rigourous Test :-)
	 */
	@Test
	public void testSayHello() {
		String hello = App.sayHello();
		assertEquals(hello, "Hello Maven");
	}
}
