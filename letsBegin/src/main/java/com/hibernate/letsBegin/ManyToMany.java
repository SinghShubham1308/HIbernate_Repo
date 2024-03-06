package com.hibernate.letsBegin;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Employee;
import com.hibernate.entity.Projects;

public class ManyToMany {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // Create employees
        Employee employee1 = new Employee();
        employee1.setEmployeeId(1);
        employee1.setEmployeeName("Shubham");

        Employee employee2 = new Employee();
        employee2.setEmployeeId(2);
        employee2.setEmployeeName("Abhishek");

        // Create projects
        Projects projects1 = new Projects();
        projects1.setProjectId(121);
        projects1.setProjectName("GPAA");

        Projects projects2 = new Projects();
        projects2.setProjectId(231);
        projects2.setProjectName("MOD");

        // Associate employees with projects
        List<Employee> employeesList1 = new ArrayList<>();
        employeesList1.add(employee1);
      
        employeesList1.add(employee2);
        

        // Associate projects with employees
        List<Projects> projectsList1 = new ArrayList<>();
        projectsList1.add(projects1);
        projectsList1.add(projects2);
        
        employee1.setProjects(projectsList1);
		projects2.setEmployees(employeesList1);
        // Save entities
        session.save(employee1);
        session.save(employee2);
        session.save(projects1);
        session.save(projects2);

        // Commit transaction
        transaction.commit();

        // Close session
        session.close();
        sessionFactory.close();
    }
}
