package o2mannotationbased;

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
public class FatherChildrenMain
{
	static AnnotationConfiguration ac = new AnnotationConfiguration().configure(); 
	static SessionFactory sf = ac.buildSessionFactory();
	public static void saveFatherChildrenMain()
	{
		Session sn = sf.openSession();
		Transaction tr1 = sn.beginTransaction();
		Father f = new Father();
		f.setfID(900);
		f.setfName("Girdhari");
		
		Children ch1 = new Children();
		ch1.setChId(84);
		ch1.setChName("Ram");
		
		Children ch2 = new Children();
		ch2.setChId(85);
		ch2.setChName("Radhe");
		
		Children ch3 = new Children();
		ch3.setChId(86);
		ch3.setChName("Banke");
		
		//one to many
		Set<Children> s = new HashSet<Children>();
		s.add(ch1);
		s.add(ch2);
		s.add(ch3);
		
		f.setChildren(s);
		
		
		//many to one
		ch1.setFather(f);
		ch2.setFather(f);
		ch3.setFather(f);
		//sn.save(f);
		
		sn.save(ch1);
		sn.save(ch2);
		sn.save(ch3);
		
		
		tr1.commit();
		sn.close();
	}
	
	public static void getFatherChildrenMain()
	{
		Session sn = sf.openSession();
		//one to many
		Father f1 = (Father) sn.get(Father.class, 900);
		System.out.println(f1.getfID());
		System.out.println(f1.getfName());
		
		Set<Children> s = f1.getChildren();
		Iterator<Children> it = s.iterator();
		while(it.hasNext())
		{
			Children ch = (Children) it.next();
			System.out.println(ch.getChId());
			System.out.println(ch.getChName());
			System.out.println(ch.getFather());
		}
		
		Query q1 = sn.createQuery("from Children");
		List<?> l1 = q1.list();
		Iterator<?> it1 = l1.iterator();
		while(it1.hasNext())
		{
			Children ch1 = (Children) it1.next();
			System.out.println(ch1.getChId());
			System.out.println(ch1.getChName());
			System.out.println(ch1.getFather());
			
			Father f2 = ch1.getFather();
			System.out.println(f2.getfID());
			System.out.println(f2.getfName());
		}
		sn.close();
	}
	
	public static void updateFatherChildrenMain()
	{
		Session sn = sf.openSession();
		//one to many
		/*Father f1 = (Father) sn.get(Father.class, 900);
		Set<Children> s = f1.getChildren();
		Iterator<?> it = s.iterator();
		while(it.hasNext())
		{
			Children ch = (Children) it.next();
			ch.setChName("Rama");
			f1.setfName("Krishna");
			Transaction tr = sn.beginTransaction();
			sn.update(f1);
			tr.commit();
		}*/
		
		//many to one
		Query q1 = sn.createQuery("from Children");
		@SuppressWarnings("unchecked")
		List<Children> l1 = q1.list();
		Iterator<?> it1 = l1.iterator();
		while(it1.hasNext())
		{
			Children ch1 = (Children) it1.next();
			Father f2 = ch1.getFather();
			f2.setfName("Hira");
			ch1.setChName("Lala");
			Transaction tr2 = sn.beginTransaction();
			sn.update(ch1);
			tr2.commit();
		}
		sn.close();
	}
	
	public static void deleteFatherChildrenMain()
	{
		Session sn = sf.openSession();
		//one to many
		/*Father f1 = (Father) sn.get(Father.class, 900);
		Set<?> s = f1.getChildren();
		Iterator<?> it = s.iterator();
		while(it.hasNext())
		{
			Children ch = (Children) it.next();
			Transaction tr3 = sn.beginTransaction();
			sn.delete(ch);
			tr3.commit();
		}*/
		
		//many to one
		Query q1 = sn.createQuery("from Children");
		List<?> l1 = q1.list();
		Iterator<?> it1 = l1.iterator();
		while(it1.hasNext())
		{
			Children ch1 = (Children) it1.next();
			Father f2 = ch1.getFather();
			Transaction tr2 = sn.beginTransaction();
			sn.delete(ch1);
			tr2.commit();
		}
		sn.close();
	}
	
	public static void main(String[] args)
	{
		//saveFatherChildrenMain();
		//getFatherChildrenMain();
		//updateFatherChildrenMain();
		deleteFatherChildrenMain();
		
	}

}
