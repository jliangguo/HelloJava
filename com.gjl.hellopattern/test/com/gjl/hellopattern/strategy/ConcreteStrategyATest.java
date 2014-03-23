package com.gjl.hellopattern.strategy;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConcreteStrategyATest extends TestCase {

	@Override
	@Before
	protected void setUp() throws Exception {
		super.setUp();
	}

	@Override
	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testConcreteStrategyAInterface() {
		Strategy stra = new ConcreteStrategyA();
		Context context = new Context(stra);
		context.contextInterface();
		// JUST FOR FUN!!!
		Assert.assertTrue(true);
	}

}
