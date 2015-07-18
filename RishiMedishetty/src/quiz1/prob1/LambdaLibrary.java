package quiz1.prob1;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class LambdaLibrary {
	public final static String IMPLEMENT = "implement!1";
	
	//sample query
	   public final static TriFunction<List<Employee>, Integer, Integer, List<Employee>> SAMPLE
	   = (list, namelength, year) -> list.stream()
	                                     .filter(e -> e.getName().length() > namelength)
	                                     .filter(e -> e.getYearOfBirth() > year)
	                                     .collect(Collectors.toList());
	   
	   public final static Function<int[], Integer> sumOfSquares
	   =(array)->IntStream.of(array).reduce(0,(a,b)->a+b*b);  
	   
	   public final static Function<int[], Integer> maxValue
	   =(array)->IntStream.of(array).max().getAsInt();

	   
	   public final static Function<int[], int[]> evenIntegers
	   =(array)->IntStream.of(array).filter(num->num%2==0).toArray();
	   

	   public final static TriFunction<List<Integer>, Integer, Integer, List<Integer>> 
	   Implementaion4= (list,m,n)->list.stream().
	   filter(number->number>m).filter(number->number%n<=5).
	   collect(Collectors.toList());
	   
/*	   public final static Function<List<Integer>, Integer> Implementation5=((list)->{
		   int count=0;
			for(int i=0;i<list.size();i++){
				if(list.get(i)==3&&list.get(i+1)==4&&list.get(i+2)==5){
					count++;
				}
			}
			return count;
			});*/
	   
	/*
	   public final static BiFunction<List<Integer>, String,Long> Implementation5=
			   (list,str)->Stream.iterate((0,n)->list.toString().indexOf(str,n)==-1?1:list.toString().
					   indexOf(str,n)+str.length()).
	*/   
	   public final static Function<List<Transaction>,  List<Transaction>> impl7
	   = (list) -> list.stream().filter(e -> e.getYear()>2011).
	   sorted(Comparator.comparing((Transaction t)->t.getTrader().getName())).
			   collect(Collectors.toList());
	   
	   public final static Function<List<Transaction>,  List<Transaction>> impl8
	   = (list) -> list.stream().filter(e -> e.getTrader().getCity().equals("Cambridge")).
	   sorted(Comparator.comparing((Transaction t)->t.getTrader().getName()))
			   .collect(Collectors.toList());

	   public final static Function<List<Employee>, List<Pair>> impl6=
			   (list)->list.stream().filter(e->e.getSalary()>55000).map(e->new Pair(e.name, e.salary))
			   .sorted(Comparator.comparing((Pair e)->e.name).thenComparing((Pair e)->-e.salary))
			   .collect(Collectors.toList());
}
