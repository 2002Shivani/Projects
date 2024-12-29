package com.main;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.district.DistrictDetails;
import com.employee.Employee;
import com.patient.PatientDetails;
import com.product.ProductDetails;
import com.student.Student;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int choice;
		do {
			
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			System.out.println(
					"Enter Choice to create database .1.EMPOYEE 2.DISTRICT " + "3.PATIRNT 4.PRODUCT 5.STUDENT 0.EXIT ");
			choice = in.nextInt();

			switch (choice) {
			case 1:
				cfg.addAnnotatedClass(Employee.class);
				break;
			case 2:
				cfg.addAnnotatedClass(DistrictDetails.class);
				break;

			case 3:
				cfg.addAnnotatedClass(PatientDetails.class);
				break;

			case 4:
				cfg.addAnnotatedClass(ProductDetails.class);
				break;

			case 5:
				cfg.addAnnotatedClass(Student.class);
				break;

			case 0:
				System.out.println("Exit");
				break;

			default:
				System.out.println("Invalid Choice");
			}

			SessionFactory sf = cfg.buildSessionFactory();
			Session ss = sf.openSession();
			Transaction tr = ss.beginTransaction();
			
			
		} while (choice != 0);
	}

}
