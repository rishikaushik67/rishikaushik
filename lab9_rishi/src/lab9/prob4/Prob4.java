package lab9.prob4;

import java.math.BigInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Prob4 {

	
	
	public void printPrimeNumber(int n1){
		IntStream primes=IntStream.iterate(1, n ->n+1 ).map(n->n*n);
		primes.limit(n1).forEach(System.out::println);
	}
	
	public static void main(String[] args) {
		
		Prob4 prob2a=new Prob4();
		prob2a.printPrimeNumber(5);
	}
}