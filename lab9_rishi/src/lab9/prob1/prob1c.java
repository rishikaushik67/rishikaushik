package lab9.prob1;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class prob1c {

	public static void main(String[] args) {
		Stream<Integer> intStream=Arrays.asList(1,2,3).stream();
		IntSummaryStatistics summary=
				intStream.collect(Collectors.summarizingInt(Integer::intValue));
		System.out.println(summary.getMax()+"\n"+summary.getMin());
	}

}
