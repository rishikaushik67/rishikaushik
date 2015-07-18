package lesson8.labs.prob1.partJ;

import java.util.function.Supplier;

public class RandomInnerClass {
	public static void main(String[] args) {
		class RandomSupplier implements Supplier<Double> {

			@Override
			public Double get() {
				return Math.random();
			}

		}

		RandomSupplier randomSupplier = new RandomSupplier();
		System.out.println(randomSupplier.get());
	}
}
