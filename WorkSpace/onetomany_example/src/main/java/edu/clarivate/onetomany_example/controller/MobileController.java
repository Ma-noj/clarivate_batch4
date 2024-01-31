package edu.clarivate.onetomany_example.controller;

import java.util.ArrayList;
import java.util.List;

import edu.clarivate.onetomany_example.dao.MobileDao;
import edu.clarivate.onetomany_example.entity.Mobile;
import edu.clarivate.onetomany_example.entity.Sim;

public class MobileController {
	public static void main(String[] args) {
		Mobile mobile = readModileInfo();
		MobileDao dao = new MobileDao();
		mobile = dao.saveMobile(mobile);
		System.out.println("Mobile Saved!!");

	}

	public static Mobile readModileInfo() {
		Mobile mobile = new Mobile();
		mobile.setId(1002);
		mobile.setName("G41");
		mobile.setBrand("Nokia");
		List<Sim> sims = readSimInfo();
		mobile.setSims(sims);
		return mobile;
	}

	public static List<Sim> readSimInfo() {
		Sim sim1 = new Sim();
		sim1.setId(103);
		sim1.setImrc("982536");
		sim1.setProvider("bsnl");

		Sim sim2 = new Sim();
		sim2.setId(104);
		sim2.setImrc("761524");
		sim2.setProvider("jio");
		List<Sim> sims = new ArrayList<>();
		sims.add(sim1);
		sims.add(sim2);
		return sims;
	}
}
