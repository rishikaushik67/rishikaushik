package lab9.prob5;

import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Prob5 {

	
	public void printSubString(String n1,int m,int k){
		Stream<String> stream=Stream.iterate(n1,n->n1.substring(m, k+1) );
		System.out.println(stream.skip(m).limit(k-m).collect(Collectors.toList()));/*.forEach(System.out::print);*/
//		System.out.println(stream.collect(Collectors.toList()));
	}
	
	public static void main(String[] args) {
		
		Prob5 prob2a=new Prob5();
		prob2a.printSubString("rishi",0,2);
	}
}
