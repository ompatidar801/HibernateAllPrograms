package tablePerConcreteClassAnnotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

@SuppressWarnings("deprecation")
public class TeachersMain {

	public static void main(String[] args) 
	{
		AnnotationConfiguration ac = new AnnotationConfiguration().configure();
		SessionFactory sf = ac.buildSessionFactory();
		Session sn = sf.openSession();
		
		PermanentTeachers pt1 = new PermanentTeachers();
		pt1.setT_id(9584);
		pt1.setT_name("Tarun");
		pt1.setSubject("Chemistry");
		pt1.setSalary(25000);
		
		PermanentTeachers pt2 = new PermanentTeachers();
		pt2.setT_id(8754);
		pt2.setT_name("Lovin Thomas");
		pt2.setSubject("Bio");
		pt2.setSalary(15000);
		
		GuestTeachers gt = new GuestTeachers();
		gt.setT_id(2343);
		gt.setT_name("BadriNarayan");
		gt.setGst_subject("Maths");
		gt.setGst_salary(4500);
		
		GuestTeachers gt1 = new GuestTeachers();
		gt1.setT_id(956);
		gt1.setT_name("Ashok");
		gt1.setGst_subject("English");
		gt1.setGst_salary(30000);
		
		Transaction tr = sn.beginTransaction();
		sn.save(pt1);
		sn.save(pt2);
		sn.save(gt);
		sn.save(gt1);
		tr.commit();
		sn.close();
	
	}

}
