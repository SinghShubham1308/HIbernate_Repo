package com.hibernate.HQL.start;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    /**
     * @param args
     */
    @SuppressWarnings("deprecation")
	public static void main( String[] args )
    {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        String queryString = "from Student where course =:x  and name=:n";
        Query q= session.createQuery(queryString,Student.class);
        q.setParameter("x", "hibernate");
        q.setParameter("n", "Shubham");
        List<Student>list=q.getResultList();
        System.out.print(list.size());
        for(Student student:list) {
       	 System.out.println(student.getName());
        }
        session.clear();
        sessionFactory.close();
    }
}
