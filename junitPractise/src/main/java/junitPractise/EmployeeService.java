package junitPractise;

import junitPractise.model.Address;
import junitPractise.model.Employee;

public class EmployeeService {

	private Address add;

	public EmployeeService(Address add) {
		this.add = add;
	}

	public Employee getEmployee() {
		return new Employee("Giri", "CS", 21, 12001, add.getAddress());
	}

}
