package many2manyAnnotation;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

@SuppressWarnings("deprecation")
public class PersonsMobiles
{
	static AnnotationConfiguration ac = new AnnotationConfiguration().configure();
	static SessionFactory sf = ac.buildSessionFactory();
	
	public static void savePersonsMobiles()
	{
		Session sn = sf.openSession();
		
		Persons p1 = new Persons();
		p1.setPerid(8475);
		p1.setPername("Mahesh");
		p1.setPeradd("Ratlam");
		
		Persons  p2 = new Persons();
		p2.setPerid(77345);
		p2.setPername("Vishal");
		p2.setPeradd("Gao");
		
		Mobiles m1 = new Mobiles();
		m1.setModid(90374);
		m1.setMobname("Xiaomi");
		m1.setModels("Mi Max");
		
		Mobiles m2 = new Mobiles();
		m2.setModid(4584);
		m2.setMobname("Xiaomi");
		m2.setModels("Mi A1");
		
		Set<Persons> s1 = new HashSet<Persons>();
		s1.add(p1);
		s1.add(p2);
		
		Set<Mobiles> s2 = new HashSet<Mobiles>();
		s2.add(m1);
		s2.add(m2);
		
		p1.setMobile(s2);
		p2.setMobile(s2);
		
		m1.setPerson(s1);
		m1.setPerson(s2);
		
		Transaction tr = sn.beginTransaction();
		sn.save(p1);
		sn.save(p2);
		sn.save(m1);
		sn.save(m2);
		
		tr.commit();
		sn.close();
	}
	
	public static void getPersonsMobiles()
	{
		Session sn = sf.openSession();
		Query q1 = sn.createQuery("from Persons p");
		List<?> l1 = q1.list();
		Iterator<?> it = l1.iterator();
		while(it.hasNext())
		{
			Persons p1 = (Persons) it.next();
			System.out.println("========Persons=========");
			System.out.println("ID: "+p1.getPerid());
			System.out.println("Name: "+p1.getPername());
			System.out.println("Address: "+p1.getPeradd());
			System.out.println("========================");
			
			Set<?> s2 = p1.getMobile();
			Iterator<?> it2 = s2.iterator();
			while(it2.hasNext())
			{
				Mobiles m3 = (Mobiles) it2.next();
				System.out.println("========Mobiles=========");
				System.out.println("ID: "+m3.getModid());
				System.out.println("Name: "+m3.getMobname());
				System.out.println("Model: "+m3.getModels());
				System.out.println("========================");
		
			}
		}
		sn.close();
	}
	
	public static void updatePersonsMobiles()
	{
		Session sn = sf.openSession();
		Transaction tr = sn.beginTransaction();
		Persons p2 = (Persons) sn.get(Persons.class, 8475);
		p2.setPername("Rama");
		
		Set<?> s2 = p2.getMobile();
		Iterator<?> it2 = s2.iterator();
		while(it2.hasNext())
		{
			Mobiles m3 = (Mobiles) it2.next();
			m3.setMobname("Samsung");
			m3.setModels("S8");
			sn.update(m3);
		
		}
		tr.commit();
		sn.close();
	}
	
	public static void deletePersonsMobiles()
	{
		Session sn = sf.openSession();
		Transaction tr = sn.beginTransaction();
		Query q = sn.createQuery("from Mobiles m");
		List<?> l = q.list();
		Iterator<?> it = l.iterator();
		while(it.hasNext())
		{
			Mobiles m  = (Mobiles) it.next();
			Set<?> s2 = m.getPerson();
			Iterator<?> it2 = s2.iterator();
			while(it2.hasNext())
			{
				Persons p = (Persons) it2.next();
				sn.delete(p);
			}
		}
		tr.commit();
		sn.close();
	}
	
	public static void main(String[] args) 
	{
		savePersonsMobiles();
		//getPersonsMobiles();
		//updatePersonsMobiles();
		//getPersonsMobiles();
		//deletePersonsMobiles();
	
	}

}
