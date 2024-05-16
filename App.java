package com.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        // Create session factory
        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(StudentBean.class)
                                    .buildSessionFactory();

        // Create session
        Session session = factory.openSession();

        try {
            // Create a StudentBean object
            StudentBean student = new StudentBean();
            student.setName("John Doe");
            student.setRollno(123456);

            // Start a transaction
            session.beginTransaction();

            // Save the StudentBean object
            session.save(student);

            // Commit transaction
            session.getTransaction().commit();

            System.out.println("Student saved successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }
}

