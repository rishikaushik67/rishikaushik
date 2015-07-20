package lesson8.labs.prob5;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class ForEachExample {
	public static void main(String[] args) {
		List<String> list = Arrays
				.asList("Hello there", "Goodbye", "Back soon", "Away",
						"On Vacation", "Everywhere you want to be");

		// print each element of the list in upper case format
		
		//Lambda Expression
		list.forEach(word->System.out.println(word.toUpperCase()));
		
		//Method Reference
		Function<String,String> toUpperCase= String::toUpperCase;
		list.forEach(w-> System.out.println(toUpperCase.apply(w)));
	}

}