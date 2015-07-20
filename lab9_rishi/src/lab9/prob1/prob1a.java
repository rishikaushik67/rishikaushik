package lab9.prob1;

import java.util.stream.IntStream;

public class prob1a {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntStream ones=IntStream.generate(()->1).limit(20).distinct();
				ones.forEach(System.out::println);

	}

}
