package curdxmlbased;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentCURDMain
{
	static SessionFactory sf = new Configuration().configure().buildSessionFactory();
	
	public static void saveStudentCURDMain()
	{
		Session sn = sf.openSession();
		
		Student s1 = new Student();
		s1.setStID(454);
		s1.setStName("Deepak");
		s1.setStMarks(78);
		
		Student s2 = new Student();
		s2.setStID(455);
		s2.setStName("JayPrakash");
		s2.setStMarks(98);
		
		Student s3 = new Student();
		s3.setStID(456);
		s3.setStName("Lalit");
		s3.setStMarks(87);
		
		Transaction tr = sn.beginTransaction();
		sn.save(s1);
		sn.save(s2);
		sn.save(s3);
		tr.commit();
		sn.close();
		
	}
	
	public static void getStudentCURDMain()
	{
		Session sn = sf.openSession();
		
		Query qr = sn.createQuery("from Student s");
		List<?> l = qr.list();
		Iterator<?> it1 = l.iterator();
		while(it1.hasNext())
		{
			Student s1 = (Student) it1.next();
			System.out.println("St_ID:"+s1.getStID());
			System.out.println("St_Name:"+s1.getStName());
			System.out.println("St_Marks:"+s1.getStMarks());
		}
		sn.close();
	}
	
	public static void updateStudentCURDMain()
	{
		Session sn = sf.openSession();
		Transaction tr = sn.beginTransaction();
		
		/*Student s1 = new Student();
		s1.setStID(454);
		s1.setStMarks(87);
		sn.update(s1);*/
		
		Student s2 = (Student) sn.get(Student.class, 454);
		s2.setStMarks(9);
		sn.update(s2);
		
		tr.commit();
		sn.close();
		
	}
	
	public static void deleteStudentCURDMain()
	{
		Session sn = sf.openSession();
		Transaction tr = sn.beginTransaction();
		Student s2 = (Student) sn.get(Student.class, 456);
		sn.delete(s2);
		tr.commit();
		sn.close();
		
	}
	
	public static void monitorsSaveOperation()
	{
		Session sn = sf.openSession();
		Transaction tr = sn.beginTransaction();
				
		Monitors m1 = new Monitors();
		m1.setMonitorSerialNo(10204);
		m1.setMonitorCompanyName("LG");
		m1.setMonitorPrice(2500.00);
		
		Monitors m2 = new Monitors();
		m2.setMonitorSerialNo(10205);
		m2.setMonitorCompanyName("Videocon");
		m2.setMonitorPrice(4000.00);
		
		Monitors m3 = new Monitors();
		m3.setMonitorSerialNo(10206);
		m3.setMonitorCompanyName("Sony");
		m3.setMonitorPrice(5200.00);
		
		sn.save(m1);
		sn.save(m2);
		sn.save(m3);
		
		tr.commit();
		System.out.println("Successfully Saved");
		sn.close();
		
	}
	
	public static void getMonitors()
	{
		Session s1 = sf.openSession();
		
		Query q1 = s1.createQuery("from Monitors m");
		List<?> l1 = q1.list();
		Iterator<?> i1 = l1.iterator();
		System.out.println("+++++++++++Monitors Details+++++++++");
		while(i1.hasNext())
		{
			
			Monitors m1 = (Monitors) i1.next();
			System.out.println("monitorSerialNo: "+m1.getMonitorSerialNo());
			System.out.println("monitorCompanyName: "+m1.getMonitorCompanyName());
			System.out.println("monitorPrice: "+m1.getMonitorPrice());
		}
		s1.close();
	}
	
	public static void updateMonitors()
	{
		Session s2 = sf.openSession();
		Transaction tr = s2.beginTransaction();
		
		Monitors m2 = (Monitors) s2.get(Monitors.class, 10204);
		m2.setMonitorCompanyName("Life Good");
		m2.setMonitorPrice(3000.00);
		s2.update(m2);
		
		tr.commit();
		s2.close();
		
	}
	
	public static void deleteMonitors()
	{
		Session sn = sf.openSession();
		Transaction tr = sn.beginTransaction();
		Monitors m2 = (Monitors) sn.get(Monitors.class, 10203);
		sn.delete(m2);
		tr.commit();
		sn.close();
		
	}
	
	public static void main(String[] args) 
	{
		//saveStudentCURDMain();
		//getStudentCURDMain();
		//updateStudentCURDMain();
		//deleteStudentCURDMain();
		
		//monitorsSaveOperation();
		//getMonitors();
		//updateMonitors();
		deleteMonitors();
		
	}

}
