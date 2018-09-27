package one2many2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TeachersStudentMain {

	static SessionFactory sf =new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
	public static void saveTeachersStudentMain()
	{
		Session sn = sf.openSession();
		
		TeachersDTO t = new TeachersDTO();
		t.setTid(234);
		t.setTname("Anil");
		
		StudentDTO s1 = new StudentDTO();
		s1.setSid(4543);
		s1.setSname("Sunny");
		s1.setSubject("History");
		
		StudentDTO s2 = new StudentDTO();
		s2.setSid(52);
		s2.setSname("Gaurav");
		s2.setSubject("Economics");
		
		StudentDTO s3 = new StudentDTO();
		s3.setSid(53);
		s3.setSname("Amit");
		s3.setSubject("Bio");
		
		Set<StudentDTO> s = new HashSet<StudentDTO>();
		s.add(s1);
		s.add(s2);
		s.add(s3);
		
		t.setStudent(s);
		
		//for many to one
		s1.setParentObject(t);
		s2.setParentObject(t);
		s3.setParentObject(t);
		
		Transaction tr = sn.beginTransaction();
		//sn.save(t);
		sn.save(s1);
		
		tr.commit();
		sn.close();
	}
	
	public static void updateTeachersStudentMain()
	{
		Session sn = sf.openSession();
		Transaction tn =sn.beginTransaction();
		TeachersDTO t = (TeachersDTO) sn.get(TeachersDTO.class, 234);
		t.setTname("Anil");
		
		Set<?> s = t.getStudent();
		Iterator<?> it = s.iterator();
		while(it.hasNext())
		{
			StudentDTO s1 = (StudentDTO)it.next();
			s1.setSname("Hunny");
			s1.setSubject("Urdu");
			sn.update(s1);
		}
		
		/*StudentDTO ss =(StudentDTO) sn.get(StudentDTO.class ,53);
		TeachersDTO tc1 = ss.getParentObject();
		tc1.setTname("seeta");
		ss.setSname("fezaa");
		ss.setSubject("Maths");
		sn.update(ss);*/
		
		tn.commit();
		sn.close();
		
	}
	public static void main(String[] args)
	{
		saveTeachersStudentMain();
		//updateTeachersStudentMain();	

	}

}
