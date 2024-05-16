package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		System.out.println("project statrted");

		Configuration cfg = new Configuration();

		cfg.configure();

		SessionFactory factory = cfg.buildSessionFactory();
		// creating student
		Student st = new Student();
		st.setId(101);
		st.setName("john");
		//st.setCity("indore");
		System.out.print(st);// to string pass data jayga
		// object save kai liye

		Session session = factory.openSession(); // seeion nikal liya

		Transaction tx = session.beginTransaction();
		session.save(st); // object ko save kr diya

		tx.commit();

		session.close();

		// System.out.println(factory);

		// System.out.println(factory.isClosed());
	}
}


