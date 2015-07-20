package lesson8.labs.prob1.partJ;

import java.util.function.Supplier;

public class RandomLambda {
	public static void main(String[] args) {
		Supplier<Double> random = () -> Math.random();

		System.out.println(random.get());
	}
}
