package one2many2;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TeachersStudentMain {

	public static void main(String[] args)
	{

		SessionFactory sf =new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session sn = sf.openSession();
		
		TeachersDTO t = new TeachersDTO();
		t.setTid(234);
		t.setTname("Anil");
		
		StudentDTO s1 = new StudentDTO();
		s1.setSid(4543);
		s1.setSname("Sunny");
		s1.setForeignsid(234);
		
		StudentDTO s2 = new StudentDTO();
		s2.setSid(52);
		s2.setSname("Gaurav");
		s2.setForeignsid(234);
		
		StudentDTO s3 = new StudentDTO();
		s3.setSid(53);
		s3.setSname("Amit");
		s3.setForeignsid(234);
		
		Set<StudentDTO> s = new HashSet<StudentDTO>();
		s.add(s1);
		s.add(s2);
		s.add(s3);
		
		t.setStudent(s);
		
		Transaction tr = sn.beginTransaction();
		sn.save(t);
		tr.commit();
		sn.close();
		
		
		

	}

}
