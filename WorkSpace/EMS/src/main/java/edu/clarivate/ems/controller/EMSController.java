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
				login(empController, employeeDao, read);
				break;
			case 2:
				register(read, employeeDao, empController);
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

	public static void login(EmployeeController empController, EmployeeDao employeeDao, Scanner read) {
		System.out.println("Enter the Employee Email :-");
		String email = read.next();
		System.out.println("Enter the Employee Password :-");
		String password = read.next();
		Employee employee = employeeDao.findEmployeeByEmailAndPassword(email, password);
		if (employee != null) {
			System.out.println("Hi Welcome To EMS!!");
			if (employee.getRole().equalsIgnoreCase("manager")) {
				// if Employee is Manager
				ManagerController managerController = new ManagerController();
				managerController.operation(read);
			}
		} else {
			System.out.println("Employee With the Given Detalies not Found");
		}
	}

	public static void register(Scanner read, EmployeeDao employeeDao, EmployeeController empController) {
		Employee employee = empController.readEmployeeInfo(read);
		employee = employeeDao.saveEmployee(employee);
		System.out.println("Employee Saved " + employee);

	}

}
