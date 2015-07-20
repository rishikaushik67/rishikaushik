package lab9.prob1;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class prob1b {

	public static void main(String[] args) {
		Stream<String> stringStream=Arrays.asList("Bill","Thomas","Mary").stream();
		System.out.println(stringStream.collect(Collectors.joining(",")));
	}

}
