package com.gjl.hellopattern.builder;

class NutritionFacts {
	private final int servingSize;
	private final int servings;
	private final int calories;
	private final int fat;
	private final int sodium;
	private final int carbonhydrate;

	public static class Builder {
		// Requried parametes
		private final int servingSize;
		private final int servings;

		// Optional parameter
		private int calories = 0;
		private int fat = 0;
		private int sodium = 0;
		private int carbonhydrate = 0;

		public Builder(int servingSize, int servings) {
			this.servingSize = servingSize;
			this.servings = servings;
		}

		public Builder calories(int val) {
			calories = val;
			return this;
		}

		public Builder fat(int val) {
			fat = val;
			return this;
		}

		public Builder sodium(int val) {
			sodium = val;
			return this;
		}

		public Builder carbonhydrate(int val) {
			carbonhydrate = val;
			return this;
		}

		public NutritionFacts build() {
			return new NutritionFacts(this);
		}
	}

	/**
	 * 说明：对于内部类，编译器会对private成员都生成一个函数，一般都是以access开头。而对于外部类对内部类的private成员的访问，
	 * 编译器更改为对这个内部类的对应函数的调用，从而实现了对内部类private成员的访问。
	 * 
	 * @param builder
	 */
	private NutritionFacts(Builder builder) {
		servingSize = builder.servingSize;
		servings = builder.servings;
		calories = builder.calories;
		fat = builder.fat;
		sodium = builder.sodium;
		carbonhydrate = builder.carbonhydrate;
	}

	@Override
	public String toString() {
		return "NutritionFacts [servingSize=" + servingSize + ", servings="
				+ servings + ", calories=" + calories + ", fat=" + fat
				+ ", sodium=" + sodium + ", carbonhydrate=" + carbonhydrate
				+ "]";
	}
}

public class NutritionFactsBuilderTest {

	public static void main(String[] args) {
		NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8)
				.calories(100).sodium(35).carbonhydrate(27).build();
		System.out.println(cocaCola.toString());
	}

}
