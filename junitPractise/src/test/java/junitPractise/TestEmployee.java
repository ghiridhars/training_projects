package junitPractise;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import junitPractise.model.Employee;

class TestEmployee {

	EmployeeCalculate calc = new EmployeeCalculate();
	Employee employee = new Employee();
	
	@BeforeAll  
    public static void setUpBeforeClass() throws Exception {  
        System.out.println("before class");  
    }  

	@Test
	void test() {
		fail("Not yet implemented");
	}

	@Test
	public void testCalculateYearlySalary() {
		employee.setName("Ghiridhar S");
		employee.setAge(22);
		employee.setSalary(20000);

		double salary = calc.calculateYearlySalary(employee);
		assertEquals(96000, salary, 0.0);
		
	}


}
