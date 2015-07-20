package lesson8.labs.prob1.partH;

import java.io.PrintStream;
import java.util.function.BiConsumer;

public class partH {

	public static void main(String[] args) {
	
		BiConsumer<PrintStream,String> print= (out,s) ->out.println(s);
		
		print.accept(System.out, "Test Lambda");
		
		
		// System.out::println
		// Method reference type is object::instanceMethod. Given an object out and an instance method println() in out
	}
}
