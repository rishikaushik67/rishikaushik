package lab9.prob3;

import java.util.*;
import java.util.function.Function;

	public class Main {
		
		static enum SortMethod {BYNAME, BYSALARY};
		Function<Employee, String> byName = e -> e.getFirstName();
		Function<Employee, Integer> bySalary = e -> e.getSalary();
		
		HashMap<SortMethod, Pair<Function, Function>> hashmap=new HashMap<Main.SortMethod, Pair<Function,Function>>(){
			{
			put(SortMethod.BYNAME, new Pair<Function, Function>(byName, bySalary));
			put(SortMethod.BYSALARY, new Pair<Function, Function>(bySalary, byName));
		}
	};
	
	public void sort(List<Employee> emp,SortMethod method){
		Collections.sort(emp,Comparator.comparing(hashmap.get(method).getFirst()).
				thenComparing(hashmap.get(method).getSecond()));
		
	}
	

	public static void main(String[] args) {
		List<Employee> list = Arrays.asList(new Employee("Joe", "Davis", 120000),
				          new Employee("John", "Sims", 110000),
				          new Employee("Joe", "Stevens", 200000),
		                  new Employee("Andrew", "Reardon", 80000),
		                  new Employee("Joe", "Cummings", 760000),
		                  new Employee("Steven", "Walters", 135000),
		                  new Employee("Thomas", "Blake", 111000),
		                  new Employee("Alice", "Richards", 101000),
		                  new Employee("Donald", "Trump", 100000));
		
		//your stream pipeline here
		
		Main ei = new Main();
		ei.sort(list, Main.SortMethod.BYNAME);
		System.out.println(list);
		//same instance
//		ei.sort(emps, EmployeeInfoBetter.SortMethod.BYSALARY);

	}

}
