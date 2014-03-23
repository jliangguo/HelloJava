package com.gjl.hellopattern.strategy;

public class Context {

	// 持有一个策略对象引用
	private final Strategy strategy;

	/**
	 * 构造函数，传入一个具体策略
	 * 
	 * @param strategy
	 */
	public Context(Strategy strategy) {
		this.strategy = strategy;
	}

	/**
	 * 策略方法
	 */
	public void contextInterface() {
		strategy.strategyInterface();
	}
}
