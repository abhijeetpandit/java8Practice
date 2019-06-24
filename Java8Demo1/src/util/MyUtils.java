package util;

import java.util.function.Predicate;

import org.abhi.beansV2.Employee;

public class MyUtils {
	public static Predicate<Employee> isAdultMale() {
		return (Employee t) -> t.getAge() > 18 && t.getGender().equalsIgnoreCase("M");
	}
	
	public static org.abhi.beans.Employee mapToOld(Employee employee) {
		org.abhi.beans.Employee oldBean = new org.abhi.beans.Employee(employee.getId(), employee.getFirstName() + employee.getLastName(), 0);
		return oldBean;
	}
}
