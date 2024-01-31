package edu.clarivate.ems.controller;

import java.util.Scanner;

import edu.clarivate.ems.entity.Addres;
import edu.clarivate.ems.entity.Employee;

public class EmployeeController {

	public Employee readEmployeeInfo(Scanner read) {
		Employee employee = new Employee();
		System.out.println("Enter the Name :- ");
		employee.setName(read.next());
		System.out.println("Enter the Email :- ");
		employee.setEmail(read.next());
		System.out.println("Enter the Password :- ");
		employee.setPassword(read.next());
		System.out.println("Enter the Role :- ");
		employee.setRole(read.next());
		AddressController addressController = new AddressController();
		Addres addres = addressController.readAddresInfo(read);
		employee.setAddres(addres);
		return employee;
	}

}
