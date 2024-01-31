package edu.clarivate.ems.controller;

import java.util.Scanner;

import edu.clarivate.ems.dao.EmployeeDao;
import edu.clarivate.ems.entity.Employee;

public class EMSController {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		EmployeeController empController = new EmployeeController();
		EmployeeDao employeeDao = new EmployeeDao();
		while (true) {
			System.out.println("Select the Choice :- \n1.Login\n2.Register\n3.Exist");
			int choice = read.nextInt();
			switch (choice) {
			case 1:// Login Operation
				break;
			case 2:
				Employee employee = empController.readEmployeeInfo(read);
				employee = employeeDao.saveEmployee(employee);
				System.out.println("Employee Saved " + employee);
				break;
			case 3:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Choice");
				break;
			}
		}
	}

}
