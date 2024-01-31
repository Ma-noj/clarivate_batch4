package edu.clarivate.ems.controller;

import java.util.List;
import java.util.Scanner;

import edu.clarivate.ems.dao.EmployeeDao;
import edu.clarivate.ems.entity.Employee;

public class ManagerController {

	public void operation(Scanner read) {
		while (true) {
			System.out.println("SELECt Choice :- \n1.Create Task\n2.Display All Employee\n3.Exsit");
			int choice = read.nextInt();
			switch (choice) {
			case 1:// Create Task and Assign to Employee
				break;
			case 2:
				dispalyEmployee();
				break;
			case 3:
				System.exit(0);
				break;
			default:
				System.out.println("Invalied Choice");
				break;
			}
		}
	}

	public void dispalyEmployee() {
		EmployeeDao employeeDao = new EmployeeDao();
		List<Employee> employees = employeeDao.findAllEmployeeAsSoftwareEng();
		System.out.println("Employee Info");
		for (Employee employee : employees) {
			System.out.println(employee);
		}
	}

}
