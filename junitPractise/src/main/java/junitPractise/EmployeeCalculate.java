package junitPractise;

import junitPractise.model.Employee;

public class EmployeeCalculate {

	public double calculateYearlySalary(Employee employee) {
		double yearlySalary = 0;
		yearlySalary = employee.getSalary()* 12;
		return yearlySalary;
	}

}
