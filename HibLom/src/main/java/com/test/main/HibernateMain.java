package com.test.main;

import org.hibernate.Session;

import com.test.bean.Student;
import com.test.bean.Student1;
import com.test.util.HibernateUtil;

public class HibernateMain {

	public static void main(String[] args) {
		Student s = new Student(); 	
		s.setName("cxvbn");
		
		Session s1= HibernateUtil.getSessionFactory().openSession();
		s1.beginTransaction();
		s1.save(s);
		s1.getTransaction().commit();
		HibernateUtil.getSessionFactory().close();
		
		Student1 s3 = new Student1();
		s3.setName("dfghj");
		Session s2 = HibernateUtil.getAnnoSessionFactory().getCurrentSession();
		s2.beginTransaction();
		s2.save(s3);
		s2.getTransaction().commit();
		HibernateUtil.getAnnoSessionFactory().close();
		
		Student1 s4 = new Student1();
		s4.setName("yuiop");
		Session s5 = HibernateUtil.getSessionJavaFactory().getCurrentSession();
		s5.beginTransaction();
		s5.save(s4);
		s5.getTransaction().commit();
		HibernateUtil.getSessionJavaFactory().close();
		
	}
}
