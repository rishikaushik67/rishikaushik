package lesson8.labs.prob2.partA;

import java.util.Comparator;

public class EmployeeSalaryComparator implements Comparator<Employee> {
	@Override
	public int compare(Employee e1, Employee e2) {
		if (e1.salary != e2.salary) {
			if (e1.salary < e2.salary)
				return -1;
			else
				return 1;
		} else {
			return e1.name.compareTo(e2.name);
		}
	}
}
