package lab9.prob2;

import java.math.BigInteger;
import java.util.stream.Stream;

public class Prob2a {

	private final static BigInteger TWO=BigInteger.ONE.add(BigInteger.ONE); 
	static final Stream<BigInteger> primes=Stream.iterate(TWO, n -> n.nextProbablePrime());
	
	public void printPrimeNumber(int n){
		primes.limit(n).forEach(System.out::println);
	}
	
	public static void main(String[] args) {
		
		Prob2a prob2a=new Prob2a();
		prob2a.printPrimeNumber(10);
	}
}
