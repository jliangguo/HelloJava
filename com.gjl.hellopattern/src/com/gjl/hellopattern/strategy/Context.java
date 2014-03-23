package com.gjl.hellopattern.strategy;

public class Context {

	// ����һ�����Զ�������
	private final Strategy strategy;

	/**
	 * ���캯��������һ���������
	 * 
	 * @param strategy
	 */
	public Context(Strategy strategy) {
		this.strategy = strategy;
	}

	/**
	 * ���Է���
	 */
	public void contextInterface() {
		strategy.strategyInterface();
	}
}
