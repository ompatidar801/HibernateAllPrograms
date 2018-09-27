package m2oannotationbased;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

@SuppressWarnings("deprecation")
public class CoachingCoursesMain
{
	static AnnotationConfiguration ac= new AnnotationConfiguration().configure();
	static SessionFactory sf = ac.buildSessionFactory();
	
	public static void saveCoachingCoursesMain()
	{
		Session sn = sf.openSession();
		Coaching coa = new Coaching();
		coa.setCoID(98);
		coa.setCoName("Prestige Point");
		
		Courses co1 = new Courses();
		co1.setCouID(191);
		co1.setCouName("Java");
		co1.setCoaching(coa);
		
		Courses co2 = new Courses();
		co2.setCouID(192);
		co2.setCouName("Hibernate");
		co2.setCoaching(coa);
		
		Courses co3 = new Courses();
		co3.setCouID(193);
		co3.setCouName("Spring");
		co3.setCoaching(coa);
		
		Transaction re = sn.beginTransaction();
		sn.save(co1);
		sn.save(co2);
		sn.save(co3);
		re.commit();
		sn.close();
		
	}
	
	public static void updateCoachingCoursesMain()
	{
		Session sn = sf.openSession();
		Transaction tr = sn.beginTransaction();
		Query qr = sn.createQuery("from Courses cou");
		List<?> l  = qr.list();
		Iterator<?> it = l.iterator();
		while(it.hasNext())
		{
			Courses co2 = (Courses) it.next();
			co2.setCouName("Java");
			Coaching coa = co2.getCoaching();
			coa.setCoName("PP");
			sn.update(coa);
	
		}
		tr.commit();
		sn.close();
	}
	
	public static void getCoachingCoursesMain()
	{

		Session sn = sf.openSession();
		Query qr = sn.createQuery("from Courses cou");
		List<?> l  = qr.list();
		Iterator<?> it = l.iterator();
		while(it.hasNext())
		{
			Courses co2 = (Courses) it.next();
			System.out.println(co2.getCouID());
			System.out.println(co2.getCouName());
			System.out.println(co2.getCoaching());
			Coaching coa = co2.getCoaching();
			System.out.println(coa.getCoID());
			System.out.println(coa.getCoName());
	
		}
		sn.close();
	}
	
	public static void deleteCoachingCoursesMain()
	{
		Session sn = sf.openSession();
		Transaction tr = sn.beginTransaction();
		Query qr = sn.createQuery("from Courses cou");
		List<?> l  = qr.list();
		Iterator<?> it = l.iterator();
		while(it.hasNext())
		{
			Courses co2 = (Courses) it.next();
			Coaching coa = co2.getCoaching();
			sn.delete(co2);
	
		}
		tr.commit();
		sn.close();
	}
	
	public static void main(String[] args)
	{
		//saveCoachingCoursesMain();
		//updateCoachingCoursesMain();
		//getCoachingCoursesMain();
		deleteCoachingCoursesMain();
		
		
	}

}
