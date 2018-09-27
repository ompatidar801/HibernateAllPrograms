package curdOperation;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

@SuppressWarnings("deprecation")
public class StudentsMain
{
	static AnnotationConfiguration ac = new AnnotationConfiguration().configure();
	static SessionFactory sf = ac.buildSessionFactory();
	
	public static void saveStudentsMain()
	{
		Session sn = sf.openSession();
		
		Students st = new Students();
		st.setSid(47564);
		st.setSname("Ravi");
		st.setMarks(76);
		
		Students st1 = new Students();
		st1.setSid(8756);
		st1.setSname("Harish");
		st1.setMarks(89);
		
		Transaction tr = sn.beginTransaction();
		sn.save(st);
		sn.save(st1);
		
		tr.commit();
		sn.close();
	}
	
	public static void getStudentsMain()
	{
		Session sn = sf.openSession();
		
		Query q = sn.createQuery("from Students s");
		List<?> l = q.list();
		Iterator<?> it = l.iterator();
		while(it.hasNext())
		{
			Students st1 = (Students) it.next();
			System.out.println("----------Students Details----------");
			System.out.println("Id: "+st1.getSid());
			System.out.println("Name: "+st1.getSname());
			System.out.println("Marks: "+st1.getMarks());
			System.out.println("------------------------------------");
		}
		
		sn.close();
	}
	
	public static void updateStudentsMain()
	{
		Session sn = sf.openSession();
		
		Students st2 = (Students) sn.get(Students.class, 8756);
		st2.setSname("Rajaram");
		st2.setMarks(878);
		
		Transaction tr = sn.beginTransaction();
		sn.update(st2);
		tr.commit();
		sn.close();
		
	}
	
	public static void deleteStudentsMain()
	{
		Session sn = sf.openSession();
		Students st2 = (Students) sn.get(Students.class, 8756);
		
		Transaction tr = sn.beginTransaction();
		sn.delete(st2);
		tr.commit();
		sn.close();
	}
	
	public static void main(String[] args) 
	{
		//saveStudentsMain();
		//getStudentsMain();
		//updateStudentsMain();
		deleteStudentsMain();
		
	}
}
