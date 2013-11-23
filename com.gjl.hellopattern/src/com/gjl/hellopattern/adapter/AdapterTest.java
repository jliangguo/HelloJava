package com.gjl.hellopattern.adapter;

class Apple {
	public void getAColor(String str) {
		System.out.println("Apple color is: " + str);
	}
}

class Orange {
	public void getOColor(String str) {
		System.out.println("Orange color is: " + str);
	}
}

class AppleAdapter extends Apple {
	private final Orange orange;

	public AppleAdapter(Orange orange) {
		this.orange = orange;
	}

	@Override
	public void getAColor(String str) {
		orange.getOColor(str);
	}
}

public class AdapterTest {

	public static void main(String[] args) {
		Apple a1 = new Apple();
		a1.getAColor("green");

		Orange orange = new Orange();

		AppleAdapter aa = new AppleAdapter(orange);
		// ʹ��Orange����ʹ��getAColor������ӡ��ɫ
		aa.getAColor("red");
	}

}
