package com.gjl.hellopattern.prototype;

//prototype
interface Prototype {
	void setSize(int x);

	void printSize();
}

// a concrete class
class A implements Prototype, Cloneable {

	private int size;

	public A(int x) {
		this.size = x;
	}

	@Override
	public void setSize(int x) {
		this.size = x;
	}

	@Override
	public void printSize() {
		System.out.println("Size: " + size);
	}

	@Override
	protected A clone() throws CloneNotSupportedException {
		return (A) super.clone();
	}

}

// when we need a large number of similar objects
public class PrototypeTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		A a = new A(1);
		for (int i = 2; i < 10; i++) {
			Prototype tmp = a.clone();
			tmp.setSize(i);
			tmp.printSize();
		}
	}

}
