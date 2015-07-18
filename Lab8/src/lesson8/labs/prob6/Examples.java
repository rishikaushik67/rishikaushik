package lesson8.labs.prob6;

import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Examples {
	// (Employee e) -> e.getName();
	static Function<Employee, String> getName1 = (Employee emp) -> emp
			.getName();
	static Function<Employee, String> getName2 = Employee::getName;

	// (Employee emp,String s) -> emp.setName(s)
	static BiConsumer<Employee, String> setName1 = (Employee emp, String s) -> emp
			.setName(s);
	static BiConsumer<Employee, String> setName2 = Employee::setName;

	// (String s1, String s2) -> s1.compareTo(s2)
	static Comparator<String> compare1 = (String s1, String s2) -> s1
			.compareTo(s2);
	static Comparator<String> compare2 = String::compareTo;

	// (Integer x, Integer y) -> Math.pow(x, y)
	static BiFunction<Integer, Integer, Double> power1 = (Integer x, Integer y) -> Math
			.pow(x, y);
	static BiFunction<Integer, Integer, Double> power2 = Math::pow;

	// (Apple a) -> a.getWeight()
	static Function<Apple, Integer> getWeight1 = (Apple a) -> a.getWeight();
	static Function<Apple, Integer> getWeight2 = Apple::getWeight;

	// (String x) -> Integer.parseInt(x)
	static Function<String, Integer> parseInt1 = (String s) -> Integer
			.parseInt(s);
	static Function<String, Integer> parseInt2 = Integer::parseInt;

	// (Employee e1, Employee e2) -> comp.compare(e1, e2)
	static EmployeeNameComparator employeeNameComparator = new EmployeeNameComparator();
	static Comparator<Employee> comparator1 = (Employee e1,
			Employee e2) -> employeeNameComparator.compare(e1, e2);
	static Comparator<Employee> comparator2 = employeeNameComparator::compare;

	Comparator<Employee> comparator3= (Employee e1,
			Employee e2) -> employeeNameComparator.compare(e1, e2);
	
	public static void main(String[] args) {

		// (Employee e) -> e.getName();
		System.out.println("// (Employee e) -> e.getName()");
		Employee employee = new Employee("Employee Name", 8000);
		System.out.println(getName1.apply(employee));
		System.out.println(getName2.apply(employee));

		// (Employee emp,String s) -> emp.setName(s)
		System.out.println("// (Employee emp,String s) -> emp.setName(s)");
		setName1.accept(employee, "New Name 1");
		setName2.accept(employee, "New Name 2");

		// (Employee e) -> e.getName();
		System.out.println("// (Employee e) -> e.getName()");
		System.out.println(getName1.apply(employee));
		System.out.println(getName2.apply(employee));
		
		// (String s1, String s2) -> s1.compareTo(s2)
		System.out.println("// (String s1, String s2) -> s1.compareTo(s2)");
		System.out.println(compare1.compare("Employee", "Employee"));
		System.out.println(compare1.compare("Employee", "Employee2"));

		System.out.println(compare2.compare("Employee", "Employee"));
		System.out.println(compare2.compare("Employee", "Employee2"));

		// (Integer x, Integer y) -> Math.pow(x, y)
		System.out.println("// (Integer x, Integer y) -> Math.pow(x, y)");
		System.out.println(power1.apply(3, 4));
		System.out.println(power2.apply(5, 3));

		// (Apple a) -> a.getWeight()
		System.out.println("// (Apple a) -> a.getWeight()");
		Apple apple = new Apple(30);
		System.out.println(getWeight1.apply(apple));
		System.out.println(getWeight2.apply(apple));

		// (String x) -> Integer.parseInt(x)
		int int1 = parseInt1.apply("33");
		int int2 = parseInt1.apply("333");

		// (Employee e1, Employee e2) -> comp.compare(e1, e2)
		System.out.println("// (Employee e1, Employee e2) -> comp.compare(e1, e2)");
		Employee emp1 = new Employee("employee", 6000);
		Employee emp2 = new Employee("employee", 6000);
		System.out.println(comparator1.compare(emp1, emp2));
		System.out.println(comparator2.compare(emp1, emp2));

		setName1.accept(emp1, "new Employee");

		System.out.println(comparator1.compare(emp1, emp2));
		System.out.println(comparator2.compare(emp1, emp2));
		
		BiConsumer<Employee,String> biConsumer=(Employee e,String s)->e.setName(s);
	}
}
