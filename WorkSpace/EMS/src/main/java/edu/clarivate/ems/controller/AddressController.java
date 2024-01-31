package edu.clarivate.ems.controller;

import java.util.Scanner;

import edu.clarivate.ems.entity.Addres;

public class AddressController {

	public Addres readAddresInfo(Scanner read) {
		Addres addres = new Addres();
		System.out.println("Enter the Street Line :-");
		addres.setLine(read.next());
		System.out.println("Enter the City :-");
		addres.setCity(read.next());
		System.out.println("Enter the State :-");
		addres.setState(read.next());
		System.out.println("Enter the Country :-");
		addres.setCountry(read.next());
		System.out.println("Enter the Pincode :-");
		addres.setPincode(read.nextInt());
		return addres;
	}

}
