package many2one2;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TeachersStudentMain 
{
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
		s1.setSubject("Science");
		s1.setParentObject(t);
		
		StudentDTO s2 = new StudentDTO();
		s2.setSid(52);
		s2.setSname("Gaurav");
		s2.setSubject("maths");
		s2.setParentObject(t);
		
		StudentDTO s3 = new StudentDTO();
		s3.setSid(53);
		s3.setSname("Amit");
		s3.setSubject("History");
		s3.setParentObject(t);
		
		Transaction tr = sn.beginTransaction();
		sn.save(s1);
		sn.save(s2);
		sn.save(s3);
		
		tr.commit();
		sn.close();
	}
	public static void updateTeachersStudentMain()
	{
		Session s2 = sf.openSession();
		Transaction tr = s2.beginTransaction();
		StudentDTO st1 = (StudentDTO) s2.get(StudentDTO.class,52);
		TeachersDTO t1 = st1.getParentObject();
		t1.setTname("Shakshi");
		st1.setSname("Yogesh");
		st1.setSubject("maths");
		
		s2.update(st1);
		
		tr.commit();
		s2.close();
		
	}
	
	public static void getTeachersStudentMain()
	{
		Session sn = sf.openSession();
		StudentDTO s1 = (StudentDTO) sn.get(StudentDTO.class, 53);
		System.out.println("Student Details");
		System.out.println("ID: "+s1.getSid()+" ");
		System.out.println("Name: "+s1.getSname()+" ");
		System.out.println("Student: "+s1.getSubject()+" ");
		
		
		TeachersDTO t1 = s1.getParentObject();
		System.out.println("TeachersDTO Details");
		System.out.print("ID: "+t1.getTid()+" ");
		System.out.print("Name: "+t1.getTname()+" ");
		
		System.out.println("");
		
		sn.close();
		
	}
	
	public static void getAllTeachersStudentMain()
	{
		Session sn = sf.openSession();
		Query q = sn.createQuery("from StudentDTO s1");
		
		
		List<?> l = q.list();
		Iterator<?> it1  = l.iterator();
		StudentDTO s1 = null;
		while(it1.hasNext())
		{
			s1= (StudentDTO) it1.next();
			System.out.println("Student Details");
			System.out.println("ID: "+s1.getSid()+" ");
			System.out.println("Name: "+s1.getSname()+" ");
			System.out.println("Student: "+s1.getSubject()+" ");
		
		}
		TeachersDTO t1 = s1.getParentObject();
		System.out.println("TeachersDTO Details");
		System.out.print("ID: "+t1.getTid()+" ");
		System.out.print("Name: "+t1.getTname()+" ");
		
		System.out.println("");
		sn.close();
		
	}
	
	/*public static void deleteTeachersStudentMain()
	{
		Session sn = sf.openSession();
		Transaction tr1 = sn.beginTransaction(); 
		CustomerDTO c1 = (CustomerDTO) sn.get(CustomerDTO.class, 744);
		
		sn.delete(c1);
		
		tr1.commit();
		sn.close();
	}*/
	
	public static void deleteTeachersAllStudentMain()
	{
		Session sn = sf.openSession();
		Transaction tr1 = sn.beginTransaction(); 
		
		Query q = sn.createQuery("from StudentDTO c1");
		
		List<?> l = q.list();
		Iterator<?> it1  = l.iterator();
		while(it1.hasNext())
		{
			StudentDTO c1= (StudentDTO) it1.next();
			sn.delete(c1);
		}
		
		tr1.commit();
		sn.close();
	}
	
	public static void main(String[] args)
	{
		//saveTeachersStudentMain();
		//updateTeachersStudentMain();
		getTeachersStudentMain();
		getAllTeachersStudentMain();
		deleteTeachersAllStudentMain();
	}

}
